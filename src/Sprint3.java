
public class Sprint3 {

	public static void main (String args[]) {	   
		Board board = new Board();
		UI ui = new UI(board);
		Player[] players = new Player[GameData.NUM_PLAYERS_PLUS_NEUTRALS];
		Player currPlayer;
		Card card;
		int playerId, countryId, numUnits, numCards,reinforcements=0,numTerritories=0,terrInContinent = 0;
		String name;
		
		ui.displayString("ENTER PLAYER NAMES");
		ui.displayMap();
		for (playerId=0; playerId<GameData.NUM_PLAYERS_PLUS_NEUTRALS; playerId++) {
			if (playerId < GameData.NUM_PLAYERS) {
				name = ui.inputName(playerId);
				numUnits = GameData.INIT_UNITS_PLAYER;
			} else {
				name = "Neutral " + (playerId - GameData.NUM_PLAYERS + 1);
				ui.displayName(playerId,name);
				numUnits = GameData.INIT_UNITS_NEUTRAL;
			}
			players[playerId] = new Player (playerId, name, numUnits);
		}
		
		ui.displayString("\nDRAW TERRITORY CARDS FOR STARTING COUNTRIES");
		Deck deck = new Deck();
		for (playerId=0; playerId<GameData.NUM_PLAYERS_PLUS_NEUTRALS; playerId++) {
			currPlayer = players[playerId];
			if (playerId < GameData.NUM_PLAYERS) {
				numCards = GameData.INIT_COUNTRIES_PLAYER;
			} else {
				numCards = GameData.INIT_COUNTRIES_NEUTRAL;
			}
			for (int i=0; i<numCards; i++) {
				card = deck.getCard();
				ui.displayCardDraw(currPlayer, card);
				currPlayer.subtractUnits(1);
				board.addUnits(card, currPlayer, 1);
			}
		}
		ui.displayMap();
		
		ui.displayString("\nROLL DICE TO SEE WHO REINFORCES THEIR COUNTRIES FIRST");
		do {
			for (int i=0; i<GameData.NUM_PLAYERS; i++) {
				players[i].rollDice(1);
				ui.displayDice(players[i]);
			}
		} while (players[0].getDie(0) == players[1].getDie(0)); 
		if (players[0].getDie(0) > players[1].getDie(0)) {
			playerId = 0;
		} else {
			playerId = 1;
		}
		currPlayer = players[playerId];
		ui.displayRollWinner(currPlayer);
		
		ui.displayString("\nREINFORCE INITIAL COUNTRIES");
		while (currPlayer.getNumUnits() > 0) {
			ui.inputPlacement(currPlayer, currPlayer);
			countryId = ui.getCountryId();
			currPlayer.subtractUnits(3);
			board.addUnits(countryId, currPlayer, 3);
			ui.displayMap();
			for (int i=GameData.NUM_PLAYERS; i<GameData.NUM_PLAYERS_PLUS_NEUTRALS; i++) {
				ui.inputPlacement(currPlayer, players[i]);
				countryId = ui.getCountryId();
				currPlayer.subtractUnits(1);
				board.addUnits(countryId, currPlayer, 1);	
				ui.displayMap();
			}
			playerId = (++playerId)%GameData.NUM_PLAYERS;
			currPlayer = players[playerId];
		}

		//seeing who goes first
		ui.displayString("\nROLL DICE TO SEE WHO'S TURN IT IS FIRST");
		do {
			for (int i=0; i<GameData.NUM_PLAYERS; i++) {
				players[i].rollDice(1);
				ui.displayDice(players[i]);
			}
		} while (players[0].getDie(0) == players[1].getDie(0));
		if (players[0].getDie(0) > players[1].getDie(0)) {
			playerId = 0;
		} else {
			playerId = 1;
		}
		currPlayer = players[playerId]; //curr Player currently using his turn
		ui.displayRollWinner(currPlayer);

		///////////////////////////////////////
		//    START OF WHILE LOOP FOR TURN

		//calculating number of territories each player owns
		for (int i = 0;i < GameData.NUM_COUNTRIES;i++) {
			if(board.getOccupier(i) == playerId) { // if territory belongs to [playerID], add reinforcements
				numTerritories++;
			}
		}
		if (numTerritories <= 8) { // if you own below eight territories, player will still receive a minimum of 3 reinforcements
			reinforcements = 3;
		} else {
			reinforcements = numTerritories / 3;
		}
		//calculating number of continents each player owns
		for (int j = 0;j < GameData.NUM_CONTINENTS; j++) {
			for (int i = 0; i < GameData.NUM_COUNTRIES; i++) {
				if (board.getOccupier(i) == playerId && GameData.CONTINENTS[i] == j) {
					terrInContinent++;
				}
			}
			switch (j) {
				case 0: //N America
					if (terrInContinent == 9) {
						reinforcements += 5;
					}
					break;
				case 1: // Europe
					if (terrInContinent == 7) {
						reinforcements += 5;
					}
					break;
				case 2: // Asia
					if (terrInContinent == 12) {
						reinforcements += 7;
					}
					break;
				case 3: // Australia
					if (terrInContinent == 4) {
						reinforcements += 2;
					}
					break;
				case 4: // S America
					if (terrInContinent == 4) {
						reinforcements += 2;
					}
					break;
				case 5: // Africa
					if (terrInContinent == 6) {
						reinforcements += 3;
					}
					break;
				default:
					break;
			}
			terrInContinent = 0;
		}

		currPlayer.addUnits(reinforcements);
		ui.displayString("\n" + ui.makeLongName(currPlayer) + " receives " + reinforcements + " units to his army");
		ui.displayString("\nPLACE REINFORCEMENTS ON BOARD");
		//Place reinforcements on board
		while (currPlayer.getNumUnits() > 0) {
			ui.inputPlacement(currPlayer, currPlayer);
			countryId = ui.getCountryId();
			currPlayer.subtractUnits(3);
			board.addUnits(countryId, currPlayer, 3);
			ui.displayMap();
		}

		//COMBAT





		playerId = (++playerId)%GameData.NUM_PLAYERS;
		currPlayer = players[playerId];
		//       HERE
		//    END OF WHILE LOOP FOR TURN
		return;
	}

}
