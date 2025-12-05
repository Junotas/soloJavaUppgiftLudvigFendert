import java.util.Scanner;

public class TicTacToeGame {
    private final Board board;
    private final Scanner scanner;
    private final Player player1;
    private final Player player2;
    private Player startingPlayer;

    public TicTacToeGame(Scanner scanner) {
        this.scanner = scanner;
        this.board = new Board();

        System.out.print("Play vs human or vs computer? (h/c): ");
        boolean vsComputer = askVsComputer();

        System.out.print("Enter name for player 1 (X): ");
        String name1 = readNonEmptyLine();

        Player p1 = new HumanPlayer(name1, 'X');
        Player p2;

        if (vsComputer) {
            p2 = new ComputerPlayer("Computer", 'O');
        } else {
            System.out.print("Enter name for player 2 (O): ");
            String name2 = readNonEmptyLine();
            p2 = new HumanPlayer(name2, 'O');
        }

        this.player1 = p1;
        this.player2 = p2;
        this.startingPlayer = player1;
    }

    public void start() {
        boolean keepPlaying = true;

        while (keepPlaying) {
            playSingleGame();
            printScore();

            System.out.print("Play again? (y/n): ");
            keepPlaying = askYesNo();

            if (keepPlaying) {
                switchStartingPlayer();
            }
        }

        System.out.println("Thanks for playing!");
    }

    private void playSingleGame() {
        board.reset();
        Player currentPlayer = startingPlayer;

        while (true) {
            System.out.println();
            board.print();
            System.out.println();
            System.out.println("It is " + currentPlayer.getName()
                    + "'s turn (" + currentPlayer.getMark() + ")");

            int move = currentPlayer.chooseMove(board, scanner);
            board.placeMark(move, currentPlayer.getMark());

            if (board.hasWinner(currentPlayer.getMark())) {
                System.out.println();
                board.print();
                System.out.println();
                System.out.println("Congratulations " + currentPlayer.getName() + "! You won this game.");
                currentPlayer.addWin();
                break;
            }

            if (board.isFull()) {
                System.out.println();
                board.print();
                System.out.println();
                System.out.println("The game is a draw.");
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

    private String readNonEmptyLine() {
        while (true) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
            System.out.print("Please enter a non-empty value: ");
        }
    }

    private boolean askYesNo() {
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                return true;
            }
            if (input.equals("n") || input.equals("no")) {
                return false;
            }
            System.out.print("Please answer with y or n: ");
        }
    }

    private boolean askVsComputer() {
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("c")) {
                return true;
            }
            if (input.equals("h")) {
                return false;
            }
            System.out.print("Please answer with h (human) or c (computer): ");
        }
    }

    private void printScore() {
        System.out.println();
        System.out.println("Current score:");
        System.out.println(player1.getName() + " (" + player1.getMark() + "): " + player1.getWins());
        System.out.println(player2.getName() + " (" + player2.getMark() + "): " + player2.getWins());
    }

    private void switchStartingPlayer() {
        if (startingPlayer == player1) {
            startingPlayer = player2;
        } else {
            startingPlayer = player1;
        }
    }
}
