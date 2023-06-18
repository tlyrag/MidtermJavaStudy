
public class Board {
	private int[][] board;
	public int[][] guessBoard;
	private int initialNumofShips;
	
	Board (int rows, int col,int numOfShips) {
		int[][] newBoard = new int[rows][col];
		this.initialNumofShips=numOfShips;
		for(int i=0; i <rows; i++) {
			for(int j =0; j<col;j++) {
				newBoard[i][j]=0;
			}
		}
		this.guessBoard=newBoard;
		this.board=newBoard;
		
		setShip(numOfShips);
	}
	
	public int[][] getBoard() {
		return this.board;
	}
	public void setShip(int numberOfShips) {
		try {
			
			for(int i= 0; i<numberOfShips;i++ ) {
				this.board[generateRandomPlace()[0]][generateRandomPlace()[1]]=1;
				//System.out.println("Row: "+generateRandomPlace()[0]+ " Col: "+generateRandomPlace()[1]);
			}
			
		} catch(Exception err){
			System.out.println("Number of ships "+numberOfShips+ "bigger than available board slots " + this.board.length*this.board[0].length);
		}
		
	}
	
	
	public int[] generateRandomPlace() {
		int randomRow = (int)(Math.random()*this.board.length);
		int randomCol = (int)(Math.random()*this.board[0].length);
		
		int[] randomArray =  {randomRow,randomCol};
		return randomArray;
	}
	
	public void displayBoard() {
		for(int row=0; row<this.board.length;row++) {
			for (int col=0; col<this.board[row].length;col++) {
				System.out.print(this.board[row][col]);
			}
			System.out.println();
		}
	}
	public boolean checkShip(int row,int col) {
		if(this.board[row][col]==1) {
			return true;
		}
		else {
			return false;
		}
	}
	public void updateBoard(int row,int col) {
		this.board[row][col]=2;
	}
	public boolean isDone() {
		
		for(int row=0; row<this.board.length;row++) {
			for (int col=0; col<this.board[row].length;col++) {
				if(this.board[row][col]==1) {
					return false;
				}
			}
		}
		return true;
	}
	public int getInitialNumOfShips() {
		return this.initialNumofShips;
	}


}
