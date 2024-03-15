package org.example.clinic;

import org.example.interfaces.Heal;

public class Patient {

    private String doctor;
    private int plan;

    public String getDoctor() {
        return doctor;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public int getPlan() {
        return plan;
    }
}


