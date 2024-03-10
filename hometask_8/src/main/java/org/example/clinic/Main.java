package org.example.clinic;

public class Main {

    public static void main(String[] args) {

        Therapist therapist = new Therapist();

        Patient patient1 = therapist.patient;         // Patient patient1 = new Patient(); (когда метод назначения доктора в классе Patient)
        patient1.setPlan(1);
        therapist.setDoctor();                        // patient1.setDoctor();
        System.out.println(patient1.getDoctor());

        Patient patient2 = therapist.patient;         // Patient patient2 = new Patient();
        patient2.setPlan(2);
        therapist.setDoctor();                        // patient2.setDoctor();
        System.out.println(patient2.getDoctor());

        Patient patient3 = therapist.patient;         //  Patient patient3 = new Patient();
        patient3.setPlan(5);
        therapist.setDoctor();                        //  patient3.setDoctor();
        System.out.println(patient3.getDoctor());

        Patient patient4 = therapist.patient;         //  Patient patient4 = new Patient();
        patient4.setPlan(7);
        therapist.setDoctor();                        //  patient4.setDoctor();
        System.out.println(patient4.getDoctor());

    }
}
