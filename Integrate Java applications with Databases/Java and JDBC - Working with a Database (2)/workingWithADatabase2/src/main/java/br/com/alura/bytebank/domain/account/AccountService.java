package br.com.alura.bytebank.domain.account;

import br.com.alura.bytebank.domain.BusinessRuleException;
import br.com.alura.bytebank.domain.customer.Customer;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AccountService {

    private Set<Account> accounts = new HashSet<>();

    public Set<Account> listOpenAccounts() {
        return accounts;
    }

    public BigDecimal consultBalance(Integer accountNumber) {
        var number = searchAccountByNumber(accountNumber);
        return number.getBalance();
    }

    public void openAccount(AccountOpeningData accountData) {
        Customer customer = new Customer(accountData.CustomerData());
        Account account = new Account(accountData.number(), customer);
        if (accounts.contains(account)) {
            throw new BusinessRuleException("There is already another account opened with the same number!");
        }

        accounts.add(account);
    }

    public void doWithdraw(Integer accountNumber, BigDecimal amount) {
        var account = searchAccountByNumber(accountNumber);
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessRuleException("Withdrawal amount must be greater than zero!");
        }

        if (amount.compareTo(account.getBalance()) > 0) {
            throw new BusinessRuleException("Insufficient balance!");
        }

        account.withdraw(amount);
    }

    public void doDeposit(Integer accountNumber, BigDecimal amount) {
        var account = searchAccountByNumber(accountNumber);
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessRuleException("Deposit amount must be greater than zero!");
        }

        account.deposit(amount);
    }

    public void closeAccount(Integer accountNumber) {
        var account = searchAccountByNumber(accountNumber);
        if (account.hasBalance()) {
            throw new BusinessRuleException("Account cannot be closed because it still has balance!");
        }

        accounts.remove(account);
    }

    private Account searchAccountByNumber(Integer number) {
        return accounts
                .stream()
                .filter(c -> Objects.equals(c.getNumber(), number))
                .findFirst()
                .orElseThrow(() -> new BusinessRuleException("There is no account registered with this number!"));
    }
}
