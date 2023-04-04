package br.com.alura.bytebank;

import br.com.alura.bytebank.domain.BusinessRuleException;
import br.com.alura.bytebank.domain.customer.CustomerData;
import br.com.alura.bytebank.domain.account.AccountService;
import br.com.alura.bytebank.domain.account.AccountOpeningData;

import java.math.BigDecimal;
import java.util.Scanner;

public class BytebankApplication {

    private static AccountService service = new AccountService();
    private static Scanner keyboard = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {
        var option = showMenu();
        while (option != 8) {
            try {
                switch(option) {
                    case 1 -> listAccounts();
                    case 2 -> openAccount();
                    case 3 -> closeAccount();
                    case 4 -> checkBalance();
                    case 5 -> makeWithdraw();
                    case 6 -> makeDeposit();
                    case 7 -> makeTransfer();
                }
            } catch (BusinessRuleException e) {
                System.out.println("Error: " +e.getMessage());
                System.out.println("Press any key and ENTER to return to the menu");
                keyboard.next();
            }
            option = showMenu();
        }

        System.out.println("Closing the application.");
    }

    private static int showMenu() {
        System.out.println("""
                BYTEBANK - CHOOSE A OPTION:
                1 - List open accounts
                2 - Account opening
                3 - Account closing
                4 - Check account's balance
                5 - Withdraw from an account
                6 - Make a deposit into an account
                7 - Make a transfer
                8 - Exit
            """);
        return keyboard.nextInt();
    }

    private static void listAccounts() {
        System.out.println("Registered accounts:");
        var accounts = service.listOpenAccounts();
        accounts.stream().forEach(System.out::println);

        System.out.println("Press any key and ENTER to return to the main menu");
        keyboard.next();
    }

    private static void openAccount() {
        System.out.println("Enter account number:");
        var accountNumber = keyboard.nextInt();

        System.out.println("Enter the customer's name:");
        var name = keyboard.next();

        System.out.println("Enter the customer's CPF:");
        var cpf = keyboard.next();

        System.out.println("Enter the customer's email:");
        var email = keyboard.next();

        service.openAccount(new AccountOpeningData(accountNumber, new CustomerData(name, cpf, email)));

        System.out.println("Account successfully opened!");
        System.out.println("Press any key and ENTER to return to the main menu");
        keyboard.next();
    }

    private static void closeAccount() {
        System.out.println("Enter account number:");
        var accountNumber = keyboard.nextInt();

        service.closeAccount(accountNumber);

        System.out.println("Account closed successfully!");
        System.out.println("Press any key and ENTER to return to the main menu");
        keyboard.next();
    }

    private static void checkBalance() {
        System.out.println("Enter account number:");
        var accountNumber = keyboard.nextInt();
        var balance = service.consultBalance(accountNumber);
        System.out.println("Account balance: " + balance);

        System.out.println("Press any key and ENTER to return to the main menu");
        keyboard.next();
    }

    private static void makeWithdraw() {
        System.out.println("Enter account number:");
        var accountNumber = keyboard.nextInt();

        System.out.println("Enter the withdrawal amount:");
        var amount = keyboard.nextBigDecimal();

        service.doWithdraw(accountNumber, amount);
        System.out.println("Withdrawal successful!");
        System.out.println("Press any key and ENTER to return to the main menu");
        keyboard.next();
    }

    private static void makeDeposit() {
        System.out.println("Enter the account number:");
        var accountNumber = keyboard.nextInt();

        System.out.println("Enter the deposit amount:");
        var amount = keyboard.nextBigDecimal();

        service.doDeposit(accountNumber, amount);

        System.out.println("Deposit made successfully!");
        System.out.println("Press any key and ENTER to return to the main menu");
        keyboard.next();
    }

    private static void makeTransfer() {
        System.out.println("Enter the origin account:");
        Integer originAccountNumber = keyboard.nextInt();

        System.out.println("Enter the destination account:");
        Integer destinationAccountNumber = keyboard.nextInt();

        System.out.println("Enter the amount to deposit:");
        BigDecimal amount = keyboard.nextBigDecimal();

        service.doTransfer(originAccountNumber, destinationAccountNumber, amount);

        System.out.println("Transfer made successfully!");
        System.out.println("Press any key and ENTER to return to the main menu");
        keyboard.next();
    }
}
