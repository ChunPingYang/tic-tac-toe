import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for TicTacToeCell.
 * The methods to test are play, getPlayer, and equals.
 */
public class TicTacToeCellTest {
  
  private TicTacToeCell testCell;
  private TicTacToeCell otherCell;
  
  @Before
  public void setUp() {
    testCell = new TicTacToeCell();
    otherCell = new TicTacToeCell();
  }
  
  @Test
  public void testPlayX() {
    assertTrue(testCell.play(TicTacToeGame.Player.X));
    assertEquals(TicTacToeGame.Player.X, testCell.getPlayer());
  }

  @Test
  public void testPlayO() {
    assertTrue(testCell.play(TicTacToeGame.Player.O));
    assertEquals(TicTacToeGame.Player.O, testCell.getPlayer());
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testPlayNobody() {
    assertEquals(TicTacToeGame.Player.Nobody, testCell.getPlayer());
    testCell.play(TicTacToeGame.Player.Nobody);
  }
  
  @Test
  public void testPlayAlreadyPlayed() {
    testCell.play(TicTacToeGame.Player.O);
    assertFalse(testCell.play(TicTacToeGame.Player.X));
  }
  
  @Test
  public void testEqualPlayed() {
    testCell.play(TicTacToeGame.Player.X);
    otherCell.play(TicTacToeGame.Player.X);
    assertTrue(testCell.equals(otherCell));
    assertTrue(otherCell.equals(testCell));
  }
  
  @Test
  public void testEqualUnplayed() {
    assertTrue(testCell.equals(otherCell));
    assertTrue(otherCell.equals(testCell));
  }
  
  @Test
  public void testEqualUnequalPlayed() {
    testCell.play(TicTacToeGame.Player.X);
    otherCell.play(TicTacToeGame.Player.O);
    assertFalse(testCell.equals(otherCell));
    assertFalse(otherCell.equals(testCell));
  }
  
  @Test
  public void testEqualUnequalOnePlayed() {
    testCell.play(TicTacToeGame.Player.X);
    assertFalse(testCell.equals(otherCell));
    assertFalse(otherCell.equals(testCell));
  }  
}
