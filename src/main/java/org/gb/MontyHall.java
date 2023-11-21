package org.gb;


import java.util.Random;

public class MontyHall {
    private final Random rnd = new Random();

    public void simulate(int iterations) {
        int switchWins = 0;
        int stayWins = 0;

        for (int i = 0; i < iterations; i++) {

            int prizeDoor = rnd.nextInt(3);
            int chosenDoor = rnd.nextInt(3);
            int openedDoor;

            do {
                openedDoor = rnd.nextInt(3);
            } while (openedDoor == prizeDoor || openedDoor == chosenDoor);

            stayWins += (chosenDoor == prizeDoor) ? 1 : 0;

            int switchDoor;
            do {
                switchDoor = rnd.nextInt(3);
            } while (switchDoor == chosenDoor || switchDoor == openedDoor);

            switchWins += (switchDoor == prizeDoor) ? 1 : 0;
        }

        System.out.println("Total rounds: " + iterations);
        System.out.println("Switch wins: " + switchWins + " or " + switchWins * 100 / iterations + "%");
        System.out.println("Stay wins: " + stayWins + " or " + stayWins * 100 / iterations + "%");
    }
}
