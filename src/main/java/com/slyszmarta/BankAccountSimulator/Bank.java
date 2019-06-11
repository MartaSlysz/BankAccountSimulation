package com.slyszmarta.BankAccountSimulator;

public class Bank {
    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount( 0 );
        int slaveCount = 4;
        Thread[] slaves = new Thread[slaveCount];
        for(int i = 0; i < slaveCount; i++) {
            if (i % 2 == 0) {
                slaves[i] = new Producer(account);
            } else {
                slaves[i] = new Consumer(account);
            }
        }
        for(int i = 0; i < slaveCount; i++) {
            slaves[i].start();
        }
        for(int i = 0; i < slaveCount; i++) {
            try {
                slaves[i].join();
            } catch(InterruptedException ie) {
                System.err.println(ie.getMessage());
            } finally {
                System.out.println("slave "+ i + " has died");
            }
        }
        System.out.print("Końcowy stan konta = ");
        System.out.println("PLN " + account.getBalance());

    }
}
