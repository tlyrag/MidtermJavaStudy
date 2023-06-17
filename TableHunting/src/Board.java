
public class Board {
	
	private int[][] boardTable;
	
	public void createBoardgame(int rowNum,int colNum) {
		int[][] newBoardTable = new int[rowNum][colNum];
		
		for(int row = 0; row<rowNum;row++ ) {
			for(int col=0;col<colNum;col++) {
				newBoardTable[row][col] =1;
			}
		}
		this.boardTable=newBoardTable;
	}
	public void setBoardValueTo1(int row,int col) {
		boardTable[row][col]=1;
	}
	public void displayBoard() {
		System.out.println();
		System.out.println("Current Board");
		System.out.println("--------------------------------");
		for(int row =0 ; row<this.boardTable.length;row++) {
			for(int col = 0; col<this.boardTable[row].length;col++) {
				System.out.print(boardTable[row][col]);
			}
				System.out.println();
		}
		System.out.println("--------------------------------");
		System.out.println();
	}
	public void setAnimal(Animals animal) {
		int[] animalPosition = animal.getCurrentPosition();
		
		this.boardTable[animalPosition[0]][animalPosition[1]] = animal.getAnimalValue();
	}
	//public void getAnimal
}
