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
    public static String lastCommand;
    public static int count = 0;
    private  static final JTextArea OutputArea = new JTextArea(5,10);

    //map




    public JScrollPane Output(){ //output
        JPanel OutputPanel = new JPanel();

        OutputPanel.setBackground(Color.LIGHT_GRAY);
        JScrollPane scrollPane = new JScrollPane(OutputArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
        JTextField textField = new JTextField("",83);
        JPanel input = new JPanel();



        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addText(textField.getText());
                lastCommand = textField.getText();
                count++;
                textField.setText("");

                if(count == 1){
                    Player1.name = lastCommand;
                    addText("Enter name of player 2");
                }
                else if(count == 2){
                    Player2.name = lastCommand;
                }

            }
        };

        textField.addActionListener(action);
        input.add(textField);


        return input;
    }



    public static void showNames(){
        addText(Player1.name + " " + Player2.name);
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


        addText("Enter name of player 1");



    }
}
