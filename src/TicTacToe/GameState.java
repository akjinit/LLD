package TicTacToe;

public interface GameState {
    void next(GameContext context,boolean hasWon,boolean draw);
    boolean isGameOver();
}
