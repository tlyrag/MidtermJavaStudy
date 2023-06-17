
public class Deck {
	private String[][] Deck;
	
	public void buildDeck()  {
		String[][] newDeck = new String[Cards.getCardsuits().length][Cards.getCardValues().length];
		for(int row=0;row<Cards.getCardsuits().length;row++) {
			for(int col=0;col<Cards.getCardValues().length;col++) {
					newDeck[row][col]=Cards.getCardsuits()[row]+"_"+Cards.getCardValues()[col];
			}
		}
		this.Deck = newDeck;
	} 
	public String[][] getDeck() {
		return this.Deck;
	}
	public String drawCards(int row, int col) {
		String cardDraw = this.Deck[row][col];
		return cardDraw;
		
	}
}
