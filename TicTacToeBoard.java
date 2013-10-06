/**
 * Represent a Tic Tac Toe game board, and provide methods for playing a game
 * on it.
 */
public class TicTacToeBoard {

  /* The grid will be represented (from the user's perspective) by squares 1
   * through 9, with 1 being the upper left hand corner, and 9 being the lower
   * right hand corner.
   * It can be visualized like so:
   *  1 | 2 | 3
   * -----------
   *  4 | 5 | 6
   * -----------
   *  7 | 8 | 9
   */
  public static final int MIN_MOVE = 1;
  public static final int MAX_MOVE = 9;
  public static final String LABELED_BOARD = " 1 | 2 | 3 \n" + 
                                             "-----------\n" + 
                                             " 4 | 5 | 6 \n" +
                                             "-----------\n" + 
                                             " 7 | 8 | 9 \n";
}
