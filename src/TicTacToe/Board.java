package TicTacToe;

public class Board {
    public final int rows;
    public final int columns;
    private Symbol[][] grid;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new Symbol[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }

    public boolean isValidMove(Position pos) {
        return pos.row >= 0 && pos.col >= 0 && pos.row < rows &&
                pos.col < columns && grid[pos.row][pos.col] == Symbol.EMPTY;
    }

    public void makeMove(Position pos, Symbol symbol) {
        grid[pos.row][pos.col] = symbol;
    }

    public void checkGameState(GameContext context) {
        boolean hasWon = false;
        // check rows
        for (int i = 0; i < rows; i++) {
            if (isWinningLine(grid[i])) {
                hasWon = true;
                break;
            }
        }
        // check columns
        if (!hasWon) {
            for (int i = 0; i < columns; i++) {
                Symbol[] column = new Symbol[rows];
                for (int j = 0; j < rows; j++) {
                    column[j] = grid[j][i];
                }
                if (isWinningLine(column)) {
                    hasWon = true;
                    break;
                }
            }
        }

        // check diagonals
        if (!hasWon) {
            Symbol[] diagonal1 = new Symbol[Math.min(rows, columns)];
            Symbol[] diagonal2 = new Symbol[Math.min(rows, columns)];
            for (int i = 0; i < Math.min(rows, columns); i++) {
                diagonal1[i] = grid[i][i];
                diagonal2[i] = grid[i][columns - 1 - i];
            }
            if (isWinningLine(diagonal1) || isWinningLine(diagonal2)) {
                hasWon = true;
            }
        }

        if (hasWon) {
            context.next(true, false);
            return;
        }

        if (isDraw()) {
            context.next(false, true);
            return;
        }

        // No win or draw: advance turn
        context.next(false, false);
    }

    public boolean isDraw(){//checks no one is empty
        for (int i = 0; i < rows; i++) {
            for(int j = 0;j<columns;j++){
                if(grid[i][j] == Symbol.EMPTY){
                    return false;
                }
            }
        }
        return true;
    }
    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Symbol symbol = grid[i][j];
                switch (symbol) {
                    case X:
                        System.out.print(" X ");
                        break;
                    case O:
                        System.out.print(" O ");
                        break;
                    case EMPTY:
                    default:
                        System.out.print(" . ");
                }
                if (j < columns - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < rows - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    static private boolean isWinningLine(Symbol[] line) {
        if (line[0] == Symbol.EMPTY) return false;
        for (Symbol s : line) {
            if (s != line[0]) return false;
        }
        return true;
    }
}
