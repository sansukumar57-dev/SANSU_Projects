package GameSystem;

public abstract class Game extends BaseFunctionality implements GameInterface{

    public void startGame(int rounds){
        int score= rounds*10;
        System.out.println("Game Strated");
        System.out.print("Score: ");
        System.out.println(score);
    }
    public void endGame(){
        System.out.println("Game Over");
    }
}
