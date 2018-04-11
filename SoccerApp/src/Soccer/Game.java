package Soccer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import sun.management.HotspotMemoryMBean;
import utility.GameUtility;

public class Game {
	private Team homeTeam;
	private Team awayTeam;
	private GameEvent[] gameEvents;
	private LocalDateTime theDateTime;

//	public void playGame(int maxGoals) {
//		int numberOfGoals = (int) (Math.random() * maxGoals + 1);
//		Goal[] theGoals = new Goal[numberOfGoals];
//		this.setGoals(theGoals);
//		GameUtility.addGameGoals(this);
//
//	}

	public Game(Team homeTeam, Team awayTeam, LocalDateTime theDateTime) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.theDateTime = theDateTime;
	}

	public void playGame() {
		ArrayList<GameEvent> eventList = new ArrayList<>();
		GameEvent currEvent;
		for(int i = 1; i <= 90; i++) {
			
			if(Math.random() > 0.95) {
				currEvent = Math.random() > 0.6 ? new Goal() : new Possesion();
				currEvent.setTheTeam(Math.random()>0.5 ? homeTeam : awayTeam);
				int index = (int)(Math.random() * currEvent.getTheTeam().getPlayerArray().length);
				currEvent.setThePlayer(currEvent.getTheTeam().getPlayerArray()[index]);
				currEvent.setTheTime(i);
				eventList.add(currEvent);
			}
		}
		this.gameEvents = new GameEvent[eventList.size()];
		eventList.toArray(this.gameEvents);
	}

	public String getDescription(Team[] theTeams) {
		int homeTeamGoals = 0;
		int awayTeamGoals = 0;

		StringBuilder returnString = new StringBuilder();
		returnString.append(homeTeam.getTeamName() + " vs " + awayTeam.getTeamName() + "\n" + "Date " + this.theDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE) + "\n");
		for (GameEvent currGameEvent : this.getGameEvents()) {
			if (currGameEvent.getTheTeam() == homeTeam) {
				homeTeamGoals++;
				homeTeam.incGoalsTotal(1);
			} else {
				awayTeamGoals++;
				awayTeam.incGoalsTotal(1);
			}
			returnString.append(currGameEvent + " after " + currGameEvent.getTheTime() + " mins by "
					+ currGameEvent.getThePlayer().getPlayerName() + " of " + currGameEvent.getTheTeam().getTeamName() + "\n");
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
			returnString.append(" ("+ homeTeamGoals + "-" + awayTeamGoals + ") \n");
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

	public GameEvent[] getGameEvents() {
		return gameEvents;
	}

	public void setGameEvents(Goal[] gameEvents) {
		this.gameEvents = gameEvents;
	}

	public LocalDateTime getTheDateTime() {
		return theDateTime;
	}

	public void setTheDateTime(LocalDateTime theDateTime) {
		this.theDateTime = theDateTime;
	}
	
	

}
