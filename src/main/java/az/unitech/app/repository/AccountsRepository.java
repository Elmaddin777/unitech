package az.unitech.app.repository;

import az.unitech.app.domain.Account;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountsRepository {

    Optional<List<Account>> getActiveAccounts();
    Account getAccountByUsername(String username);

    Account getAccountByAccountNo(String accNumber);

    void makeTransfer(Account sourceAccount, Account destinationAccount, BigDecimal amount);
}
