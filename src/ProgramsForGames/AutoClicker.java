package ProgramsForGames;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AutoClicker {

    public static Scanner input = new Scanner(System.in);

    private static long timeBetweenClicks; //2500
    private static long press; //500
    private static int mouseButton;

    public static void inputTime() {
        System.out.println("***Enter time between clicks in milliseconds (1s = 1000ms)***");
        System.out.print("Input: ");
        timeBetweenClicks = input.nextLong();//*1000 for seconds
        System.out.println("***For how long is mouse pressed in milliseconds***");
        System.out.print("Input: ");
        press = input.nextLong();
    }

    public static void chooseSide() {
        System.out.print("Enter what side of a mouse will be clicked (1=Left, 2=Right, 3=Middle): ");
        int side = input.nextInt();
        while (true) {
            if (side == 1 || side == 2 || side == 3)
                break;
            System.out.print("Enter a valid value: ");
            side = input.nextInt();
        }

        if (side == 2)
            mouseButton = InputEvent.BUTTON3_DOWN_MASK; //Right side
        else if (side == 1)
            mouseButton = InputEvent.BUTTON1_DOWN_MASK; //Left side
        else
            mouseButton = InputEvent.BUTTON2_DOWN_MASK; //Middle
    }

    public static void click(long timeBetweenClicks, long press, int mouseButton) {
        try {

            System.out.println("Script is starting in 2 seconds!");
            Thread.sleep(2500);

            Robot r = new Robot();

            int clicks = 1;
            while (true) {
                System.out.println("Click number: " + clicks);
                r.mousePress(mouseButton);
                Thread.sleep(press);
                r.mouseRelease(mouseButton);
                Thread.sleep(timeBetweenClicks);
                clicks++;
            }
        } catch (Exception e) {
            System.err.println("ERROR OCCURRED!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        inputTime();
        chooseSide();
        click(timeBetweenClicks, press, mouseButton);

    }
}
