package org.example.spring;

import lombok.*;
import org.example.aspect.Benchmark;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
@Component

public class HippodromeService {

    private List<Horse> horses;
    private User user;

    @Benchmark
    public void run() {

        while (user.getWallet() != 0) {

            System.out.println("Your debit is: " + user.getWallet());

            System.out.println("Choose your favorite horse-number from this: " + getHorses().toString());

            Scanner scanner = new Scanner(System.in);

            int horseId = scanner.nextInt();

            System.out.println("Place your bet: ");

            int bet = scanner.nextInt();

            for (int i = 0; i < 10; i++) {
                for (Horse horse : horses) {
                    horse.move();
                    horse.print();
                }
                System.out.println();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            printWinner();

            if (getWinner().getId() == horseId) {
                user.setWallet(user.getWallet() + bet);
            } else {
                user.setWallet(user.getWallet() - bet);
            }

            if (user.getWallet() == 0) {
                System.out.println("You are LOSE!!!");
            }
        }
    }

    public Horse getWinner() {
        Horse tempHorse = horses.get(0);
        for (Horse horse : horses) {
            if (horse.getDistance() > tempHorse.getDistance()) {
                tempHorse = horse;
            }
        }
        return tempHorse;
    }

    public void printWinner() {
        System.out.println("WINNER is: " + getWinner().getId() + "!");
    }

}
