import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JFrame;

public class UI {

	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT = 800;
	private static String PROMPT = "> ";

	private JFrame frame = new JFrame();
	private MapPanel mapPanel;	
	private InfoPanel infoPanel = new InfoPanel();
	private CommandPanel commandPanel = new CommandPanel();
	private Parse parse = new Parse();
	private Board board;
	
	UI (Board inBoard) {
		board = inBoard;
		mapPanel = new MapPanel(board);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Risk");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mapPanel, BorderLayout.NORTH);
		frame.add(infoPanel, BorderLayout.CENTER);
		frame.add(commandPanel,BorderLayout.SOUTH);
		frame.setResizable(false);
		frame.setVisible(true);
		return;
	}
	
	public String makeLongName (Player player) {
		return player.getName() + " (" + mapPanel.getColorName(player.getId()) + ") ";
	}
	
	public void displayMap () {
		mapPanel.refresh();
		return;
	}

	public void displayString (String string) {
		infoPanel.addText(string);
		return;
	}
	
	public void displayName (int playerId, String name) {
		displayString("Neutral player " + (playerId+1) + " is " + mapPanel.getColorName(playerId));
		return;		
	}

	public void displayCardDraw (Player player, Card card) {
		displayString(makeLongName(player) + " draws the " + card.getCountryName() + " card");
		return;
	}
	
	public void displayDice (Player player) {
		displayString(makeLongName(player) + " rolls " + player.getDice() );
		return;
	}
	
	public void displayRollWinner (Player player) {
		displayString(makeLongName(player)  + " wins roll and goes first");
		return;
	}
	
	public String inputName (int playerId) {
		String response;
		displayString("Enter the name for player " + (playerId+1) + " (" + mapPanel.getColorName(playerId) + "):");
		response = commandPanel.getCommand();
		response.trim();
		displayString(PROMPT + response);
		return response;		
	}
		
	public void inputPlacement (Player byPlayer, Player forPlayer) {
		String response, message;
		boolean placementOK = false;
		do {
			message = makeLongName(byPlayer) + ": Enter a country to reinforce with ";
			if (byPlayer.equals(forPlayer)) {
				message += "your own units";				
			} else {
				message += makeLongName(forPlayer) + "'s units";
			}
			displayString(message);
			response = commandPanel.getCommand();
			displayString(PROMPT + response);
			parse.countryId(response);
			if (parse.isError()) {
				displayString("Error: Not a country");
			} else {
				if (!board.checkOccupier(forPlayer, parse.getCountryId())) {
					displayString("Error: Cannot place the units on that country");
				} else {
					placementOK = true;
				}
			}
		} while (!placementOK);
		return;
	}
	public int[] inputAttack(Player byPlayer) {
		String response;
		String country_Attacking, country_Defending;
		int units_Attacking;
		int[] return_values = new int[3];
		boolean country1_OK = false;
		boolean country2_OK = false;
		do {
			displayString("\n" + makeLongName(byPlayer) +
					"Enter country to attack from, country to attack and number of units to use, or enter skip");
			displayString("\n separate each input by a space");
			response = commandPanel.getCommand();
			displayString(PROMPT + response);

			country_Attacking = response.substring(0, response.indexOf(" "));
			response = response.substring(response.indexOf(" "));
			country_Defending = response.substring(0, response.indexOf(" "));
			response = response.substring(response.indexOf(" "));
			units_Attacking = Integer.parseInt(response);

			parse.countryId((country_Attacking));

			if (parse.isError()) {
				displayString("Error: Not a country");
			} else {
				if (!board.checkOccupier(byPlayer, parse.getCountryId())) {
					displayString("Error: Cannot attack from that country");
				}
				else{country1_OK =true;}
			}
			return_values[0] = parse.getCountryId();
			if(units_Attacking > parse.getNumUnits()-1 || units_Attacking > 3){
				displayString("Not enough units in country or more than 3 units have been selected");
				country1_OK = false;
			}
			parse.countryId(country_Defending);
			if (parse.isError()) {
				displayString("Error: Not a country");
			}
			else{country2_OK = true;}
			//*****check adjacent******

				return_values[1] = parse.getCountryId();
				return_values[2] = units_Attacking;
			}

			while (!country1_OK && !country2_OK) ;
			return return_values;
	}
	public int inputDefense(Player defender, int countryDefending){
		int defenders;
		boolean unitsOK = false;
		do {
			displayString("Enter number of units to attack with");
			defenders = Integer.parseInt(commandPanel.getCommand());
			if(defenders > board.getNumUnits(countryDefending) || defenders > 2){
				displayString("not enough units or more than 2 units have been selected");
			}
			else{
				unitsOK = true;
			}
		}while(!unitsOK);
		return defenders;
	}
	public void diceCombat(Player attacker, Player defender, int unitsAttacking, int unitsDefending, int countryAttacking,
						   int countryDefending){
		ArrayList<Integer> attackerRolls = new ArrayList<>();
		ArrayList<Integer> defenderRolls = new ArrayList<>();
		int attackerHighest = 0;
		int defenderHighest = 0;
		int dec_Attacker = 0;int dec_Defender = 0;
		attacker.rollDice(unitsAttacking-1);
		attackerRolls = attacker.getDice();
		defender.rollDice(unitsDefending-1);
		defenderRolls = defender.getDice();
		for(int i = 1; i<unitsAttacking-1 ; i++){
			if(attackerRolls.get(i) > attackerHighest){
				attackerHighest = attackerRolls.get(i);
			}
		}
		if(attackerRolls.get(0)>defenderRolls.get(0)){
			dec_Defender++;
		}
		else{
			dec_Attacker++;
		}
		if(unitsDefending>1) {
			if (attackerHighest > defenderRolls.get(1)) {
				dec_Defender++;
			} else {
				dec_Attacker++;
			}
		}
		displayString(attacker.getName() + "'s rolls were " + attackerRolls.toString() + " and " + defender.getName() +
				" 's rolls were "+defenderRolls.toString() );
		displayString(attacker.getName() + " loses " + dec_Attacker + " units and " + defender.getName() + " loses " +
					dec_Defender + " units");
		board.subtractUnits(countryAttacking,dec_Attacker);
		board.subtractUnits(countryDefending,dec_Defender);
		attacker.subtractUnits(dec_Attacker);
		defender.subtractUnits(dec_Defender);

	}
	public boolean checkSkip(){
		boolean check=false;
		if((commandPanel.getCommand()).equalsIgnoreCase("skip")){
			check = true;
		}
		return check;
	}


	
	public int getCountryId () {
		return parse.getCountryId();
	}
	
	//Game ends if NUM_PLAYERS is less than 2
	public void displayGameWinner(Player player) {
		if(GameData.NUM_PLAYERS <=1) {
			displayString("\nGAME OVER");
			displayString("\nCongrats to" + player);
		}
	}
	
	
}
