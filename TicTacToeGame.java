import java.util.Scanner;

/**
 * Driver for playing a game of Tic Tac Toe
 */
public class TicTacToeGame {
  private static final String WELCOME_MESSAGE = "\nWelcome to Tic Tac Toe!\n";
  private static final String MOVE_INSTRUCTION_MESSAGE = "The game board looks"
      + " like this:\n\n" + TicTacToeBoard.LABELED_BOARD + "\nOn your turn, "
      + "enter the number of the square you want to make your move on.\n";
  private static final String MOVE_PROMPT = "Please enter a move";
  private static final String VALID_MOVE_PROMPT = "Please enter a move between "
      + TicTacToeBoard.MIN_MOVE + " and " + TicTacToeBoard.MAX_MOVE;

  private static final Scanner scanner = new Scanner(System.in);

  /**
   * Write a line to the human player.
   * @param toWrite the message to write.
   */
  private static void say(String toWrite) {
    System.out.println(toWrite);
  }

  /**
   * Write a message to the human player, asking for input.
   * @param toPrompt the message to prompt with.
   */
   private static void prompt(String toPrompt) {
     System.out.print(toPrompt + ": ");
   }

  /**
   * Prompt the user for a move, and return it.
   * @returns a valid move entered by the user.
   */
  private static int getMove() {
    prompt(MOVE_PROMPT);
    return getValidMove();
  }

  /**
   * Get a move from the user. If it is invalid, display an error and prompt the
   * user again.
   * @returns the valid move the user made.
   */
  private static int getValidMove() {
    String playerInput = scanner.nextLine();
    try {
      int move = Integer.parseInt(playerInput);
      if (move >= TicTacToeBoard.MIN_MOVE && move <= TicTacToeBoard.MAX_MOVE) {
        return move;
      } else {
        throw new NumberFormatException();
      }
    } catch (NumberFormatException e) {
      prompt(VALID_MOVE_PROMPT);
      return getValidMove();
    }
  }

  /**
   * Plays a game of Tic Tac Toe on the command line with a randomized
   * computer opponent.
   */
  public static void main(String[] args) {
    say(WELCOME_MESSAGE);
    say(MOVE_INSTRUCTION_MESSAGE);
    int move = getMove();
  }
}
