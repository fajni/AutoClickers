package ProgramsForGames.forms;

import ProgramsForGames.AutoClicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class AutoClickerForm {
    private JPanel mainPanel;
    private JTextField textField_TimeBetween;
    private JButton btn_Start;
    private JTextField textField_TimePress;
    private JComboBox comboBox_MouseSide;
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
        JFrame frame = new JFrame("AutoClicker Simple Application");
        frame.setContentPane(new AutoClickerForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        frame.setSize(700, 450);

        Dimension dimension = new Dimension();
        dimension.setSize(500, 350);

        frame.setMinimumSize(dimension);

        frame.setResizable(true);
    }

    public int setMouseButton(String side) {

        switch (side) {
            case "Left Side":
                return InputEvent.BUTTON1_DOWN_MASK;
            case "Middle Side":
                return InputEvent.BUTTON2_DOWN_MASK;
            case "Right Side":
                return InputEvent.BUTTON3_DOWN_MASK;
            default:
                return 0;
        }
    }

    public AutoClickerForm() {

        btn_Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Objects.equals(textField_TimeBetween.getText(), "") || comboBox_MouseSide.getSelectedItem() == null || Objects.equals(textField_TimePress.getText(), "")) {
                    textArea_Output.setText("Empty Fields Are Not Allowed!");
                    JOptionPane.showInternalMessageDialog(null, "Empty Fields Are Not Allowed!", "Wrong Inputs", 2);
                    return;
                }

                if (!isLong(textField_TimeBetween.getText()) || !isLong(textField_TimePress.getText())) {
                    return;
                }

                textArea_Output.setText(
                        "Time between clicks: " + textField_TimeBetween.getText() + " seconds" +
                                "\nMouse Side: " + comboBox_MouseSide.getSelectedItem() +
                                "\nTime Press: " + textField_TimePress.getText() + " seconds"
                );

                JOptionPane.showMessageDialog(null, "Starting the application with current values!");

                long timeBetweenClicks = Long.parseLong(textField_TimeBetween.getText());
                long press = Long.parseLong(textField_TimePress.getText());
                int mouseButton = setMouseButton((String) comboBox_MouseSide.getSelectedItem()); //1=Left, 2=Right, 3=Middle

                System.out.println("Time between clicks: " + timeBetweenClicks + "s, Time press: " + press + ", Mouse Side: " + mouseButton);

                AutoClicker.click(timeBetweenClicks, press, mouseButton);
            }
        });
    }

    public static void main(String[] args) {
        setMyWindow();
        //new AutoClickerForm();
    }
}
