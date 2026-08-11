package TicTacToe;

public class Player {
    Symbol symbol;
    PlayerStrategy playerStrategy;

    public Player(Symbol symbol, PlayerStrategy playerStrategy){
        this.symbol = symbol;
        this.playerStrategy = playerStrategy;
    }

    public PlayerStrategy getPlayerStrategy() {
        return playerStrategy;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
