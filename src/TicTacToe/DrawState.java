package TicTacToe;

public class DrawState implements GameState{

    @Override
    public void next(GameContext context, boolean hasWon, boolean draw) {

    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
