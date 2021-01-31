import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {

    JPanel map = new JPanel();

    //implementing map

    JPanel output = new JPanel();

    //implementing output terminal

    public Component text() {
        JPanel input = new JPanel();
        JTextField textField = new JTextField("",83);

        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String in = textField.getText();
                textField.setText("");
                System.out.println(in);//prints to console (debugging)
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
        jfr.add(gui.text(),BorderLayout.SOUTH);
        jfr.setResizable(false);
        jfr.setVisible(true);
    }
}
