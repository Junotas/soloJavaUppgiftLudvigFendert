import java.util.Scanner;

public abstract class Player {
    private final String name;
    private final char mark;
    private int wins;

    public Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
        this.wins = 0;
    }

    public String getName() {
        return name;
    }

    public char getMark() {
        return mark;
    }

    public int getWins() {
        return wins;
    }

    public void addWin() {
        wins++;
    }

    public abstract int chooseMove(Board board, Scanner scanner);
}
