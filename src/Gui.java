import javax.swing.*;
import java.awt.*;

public class Gui {

    JPanel map = new JPanel();

    //implementing map

    JPanel output = new JPanel();

    //implementing output terminal

    JPanel input = new JPanel();

    //implementing input box


    public static void main(String[] args) {
        JFrame jfr = new JFrame("Risk");
        jfr.setSize(1000, 600);
        jfr.setLayout(new FlowLayout());
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfr.setVisible(true);

    }
}
