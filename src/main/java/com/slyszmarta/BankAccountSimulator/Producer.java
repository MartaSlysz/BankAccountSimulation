package com.slyszmarta.BankAccountSimulator;

import java.util.Random;

public class Producer extends Thread {
    private SavingsAccount account;
    public Producer (SavingsAccount acct){
        account = acct;
    }
    public void run(){
        for(int i = 0; i < 5; i++) {
            account.deposit(15);
        }
    }

}
