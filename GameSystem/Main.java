package GameSystem;

public class Main {

    public static void main(String[] args){
        Player player1=new Player();
        Player player2=new Player();
        SinglePlayerGame singlePlayerGame= new SinglePlayerGame();
        MultiPlayerGame multiPlayerGame= new MultiPlayerGame();
        player1.setGameId(7);
        player1.setRounds(5);
        player1.setGameMode("SINGLE");
        singlePlayerGame.setGameId(player1.getGameId());
        singlePlayerGame.setScore(player1.getRounds());
        player2.setGameId(7);
        player2.setRounds(3);
        player2.setGameMode("MULTI");
        multiPlayerGame.setGameId(player2.getGameId());
        multiPlayerGame.setScore(player2.getRounds());

        if(player1.getGameMode()=="SINGLE"){
            System.out.println("===== PLAYER 1: SINGLE =====");
            System.out.println("Game Started");
            singlePlayerGame.startGame( singlePlayerGame.getScore());
            singlePlayerGame.saveProgress();
            singlePlayerGame.endGame();
        }
        if(player2.getGameMode()=="MULTI"){
            System.out.println("===== PLAYER 2: MULTI =====");
            System.out.println("Game Started");
            multiPlayerGame.startGame( multiPlayerGame.getScore());
            multiPlayerGame.inviteFriend();
            multiPlayerGame.endGame();
        }

    }
}
