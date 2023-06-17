
public class Animals {
	private String animalName;
	private int AnimalValue;
	private int animalKills;
	private int[] moveDirections;
	private int[] attackRaycast;
	private int[] initialPosition;
	private int[] currentPosition;
	private boolean isAlive;
	private boolean isPredator;
	
	
	public String getAnimalName() {
		return this.animalName;
	}
	
	Animals(String animalName,int animalValue,int moveInRows,int moveInCols,int rayCastAttackRow, int rayCastAttackCol,int initialPositionRow,int initialPositionCol,boolean isPredator) {
		this.animalName = animalName;
		
		this.AnimalValue=animalValue;
		
		int[] moveDirection = {moveInRows,moveInCols};
		this.moveDirections =moveDirection;
		
		int[] attackRaycast =  {rayCastAttackRow,rayCastAttackCol};
		this.attackRaycast =attackRaycast;
		
		int[] initialPosition =  {initialPositionRow,initialPositionCol};
		this.initialPosition =initialPosition;
		this.currentPosition = initialPosition;
		
		this.isAlive= true;
		
		this.isPredator=isPredator;
	
		
	}
	public int getAnimalValue() {
		return this.AnimalValue;
	}
	public int[] getCurrentPosition() {
		return this.currentPosition;
	}
	public void move(Animals animal,int move,int maxMapRows,int maxMapCol,Board board) {
		if(this.isAlive==true) {
			board.setBoardValueTo1(this.currentPosition[0], this.currentPosition[1]);
			switch(move) {
			case 1:
				this.currentPosition[0]+=1;
				break;
			case 2:
				this.currentPosition[0]=-1;
				break;
			case 3:
				this.currentPosition[1]+=1;
				break;
			case 4:
				this.currentPosition[1]-=1;
				break;
			case 5:	
				this.currentPosition[1]+=1;
				this.currentPosition[1]+=1;
				break;
			case 6:	
				this.currentPosition[1]-=1;
				this.currentPosition[1]-=1;
				break;
			case 7:	
				this.currentPosition[1]+=1;
				this.currentPosition[1]-=1;
				break;
			case 8:	
				this.currentPosition[1]-=1;
				this.currentPosition[1]+=1;
				break;
		}
			// evaluate boardMap, if bigger than boardmap stay in the border;
			if(this.currentPosition[0]>maxMapRows-1) {
				this.currentPosition[0]=maxMapRows-1;
			}
			
			if(this.currentPosition[0]<0) {
				this.currentPosition[0]=0;
			}
			if(this.currentPosition[1]>maxMapCol-1) {
				this.currentPosition[1]=maxMapCol-1;
			}
			
			if(this.currentPosition[1]<0) {
				this.currentPosition[1]=0;
			}
		}
		board.setAnimal(animal);
	}
	
	public void attack(int row,int col) {
		if(isPredator) {
			for(int i = this.currentPosition[0]-1; i>=this.currentPosition[0]+1;i++ ) {}
		}
	}
	
}
