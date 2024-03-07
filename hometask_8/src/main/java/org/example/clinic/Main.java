package org.example.clinic;

public class Main {

    public static void main(String[] args) {

        Patient patient1 = new Patient();
        patient1.setPlan(1);
        patient1.setDoctor();
        System.out.println(patient1.getDoctor());

        Patient patient2 = new Patient();
        patient2.setPlan(2);
        patient2.setDoctor();
        System.out.println(patient2.getDoctor());

        Patient patient3 = new Patient();
        patient3.setPlan(5);
        patient3.setDoctor();
        System.out.println(patient3.getDoctor());

        Patient patient4 = new Patient();
        patient4.setPlan(7);
        patient4.setDoctor();
        System.out.println(patient4.getDoctor());

    }
}
