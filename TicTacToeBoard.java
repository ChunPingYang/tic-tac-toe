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

  /* The number of cells per row/col */
  private static final int N = 3;

  /* Conversion from 1-9 representation to two dimensional array indices */
  private static final int[] ROW = {0, 0, 0, 1, 1, 1, 2, 2, 2};
  private static final int[] COL = {0, 1, 2, 0, 1, 2, 0, 1, 2};

  private TicTacToeCell[][] board;

  /**
   * Initialize the board to all unplayed cells.
   */
  public TicTacToeBoard() {
    board = new TicTacToeCell[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        board[i][j] = new TicTacToeCell();
      }
    }
  }

  /**
   * Play a move, it it is legal.
   * @returns true if the move was successfully played.
   */
  public boolean playMove(int move, TicTacToeGame.Player player) {
    move -= 1; // for 0-indexing
    return board[ROW[move]][COL[move]].play(player);
  }
}
