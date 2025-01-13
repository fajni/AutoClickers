package autoclickers.forms;

import autoclickers.WASD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class WASDForm {

    private JPanel mainPanel;
    private JLabel label_Title;
    private JTextField textField_EachButton;
    private JTextField textField_WASDTime;
    private JButton btn_Start;
    private JTextArea textArea_Output;
    private JLabel s_ms;
    private JScrollPane scrollPane;
    private JButton btn_Stop;

    private final Map<String, String> convert = new LinkedHashMap<>() {{
        put("0.1", "100ms");
        put("0.5s", "500ms");
        put("1s", "1000ms");
        put("1min", "60 000ms");
        put("5min", "300 000ms");
        put("10min", "600 000ms");
        put("1h", "3 600 000ms");
        put("1h30min", "5 400 000ms");
    }};

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

            if (Objects.equals(textField_EachButton.getText(), "") || Objects.equals(textField_WASDTime.getText(), "")) {

                textArea_Output.setText("Empty Fields Are Not Allowed!");
                JOptionPane.showInternalMessageDialog(null, "Empty Fields Are Not Allowed!", "Wrong Inputs", 2);

                return;
            }

            if (!isLong(textField_EachButton.getText()) || !isLong(textField_WASDTime.getText())) {

                return;
            }

            textArea_Output.setText(
                            "Time For Each Button: " + textField_EachButton.getText() + " milliseconds" +
                            "\nTime Between Each WASD: " + textField_WASDTime.getText() + " milliseconds"
            );

            JOptionPane.showMessageDialog(null, "Application will run with current values!");

            Long eachButton = Long.parseLong(textField_EachButton.getText());
            Long WASDTime = Long.parseLong(textField_WASDTime.getText());

            new Thread(new Runnable() {

                @Override
                public void run() {
                    WASD.stop = false;
                    WASD.wasd(eachButton, WASDTime);
                }

            }).start();

        });

        btn_Stop.addActionListener(action -> {

            if(WASD.stop) {

                textArea_Output.setText("WASD is not running!");
                return;
            }

            textArea_Output.setText("WASD stopped!");
            JOptionPane.showMessageDialog(null, "WASD stopped!");
            WASD.stop = true;

        });

        s_ms.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                String s = "";

                for (Map.Entry<String, String> value : convert.entrySet()) {
                    s = s + (value.getKey() + " = " + value.getValue() + "\n");
                    System.out.println(value.getKey() + " = " + value.getValue());
                }

                textArea_Output.setText(s);
            }

        });

        textArea_Output.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                textArea_Output.setText(""); // clear textArea on click
            }

        });
    }

    public static void main(String[] args) {
        setMyWindow();
    }
}
