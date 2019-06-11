package com.slyszmarta.BankAccountSimulator;

public class SavingsAccount {
    private double balance;
    private double cap = 50;
    public synchronized double getBalance() { return balance; }

    public SavingsAccount(double bal)
    {
        balance = bal;
    }
    public SavingsAccount() {
        this(0);
    }

    public synchronized void deposit(double amount) {
        while (cap < balance + amount) {
            try {
                wait(); // wait for funds
            } catch (InterruptedException ie) {
                System.err.println(ie.getMessage());
            }
        }
        double temp = balance;
        temp = temp+amount;
        try{
            Thread.sleep( 300 );
        } catch (InterruptedException ie){
            System.err.println(ie.getMessage());
        }
        System.out.println("Stan konta po wpłacie to PLN: "+temp);
        balance = temp;
        notify();
    }

    public synchronized void withdraw(double amount){
        while (balance < amount) {
            try {
                wait(); // wait for funds
            } catch (InterruptedException ie) {
                System.err.println(ie.getMessage());
            }
        }
        double temp = balance;
        temp = temp-amount;
        try{
            Thread.sleep( 200 );
        } catch (InterruptedException ie){
            System.err.println( ie.getMessage() );
        }
        System.out.println("Stan konta po wypłacie to PLN: "+temp);
        balance = temp;
        notify();
    }
}
