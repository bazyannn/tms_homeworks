package org.example.clinic;

public class Main {

    public static void main(String[] args) {

        Therapist therapist = new Therapist();

        Patient patient = new Patient(1);

        therapist.setDoctor(patient);
        Doctor doctor = patient.getDoctor();
        doctor.treat();

    }
}
