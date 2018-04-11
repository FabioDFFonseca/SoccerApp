package Soccer;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.StringTokenizer;

import utility.GameUtility;
import utility.PlayerDatabase;

public class League {

	public static void main(String[] args) {
		// TO-DO app;
		League theLeague = new League();
		Team[] theTeams = theLeague.createTeams("The Robins, The Crows, The Swallows", 3);
		Game[] theGames = theLeague.createGames(theTeams);

		System.out.println(theLeague.getLeagueAnnouncement(theGames));
		
		for (Game currGame : theGames) {
			currGame.playGame();
			System.out.println(currGame.getDescription(theTeams));
			
		}
		theLeague.showBestTeam(theTeams);
	}

	public Team[] createTeams(String teamName, int teamSize) { // Criar equipas e jogadores
		PlayerDatabase playerDataBase = new PlayerDatabase();

		StringTokenizer teamNameTokens = new StringTokenizer(teamName, ",");
		Team[] theTeams = new Team[teamNameTokens.countTokens()];
		for (int i = 0; i < theTeams.length; i++) {
			theTeams[i] = new Team(teamNameTokens.nextToken(), playerDataBase.getTeam(teamSize));
		}

		return theTeams;
	}

	public Game[] createGames(Team[] theTeams) { // Criar o jogo
		ArrayList<Game> theGames = new ArrayList<>();
		int daysBetweenGames = 0;
		for (Team homeTeam : theTeams) {
			for (Team awayTeam : theTeams) {
				if (homeTeam != awayTeam) {
					daysBetweenGames += 7;
					Game game = new Game(homeTeam, awayTeam, LocalDateTime.now().plusDays(daysBetweenGames));
					theGames.add(game);
				}
			}

		}
		return theGames.toArray(new Game[1]);
	}
	
	
	
	public String getLeagueAnnouncement(Game[] theGames) {
		Game firstGame = theGames[0];
		Game lastGame = theGames[theGames.length - 1];
		Period thePeriod = Period.between(firstGame.getTheDateTime().toLocalDate(), lastGame.getTheDateTime().toLocalDate());
		
		
		return "The League is scheduled to run for " + thePeriod.getMonths() + " month(s) and " + thePeriod.getDays() + " day(s) \n";
	}

	
	
	public void showBestTeam(Team[] theTeams) {
		Team currBestTeam = theTeams[0];
		System.out.println("\nTeam Points:");
		for (Team currTeam : theTeams) {
			System.out.println(currTeam.getTeamName() + ":" + currTeam.getPointsTotal() + " -- " + "Total goals: "
					+ currTeam.getGoalsTotal());
			currBestTeam = currTeam.getPointsTotal() > currBestTeam.getPointsTotal() ? currTeam : currBestTeam;
			// if(currTeam.getPointsTotal() > currBestTeam.getPointsTotal()) {
			// currBestTeam = currTeam;
			// }else if(currTeam.getPointsTotal() == currBestTeam.getPointsTotal()) {
			// if(currTeam.getGoalsTotal() > currBestTeam.getGoalsTotal()) {
			// currBestTeam = currTeam;
			// }
			// }
			if (currTeam.getPointsTotal() > currBestTeam.getPointsTotal()) {
				currBestTeam = currTeam;
			} else if (currTeam.getPointsTotal() == currBestTeam.getPointsTotal()) {
				if (currTeam.getGoalsTotal() > currBestTeam.getGoalsTotal()) {
					currBestTeam = currTeam;
				}
			}
		}

		System.out.println("Winner of the League is : " + currBestTeam.getTeamName());
		System.out.println(currBestTeam.getTeamName() + ":" + "\tTotal points: " + currBestTeam.getPointsTotal()
				+ " \tTotal Goals: " + currBestTeam.getGoalsTotal());

	}

}
