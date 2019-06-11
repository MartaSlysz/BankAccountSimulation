package com.slyszmarta.BankAccountSimulator;

import java.util.Random;

public class Consumer extends Thread {
    private SavingsAccount account;
    public Consumer(SavingsAccount acct){
        account = acct;

    }
    public void run(){
        for(int i = 0; i < 5; i++) {
            account.withdraw(10);
        }
    }
}
