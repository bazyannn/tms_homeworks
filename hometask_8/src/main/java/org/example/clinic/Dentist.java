package org.example.clinic;

public class Dentist extends Doctor {
    @Override
    public void treat() {
        System.out.println("Caries treat");
    }
/*
    @Override
    public String type() {          // решение Сергей
        return "Dentist";
    }*/        // решение Сергей
}
