import java.util.ArrayList;
import java.util.Collections;

public class Player {
	
	private int id;
	private String name;
	private int numUnits;
	private ArrayList<Integer> dice = new ArrayList<Integer>();
	private int battleLoss = 0;
	private ArrayList<Card> cards = new ArrayList<Card>();
	private int numInfantry=0,numCavalry=0,numArtillery=0;
	
	Player (int inId, String inName, int inNumUnits) {
		id = inId;
		name = inName;
		numUnits = inNumUnits;
		return;
	}
	public void addCard(Card card){
		cards.add(card);
		switch(card.getInsigniaID()) {
			case 0:
				numInfantry++;
				break;
			case 1:
				numCavalry++;
				break;
			case 2:
				numArtillery++;
				break;
		}
		return;
	}
	public boolean checkExchangeable() {

		if (cards.size() >= 3 ){
			if(numInfantry>=3){
				return  true;
			}
			else if(numCavalry>=3){
				return true;
			}
			else if(numArtillery>=3){
				return true;
			}
			else if(numInfantry>=1 && numCavalry>=1 && numArtillery>=1){
				return true;
			}

		}
		return false;
	}
	
	public void rollDice (int numDice) {
		dice.clear();
		for (int j=0; j<numDice; j++) {
				dice.add(1 + (int)(Math.random() * 6));   
		}
		Collections.sort(dice, Collections.reverseOrder());
		return;
	}

	public void addUnits (int inNum) {
		numUnits = numUnits + inNum;
		return;
	}
	
	public void subtractUnits (int inNum) {
		numUnits = numUnits - inNum;
		return;
	}
	
	public int getId () {
		return id;
	}
	
	public String getName () {
		return name;
	}
	
	public int getNumUnits () {
		return numUnits;
	}

	public ArrayList<Integer> getDice () {
		return dice;
	}
	
	public int getDie (int dieId) {
		return dice.get(dieId);
	}
	
	public void resetBattleLoss () {
		battleLoss = 0;
		return;
	}
	
	public void addBattleLoss () {
		battleLoss++;
		return;
	}
	
	public int getBattleLoss () {
		return battleLoss;
	}

	public int getNumInfantry() {
		return numInfantry;
	}

	public int getNumCavalry() {
		return numCavalry;
	}

	public int getNumArtillery() {
		return numArtillery;
	}
	public int getCards(){
		return cards.size();
	}
	public void subtractInfantry(int num){
		numInfantry -= num;
	}
	public void subtractCavalry(int num){
		numCavalry -= num;
	}
	public void subtractArtillery(int num){
		numArtillery -= num;
	}
	public void removeCards(int insigniaID) {
		int count = 0;
		boolean foundI=false,foundC=false,foundA=false;
		if (insigniaID == 4) {
			for (int c = 0; c < 5; c++) {
				while (!foundI) {
					if (cards.get(c).getInsigniaID() == 0) {
						cards.remove(c);
						foundI = true;
					}
				}
				while (!foundC) {
					if (cards.get(c).getInsigniaID() == 1) {
						cards.remove(c);
						foundC = true;
					}
				}
				while (!foundA) {
					if (cards.get(c).getInsigniaID() == 2) {
						cards.remove(c);
						foundA = true;
					}
				}
			}
		}
		 else {
			for (int i = 0; i < 3; i++) {
				if ((cards.get(i)).getInsigniaID() == insigniaID) {
					cards.remove(i);
					count++;
				}
			}
		}
	}
}

