import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
/*
 * Dawid Skraba 19433692
 * Loghlen Rickard 1836227
 * Adi Gatt 19202928
 */
public class Risk {
	
    //Main Method
    public static void main(String[] args) {
        //Draw main game box
        JFrame frame = new JFrame();
        //Panel
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder( 30,30,10,30));
        panel.setLayout(new GridLayout(0,1));
        panel.setBackground(Color.WHITE);


        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(1200,800);
        frame.setTitle("Risk");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Draw output box at the top of the screen
        JTextArea outputArea = new JTextArea(5,10);
        JPanel outputPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(outputArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        outputPanel.add(scrollPane, BorderLayout.CENTER);
        outputArea.setEditable(false);
        outputPanel.add(scrollPane);
        outputPanel.setVisible(true);

        //Text field for user input
        JTextField textField = new JTextField("",50);

        RiskController controller = new RiskController(textField, outputArea);
        Draw component = new Draw();
        

        //Input Text
        frame.add(textField,BorderLayout.SOUTH);
        frame.add(scrollPane,BorderLayout.NORTH);

        controller.initialize();

        panel.add(component);
        frame.setVisible(true);
    }
}
