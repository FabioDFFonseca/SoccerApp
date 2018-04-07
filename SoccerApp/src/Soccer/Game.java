package Soccer;

import sun.management.HotspotMemoryMBean;
import utility.GameUtility;

public class Game {
	private Team homeTeam;
	private Team awayTeam;
	private Goal[] goals;

	public void playGame(int maxGoals) {
		int numberOfGoals = (int) (Math.random() * maxGoals + 1);
		Goal[] theGoals = new Goal[numberOfGoals];
		this.setGoals(theGoals);
		GameUtility.addGameGoals(this);

	}

	public Game(Team homeTeam, Team awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}

	public void playGame() {
		playGame(6);
	}

	public String getDescription(Team[] theTeams) {
		int homeTeamGoals = 0;
		int awayTeamGoals = 0;

		StringBuilder returnString = new StringBuilder();
		returnString.append(homeTeam.getTeamName() + " vs " + awayTeam.getTeamName() + "\n");
		for (Goal currGoal : this.getGoals()) {
			if (currGoal.getTheTeam() == theTeams[0]) {
				homeTeamGoals++;
				theTeams[0].incGoalsTotal(1);
			} else {
				awayTeamGoals++;
				theTeams[1].incGoalsTotal(1);
			}
			returnString.append("Goal scored after " + currGoal.getTheTime() + " mins by "
					+ currGoal.getThePlayer().getPlayerName() + " of " + currGoal.getTheTeam().getTeamName() + "\n");
		}
		if (homeTeamGoals == awayTeamGoals) {
			returnString.append("It's a draw!");
			homeTeam.incPointsTotal(1);
			awayTeam.incPointsTotal(1);
		} else if (homeTeamGoals > awayTeamGoals) {
			returnString.append(homeTeam.getTeamName()+ " win!");
			homeTeam.incPointsTotal(3);
		} else {
			returnString.append(awayTeam.getTeamName()+ " win!");
			awayTeam.incPointsTotal(3);
		}
		returnString.append(" ("+ homeTeamGoals + " - " + awayTeamGoals + ") \n");
		return returnString.toString();

	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public Goal[] getGoals() {
		return goals;
	}

	public void setGoals(Goal[] goals) {
		this.goals = goals;
	}

}
