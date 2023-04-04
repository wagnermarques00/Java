package br.com.alura.bytebank.domain.account;

import br.com.alura.bytebank.domain.customer.Customer;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {

    private Integer number;
    private BigDecimal balance;
    private Customer customer;
    private Boolean isActive;

    public Account(Integer number, BigDecimal balance, Customer customer, Boolean isActive) {
        this.number = number;
        this.customer = customer;
        this.balance = balance;
        this.isActive = isActive;
    }

    public boolean hasBalance() {
        return this.balance.compareTo(BigDecimal.ZERO) != 0;
    }

    public void withdraw(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return number.equals(account.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                ", owner=" + customer +
                '}';
    }

    public Integer getNumber() {
        return number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Boolean getActive() {
        return isActive;
    }
}
