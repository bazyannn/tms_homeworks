package org.example.clinic;

import org.example.interfaces.Heal;

public class Therapist implements Heal {    // extends Doctor(если через абстрактный класс)

    @Override
    public void treat() {
        System.out.println("Prescribe medications");
    }

    public void setDoctor(Patient patient) {

        Heal doctor;                     // Doctor (если через абстрактный класс)

        if (patient.getPlan() == 1) {
            doctor = new Surgeon();
            patient.setDoctor("Surgeon");        // сетаем доктора в поле пациента(чтобы вывести в консоль, что назначен доктор)

        } else if (patient.getPlan() == 2) {
            doctor = new Dentist();
            patient.setDoctor("Dentist");        // сетаем доктора в поле пациента(чтобы вывести в консоль, что назначен доктор)

        } else {
            doctor = new Therapist();
            patient.setDoctor("Therapist");      // сетаем доктора в поле пациента(чтобы вывести в консоль, что назначен доктор)
        }
        doctor.treat();
    }
}















