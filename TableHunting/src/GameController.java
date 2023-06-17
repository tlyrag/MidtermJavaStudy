import java.util.ArrayList;
public class GameController {
	
	//public static int[][] gameBoard;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board tableBoard = new Board();
		ArrayList<Animals> animalList= new ArrayList<Animals>();
		
		int tableRows = 10;
		int tableCols = 10;
		tableBoard.createBoardgame(tableRows,tableCols);
		tableBoard.displayBoard();
		
		// Deer will be a 2 in the board
		Animals Deer = new Animals("Deer",2,1,1,0, 0,getRandomNum(0,10),getRandomNum(0,10),false);
		tableBoard.setAnimal(Deer);
		
		tableBoard.displayBoard();
		//moving deer through the table
		Deer.move(Deer, getRandomNum(1,8), tableRows, tableCols, tableBoard);
		tableBoard.displayBoard();
		
	}
	public static int getRandomNum(int min,int max) {
		int random;
		random = (int) (min + max*Math.random());
		return random;
	}
	
//	public static ArrayList<Animals>initializnigDeers() {
//		
//	}
	
}
