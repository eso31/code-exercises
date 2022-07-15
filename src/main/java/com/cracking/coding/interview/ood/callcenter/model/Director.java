package com.cracking.coding.interview.ood.callcenter.model;

import com.cracking.coding.interview.ood.callcenter.Util;

public class Director extends Employee {
    public Director() {
        super();
    }

    @Override
    public void attendCall(String callId) {
        setFree(false);

        System.out.println("I am a director attending the call " + callId);
        Util.wait(1000, 5000);

        setFree(true);
    }
}
