
public class Player {
	private int coins;
	private String name;
	private String[] playerHand;
	
	Player(String name,int coins) {
		this.name=name;
		this.coins=coins;
	}
	
	public int getCoins() {
		return this.coins; 
	}
	public void setCoins(int coins) {
		this.coins=coins;
	}
	public void displayHands() {
		for(int i =0; i<this.playerHand.length;i++) {
			System.out.print(playerHand[i]+" ");
		}
		System.out.println();
	}
	public String[] getHand() {
		return this.playerHand;
	}
	public void setCardInHad(String card) {
		 
		if(this.playerHand==null) {
			String[] newPlayerHand = {card};
			 this.playerHand=newPlayerHand;
			 System.out.println("Card Draw: " + card);
			 return;
		 }
		String[] newPlayerHand = new String[this.playerHand.length+1];
		 
		
		 for(int i=0;i<this.playerHand.length;i++) {
			 newPlayerHand[i]=this.playerHand[i];
		 }
		 newPlayerHand[this.playerHand.length] = card;
		 this.playerHand=newPlayerHand;
		 System.out.println("Card Draw: " + card);
	}
	public void sortHand() {
		if(Integer.parseInt(this.playerHand[0].split("_")[1]) >Integer.parseInt(this.playerHand[1].split("_")[1])) {
			String key = this.playerHand[0];
			this.playerHand[0] =this.playerHand[1];
			this.playerHand[1]=key;
			
		}  
	}
	public void resetHand() {
		String[] emptyPlayerHand = null;
		this.playerHand =emptyPlayerHand;
	}
}
