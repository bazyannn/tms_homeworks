package org.example.clinic;

public class Surgeon extends Doctor {
    @Override
    public void treat() {
        System.out.println("Do operation");
    }
/*
    @Override
    public String type() {          // решение Сергей
        return "Surgeon";
    }*/       // решение Сергей
}






