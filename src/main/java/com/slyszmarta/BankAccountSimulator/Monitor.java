package com.slyszmarta.BankAccountSimulator;

public class Monitor {
    private int state = 0;
    public synchronized void update(int newState) {
        state = newState;
    }
}
