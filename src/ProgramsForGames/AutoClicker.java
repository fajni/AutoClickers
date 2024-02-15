package ProgramsForGames;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Scanner;

public class AutoClicker {

    public static Scanner input = new Scanner(System.in);

    private static long timeBetweenClicks2; //2500
    private static long press2; //500
    private static int mouseButton2;

    private long timeBetweenClicks;
    private long press;
    private int mouseButton;

    public AutoClicker() {
    }

    public AutoClicker(long timeBetweenClicks, long press, int mouseButton) {
        super();
        this.timeBetweenClicks = timeBetweenClicks;
        this.press = press;
        this.mouseButton = mouseButton;
    }

    public static void inputTime() {
        System.out.println("***Enter time between clicks in milliseconds (1s = 1000ms)***");
        System.out.print("Input: ");
        timeBetweenClicks2 = input.nextLong();//*1000 for seconds
        System.out.println("***For how long is mouse pressed in milliseconds***");
        System.out.print("Input: ");
        press2 = input.nextLong();
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
            mouseButton2 = InputEvent.BUTTON3_DOWN_MASK; //Right side
        else if (side == 1)
            mouseButton2 = InputEvent.BUTTON1_DOWN_MASK; //Left side
        else
            mouseButton2 = InputEvent.BUTTON2_DOWN_MASK; //Middle
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
                Thread.sleep(press * 1000);
                r.mouseRelease(mouseButton);
                Thread.sleep(timeBetweenClicks * 1000);
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
        click(timeBetweenClicks2, press2, mouseButton2);

    }
}
