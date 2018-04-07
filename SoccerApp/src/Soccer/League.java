package Soccer;

import utility.GameUtility;

public class League {

    public static void main(String[] args) {
        // TO-DO app;
    	League theLeague = new League();
        Team[] theTeams = theLeague.createTeams();
        Game[] theGames = theLeague.createGames(theTeams);
        
        int contador = 1;
        for(Game currGame: theGames) {
   		 currGame.playGame();
   		 System.out.println("Game:" + contador);
   		 System.out.println(currGame.getDescription(theTeams));
   		 contador++;
		theLeague.showBestTeam(theTeams);
   	 }
        
    }

    public Team[] createTeams() {								//Criar equipas e jogadores
    	Player player1 = new Player("George Eliot"); 
        Player player2 = new Player("Graham Greene");
        Player player3 = new Player("Geoffrey Chaucer");
    	Player[] thePlayers = {player1, player2, player3};
    	
    	Team team1 = new Team("The Greens");
        team1.setPlayerArray(thePlayers);
        Team team2 = new Team();
        team2.setTeamName("The Reds");
        team2.setPlayerArray(new Player[3]);
        team2.getPlayerArray()[0] = new Player("Robert Service");
        team2.getPlayerArray()[1] = new Player("Robbie Burns");
        team2.getPlayerArray()[2] = new Player("Rafael Sabatini");
        
        Team[] theTeams = {team1, team2};
        return theTeams;
    }
    
    public Game[] createGames(Team[] theTeams) {  // Criar o jogo
    	 Game currGame = new Game(theTeams[0], theTeams[1]);
    	 Game currGame2 = new Game(theTeams[1], theTeams[0]);
    	 Game currGame3 = new Game(theTeams[0], theTeams[1]);
    	 Game currGame4 = new Game(theTeams[1], theTeams[0]);
         Game[] theGames = {currGame, currGame2, currGame3, currGame4};
         return theGames;
    }
    
    public void showBestTeam(Team[] theTeams) {
    	Team currBestTeam = theTeams[0];
    	Team currTeam = theTeams[1];
    	System.out.println("\nTeam Points");
//    	for(Team currTeam: theTeams) {
//    		System.out.println(currTeam.getTeamName() + ":" + currTeam.getPointsTotal());
//    		currBestTeam = currTeam.getPointsTotal() > currBestTeam.getPointsTotal() ? currTeam:currBestTeam;
//    	}
    	if(currTeam.getPointsTotal() > currBestTeam.getPointsTotal()) {
    		currBestTeam = currTeam;
    	}else if(currTeam.getPointsTotal() == currBestTeam.getPointsTotal()) {
    		if(currTeam.getGoalsTotal() > currBestTeam.getGoalsTotal()) {
    			currBestTeam = currTeam;
    		}
    	}
    	System.out.println(currTeam.getTeamName() + ":" + currTeam.getPointsTotal() + " --" + currTeam.getGoalsTotal);
    	System.out.println("Winner of the League is : " + currTeam.getTeamName());
    	
    }
    
   
    
}
