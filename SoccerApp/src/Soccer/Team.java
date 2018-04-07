package Soccer;

public class Team {

    private String teamName;
    private  Player [] playerArray;
    private int pointsTotal;
    private int goalsTotal;
	public int  getGoalsTotal;
    
    public void incPointsTotal(int pointsTotal){
    	this.pointsTotal += pointsTotal;
    }   
    
    public Team (String teamName) {
    	this.teamName = teamName;
    }
    
    public Team (String teamName, Player[] players) {
    	this(teamName);
    	this.playerArray = players;
    }
   
    public Team() {
    	
    }
    
    
    
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Player [] getPlayerArray() {
		return playerArray;
	}
	public void setPlayerArray(Player [] playerArray) {
		this.playerArray = playerArray;
	}

	int getPointsTotal() {
		return pointsTotal;
	}

	private void setPointsTotal(int pointsTotal) {
		this.pointsTotal = pointsTotal;
	}
	
	public void incGoalsTotal(int goals) {
		this.setGoalsTotal(this.getGoalsTotal() + goals);
	}

	int getGoalsTotal() {
		return goalsTotal;
	}

	private void setGoalsTotal(int goalsTotal) {
		this.goalsTotal = goalsTotal;
	}

}
