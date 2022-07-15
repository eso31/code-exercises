package com.cracking.coding.interview.ood.callcenter.model;

public class Employee {
    protected boolean free;

    public Employee() {
        this.free = true;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public synchronized void attendCall(String callId) {
        System.out.println("Attending call");
    }
}
