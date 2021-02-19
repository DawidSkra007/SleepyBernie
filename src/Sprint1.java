import java.util.concurrent.TimeUnit;

public class Sprint1 {

	public static void main (String args[]) throws InterruptedException {
		Board board = new Board();
		UI ui = new UI(board);
		int playerId, countryId,placement = 0;
		String name,territory;
		int player1Roll,player2Roll;
		
		// display blank board
		ui.displayMap();
		// get player names
		for (playerId=0; playerId<GameData.NUM_PLAYERS; playerId++) {
			ui.displayString("Enter the name of player " + (playerId+1));
			name = ui.getCommand();
			ui.displayString("> " + name);
		}
	
		// add units
		countryId = 0;
		for (playerId=0; playerId<GameData.NUM_PLAYERS; playerId++) {
			for (int i=0; i<GameData.INIT_COUNTRIES_PLAYER; i++) {
				board.addUnits(countryId, playerId, 1);
				countryId++;
			}
		}
		for (; playerId<GameData.NUM_PLAYERS_PLUS_NEUTRALS; playerId++) {
			for (int i=0; i<GameData.INIT_COUNTRIES_NEUTRAL; i++) {
				board.addUnits(countryId, playerId, 1);
				countryId++;
			}
		}		

		// display map
		ui.displayMap();

		//rolling die for each player
		TimeUnit.SECONDS.sleep(1);

		player1Roll = Dice.diceRoll(2);  //roll two, six sided die
		ui.displayString("Player 1 " + "rolled " + player1Roll);
		player2Roll = Dice.diceRoll(2);
		ui.displayString("Player 2 " + "rolled " + player2Roll);
		while (player1Roll == player2Roll) {
			ui.displayString("Draw: Re-roll");
			player1Roll = Dice.diceRoll(2);
			ui.displayString("Player 1 " + "rolled " + player1Roll);
			player2Roll = Dice.diceRoll(2);
			ui.displayString("Player 2 " + "rolled " + player2Roll);
		}

		if (player1Roll > player2Roll) {

			while (placement != 24) {
				boolean nam1 = false;
				int neutralCount = 0, n = 2;

				//player 1 gets to place units
				while (!nam1) {
					ui.displayString("Player 1: Enter territory to place 3 of your units");
					territory = ui.getCommand();
					ui.displayString("> " + territory);

					for (int i = 0; i < GameData.NUM_COUNTRIES; i++) {
						if (territory.equals(GameData.COUNTRY_NAMES[i])) {
							if (board.getOccupier(i) == 0) {
								nam1 = true;
								board.addUnits(i, 0, 3);
								ui.displayMap();
								placement++;
							} else {
								ui.displayString("That is not your territory, try again.");
								break;
							}
						}
					}
				}
				//here player 1 adds 1 unit for each of the neutrals
				while (neutralCount != 4) {
					ui.displayString("Player 1: Enter territory to place 1 unit for neutral " + n);
					territory = ui.getCommand();
					ui.displayString("> " + territory);

					for (int i = 0; i < GameData.NUM_COUNTRIES;i++) {
						if (territory.equals(GameData.COUNTRY_NAMES[i]) ) {
							if (board.getOccupier(i) == n) {
								board.addUnits(i,n,1);
								ui.displayMap();
								neutralCount++;
								n++;
							} else {
								ui.displayString("That territory is not controlled by that neutral player, try again.");
								break;
							}
						}
					}
				}

				//player 2 gets to place units
				boolean nam2 = false;
				neutralCount = 0;
				while (!nam2) {
					ui.displayString("Player 2: Enter territory to place 3 of your units");
					territory = ui.getCommand();
					ui.displayString("> " + territory);

					for (int i = 0; i < GameData.NUM_COUNTRIES; i++) {
						if (territory.equals(GameData.COUNTRY_NAMES[i])) {
							if (board.getOccupier(i) == 1) {
								nam2 = true;
								board.addUnits(i, 1, 3);
								ui.displayMap();
								placement++;
							} else {
								ui.displayString("That is not your territory, try again.");
								break;
							}
						}
					}
				}
				//here player 2 adds 1 unit for each neutral
			n = 2;
			while (neutralCount != 4) {
				ui.displayString("Player 2: Enter territory to place 1 unit for neutral " + n);
				territory = ui.getCommand();
				ui.displayString("> " + territory);

				for (int i = 0; i < GameData.NUM_COUNTRIES; i++) {
					if (territory.equals(GameData.COUNTRY_NAMES[i]) ) {
						if (board.getOccupier(i) == n) {
							board.addUnits(i,n,1);
							ui.displayMap();
							neutralCount++;
							n++;
						} else {
							ui.displayString("That territory is not controlled by that neutral player, try again.");
							break;
						}
					}
				}
			}
			}
		} else {
			while (placement != 24) {
			boolean nam2 = false;
			int neutralCount = 0, n = 2;
			while (!nam2) {
				ui.displayString("Player 2: Enter territory to place 3 of your units");
				territory = ui.getCommand();
				ui.displayString("> " + territory);

				for (int i = 0; i < GameData.NUM_COUNTRIES; i++) {
					if (territory.equals(GameData.COUNTRY_NAMES[i])) {
						if (board.getOccupier(i) == 1) {
							nam2 = true;
							board.addUnits(i, 1, 3);
							ui.displayMap();
							placement++;
						} else {
							ui.displayString("That is not your territory, try again.");
							break;
						}
					}
				}
			}
			//here player 2 adds 1 unit for each neutral
			while (neutralCount != 4) {
				ui.displayString("Player 2: Enter territory to place 1 unit for neutral " + n);
				territory = ui.getCommand();
				ui.displayString("> " + territory);

				for (int i = 0; i < GameData.NUM_COUNTRIES; i++) {
					if (territory.equals(GameData.COUNTRY_NAMES[i]) ) {
						if (board.getOccupier(i) == n) {
							board.addUnits(i,n,1);
							ui.displayMap();
							neutralCount++;
							n++;
						} else {
							ui.displayString("That territory is not controlled by that neutral player, try again.");
							break;
						}
					}
				}
			}

				boolean nam1 = false;
				neutralCount = 0;

				//player 1 gets to place units
				while (!nam1) {
					ui.displayString("Player 1: Enter territory to place 3 of your units");
					territory = ui.getCommand();
					ui.displayString("> " + territory);

					for (int i = 0; i < GameData.NUM_COUNTRIES; i++) {
						if (territory.equals(GameData.COUNTRY_NAMES[i])) {
							if (board.getOccupier(i) == 0) {
								nam1 = true;
								board.addUnits(i, 0, 3);
								ui.displayMap();
								placement++;
							} else {
								ui.displayString("That is not your territory, try again.");
								break;
							}
						}
					}
				}
				n = 2;
				//here player 1 adds 1 unit for each of the neutrals
				while (neutralCount != 4) {
					ui.displayString("Player 1: Enter territory to place 1 unit for neutral " + n);
					territory = ui.getCommand();
					ui.displayString("> " + territory);

					for (int i = 0; i < GameData.NUM_COUNTRIES;i++) {
						if (territory.equals(GameData.COUNTRY_NAMES[i]) ) {
							if (board.getOccupier(i) == n) {
								board.addUnits(i,n,1);
								ui.displayMap();
								neutralCount++;
								n++;
							} else {
								ui.displayString("That territory is not controlled by that neutral player, try again.");
								break;
							}
						}
					}
				}
			}
		}

		return;
	}



}

