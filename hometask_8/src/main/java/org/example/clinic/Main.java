package org.example.clinic;

public class Main {

    public static void main(String[] args) {

        Therapist therapist = new Therapist();

        Patient patient1 = new Patient();
        patient1.setPlan(1);
        therapist.setDoctor(patient1);
        System.out.println(patient1.getDoctor());

        Patient patient2 = new Patient();
        patient2.setPlan(2);
        therapist.setDoctor(patient2);
        System.out.println(patient2.getDoctor());

        Patient patient3 = new Patient();
        patient3.setPlan(5);
        therapist.setDoctor(patient3);
        System.out.println(patient3.getDoctor());

        Patient patient4 = new Patient();
        patient4.setPlan(7);
        therapist.setDoctor(patient4);
        System.out.println(patient4.getDoctor());

    }
}
