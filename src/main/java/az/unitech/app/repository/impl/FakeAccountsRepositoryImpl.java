package az.unitech.app.repository.impl;

import az.unitech.app.domain.Account;
import az.unitech.app.repository.AccountsRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class FakeAccountsRepositoryImpl implements AccountsRepository {

    @Override
    public Optional<List<Account>> getActiveAccounts() {
        return Optional.of(getAccounts().stream()
                .filter(Account::isActive)
                .toList());
    }

    @Override
    public Account getAccountByUsername(String username) {
        // let's consider it is the first account
        return getAccounts().get(0);
    }

    @Override
    public Account getAccountByAccountNo(String accNumber) {
        // let's consider it is the third account
        return getAccounts().get(2);
    }

    @Override
    public void makeTransfer(Account sourceAccount, Account destinationAccount, BigDecimal amount) {
        // whole process is transactional by service
        sourceAccount.getBalance().subtract(amount);
        destinationAccount.getBalance().add(amount);
    }

    private List<Account> getAccounts(){

        return List.of(
                new Account(
                        "123456789",
                        BigDecimal.valueOf(12989),
                        true
                ),

                new Account(
                        "123456789",
                        BigDecimal.valueOf(98898),
                       true
                ),

                new Account(
                        "123456789",
                        BigDecimal.valueOf(0),
                        false
                )
        );
    }

}
