package ProgramsForGames.forms;

import ProgramsForGames.AutoClicker;

import javax.swing.*;

public class AutoClickerForm {
    private JPanel MainPanel;
    private JTextField textField_Time;
    private JButton btn_Start;
    private JTextField textField_TimePress;
    private JComboBox comboBox_MouseSide;
    private JTextArea clickNumberTextArea;

    public static void setMyWindow(){
        JFrame frame = new JFrame("AutoClicker Simple Application");
        frame.setContentPane(new AutoClickerForm().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(700, 450);
        frame.setResizable(true);
    }

    public static void main(String[] args) {

        AutoClicker a = new AutoClicker();
        setMyWindow();
    }
}
