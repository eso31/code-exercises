package com.cracking.coding.interview.ood.callcenter.model;

import com.cracking.coding.interview.ood.callcenter.Util;

public class Manager extends Employee {
    public Manager() {
        super();
    }

    @Override
    public void attendCall(String callId) {
        setFree(false);

        System.out.println("I am a manager attending the call " + callId);
        Util.wait(1000, 5000);

        setFree(true);
    }
}
