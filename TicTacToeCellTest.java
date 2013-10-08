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
    this.testCell = new TicTacToeCell();
    this.otherCell = new TicTacToeCell();
  }
  
  @Test
  public void testPlayX() {
    assertTrue(this.testCell.play(TicTacToeGame.Player.X));
  }

  @Test
  public void testPlayO() {
    assertTrue(this.testCell.play(TicTacToeGame.Player.O));
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testPlayNobody() {
    this.testCell.play(TicTacToeGame.Player.Nobody);
  }
  
  @Test
  public void testPlayAlreadyPlayed() {
    this.testCell.play(TicTacToeGame.Player.O);
    assertFalse(this.testCell.play(TicTacToeGame.Player.X));
  }
  
  @Test
  public void testEqualPlayed() {
    this.testCell.play(TicTacToeGame.Player.X);
    this.otherCell.play(TicTacToeGame.Player.X);
    assertTrue(this.testCell.equals(this.otherCell));
    assertTrue(this.otherCell.equals(this.testCell));
  }
  
  @Test
  public void testEqualUnplayed() {
    assertTrue(this.testCell.equals(this.otherCell));
    assertTrue(this.otherCell.equals(this.testCell));
  }
  
  @Test
  public void testEqualUnequalPlayed() {
    this.testCell.play(TicTacToeGame.Player.X);
    this.otherCell.play(TicTacToeGame.Player.O);
    assertFalse(this.testCell.equals(this.otherCell));
    assertFalse(this.otherCell.equals(this.testCell));
  }
  
  @Test
  public void testEqualUnequalOnePlayed() {
    this.testCell.play(TicTacToeGame.Player.X);
    assertFalse(this.testCell.equals(this.otherCell));
    assertFalse(this.otherCell.equals(this.testCell));
  }  
}
