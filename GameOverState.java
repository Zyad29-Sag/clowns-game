package eg.edu.alexu.csd.oop.game.sample.world.circus;

public class GameOverState implements GameState {
 
    private ClownGame clownGame;
 
    public GameOverState(ClownGame clownGame) {
        this.clownGame = clownGame;
    }
 
    @Override
    public void update() {
    }
 
    @Override
    public String getStatus() {
        return "Game State - " + clownGame.getStatus();
    }
 
}