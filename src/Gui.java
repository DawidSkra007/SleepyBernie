import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class Player1{
    public static String name;
}

class Player2{
    public static String name;
}

public class Gui {
    public JTextArea textArea;

    JPanel map = new JPanel();

    //implementing map


    public Component input() {
        JPanel input = new JPanel();
        JTextField textField = new JTextField("",83);

        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player1.name = textField.getText();
                textArea.append(Player1.name + "\n");
                textField.setText("");

                Player2.name = textField.getText();
                textArea.append(Player2.name + "\n");
                textField.setText("");
            }
        };

        textField.addActionListener(action);
        String value = textField.getText();
        input.add(textField);
        return input;
    }

    public static void main(String[] args) {
        Gui gui = new Gui();

        JFrame jfr = new JFrame("Risk");
        jfr.setSize(1000, 600);
        jfr.setLayout(new BorderLayout());
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfr.add(gui.input(),BorderLayout.PAGE_END);
        jfr.pack();
        jfr.setResizable(false);
        jfr.setVisible(true);
    }
}
