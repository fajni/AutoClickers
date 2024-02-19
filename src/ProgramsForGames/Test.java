package ProgramsForGames;

import java.util.Scanner;

public class Test {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        System.out.println("Enter value for how long will script be running (minutes): ");
        long t = input.nextLong() * 60000;
        System.out.println("Value: " + (t / 60000) + " minutes");
        long start = System.currentTimeMillis();

        while (t > 0) {

            long before = System.currentTimeMillis();

            Thread.sleep(2000);

            long after = System.currentTimeMillis();
            long total = after - start;
            long time = after - before;

            System.out.println("Script has been running for: "+(total/1000)+ " seconds");

            t = t - time;
            System.out.println("T: "+t);
        }

    }
}
