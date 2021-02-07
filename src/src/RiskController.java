import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
/*
 * Dawid Skraba 19433692
 * Loghlen Rickard 1836227
 * Adi Gatt 19202928
 */
public class RiskController {

    static String[] init = {};
    public Player p1 = new Player("null",init);
    public Player p2 = new Player("null",init);
    public Neutral n1 = new Neutral();
    public Neutral n2 = new Neutral();
    public Neutral n3 = new Neutral();
    public Neutral n4 = new Neutral();


    private String input;

    public static JTextField textField;
    public static JTextArea outputArea;
    public static String inputText;


    public void initialize(){
        outputArea.setText("");

        addText("Enter the name of Player 1: ");

        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input = "";
                input = textField.getText();

                if(p1.getName().equals("null")){
                    p1.setName(input);
                    addText("Player 1 set their name to: " + p1.getName());

                    addText("Enter the name of Player 2: ");
                    textField.setText("");
                }
                else{
                    p2.setName(input);
                    addText("Player 2 set their name to: " + p2.getName());

                    assignCountries();
                }

            }
        };

        textField.addActionListener(action);
    }

    public RiskController(JTextField textF,  JTextArea outputA){
        textField = textF;
        outputArea = outputA;
    }

    public void addText(String s){
        outputArea.setText(outputArea.getText() + "\n" + s);
    }

    public void assignCountries() {
        try {
            File countryList = new File("src/countries.txt");
            Scanner myReader = new Scanner(countryList);

            int i;
            String[] countryAssigningP1 = new String[9];
            String[] countryAssigningP2 = new String[9];
            String[] countryAssigningN1 = new String[6];
            String[] countryAssigningN2 = new String[6];
            String[] countryAssigningN3 = new String[6];
            String[] countryAssigningN4 = new String[6];


            for(i = 0; i < 9; i++){
                countryAssigningP1[i] = myReader.nextLine();
            }
            p1.setTerritories(countryAssigningP1);

            for(i = 0; i < 9; i++){
                countryAssigningP2[i] = myReader.nextLine();
            }
            p2.setTerritories(countryAssigningP2);

            for(i = 0; i < 6; i++){
                countryAssigningN1[i] = myReader.nextLine();
            }
            n1.setTerritories(countryAssigningN1);

          //  Arrays.fill(countryAssigningN, null);

            for(i = 0; i < 6; i++){
                countryAssigningN2[i] = myReader.nextLine();
            }
            n2.setTerritories(countryAssigningN2);

           // Arrays.fill(countryAssigningN, null);

            for(i = 0; i < 6; i++){
                countryAssigningN3[i] = myReader.nextLine();
            }
            n3.setTerritories(countryAssigningN3);

           // Arrays.fill(countryAssigningN, null);

            for(i = 0; i < 6; i++){
                countryAssigningN4[i] = myReader.nextLine();
            }
            n4.setTerritories(countryAssigningN4);



            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        for (String test2 : p1.getTerritories()){
            System.out.println("Player 1 " + test2);
        }
        for (String test2 : p2.getTerritories()){
            System.out.println("Player 2: " + test2);
        }
        for (String test2 : n1.getTerritories()){
            System.out.println("Neutral 1 " + test2);
        }
        for (String test2 : n2.getTerritories()){
            System.out.println("Neutral 2: " + test2);
        }
        for (String test2 : n3.getTerritories()){
            System.out.println("Neutral 3 " + test2);
        }
        for (String test2 : n4.getTerritories()){
            System.out.println("Neutral 4: " + test2);
        }
    }

}
