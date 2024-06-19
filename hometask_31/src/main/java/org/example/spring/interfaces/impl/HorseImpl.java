package org.example.spring.interfaces.impl;

import org.example.aspect.Benchmark;
import org.example.spring.interfaces.Horse;
import lombok.*;

@Getter
@Setter

public class HorseImpl implements Horse {

    private Integer id;
    private final double speed = 4.5;
    private double distance;

        public HorseImpl(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Horse{"+
                id +
                '}';
    }
    @Benchmark
    @Override
        public void move() {
        distance += speed * Math.random();
    }

    @Override
    public void print() {
        for (int i = 0; i < Math.round(distance); i++) {
            System.out.print(". ");
        }
        System.out.print(id);
        System.out.println();
    }
}
