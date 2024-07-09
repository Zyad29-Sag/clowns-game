package eg.edu.alexu.csd.oop.game.sample.world.circus;

public class PlayingState implements GameState{
 
    private ClownGame clownGame;
 
    public PlayingState(ClownGame ClownGame) {
        this.clownGame = ClownGame;
    }
    @Override
    public void update() {
        clownGame.updatePlayingState();
    }
 
    @Override
    public String getStatus() {
        return "Game State - " + clownGame.getStatus();
    }
}