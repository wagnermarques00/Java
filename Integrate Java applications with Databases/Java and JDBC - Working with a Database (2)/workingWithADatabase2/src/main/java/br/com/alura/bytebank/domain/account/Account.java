package br.com.alura.bytebank.domain.account;

import br.com.alura.bytebank.domain.customer.Customer;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {

    private Integer number;
    private BigDecimal balance;
    private Customer owner;

    public Account(Integer number, Customer owner) {
        this.number = number;
        this.owner = owner;
        this.balance = BigDecimal.ZERO;
    }

    public boolean hasBalance() {
        return this.balance.compareTo(BigDecimal.ZERO) != 0;
    }

    public void withdraw(BigDecimal value) {
        this.balance = this.balance.subtract(value);
    }

    public void deposit(BigDecimal value) {
        this.balance = this.balance.add(value);
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
                ", owner=" + owner +
                '}';
    }

    public Integer getNumber() {
        return number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Customer getOwner() {
        return owner;
    }
}
