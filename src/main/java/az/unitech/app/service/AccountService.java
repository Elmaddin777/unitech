package az.unitech.app.service;

import az.unitech.app.domain.Account;
import az.unitech.app.dto.AccountDto;
import az.unitech.app.error.FailedTransactionException;
import az.unitech.app.repository.AccountsRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AccountService {

    private final AccountsRepository accountsRepository;
    private final ModelMapper modelMapper;

    public List<AccountDto> getActiveUserAccounts() {
        var activeAccounts = accountsRepository.getActiveAccounts();

        return activeAccounts.stream()
                .map(o -> modelMapper.map(o, AccountDto.class))
                .toList();
    }

    // @Transactional
    public void transferToAccount(String accNumber, BigDecimal amount) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Account sourceAccount = accountsRepository.getAccountByUsername(authentication.getName());
        Account destinationAccount = accountsRepository.getAccountByAccountNo(accNumber);

        if (sourceAccount.getBalance().compareTo(amount) < 0) {
            throw new FailedTransactionException(
                    "There is not enough balance for this transaction");
        }

        if (sourceAccount.getAccountNo().equals(accNumber)) {
            throw new FailedTransactionException("Can't make transaction to the same account");
        }

        if (!destinationAccount.isActive()) {
            throw new FailedTransactionException("Destination account is not active");
        }

        if (Objects.isNull(destinationAccount)) {
            throw new FailedTransactionException("Destination account doesn't exist");
        }

        accountsRepository.makeTransfer(sourceAccount, destinationAccount, amount);

    }

}
