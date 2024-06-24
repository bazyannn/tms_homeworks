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
    private int horseId;
    private int bet;

    @Benchmark
    public void run() {

        while (user.getWallet() != 0) {

            System.out.println("Your debit is: " + user.getWallet());

            System.out.println("Choose your favorite horse-number from this: " + getHorses().toString());

            Scanner scanner = new Scanner(System.in);

            int horseId = scanner.nextInt();

            this.horseId = horseId;

            System.out.println("Place your bet: ");

            int bet = scanner.nextInt();

            this.bet = bet;

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
            calcUserCount();

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

    public void calcUserCount() {
        if (getWinner().getId() == this.getHorseId()) {
            user.setWallet(user.getWallet() + this.getBet());
        } else {
            user.setWallet(user.getWallet() - this.getBet());
        }
    }
}
