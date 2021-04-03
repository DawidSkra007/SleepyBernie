import java.util.Random;
public class Card {
	
	private int countryId;
	private String countryName;
	private int insigniaID;
	private String insigniaName;
	Random rand = new Random();

	Card (int inCountryId, String inCountryName) {   
		countryId = inCountryId;
		countryName = inCountryName;
		insigniaID = rand.nextInt(2);
		return;
	}

	public String getInsigniaName() {
		switch(insigniaID) {
			case 0:
				insigniaName = "Infantry";
				break;
			case 1:
				insigniaName = "Cavalry";
				break;
			case 2:
				insigniaName = "Artillery";
				break;
		}
			return insigniaName;

	}

	public int getInsigniaID() {
		return insigniaID;
	}

	public int getCountryId () {
		return countryId;
	}
	
	public String getCountryName () {
		return countryName;
	}
	
}