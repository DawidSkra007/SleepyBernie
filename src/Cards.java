import java.util.Random;
public class Cards {
    public static Card[] deck;
    public static Card[] owned_1 = new Card[5];//cards owned by player 1
    public static Card[] owned_2 = new Card[5];//cards owned by player 2
    public static void cards() {
        Random rand = new Random();
        deck = new Card[42];
        for (int i = 0; i < GameData.NUM_COUNTRIES; i++) {
            int temp = (rand.nextInt(3));
            deck[i] = new Card(temp,i);
        }
    }
    public static String draw(Card card){
        switch (card.symbol){
            case 0:
                return("Card drawn is " + GameData.COUNTRY_NAMES[card.countryID] + " which has symbol 'infantry'");
            case 1:
                return("Card drawn is " + GameData.COUNTRY_NAMES[card.countryID] + " which has symbol 'cavalry'");
            case 2:
                return("Card drawn is " + GameData.COUNTRY_NAMES[card.countryID] + " which has symbol 'artillery'");
            default:
                return null;
        }
    }

}
    class Card{
        public int symbol;
        public int countryID;

        Card(int s, int c){
            this.symbol = s;
            this.countryID = c;}

        public void setSymbol(int s){
            symbol = s;
        }
        public void setCountryID(int i){
            countryID = i;
        }
    }



