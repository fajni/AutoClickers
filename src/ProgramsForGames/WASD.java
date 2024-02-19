package ProgramsForGames;

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

    public static void wasd(Long t){

        t =  t * 60000;

        try {
            System.out.println("Program will start in 2 seconds!");
            Thread.sleep(2500);

            Robot r = new Robot();

            int wasdNumber = 1;
            long start = System.currentTimeMillis();
            while ( t > 0) {

                long before = System.currentTimeMillis();
                Thread.sleep(1400);

                System.out.println("WASD Number: " + wasdNumber);
                r.keyPress(KeyEvent.VK_W);
                Thread.sleep(150);
                r.keyRelease(KeyEvent.VK_W);
                r.keyPress(KeyEvent.VK_A);
                Thread.sleep(150);
                r.keyRelease(KeyEvent.VK_A);
                r.keyPress(KeyEvent.VK_S);
                Thread.sleep(150);
                r.keyRelease(KeyEvent.VK_S);
                r.keyPress(KeyEvent.VK_D);
                Thread.sleep(150);
                r.keyRelease(KeyEvent.VK_D);
                wasdNumber++;

                long after = System.currentTimeMillis();
                long total = after - start;
                long time = after - before;
                System.out.println("Script has been running for: "+(total/1000)+ " seconds");
                t = t - time;
            }

            //TO DO: F5==116 for closing

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("Enter value for how long will script be running (minutes): ");
        long t = input.nextLong();
        System.out.println("Value: " + (t/60000) + " minutes");

        wasd(t);
    }
}



