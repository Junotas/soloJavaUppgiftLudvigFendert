import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Tic Tac Toe ===");
        TicTacToeGame game = new TicTacToeGame(scanner);
        game.start();

        scanner.close();
    }
}
