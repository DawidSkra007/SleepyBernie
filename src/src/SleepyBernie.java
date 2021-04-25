// put your code here
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class SleepyBernie implements Bot {
	// The public API of SleepyBernie must not change
	// You cannot change any other classes
	// SleepyBernie may not alter the state of the board or the player objects
	// It may only inspect the state of the board and the player objects
	// So you can use player.getNumUnits() but you can't use player.addUnits(10000), for example

	private BoardAPI board;
	private PlayerAPI player;
	private int botID, playerID, botCountries, playerCountries;
	private double[] botContinents, playerContinents;


	private double min = 0.5;

	private double[][] allProbabilities = {{0.417, 0.106, 0.027, 0.007, 0.002, 0, 0, 0, 0, 0},
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
	private ArrayList<Attack> possibleMoves = new ArrayList<Attack>();
	private ArrayList<Country> withBorder;
	private ArrayList<Country> withoutBorder;
	private ArrayList<Attack> refinedMoves = new ArrayList<Attack>();
	private ArrayList<Country> countries;
	private Attack PrevAttack;

	SleepyBernie (BoardAPI inBoard, PlayerAPI inPlayer) {
		board = inBoard;
		player = inPlayer;
		// put your code here
		botID = getbotID();
		playerID = getplayerID();
		botContinents = new double[6];
		playerContinents = new double[6];

		countries = createListOfCountries();
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
		// put your code here
		withBorder = new ArrayList<Country>();
		getwithBorder(0);

		if(withBorder.size() != 0){
			Collections.sort(withBorder, compareCountryByUnits);
			country = withBorder.get(0).name;
		} else {
			getwithBorder(-1);
			Collections.sort(withBorder, compareCountryByUnits);
			country = withBorder.get(0).name;
		}
		//replace spaces in country name
		country = country.replaceAll("\\s", "");
		command = country + " 1";
		return(command);
	}

	public String getPlacement (int forPlayer) {
		String command = "";
		// put your code here
		String country = "";

		ArrayList<Country> borderingEnemy = getEnemyNeutralNeighborsCountries(forPlayer);

		if(borderingEnemy.size() != 0){
			Collections.sort(borderingEnemy, compareCountryByUnits);
			country = borderingEnemy.get(0).name;
		}else{

			country = getRandomOwnedCountry(forPlayer);
		}
		//replace spaces in country name
		country = country.replaceAll("\\s", "");
		command = country;
		return(command);
	}

	public String getCardExchange () {
		String command = "";
		// put your code here
		if(player.isForcedExchange()){
			command = getCardTradeIns();
		}else{
			command = "skip";
		}

		return(command);
	}

	public String getBattle () {
		String command = "";
		// put your code here
		scanBoard();
		possibleMoves = new ArrayList<Attack>();
		getAllPossibleMoves();
		refinedMoves = new ArrayList<Attack>();
		getbestPosiibleMoves();
		Collections.sort(refinedMoves, compareAttackByProb);
		if (refinedMoves.size() > 0) {
			Attack chosenAttack = refinedMoves.get(refinedMoves.size() - 1);
			PrevAttack = chosenAttack;

			String attackName = GameData.COUNTRY_NAMES[chosenAttack.attackID].replaceAll("\\s", "");
			String defendName =  GameData.COUNTRY_NAMES[chosenAttack.defendID].replaceAll("\\s", "");
			int troops;
			if (chosenAttack.attacker > 3){
				troops = 3;
			} else {
				troops = chosenAttack.attacker-1;
			}
			command = attackName + " " + defendName + " " + troops;
		} else {
			command = "skip";
		}
		return(command);
	}

	public String getDefence (int countryId) {
		String command = "";
		// put your code here
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
		Fortify fortify = new Fortify(PrevAttack);
		command += fortify.numTroops();
		return(command);
	}

	public String getFortify () {
		String command = "";
		// put code here
		withoutBorder = new ArrayList<Country>();
		getcountrieswithoutBorder();
		Collections.sort(withoutBorder, compareCountryByUnits);
		if (withoutBorder.size() > 0) {
			possibleMoves = new ArrayList<Attack>();
			getAllPossibleMoves();
			Collections.sort(possibleMoves, compareAttackByProb);
			int i = 0;
			while (possibleMoves.size() > i && (!board.isConnected(withoutBorder.get(withoutBorder.size() - 1).index, possibleMoves.get(i).attackID))) {
				i++;
			}
			if (possibleMoves.size() > i) {
				String donator = GameData.COUNTRY_NAMES[withoutBorder.get(withoutBorder.size() - 1).index].replaceAll("\\s", "");
				String reciever = GameData.COUNTRY_NAMES[possibleMoves.get(i).attackID].replaceAll("\\s", "");
				int troops = 0;
				if (withoutBorder.get(withoutBorder.size() - 1).numUnits() > 1){
					if (withoutBorder.get(withoutBorder.size() - 1).numUnits() == 2){
						troops = 1;
					} else {
						troops = withoutBorder.get(withoutBorder.size() - 1).numUnits() * 2 / 3;
					}
					command = donator + " " + reciever + " " + troops;
				} else {
					command = "skip";
				}
			} else {
				command = "skip";
			}
		} else {
			command = "skip";
		}
		return(command);
	}

	//END OF PUBLIC API
	private String getCardTradeIns(){
		ArrayList<Card> myCards = player.getCards();
		int[] c = {0,0,0,0};         
		for(Card card: myCards){
			c[card.getInsigniaId()]++;
		}

		if(c[0] >= 3){
			return "iii";
		}
		if(c[1] >= 3){
			return "ccc";
		}
		if(c[2] >= 3){
			return "aaa";
		}
		if(c[0] >= 1 && c[1] >= 1 && c[2] >= 1){
			return "ica";
		}
		if(c[3] >= 1 && (c[0]+c[1]+c[2]) >= 2){
			if(c[0] >= 2){  return "iiw";}
			if(c[1] >= 2){  return "ccw";}
			if(c[2] >= 2){  return "aaw";}

			if(c[0]>=1 && c[1]>=1){ return "icw";}
			if(c[1]>=1 && c[2]>=1){ return "wca";}
			if(c[0]>=1 && c[2]>=1){ return "iwc";}
		}
		if(c[3] >= 2 && (c[0]+c[1]+c[2]) >= 1){
			if(c[0] >= 1){ return "iww";}
			if(c[1] >= 1){ return "cww";}
			if(c[2] >= 1){ return "aww";}
		}
		if(c[3] >= 3){
			return "www";
		}

		return "";
	}

	//method creates a list of all the countries on the board
	private ArrayList<Country> createListOfCountries(){
		ArrayList<Country> list = new ArrayList<>();
		for(int i=0; i<GameData.NUM_COUNTRIES; i++){
			list.add(new Country(i));
		}
		return list;
	}
	//method returns a list of countries belonging to enemy that border all of players countries
	private ArrayList<Country> getEnemyNeutralNeighborsCountries(int neutralId){
		ArrayList<Country> borderEnemies = new ArrayList<>();
		for(Country country: countries){
			if(country.owner() == playerID){
				for(int i=0; i<country.adjacents.length; i++){
					Country borderCountry = countries.get(country.adjacents[i]);
					if(borderCountry.owner() == neutralId){
						borderEnemies.add(borderCountry);
					}
				}
			}
		}
		return borderEnemies;
	}

	private String getRandomOwnedCountry(int forPlayer){
		ArrayList<Country> owned = new ArrayList<>();
		for(Country country: countries){
			if(country.owner() == forPlayer){
				owned.add(country);
			}
		}
		return owned.get((int)(Math.random() * owned.size() -1)).name;
	}

	public class Attack{
		int attacker, defender, attackID, defendID;
		double probability = 0;

		public Attack(int attack, int defend){
			attackID = attack;
			defendID = defend;
			attacker = board.getNumUnits(attack);
			defender = board.getNumUnits(defend);
			if (attacker > defender) {
				probability = ProbabiltyCalculator(attacker, defender);
			}
		}

		public double ProbabiltyCalculator(int a, int d){
			double prob = 0;
			if (a-1 <= 10 && d <= 10){
				prob = allProbabilities[a-1-1][d-1];
			} else if (a-1 > d){
				while (d > 10){
					a-=10;
					d-= 10;
				}
				if (a <= 20 && d >= 2) {
					prob = allProbabilities[a/2-1][d/2-1];
				} else {
					prob = 1;
				}
			}
			return prob;
		}
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

		public int owner(){return board.getOccupier(index);}

		public Boolean hasOwner(){return board.isOccupied(index);}

		public int numUnits(){ return board.getNumUnits(index);}
	}

	private void getbestPosiibleMoves(){
		for (int i=0; i<possibleMoves.size(); i++){
			if (possibleMoves.get(i).probability >= min) {
				refinedMoves.add(possibleMoves.get(i));
				int defenderCont = GameData.CONTINENT_IDS[possibleMoves.get(i).defendID];
				refinedMoves.get(refinedMoves.size()-1).probability += refinedMoves.get(refinedMoves.size()-1).probability * 0.5 * (Math.pow(botContinents[defenderCont], 2) + Math.pow(playerContinents[defenderCont], 2));
			}
		}
	}

	private void getAllPossibleMoves(){
		for (int i=0; i<GameData.NUM_COUNTRIES; i++){
			if (board.getOccupier(i) == botID){
				for (int j=0; j<GameData.ADJACENT[i].length; j++){
					if (board.getOccupier(GameData.ADJACENT[i][j]) != botID){
						possibleMoves.add(new Attack(i, GameData.ADJACENT[i][j]));
					}
				}
			}
		}
	}

	private void getwithBorder(int flag){
		for (int i=0; i<GameData.NUM_COUNTRIES; i++){
			if (board.getOccupier(i) == botID){
				for (int j=0; j<GameData.ADJACENT[i].length; j++){
					if (flag == -1) {
						if (board.getOccupier(GameData.ADJACENT[i][j]) != botID) {
							withBorder.add(new Country(i));
						}
					} else {
						if (board.getOccupier(GameData.ADJACENT[i][j]) == playerID) {
							withBorder.add(new Country(i));
						}
					}
				}
			}
		}
	}

	private void getcountrieswithoutBorder(){
		for (int i=0; i<GameData.NUM_COUNTRIES; i++){
			if (board.getOccupier(i) == botID){
				boolean flag = true;
				for (int j=0; j<GameData.ADJACENT[i].length; j++){
					if (board.getOccupier(GameData.ADJACENT[i][j]) != botID) {
						flag = false;
					}
				}
				if (flag){
					withoutBorder.add(new Country(i));
				}
			}
		}
	}

	private int getbotID(){ 
		return player.getId(); 
		
	}

	private int getplayerID(){
		if(getbotID() == 0){ return 1; }
		return 0;
	}
	
	private void scanBoard(){
		int owner;
		botCountries = 0;
		playerCountries = 0;
		int[][] continents = new int[2][6];
		for (int i=0; i<6; i++){
			continents[0][i] = 0;
			continents[1][i] = 0;
		}
		for (int i=0; i< GameData.NUM_COUNTRIES; i++){
			owner = board.getOccupier(i);
			if (owner == botID){
				botCountries++;
				continents[0][GameData.CONTINENT_IDS[i]]++;
			} else if (owner == playerID){
				playerCountries++;
				continents[1][GameData.CONTINENT_IDS[i]]++;
			}
		}
		for (int i=0;i<6; i++){
			botContinents[i] = (double)continents[0][i]/(double)GameData.CONTINENT_COUNTRIES[i].length;
			playerContinents[i] = (double)continents[1][i]/(double)GameData.CONTINENT_COUNTRIES[i].length;
		}
	}

	class Fortify{
		int donator;
		int receiver;

		public Fortify(Country d, Country r){
			donator = d.index;
			receiver = r.index;
		}

		public Fortify(Attack attack){
			donator = attack.attackID;
			receiver = attack.defendID;
		}

		public Boolean isPossible(){
			if(board.getNumUnits(donator) > 1 && board.isConnected(donator, receiver)){
				return true;
			}
			return false;
		}
		public int numTroops(){
			if(board.getNumUnits(donator) == 2){
				return 1;
			}
			return (board.getNumUnits(donator)/3)*2 -1;
		}

		public String toString(){
			return GameData.COUNTRY_NAMES[donator] + "(" + board.getNumUnits(donator) + ") " +
					"--(" + numTroops() + ")--> " +
					GameData.COUNTRY_NAMES[receiver] + "(" + board.getNumUnits(receiver) + ")";
		}
	}

	Comparator<Attack> compareAttackByProb = new Comparator<Attack>() {
		@Override
		public int compare(Attack a, Attack b) {
			return new Double(a.probability).compareTo(b.probability);
		}
	};
	Comparator<Country> compareCountryByUnits = new Comparator<Country>(){
		public int compare(Country a, Country b){
			return new Integer(a.numUnits()).compareTo(new Integer(b.numUnits()));
		}
	};

}