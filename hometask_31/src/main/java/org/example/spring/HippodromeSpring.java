package org.example.spring;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.spring.interfaces.impl.HorseImpl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Getter @Setter
@AllArgsConstructor
@Component

public class HippodromeSpring  {

    private List<HorseImpl> horses;
    private User user;
//    @Override
//    public void move() {
//        for (HorseImpl horse : horses) {
//            horse.move();
//        }
//    }
//
//    @Override
//    public void print() {
//        for (HorseImpl horse : horses){
//            horse.print();
//        }
//        System.out.println();
//    }

    public void run() {

        while (user.getCount() != 0) {

            System.out.println("Your debit is: " + user.getCount());

            System.out.println("Choose your favorite horse-number from this: " + getHorses().toString());

            Scanner scanner = new Scanner(System.in);

            int horseId = scanner.nextInt();

            System.out.println("Place your bet: ");

            int bet = scanner.nextInt();

            user = new User(user.getCount(), horseId, bet);

            for (int i = 0; i < 10; i++) {
                for (HorseImpl horse : horses) {
                    horse.move();
                    horse.print();
                }
                System.out.println();

//                move();
//                print();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            printWinner();
            calcUserCount();

            if (user.getCount() == 0) {
                System.out.println("You are LOSE!!!");
            }

        }
    }

    public HorseImpl getWinner() {
        HorseImpl tempHorse = horses.get(0);
        for (HorseImpl horse : horses) {
            if (horse.getDistance() > tempHorse.getDistance()) {
                tempHorse = horse;
            }
        }
        return tempHorse;
    }

    public void printWinner() {
        System.out.println("WINNER is: " + getWinner().getId() + "!");
    }

    public void  calcUserCount() {
        if (getWinner().getId() == user.getHorseId()) {
            user.setCount(user.getCount() + user.getBet());
        } else {
            user.setCount(user.getCount() - user.getBet());
        }
    }
}
