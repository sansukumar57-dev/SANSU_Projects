package GameSystem;

public class Player extends BaseFunctionality implements PlayerInterface    {
    private int  rounds;
    private String  gameMode;

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }
}
