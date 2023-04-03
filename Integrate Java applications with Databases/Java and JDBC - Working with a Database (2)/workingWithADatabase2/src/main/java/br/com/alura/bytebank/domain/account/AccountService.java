package br.com.alura.bytebank.domain.account;

import br.com.alura.bytebank.ConnectionFactory;
import br.com.alura.bytebank.domain.BusinessRuleException;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AccountService {

	private ConnectionFactory connectionFactory;
	private Set<Account> accounts = new HashSet<>();

	public AccountService() {
		this.connectionFactory = new ConnectionFactory();
	}

	public Set<Account> listOpenAccounts() {
		Connection connection = connectionFactory.recoverConnection();
		return new AccountDAO(connection).listAll();
	}

	public BigDecimal consultBalance(Integer accountNumber) {
		var number = searchAccountByNumber(accountNumber);
		return number.getBalance();
	}

	public void openAccount(AccountOpeningData accountData) {
		Connection connection = connectionFactory.recoverConnection();
		AccountDAO accountDAO = new AccountDAO(connection);

		accountDAO.save(accountData);
	}

	public void doWithdraw(Integer accountNumber, BigDecimal amount) {
		var account = searchAccountByNumber(accountNumber);
		if(amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new BusinessRuleException("Withdrawal amount must be greater than zero!");
		}

		if(amount.compareTo(account.getBalance()) > 0) {
			throw new BusinessRuleException("Insufficient balance!");
		}

		account.withdraw(amount);
	}

	public void doDeposit(Integer accountNumber, BigDecimal amount) {
		var account = searchAccountByNumber(accountNumber);
		if(amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new BusinessRuleException("Deposit amount must be greater than zero!");
		}

		account.deposit(amount);
	}

	public void closeAccount(Integer accountNumber) {
		var account = searchAccountByNumber(accountNumber);
		if(account.hasBalance()) {
			throw new BusinessRuleException("Account cannot be closed because it still has balance!");
		}

		accounts.remove(account);
	}

	private Account searchAccountByNumber(Integer number) {
		return accounts.stream().filter(c -> Objects.equals(c.getNumber(), number)).findFirst()
					   .orElseThrow(() -> new BusinessRuleException("There is no account registered with this number!"));
	}
}
