import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, char mark) {
        super(name, mark);
    }

    @Override
    public int chooseMove(Board board, Scanner scanner) {
        while (true) {
            System.out.print("Choose a free position (1-9): ");
            String input = scanner.nextLine().trim();

            int number;
            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number between 1 and 9.");
                continue;
            }

            if (number < 1 || number > 9) {
                System.out.println("That position is outside the board. Try again.");
                continue;
            }

            if (!board.isCellEmpty(number)) {
                System.out.println("That position is already taken. Try again.");
                continue;
            }

            return number;
        }
    }
}
