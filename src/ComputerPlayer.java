import java.util.Random;
import java.util.Scanner;

public class ComputerPlayer extends Player {

    private final Random random;

    public ComputerPlayer(String name, char mark) {
        super(name, mark);
        this.random = new Random();
    }

    @Override
    public int chooseMove(Board board, Scanner scanner) {
        int[] freePositions = new int[9];
        int freeCount = 0;

        for (int pos = 1; pos <= 9; pos++) {
            if (board.isCellEmpty(pos)) {
                freePositions[freeCount] = pos;
                freeCount++;
            }
        }

        int index = random.nextInt(freeCount);
        int chosen = freePositions[index];

        System.out.println(getName() + " (" + getMark() + ") chooses position " + chosen);
        return chosen;
    }
}
