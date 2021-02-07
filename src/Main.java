import javax.swing.*;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Country {

    private String name;

    int Units;
    private int x;
    private int y;
    private int width;
    private int height;


    public Country(String name, int x, int y, int width, int height)  {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public String getName() {
        return name;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}

    public class Main extends JFrame {
    	private static List<Set<Country>> continents;
        public  static  Country[] countries = new Country[42];
        public static void addCountries() {
            countries[0] = new Country("Ontario", 191,150, 80, 80);
            countries[1] = new Country("Quebec", 255,161, 80, 50);
            countries[2] = new Country("NW Territory", 146,86, 105, 55);
            countries[3] = new Country("Alberta", 123,144, 50, 80);
            countries[4] = new Country("Greenland", 314,61, 80, 60);
            countries[5] = new Country("E United States", 205,235, 120, 50);
            countries[6] = new Country("W United States", 135,219, 60, 50);
            countries[7] = new Country("Central America", 140,299, 50, 70);
            countries[8] = new Country("Alaska", 45,89, 100, 100);
            countries[9] = new Country("Great Britain", 370,199, 70, 50);
            countries[10] = new Country("W Europe", 398,280, 90, 120);
            countries[11] = new Country("S Europe", 465,270, 40, 120);
            countries[12] = new Country("Ukraine", 547,180, 70, 100);
            countries[13] = new Country("N Europe", 460,200, 20, 40);
            countries[14] = new Country("Iceland", 393,127, 20, 20);
            countries[15] = new Country("Scandinavia", 463,122, 60, 40);
            countries[16] = new Country("Afghanistan", 628,227, 50, 100);
            countries[17] = new Country("India",679,332, 100, 110);
            countries[18] = new Country("Middle East", 572,338, 80, 40);
            countries[19] = new Country("Japan", 861,213, 60, 40);
            countries[20] = new Country("Ural", 645,152, 20, 40);
            countries[21] = new Country("Yakutsk", 763,70, 70, 40);
            countries[22] = new Country("Kamchatka", 827,940, 90, 90);
            countries[23] = new Country("Siam", 751,360, 80, 110);
            countries[24] = new Country("Irkutsk", 750,140, 60, 60);
            countries[25] = new Country("Siberia", 695,108, 80, 110);
            countries[26] = new Country("Mongolia", 760,216, 110, 70);
            countries[27] = new Country("China", 735,277, 70, 70);
            countries[28] = new Country("E Australia", 889,537, 80, 55);
            countries[29] = new Country("New Guinea", 850,429, 60, 100);
            countries[30] = new Country("W Australia", 813,526, 90, 70);
            countries[31] = new Country("Indonesia", 771,454, 30, 75);
            countries[32] = new Country("Venezuela", 213,352, 40, 70);
            countries[33] = new Country("Peru",221,426, 60, 30);
            countries[34] = new Country("Brazil", 289,415, 60, 25);
            countries[35] = new Country("Argentina",233,523, 60, 25);
            countries[36] = new Country("Congo", 496,462, 30, 70);
            countries[37] = new Country("N Africa", 440,393, 20, 40);
            countries[38] = new Country("S Africa", 510,532, 30, 30);
            countries[39] = new Country("Egypt", 499,354, 60, 70);
            countries[40] = new Country("E Africa", 547,432, 50, 70);
            countries[41] = new Country("Madagascar", 586,545, 40, 25);
        }
        
        private static void addContinents() {

            continents = new ArrayList<Set<Country>>();
            for (int i = 0; i < 6; i++) {
                continents.add(i, new TreeSet<Country>());
            }
            // North America
            Set<Country> thisContinent = continents.get(0);
            for (int i = 0; i < 9; i++) {
                thisContinent.add(countries[i]);
            }
            // Europe
            thisContinent = continents.get(1);
            for (int i = 9; i < 16; i++) {
                thisContinent.add(countries[i]);
            }
            // Asia
            thisContinent = continents.get(2);
            for (int i = 16; i < 29; i++) {
                thisContinent.add(countries[i]);
            }
            // Australia
            thisContinent = continents.get(3);
            for (int i = 28; i < 32; i++) {
                thisContinent.add(countries[i]);
            }
            // South America
            thisContinent = continents.get(4);
            for (int i = 32; i < 36; i++) {
                thisContinent.add(countries[i]);
            }
            // Africa
            thisContinent = continents.get(5);
            for (int i = 36; i < 42; i++) {
                thisContinent.add(countries[i]);
            }
        }

        
   
        // This needs to assign 9 territores to both users and than 6 to neturals

         
        //Still need a function for adjacents 
        
        //Need function to display troops in country
  
    
    
        Main() {
            {
                setSize(1000, 600);
                setTitle("Risk");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLayout(new BorderLayout());
                setVisible(true);
            }
        }



        public static void main(String[] Args) {
            Main m = new Main();
            addCountries();
            addContinents();
            m.repaint();

        }

        @Override
        public void paint(Graphics g) {
            for(int i = 0; i< 42; i++){
                g.drawRect(countries[i].getX(),countries[i].getY(),countries[i].getWidth(),countries[i].getHeight());
                g.drawString(countries[i].getName(), countries[i].getX() +30 ,countries[i].getY()+ 20);
        }
    }
    }


