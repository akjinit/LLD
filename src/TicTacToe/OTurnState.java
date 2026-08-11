package TicTacToe;

public class OTurnState implements GameState{

    @Override
    public void next(GameContext context, boolean hasWon,boolean draw) {
        if(draw){
            context.setCurrentState(new DrawState());
        }
        else if(hasWon){
            context.setCurrentState(new OWonState());
        }else{
            context.setCurrentState(new XTurnState());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
