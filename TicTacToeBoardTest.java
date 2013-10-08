import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for TicTacToeBoard.
 * The methods to test are isDone, whoWon, and toString.
 * Helper methods are covered by testing these methods.
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
    
    assertTrue(playedBoard.isDone());
    assertEquals(TicTacToeGame.Player.X, playedBoard.whoWon());
    assertArrayEquals(possibleMoves, playedBoard.getPossibleMoves());
    assertEquals(boardString, playedBoard.toString());
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

    assertTrue(playedBoard.isDone());
    assertEquals(TicTacToeGame.Player.O, playedBoard.whoWon());
    assertArrayEquals(possibleMoves, playedBoard.getPossibleMoves());
    assertEquals(boardString, playedBoard.toString());
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

    assertTrue(playedBoard.isDone());
    assertEquals(TicTacToeGame.Player.O, playedBoard.whoWon());
    assertArrayEquals(possibleMoves, playedBoard.getPossibleMoves());
    assertEquals(boardString, playedBoard.toString());
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

    assertTrue(playedBoard.isDone());
    assertEquals(TicTacToeGame.Player.X, playedBoard.whoWon());
    assertArrayEquals(possibleMoves, playedBoard.getPossibleMoves());
    assertEquals(boardString, playedBoard.toString());
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

    assertTrue(playedBoard.isDone());
    assertEquals(TicTacToeGame.Player.Nobody, playedBoard.whoWon());
    assertArrayEquals(possibleMoves, playedBoard.getPossibleMoves());
    assertEquals(boardString, playedBoard.toString());
  }

  @Test
  public void testNotStarted() {
    int[] possibleMoves = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    String boardString = "   |   |   \n" +
            "-----------\n" +
            "   |   |   \n" +
            "-----------\n" +
            "   |   |   \n";

    assertFalse(playedBoard.isDone());
    assertEquals(TicTacToeGame.Player.Nobody, playedBoard.whoWon());
    assertArrayEquals(possibleMoves, playedBoard.getPossibleMoves());
    assertEquals(boardString, playedBoard.toString());
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

    assertFalse(playedBoard.isDone());
    assertEquals(TicTacToeGame.Player.Nobody, playedBoard.whoWon());
    assertArrayEquals(possibleMoves, playedBoard.getPossibleMoves());
    assertEquals(boardString, playedBoard.toString());
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
}
