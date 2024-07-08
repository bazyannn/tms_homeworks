package org.example.spring;

import lombok.*;

@Getter
@Setter

public class Horse {

    private Integer id;
    private final double speed = 4.5;
    private double distance;

    public Horse(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Horse{" +
                id +
                '}';
    }

    public void move() {
        distance += speed * Math.random();
    }

    public void print() {
        for (int i = 0; i < Math.round(distance); i++) {
            System.out.print(". ");
        }
        System.out.print(id);
        System.out.println();
    }
}
