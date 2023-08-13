package ProgramsForGames;

import java.awt.Robot;
import java.awt.event.KeyEvent;

//Pressing WASD buttons constantly
public class WASD {

    //    public static void closing(long start) {
//        long total = System.currentTimeMillis() - start;
//        float sec = total / 1000F;
//        System.out.println("Script has been running for: " + sec + "seconds");
//        System.exit(0);
//    }
//    private static double round(double value, int precision) { ZAOKRUZIVANJE NA 2 DECIMALE!
//        int scale = (int) Math.pow(10, precision);
//        return (double) Math.round(value * scale) / scale;
//    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        try {
            System.out.println("Program will start in 2 seconds!");
            System.err.println("Program will be run for 30min(1.800.000s) unless it\'s stopped!");
            Thread.sleep(2500);

            Robot r = new Robot();
            int wasdNumber = 1;
            while (System.currentTimeMillis() > 1800000) {
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
                long total = System.currentTimeMillis() - start;
                float sec = total / 1000F;
                System.out.println("Script has been running for: " + Math.round(sec) + " seconds");
                Thread.sleep(2000);
            }

            //TO DO: F5==116 for closing

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}



