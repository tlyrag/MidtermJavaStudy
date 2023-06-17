import java.util.Scanner;

public class GameController {
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		Deck newDeck = new Deck();
		Player newPlayer = new Player(getUserName(),getCoins());
		
		
		newDeck.buildDeck();
		int deckCard = newDeck.getDeck().length;
		//System.out.println(deckCard);
		boolean userInput= true;
		while(newPlayer.getCoins()>=1 &&userInput==true) {
			System.out.println("You currently have " +newPlayer.getCoins() +" Coins");
			drawInitialHand(newPlayer,newDeck);
			
			bet(newPlayer,newDeck);
			userInput = playAgain();
			
		}
		System.out.println("Game over you have "  +newPlayer.getCoins() +" Coins");
		
		
	}
	public static String getUserName() {
		System.out.println("Please enter your name");
		String userName = input.nextLine();
		return userName;
	}
	public static int getCoins() {
		System.out.println("How Many Coins you have");
		int userCoins = input.nextInt();
		input.nextLine();
		return userCoins;
	}
	public static void drawInitialHand(Player newPlayer,Deck newDeck) {
		int randomSuitNumber = (int) ((newDeck.getDeck().length-1)*Math.random());
		int randomCard = (int) ((newDeck.getDeck()[randomSuitNumber].length-1)*Math.random());
		
		//System.out.println(randomSuitNumber);
		//System.out.println(randomCard);
	
		String card = newDeck.drawCards(randomSuitNumber, randomCard);
		newPlayer.setCardInHad(card);
		
		
		
		 randomSuitNumber = (int) ((newDeck.getDeck().length-1)*Math.random());
		 randomCard = (int) ((newDeck.getDeck()[randomSuitNumber].length-1)*Math.random());
		 
		 
		 //System.out.println(randomSuitNumber);
		//System.out.println(randomCard);
		card = newDeck.drawCards(randomSuitNumber, randomCard);
		
		for(int i =0; i<newPlayer.getHand().length;i++) {
			if(newPlayer.getHand()[i].equals(card)) {
				 randomSuitNumber = (int) ((newDeck.getDeck().length-1)*Math.random());
				 randomCard = (int) ((newDeck.getDeck()[randomSuitNumber].length-1)*Math.random());
				 card = newDeck.drawCards(randomSuitNumber, randomCard);
			}
		}
		
		newPlayer.setCardInHad(card);
		System.out.println("Here is your new hand");
		newPlayer.displayHands();
		newPlayer.sortHand();
	}
	
	public static void bet(Player player,Deck deck) {
		System.out.println("Do you want to bet? Y/N");
		//input.nextLine();
		
		String userChoice = input.nextLine();
		
		if(userChoice.toLowerCase().equals("y")) {
			player.setCoins(player.getCoins()-2);
			play(player,deck);
		} else if (userChoice.toLowerCase().equals("n")){
			player.setCoins(player.getCoins()-1);
			player.resetHand();
		} else {
			System.out.println("Please enter Y or N");
			bet(player,deck);
		}
	}
	public static void play(Player player,Deck deck) {
		int randomSuitNumber = (int) ((deck.getDeck().length-1)*Math.random());
		int randomCard = (int) ((deck.getDeck()[randomSuitNumber].length-1)*Math.random());
		String card = deck.drawCards(randomSuitNumber, randomCard);
		
		for(int i =0; i<player.getHand().length;i++) {
			if(player.getHand()[i].equals(card)) {
				 randomSuitNumber = (int) ((deck.getDeck().length-1)*Math.random());
				 randomCard = (int) ((deck.getDeck()[randomSuitNumber].length-1)*Math.random());
				 card = deck.drawCards(randomSuitNumber, randomCard);
			}
		}
		
		String[] playerHand = player.getHand();
		
		int cardDrawValue = Integer.parseInt(card.split("_")[1]);
		int cardLowerValue = Integer.parseInt(player.getHand()[0].split("_")[1]);
		int cardBiggestValue = Integer.parseInt(player.getHand()[1].split("_")[1]);
		System.out.println(card);
		if(cardDrawValue> cardLowerValue && cardDrawValue<cardBiggestValue) {
			System.out.println("You Won");
			player.setCoins(player.getCoins()+4);
		} else {
			System.out.println("You Lost");
		}
		player.resetHand();
		//player.setCardInHad(card);
	}
	public static boolean playAgain() {
		System.out.println("Want to play again?");
		String userChoice = input.nextLine();
		//input.nextLine();
		
		
		
		if(userChoice.toLowerCase().equals("y")) {
			return true;
		} else if (userChoice.toLowerCase().equals("n")){
			return false;
		} else {
			System.out.println("Please enter Y or N");
			return playAgain();
		}
	} 

}

