package br.com.alura.bytebank.domain.account;

import br.com.alura.bytebank.domain.customer.CustomerData;

public record AccountOpeningData(Integer number, CustomerData customerData) {
}
