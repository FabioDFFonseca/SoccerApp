package Soccer;

import utility.GameUtility;

public class League {

    public static void main(String[] args) {
        // TO-DO app;
    	League theLeague = new League();
        Team[] teams = theLeague.createTeams();
        Game[] theGames = theLeague.createGames(teams);
        
        int contador = 1;
        for(Game currGame: theGames) {
   		 currGame.playGame();
   		 System.out.println("Game:" + contador);
   		 System.out.println(currGame.getDescription());
   		 contador++;
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
        
        Team[] teams = {team1, team2};
        return teams;
    }
    
    public Game[] createGames(Team[] teams) {  // Criar o jogo
    	 Game currGame = new Game(teams[0], teams[1]);
    	 Game currGame2 = new Game(teams[1], teams[0]);
    	 Game currGame3 = new Game(teams[0], teams[1]);
    	 Game currGame4 = new Game(teams[1], teams[0]);
         Game[] theGames = {currGame, currGame2, currGame3, currGame4};
         return theGames;
    }
    
    
}
