package TicTacToe;

public class GameContext {
    private GameState currentState;
    public GameContext(Symbol symbol){
        currentState = symbol == Symbol.X ? new XTurnState() : new OWonState();
    }

    public void setCurrentState(GameState currentState) {
        this.currentState = currentState;
    }

    public void next(boolean hasWon,boolean draw){
        currentState.next(this,hasWon,draw);
    }
    public boolean isGameOver(){
        return currentState.isGameOver();
    }
    public GameState getCurrentState(){
        return currentState;
    }
}
