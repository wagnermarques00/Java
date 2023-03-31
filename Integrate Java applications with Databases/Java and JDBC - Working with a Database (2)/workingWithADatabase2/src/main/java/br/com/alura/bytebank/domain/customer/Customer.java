package br.com.alura.bytebank.domain.customer;

import java.util.Objects;

public class Customer {

    private String nome;
    private String cpf;
    private String email;

    public Customer(CustomerData dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return cpf.equals(customer.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

}
