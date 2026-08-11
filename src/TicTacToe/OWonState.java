package TicTacToe;

public class OWonState implements GameState {

    @Override
    public void next(GameContext context, boolean hasWon,boolean draw) {

    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
