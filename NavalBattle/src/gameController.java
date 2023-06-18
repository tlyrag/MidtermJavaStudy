import java.util.Scanner;

public class gameController {
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		Board playerBoard = new Board(5,5,4);
		Board computerBoard = new Board(5,5,4);
		Player user = new Player("user", playerBoard);
		Player computer = new Player("computer", computerBoard);
		
		playerBoard.displayBoard();
		int turn = 1;
		while(user.getShipLefts()!=0 && computer.getShipLefts()!=0){
			System.out.println(turn+": Please select a cell:");
			//int[] userChoice =getUserInput();
			
			//guessShip(user, computer, computerBoard, userChoice[0], userChoice[1]);
			guessShip(user, computer, computerBoard, computerRandomPlay(playerBoard)[0], computerRandomPlay(playerBoard)[1]);
			guessShip(computer, user, playerBoard, computerRandomPlay(playerBoard)[0], computerRandomPlay(playerBoard)[1]);
			turn++;
		}
		if(user.getShipLefts()==0) {
			System.out.println();
			System.out.println("Game Over: You Lost");
			System.out.println("Turns played:"+ turn);
			System.out.println();
			System.out.println(user);
			System.out.println("-------------");
			System.out.println(computer);
			System.out.println("-------------");
		}else {
			System.out.println();
			System.out.println("Game Over: You Won");
			System.out.println("Turns played:"+ turn);
			System.out.println();
			System.out.println(user);
			System.out.println("-------------");
			System.out.println(computer);
			System.out.println("-------------");
		}
	}

	public static void guessShip(Player player,Player enemy,Board board,int row,int col) {
		boolean isShip =board.checkShip(row,col);
		
		if(isShip) {
			System.out.println("Ship Sunk");
			board.updateBoard(row, col);
			player.setScore();
			enemy.setShiplefts();
			
		} else {
			System.out.println("No ship at this place");
		}
	}
	public static int[] getUserInput() {
		System.out.println("Please enter Row");
		int row = input.nextInt();
		System.out.println("Please enter Col");
		int col = input.nextInt();
		
		int[] userChoice = {row,col};
		return userChoice;
	}
	public static int[] computerRandomPlay(Board board) {
		int randomRow = (int)(Math.random()*board.getBoard().length);
		int randomCol = (int)(Math.random()*board.getBoard()[0].length);
		int[] randomChoice = {randomRow,randomCol};
		return randomChoice;
	}
}
