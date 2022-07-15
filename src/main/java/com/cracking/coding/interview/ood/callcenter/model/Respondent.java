package com.cracking.coding.interview.ood.callcenter.model;

import com.cracking.coding.interview.ood.callcenter.Util;

public class Respondent extends Employee {
    public Respondent() {
        super();
    }

    @Override
    public synchronized void attendCall(String callId) {
        setFree(false);

        System.out.println("I am a respondent attending the call " + callId);
        Util.wait(1000, 5000);

        setFree(true);
    }
}
