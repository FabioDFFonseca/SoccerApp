package Soccer;

import sun.font.CreatedFontTracker;
import utility.GameUtility;

public class League {

    public static void main(String[] args) {
        // TO-DO app;

        Team[] teams = createTeams();
        Game[] theGames = createGames(teams);
        Game currGame = theGames[0];
        currGame.playGame();
        System.out.println(currGame.getDescription());
       
        
//        Goal goal1 = new Goal();
//        goal1.thePlayer = currGame.homeTeam.playerArray[2];
//        goal1.theTeam = currGame.homeTeam;
//        goal1.theTime = 55;
//
//        Goal[] theGoals = {goal1};
//        currGame.goals = theGoals;
//        System.out.println("Goal scored after " + currGame.goals[0].theTime + " mins by " + currGame.goals[0].thePlayer.playerName + " of " + currGame.goals[0].theTeam.teamName);
        
        
    }

    public static Team[] createTeams() {								//Criar equipas e jogadores
    	Player player1 = new Player();
        player1.playerName = "George Eliot";
        Player player2 = new Player();
        player2.playerName = "Graham Greene";
        Player player3 = new Player();
        player3.playerName = "Geoffrey Chaucer";
    	Player[] thePlayers = {player1, player2, player3};
    	
    	Team team1 = new Team();
        team1.teamName = "The Greens";
        team1.playerArray = thePlayers;
        Team team2 = new Team();
        team2.teamName = "the Reds";
        team2.playerArray = new Player[3];
        team2.playerArray[0] = new Player();
        team2.playerArray[0].playerName = "Robert Service";
        team2.playerArray[1] = new Player();
        team2.playerArray[1].playerName = "Robbie Burns";
        team2.playerArray[2] = new Player();
        team2.playerArray[2].playerName = "Rafael Sabatini";
        
        Team[] teams = {team1, team1};
        return teams;
    }
    
    public static Game[] createGames(Team[] theTeams) {  // Criar o jogo
    	 Game currGame = new Game();
         currGame.homeTeam = theTeams[0];
         currGame.awayTeam = theTeams[1];
         Game[] theGames = {currGame};
         return theGames;
    }
    
    
}
