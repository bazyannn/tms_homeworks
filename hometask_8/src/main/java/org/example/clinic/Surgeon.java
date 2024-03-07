package org.example.clinic;

import org.example.interfaces.Heal;

public class Surgeon implements Heal {        // extends Doctor(если через абстрактный класс)


    @Override
    public void treat() {
        System.out.println("Do operation");
    }



}

