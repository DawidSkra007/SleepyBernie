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
    private  static final JTextArea OutputArea = new JTextArea(5,10);

    //map


    public static JScrollPane Output(){ //output
        JPanel OutputPanel = new JPanel();

        OutputPanel.setBackground(Color.LIGHT_GRAY);
        JScrollPane scrollPane = new JScrollPane(OutputArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        OutputPanel.add(scrollPane,BorderLayout.CENTER);
        OutputArea.setEditable(false);
        OutputPanel.add(scrollPane);
        OutputPanel.setVisible(true);
        return scrollPane;
    }
    public static void addText(String s){
        OutputArea.setText(OutputArea.getText() + "\n" + s);
    }

    public Component text() {
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

        jfr.add(gui.text(),BorderLayout.SOUTH);
        jfr.add(gui.Output(),BorderLayout.WEST);
        jfr.setResizable(false);
        jfr.setVisible(true);
    }
}
