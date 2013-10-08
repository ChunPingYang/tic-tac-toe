import java.util.ArrayList;
import java.util.List;

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
  private static final String BOARD_TEMPLATE = " %s | %s | %s \n" + 
                                               "-----------\n" + 
                                               " %s | %s | %s \n" +
                                               "-----------\n" + 
                                               " %s | %s | %s \n";
  public static final String LABELED_BOARD = " 1 | 2 | 3 \n" + 
                                             "-----------\n" + 
                                             " 4 | 5 | 6 \n" +
                                             "-----------\n" + 
                                             " 7 | 8 | 9 \n";

  /* Conversion from 1-9 representation to two dimensional array indices */
  private static final int[] ROW = {0, 0, 0, 1, 1, 1, 2, 2, 2};
  private static final int[] COL = {0, 1, 2, 0, 1, 2, 0, 1, 2};

  private TicTacToeCell[][] board;
  private List<Integer> possibleMoves;

  /**
   * Initialize the board to all unplayed cells.
   */
  public TicTacToeBoard() {
    this.board = new TicTacToeCell[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        this.board[i][j] = new TicTacToeCell();
      }
    }
    possibleMoves = new ArrayList<Integer>();
    for (int i = MIN_MOVE; i <= MAX_MOVE; i++) {
      possibleMoves.add(i);
    }
  }
  
  /**
   * Return a string representation of the board, like in the comments above.
   * @return a string visualizing the baord.
   */
  public String toString() {
    String boardString = String.format(BOARD_TEMPLATE, board[0][0], board[0][1],
            board[0][2], board[1][0], board[1][1], board[1][2], board[2][0],
            board[2][1], board[2][2]);
    return boardString;
  }
  
  /**
   * Play a move, it it is legal.
   * @return true if the move was successfully played.
   */
  public boolean playMove(int move, TicTacToeGame.Player player) {
    // subtract 1 for 0-indexing
    if (board[ROW[move - 1]][COL[move - 1]].play(player)) {
      // Move must be an Integer so it knows to remove by value, not index.
      possibleMoves.remove(new Integer(move));
      return true;
    }
    return false; // The move was unsuccessful.
  }

  /**
   * Figure out whether the game has ended.
   * @return true if the game has ended.
   */
  public boolean isDone() {
    TicTacToeGame.Player winner = whoWon();
    if (possibleMoves.size() == 0 || winner == TicTacToeGame.Player.X ||
       winner == TicTacToeGame.Player.O) {
      return true;
    }
    return false;
  }

  /**
   * Determine who won the game.
   * @return the winner of the game.
   */
  public TicTacToeGame.Player whoWon() {
    TicTacToeGame.Player winner = winnerOfDownDiagonal();
    if (winner != TicTacToeGame.Player.Nobody) {
      return winner;
    }
    winner = winnerOfUpDiagonal();
    if (winner != TicTacToeGame.Player.Nobody) {
      return winner;
    }
    for (int i = 0; i < 3; i++) {
      winner = winnerOfRow(i);
      if (winner != TicTacToeGame.Player.Nobody) {
        return winner;
      }
      winner = winnerOfCol(i);
      if (winner != TicTacToeGame.Player.Nobody) {
        return winner;
      }
    }
    return TicTacToeGame.Player.Nobody;
  }

  /**
   * Get the numbers of the cells that haven't been played yet.
   * @return an array of the possible remaining moves.
   */
  public int[] getPossibleMoves() {
    int[] possibleMovesArray = new int[possibleMoves.size()];
    for (int i = 0; i < possibleMovesArray.length; i++) {
      possibleMovesArray[i] = possibleMoves.get(i);
    }
    return possibleMovesArray;
  }
  
  /**
   * Return the winner of the specified row, if there is one.
   * @param row the row to get the winner of. 0 <= row < 3.
   * @return the winner, or TicTacToeGame.Player.Nobody if there is no winner.
   */
  private TicTacToeGame.Player winnerOfRow(int row) {
    if (board[row][0].equals(board[row][1]) &&
            board[row][0].equals(board[row][2])) {
      return board[row][0].getPlayer();
    }
    return TicTacToeGame.Player.Nobody;
  }

  /**
   * Return the winner of the specified col, if there is one.
   * @param col the column to get the winner of. 0 <= col < 3.
   * @return the winner, or TicTacToeGame.Player.Nobody if there is no winner.
   */
  private TicTacToeGame.Player winnerOfCol(int col) {
    if(board[0][col].equals(board[1][col]) &&
            board[0][col].equals(board[2][col])) {
      return board[0][col].getPlayer();
    }
    return TicTacToeGame.Player.Nobody;
  }

  /**
   * Return the winner of the down diagonal, if there is one.
   * @return the winner, or TicTacToeGame.Player.Nobody if there is no winner.
   */
  private TicTacToeGame.Player winnerOfDownDiagonal() {
    if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
      return board[0][0].getPlayer();
    }
    return TicTacToeGame.Player.Nobody;
  }

  /**
   * Return the winner of the up diagonal, if there is one.
   * @return the winner, or TicTacToeGame.Player.Nobody if there is no winner.
   */
  private TicTacToeGame.Player winnerOfUpDiagonal() {
    if (board[2][0].equals(board[1][1]) && board[2][0].equals(board[0][2])) {
      return board[2][0].getPlayer();
    }
    return TicTacToeGame.Player.Nobody;
  }
}
