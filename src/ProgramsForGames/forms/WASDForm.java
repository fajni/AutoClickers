package ProgramsForGames.forms;

import ProgramsForGames.WASD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class WASDForm {

    private JPanel mainPanel;
    private JLabel label_Title;
    private JTextField textField_Time;
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
        dimension.setSize(500, 350);

        frame.setMinimumSize(dimension);

        frame.setResizable(true);
    }

    public WASDForm(){
        btn_Start.addActionListener(action -> {
            if(!isLong(textField_Time.getText())){
                return;
            }

            textArea_Output.setText(
                    "Time: "+textField_Time.getText() +" minutes"
            );

            JOptionPane.showMessageDialog(null, "Application will be running "+textField_Time.getText()+" minutes!");

            Long t = Long.parseLong(textField_Time.getText());
            WASD.wasd(t);
        });
    }

    public static void main(String[] args) {
        setMyWindow();
    }
}
