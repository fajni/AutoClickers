package autoclickers;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

//Pressing WASD buttons constantly
public class WASD {

    public static Scanner input = new Scanner(System.in);

//    private static double round(double value, int precision) { ZAOKRUZIVANJE NA 2 DECIMALE!
//        int scale = (int) Math.pow(10, precision);
//        return (double) Math.round(value * scale) / scale;
//    }

    public static void wasd(Long executionTime, Long eachButton, Long WASDTime) {

        executionTime = executionTime * 60000;

        try {
            System.out.println("Program will start in 2 seconds!");
            Thread.sleep(2500);

            Robot r = new Robot();

            int wasdCounter = 1; // wasd counter

            long start = System.currentTimeMillis();
            while (executionTime > 0) {

                long before = System.currentTimeMillis();

                Thread.sleep(WASDTime);

                System.out.println("WASD Number: " + wasdCounter);

                // W
                r.keyPress(KeyEvent.VK_W);
                Thread.sleep(eachButton);
                r.keyRelease(KeyEvent.VK_W);

                // A
                r.keyPress(KeyEvent.VK_A);
                Thread.sleep(eachButton);
                r.keyRelease(KeyEvent.VK_A);

                // S
                r.keyPress(KeyEvent.VK_S);
                Thread.sleep(eachButton);
                r.keyRelease(KeyEvent.VK_S);

                // D
                r.keyPress(KeyEvent.VK_D);
                Thread.sleep(eachButton);
                r.keyRelease(KeyEvent.VK_D);

                wasdCounter++;

                long after = System.currentTimeMillis();
                long total = after - start;
                long time = after - before;

                System.out.println("Script has been running for: " + (total / 1000) + " seconds");

                executionTime = executionTime - time;
            }

            //TODO: F5==116 for closing

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("Enter value for how long will script be running (minutes): ");
        long executionTime = input.nextLong();
        System.out.println("Value: " + (executionTime / 60000) + " minutes");

        System.out.println("Enter value for how long will each button be pressed (milliseconds): ");
        long eachButton = input.nextLong();
        System.out.println("Value: " + (eachButton) + " milliseconds");

        System.out.println("Enter time between each WASD combo (milliseconds): ");
        long WASDTime = input.nextLong();
        System.out.println("Value: " + (WASDTime) + " minutes");

        wasd(executionTime, eachButton, WASDTime);
    }
}



