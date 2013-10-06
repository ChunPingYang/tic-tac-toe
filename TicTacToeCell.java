/**
 * Represent a cell of a tic tac toe board.
 */
public class TicTacToeCell{

  /**
   * Possible states for the cell: either it hasn't been played yet, or it has
   * been claimed by X or O.
   */
  private static enum CellState {
    NOT_PLAYED, X, O
  }

  private CellState state;

  /**
   * Initialize a cell that has not been played yet.
   */
  public TicTacToeCell() {
    this.state = CellState.NOT_PLAYED;
  }

  /**
   * Determine whether it is legal to play this cell.
   * @return if this cell has already been played.
   */
  private boolean canPlay() {
    return this.state == CellState.NOT_PLAYED;
  }

  /**
   * Play this cell, if it has not already been played.
   * @param player the player (X or O) making a move on this cell.
   * @throws IllegalArgumentException if the player is not X or O.
   * @return true if the cell was successfully played.
   */
  public boolean play(TicTacToeGame.Player player) {
    if (!canPlay()) {
      return false;
    }
    if (player == TicTacToeGame.Player.X) {
      this.state = CellState.X;
    } else if (player == TicTacToeGame.Player.O) {
      this.state = CellState.O;
    } else {
      throw new IllegalArgumentException("Unknown player type: " + player);
    }
    return true;
  }
}
