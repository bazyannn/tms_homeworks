package org.example.clinic;

import org.example.interfaces.Heal;

public class Patient {

    private String doctor;
    private int plan;

    public void setDoctor() {

        Heal doctor;                     // Doctor (если через абстрактный класс)

        if (getPlan() == 1) {
            doctor = new Surgeon();
            setDoctor("Surgeon");        // сетаем доктора в поле пациента(чтобы вывести в консоль, что назначен доктор)

        } else if (getPlan() == 2) {
            doctor = new Dentist();
            setDoctor("Dentist");        // сетаем доктора в поле пациента(чтобы вывести в консоль, что назначен доктор)

        } else {
            doctor = new Therapist();
            setDoctor("Therapist");      // сетаем доктора в поле пациента(чтобы вывести в консоль, что назначен доктор)
        }
        doctor.treat();

    }


    public void setPlan(int plan) {
        this.plan = plan;
    }

    public int getPlan() {
        return plan;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDoctor() {
        return doctor;
    }


}