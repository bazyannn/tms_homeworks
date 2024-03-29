package org.example.interfaces;

import org.example.interfaces.Cat;
import org.example.interfaces.Dog;

public class Main {

    public static void main(String[] args) {

        // ------------------ task1 --------------

        Cat cat1 = new Cat();
        Dog dog1 = new Dog();

        cat1.doVoice();
        dog1.doVoice();

    }
}
