import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for TicTacToeBoard.
 * The methods to test are isDone, whoWon, getPossibleMoves, and toString.
 * Helper methods (including play, winnerOfRow, etc) are covered by testing
 *     these methods.
 */
public class TicTacToeBoardTest {

  private TicTacToeBoard playedBoard;

  @Before
  public void setUp() {
    playedBoard = new TicTacToeBoard();
  }

  @Test
  public void testRowWins() {
    play(TicTacToeGame.Player.X, 1, 2, 3);
    int[] possibleMoves = {4, 5, 6, 7, 8, 9};
    String boardString = " X | X | X \n" +
                         "-----------\n" +
                         "   |   |   \n" +
                         "-----------\n" +
                         "   |   |   \n";
    
    assertCorrect(true, TicTacToeGame.Player.X, possibleMoves, boardString);
  }

  @Test
  public void testColWins() {
    play(TicTacToeGame.Player.O, 2, 5, 8);
    int[] possibleMoves = {1, 3, 4, 6, 7, 9};
    String boardString = "   | O |   \n" +
                         "-----------\n" +
                         "   | O |   \n" +
                         "-----------\n" +
                         "   | O |   \n";

    assertCorrect(true, TicTacToeGame.Player.O, possibleMoves, boardString);
  }

  @Test
  public void testDownDiagonalWins() {
    play(TicTacToeGame.Player.O, 1, 5, 9);
    int[] possibleMoves = {2, 3, 4, 6, 7, 8};
    String boardString = " O |   |   \n" +
                         "-----------\n" +
                         "   | O |   \n" +
                         "-----------\n" +
                         "   |   | O \n";

    assertCorrect(true, TicTacToeGame.Player.O, possibleMoves, boardString);
  }

  @Test
  public void testUpDiagonalWins() {
    play(TicTacToeGame.Player.X, 3, 5, 7);
    int[] possibleMoves = {1, 2, 4, 6, 8, 9};
    String boardString = "   |   | X \n" +
                         "-----------\n" +
                         "   | X |   \n" +
                         "-----------\n" +
                         " X |   |   \n";

    assertCorrect(true, TicTacToeGame.Player.X, possibleMoves, boardString);
  }

  @Test
  public void testTie() {
    play(TicTacToeGame.Player.X, 1, 3, 4, 8, 9);
    play(TicTacToeGame.Player.O, 2, 5, 6, 7);
    int[] possibleMoves = {};
    String boardString = " X | O | X \n" +
                         "-----------\n" +
                         " X | O | O \n" +
                         "-----------\n" +
                         " O | X | X \n";

    assertCorrect(true, TicTacToeGame.Player.Nobody, possibleMoves, boardString);
  }

  @Test
  public void testNotStarted() {
    int[] possibleMoves = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    String boardString = "   |   |   \n" +
            "-----------\n" +
            "   |   |   \n" +
            "-----------\n" +
            "   |   |   \n";

    assertCorrect(false, TicTacToeGame.Player.Nobody, possibleMoves, boardString);
  }

  @Test
  public void testInTheMiddle() {
    play(TicTacToeGame.Player.X, 1, 3, 9);
    play(TicTacToeGame.Player.O, 2, 4);
    int[] possibleMoves = {5, 6, 7, 8};
    String boardString = " X | O | X \n" +
                         "-----------\n" +
                         " O |   |   \n" +
                         "-----------\n" +
                         "   |   | X \n";

    assertCorrect(false, TicTacToeGame.Player.Nobody, possibleMoves, boardString);
  }

  /**
   * Play a sequence of moves by a specific player.
   * @param player the player playing the moves.
   * @param moves the moves to play.
   */
  private void play(TicTacToeGame.Player player, int...moves) {
    for (int move: moves) {
      playedBoard.playMove(move, player);
    }
  }

  /**
   * Assert that the isDone, whoWon, getPossibleMoves, and toString
   *     methods are behaving as expected.
   */
  private void assertCorrect(boolean done, TicTacToeGame.Player winner,
         int[] movesLeft, String stringRep) {
    assertEquals(done, playedBoard.isDone());
    assertEquals(winner, playedBoard.whoWon());
    assertArrayEquals(movesLeft, playedBoard.getPossibleMoves());
    assertEquals(stringRep), playedBoard.toString());
  }
}
