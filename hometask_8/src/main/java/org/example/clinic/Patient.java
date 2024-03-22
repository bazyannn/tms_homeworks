package org.example.clinic;

public class Patient {

    private Doctor doctor;
    private int plan;

    public Patient( int plan) {
        this.plan = plan;
    }

    public int getPlan() {
        return plan;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}



