package br.com.alura.bytebank.domain.account;

import br.com.alura.bytebank.ConnectionFactory;
import br.com.alura.bytebank.domain.BusinessRuleException;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Set;

public class AccountService {

	private ConnectionFactory connectionFactory;

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

		if(!account.getActive()) {
			throw new BusinessRuleException("Account is not active");
		}

		BigDecimal newBalance = account.getBalance().subtract(amount);
		Connection connection = connectionFactory.recoverConnection();
		AccountDAO accountDAO = new AccountDAO(connection);

		accountDAO.updateBalance(account.getNumber(), newBalance);
	}

	public void doDeposit(Integer accountNumber, BigDecimal amount) {
		var account = searchAccountByNumber(accountNumber);
		if(amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new BusinessRuleException("Deposit amount must be greater than zero!");
		}

		if(!account.getActive()) {
			throw new BusinessRuleException("Account is not active");
		}

		BigDecimal newBalance = account.getBalance().add(amount);
		Connection connection = connectionFactory.recoverConnection();
		AccountDAO accountDAO = new AccountDAO(connection);

		accountDAO.updateBalance(account.getNumber(), newBalance);
	}

	public void doTransfer(Integer originAccountNumber, Integer destinationAccountNumber, BigDecimal amount) {
		this.doWithdraw(originAccountNumber, amount);
		this.doDeposit(destinationAccountNumber, amount);
	}

	public void closeAccount(Integer accountNumber) {
		var account = searchAccountByNumber(accountNumber);
		if(account.hasBalance()) {
			throw new BusinessRuleException("Account cannot be closed because it still has balance!");
		}

		Connection connection = connectionFactory.recoverConnection();
		AccountDAO accountDAO = new AccountDAO(connection);

		accountDAO.deleteByNumber(accountNumber);
	}

	public void logicalCloseAccount(Integer accountNumber) {
		var account = searchAccountByNumber(accountNumber);
		if(account.hasBalance()) {
			throw new BusinessRuleException("Account cannot be closed because it still has balance!");
		}

		Connection connection = connectionFactory.recoverConnection();
		AccountDAO accountDAO = new AccountDAO(connection);

		accountDAO.logicalUpdate(accountNumber);
	}

	private Account searchAccountByNumber(Integer number) {
		Connection connection = connectionFactory.recoverConnection();
		Account account = new AccountDAO(connection).listByNumber(number);

		if(account != null) {
			return account;
		} else {
			throw new BusinessRuleException("There is no account associated with this number.");
		}
	}
}
