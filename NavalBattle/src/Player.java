
public class Player {
	private String Name;
	private int playerScore=0;
	private int shipLefts;
	private int[][] guessedPlaces;
	
	Player(String name,Board board) {
		this.Name=name;
		this.shipLefts=board.getInitialNumOfShips();
	}
	public int getShipLefts() {
		return this.shipLefts;
	}
	public int getPlayerScore() {
		return this.playerScore;
	}
	public void setShiplefts() {
		this.shipLefts--;
	}
	public void setScore() {
		this.playerScore++;
	}
	
	
	@Override
	public String toString() {
		StringBuilder userInfo = new StringBuilder();
		userInfo.append("UserName: "+ this.Name );
		userInfo.append("\n");
		userInfo.append("PlayerScore: "+ this.playerScore );
		userInfo.append("\n");
		userInfo.append("shipLefts: "+ this.shipLefts );
		String user = userInfo.toString();
		return user;
	}

}
