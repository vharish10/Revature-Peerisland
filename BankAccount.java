import java.util.*;

public class BankAccount {
    private int accountNumber;
    private String customerName;
    private double balance;

    //parameterised constructor
    public BankAccount(int accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

//    public void setAccountNumber(int accountNumber) {
//        this.accountNumber = accountNumber;
//    }

    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance) {
        if(balance>0){
            this.balance = balance;
        }else{
            System.out.println("Balance cannot be negative");
        }
    }
    public void deposit(double amount){
        if(amount>0){
            balance=balance+amount;
            System.out.println("Deposited Amount"+amount);
            System.out.println("Balance amount"+balance);
        }
        else{
            System.out.println(" Invalid Deposit amount");
        }
    }

    void displayAccountInfo(){
        System.out.println("Account Number : "+accountNumber);
        System.out.println("Customer Name : "+customerName);
        System.out.println("Balance: "+balance);
    }
}