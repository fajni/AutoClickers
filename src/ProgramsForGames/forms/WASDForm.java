package ProgramsForGames.forms;

import ProgramsForGames.WASD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class WASDForm {

    private JPanel mainPanel;
    private JLabel label_Title;
    private JTextField textField_Time;
    private JTextField textField_EachButton;
    private JTextField textField_WASDTime;
    private JButton btn_Start;
    private JTextArea textArea_Output;

    public boolean isLong(String s) {
        try {
            long time = Long.parseLong(s);
        } catch (NumberFormatException nfe) {
            textArea_Output.setText("Wrong data types!");
            JOptionPane.showMessageDialog(null, "Wrong data types!");
            return false;
        }
        return true;
    }

    public static void setMyWindow() {
        JFrame frame = new JFrame("WASD Keys Clicker");
        frame.setContentPane(new WASDForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(700, 450);

        Dimension dimension = new Dimension();
        dimension.setSize(530, 400);

        frame.setMinimumSize(dimension);

        frame.setResizable(true);
    }

    public WASDForm() {

        btn_Start.addActionListener(action -> {

            if (Objects.equals(textField_Time.getText(), "") || Objects.equals(textField_EachButton.getText(), "") || Objects.equals(textField_WASDTime.getText(), "")) {

                textArea_Output.setText("Empty Fields Are Not Allowed!");
                JOptionPane.showInternalMessageDialog(null, "Empty Fields Are Not Allowed!", "Wrong Inputs", 2);

                return;
            }

            if (!isLong(textField_Time.getText()) || !isLong(textField_EachButton.getText()) || !isLong(textField_WASDTime.getText())) {

                return;
            }

            textArea_Output.setText(
                    "Time: " + textField_Time.getText() + " minutes" +
                            "\nTime For Each Button: " + textField_EachButton.getText() + " milliseconds" +
                            "\nTime Between Each WASD: " + textField_WASDTime.getText() + " milliseconds"
            );

            JOptionPane.showMessageDialog(null, "Application will be running for " + textField_Time.getText() + " minutes!");

            Long executionTime = Long.parseLong(textField_Time.getText());
            Long eachButton = Long.parseLong(textField_EachButton.getText());
            Long WASDTime = Long.parseLong(textField_WASDTime.getText());

            WASD.wasd(executionTime, eachButton, WASDTime);
        });
    }

    public static void main(String[] args) {
        setMyWindow();
    }
}
