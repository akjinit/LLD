package TicTacToe;

public class XTurnState implements GameState {
    @Override
    public void next(GameContext context,boolean hasWon,boolean draw){
        if(draw){
            context.setCurrentState(new DrawState());
        }
        else if(hasWon){
            context.setCurrentState(new XWonState());
        }else{
            context.setCurrentState(new OTurnState());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}


