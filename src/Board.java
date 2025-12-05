public class Board {
    private final char[][] cells;

    public Board() {
        cells = new char[3][3];
        reset();
    }

    public void reset() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                cells[row][col] = ' ';
            }
        }
    }

    public boolean isCellEmpty(int position) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        return cells[row][col] == ' ';
    }

    public void placeMark(int position, char mark) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        cells[row][col] = mark;
    }

    public boolean hasWinner(char mark) {
        // Rows and columns
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == mark && cells[i][1] == mark && cells[i][2] == mark) {
                return true;
            }
            if (cells[0][i] == mark && cells[1][i] == mark && cells[2][i] == mark) {
                return true;
            }
        }

        // Diagonals
        if (cells[0][0] == mark && cells[1][1] == mark && cells[2][2] == mark) {
            return true;
        }
        if (cells[0][2] == mark && cells[1][1] == mark && cells[2][0] == mark) {
            return true;
        }

        return false;
    }

    public boolean isFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (cells[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void print() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int position = row * 3 + col + 1;
                char value = cells[row][col];

                if (value == ' ') {
                    System.out.print(" " + position + " ");
                } else {
                    System.out.print(" " + value + " ");
                }

                if (col < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row < 2) {
                System.out.println("---+---+---");
            }
        }
    }
}
