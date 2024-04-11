package org.example.clinic;

public class Therapist extends Doctor {

/*    private Doctor [] doctors = new Doctor[2];
//
//    public Therapist(Doctor... doctors) {
//        this.doctors = doctors;
//    }

 */        // решение Сергей
    @Override
    public void treat() {
        System.out.println("Prescribe medications");
    }
/*
    @Override
    public String type() {
        return "Therapist";
    }*/      // решение Сергей

    public void setDoctor(Patient patient) {

        Doctor doctor;                         // мой вариант

        if (patient.getPlan() == 1) {
            doctor = new Surgeon();
            patient.setDoctor(doctor);

        } else if (patient.getPlan() == 2) {
            doctor = new Dentist();
            patient.setDoctor(doctor);

        } else {
            doctor = new Therapist();
            patient.setDoctor(doctor);
        }
    }
    /*   int plan = patient.getPlan();
//
//        if (plan == 1){
//            for (var doctor:doctors ) {
//                if (doctor.type().equals("Surgeon")) {
//                    patient.setDoctor(doctor);
//                }
//            }
//        } else if (plan == 2) {
//            for (var doctor : doctors) {
//                if (doctor.type().equals("Dentist")) {
//                    patient.setDoctor(doctor);
//                }
//            }
//        } else {
//            patient.setDoctor(this);
        }
*/                    // решение Сергей
}















