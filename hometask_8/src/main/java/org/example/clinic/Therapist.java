package org.example.clinic;

import org.example.interfaces.Heal;

public class Therapist implements Heal {    // extends Doctor(если через абстрактный класс)


    @Override
    public void treat() {
        System.out.println("Prescribe medications");
    }


}















