// put your code here
//SleepyBernie
//Testing in provided Project
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class YourTeamName {
    // The public API of YourTeamName must not change
    // You cannot change any other classes
    // YourTeamName may not alter the state of the board or the player objects
    // It may only inspect the state of the board and the player objects
    // So you can use player.getNumUnits() but you can't use player.addUnits(10000), for example

    private BoardAPI board;
    private PlayerAPI player;
    private int myId, enemyId;
    private ArrayList<Country> countries;
    private ArrayList<Country> borderCountries;

    //***********************************************
    private double[][] probabilityMatrix = {{0.417, 0.106, 0.027, 0.007, 0.002, 0, 0, 0, 0, 0},
            {0.754, 0.363 ,0.206, 0.091, 0.049, 0.021, 0.011, 0.005, 0.003, 0.001},
            {0.916, 0.656, 0.470, 0.315, 0.206, 0.134, 0.084, 0.054, 0.033, 0.021},
            {0.972, 0.785, 0.642, 0.477, 0.359, 0.253, 0.181, 0.123, 0.086, 0.057},
            {0.990, 0.890, 0.769, 0.638, 0.506, 0.397, 0.297, 0.224, 0.162, 0.118},
            {0.997, 0.934, 0.857, 0.745, 0.638, 0.521, 0.423, 0.329, 0.258, 0.193},
            {0.999, 0.967, 0.910, 0.834, 0.736, 0.640, 0.536, 0.446, 0.357, 0.287},
            {1, 0.980, 0.947, 0.888, 0.818, 0.730, 0.643, 0.547, 0.464, 0.380},
            {1, 0.990, 0.967, 0.930, 0.873, 0.808, 0.726, 0.646, 0.558, 0.480},
            {1, 0.994, 0.981, 0.954, 0.916, 0.861, 0.8, 0.724, 0.65, 0.568},
    };

    YourTeamName (BoardAPI inBoard, PlayerAPI inPlayer) {
        board = inBoard;
        player = inPlayer;
        myId = getMyId();
        enemyId = getEnemyId();
        return;
    }

    public String getName () {
        String command = "";
        // put your code here
        command = "SleepyBernie";
        return(command);
    }

    public String getReinforcement () {
        String command = "";
        String country = "";

        borderCountries = new ArrayList<Country>();
        getBorderCountries(0);
        //least protected territory bordering the enemy
        if (borderCountries.size() != 0) {
            Collections.sort(borderCountries, compareCountryByUnits);
            country = borderCountries.get(0).name;
        } else {
            getBorderCountries(-1);
            Collections.sort(borderCountries, compareCountryByUnits);
            country = borderCountries.get(0).name;
        }

        country = country.replaceAll("\\s", "");
        command = country + " 1";
        return(command);
    }

    public String getPlacement (int forPlayer) {
        String command = "";
        String country = "";

        ArrayList<Country> borderingEnemy = getEnemyNeutralNeighbors(forPlayer);
        //get the least protected territory bordering the enemy
        if(borderingEnemy.size() != 0) {
            Collections.sort(borderingEnemy, compareCountryByUnits);
            country = borderingEnemy.get(0).name;
        } else {
            //only when no countries border enemy
            country = getRandomOwned(forPlayer);
        }

        country = country.replaceAll("\\s", "");
        command = country;
        return(command);
    }

    public String getCardExchange () {
        String command = "";
        // put your code here
        command = "skip";
        return(command);
    }

    public String getBattle () {
        String command = "";
        // put your code here
        command = "skip";
        return(command);
    }

    public String getDefence (int countryId) {
        String command = "";
        if (board.getNumUnits(countryId) >= 2){
            command += 2;
        } else {
            command += 1;
        }
        return(command);
    }

    public String getMoveIn (int attackCountryId) {
        String command = "";
        // put your code here
        command = "0";
        return(command);
    }

    public String getFortify () {
        String command = "";
        // put code here
        command = "skip";
        return(command);
    }

    class Country {
        public int index;
        public String name;
        public int continent;
        public int[] adjacents;

        public Country(int ind) {
            index = ind;
            name = GameData.COUNTRY_NAMES[index];
            continent = GameData.CONTINENT_IDS[index];
            adjacents = GameData.ADJACENT[index];
        }

        public int owner(){ return board.getOccupier(index);}

        public Boolean hasOwner(){ return board.isOccupied(index);}

        public int numUnits(){ return board.getNumUnits(index);}
    }

    private int getMyId() { return player.getId(); }

    private int getEnemyId() {
        if  (getMyId() == 0) {
            return 1;
        }
        return 0;
    }

    private void getBorderCountries(int flag) {
        for (int i = 0; i < GameData.NUM_COUNTRIES; i++) {
            if (board.getOccupier(i) == myId) {
                for (int j = 0; j < GameData.ADJACENT[i].length; j++) {
                    if (flag == -1) {
                        if (board.getOccupier(GameData.ADJACENT[i][j]) != myId) {
                            borderCountries.add(new Country(i));
                        }
                    } else {
                        if (board.getOccupier(GameData.ADJACENT[i][j]) == enemyId) {
                            borderCountries.add(new Country(i));
                        }
                    }
                }
            }
        }
    }

    Comparator<Country> compareCountryByUnits = new Comparator<Country>() {
        public int compare(Country a, Country b){
            return Integer.compare(a.numUnits(), b.numUnits());
        }
    };

    private String getRandomOwned(int forPlayer) {
        ArrayList<Country> owned = new ArrayList<>();
        for(Country country : countries){
            if(country.owner() == forPlayer){
                owned.add(country);
            }
        }
        return owned.get((int)(Math.random() * owned.size() - 1)).name;
    }

    private ArrayList<Country> getEnemyNeutralNeighbors(int neutralId) {
        ArrayList<Country> borderEnemies = new ArrayList<>();
        for (Country country : countries) {
            if ( country.owner() == enemyId) {
                for (int i = 0; i < country.adjacents.length; i++) {
                    Country borderCountry = countries.get(country.adjacents[i]);
                    if ( borderCountry.owner() == neutralId) {
                        borderEnemies.add(borderCountry);
                    }
                }
            }
        }
        return borderEnemies;
    }

}
