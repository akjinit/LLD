package TicTacToe;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame(new HumanPlayerStrategy("Akshat"), new HumanPlayerStrategy("Ifra"),
                3, 3
        );
        game.play();
    }
}