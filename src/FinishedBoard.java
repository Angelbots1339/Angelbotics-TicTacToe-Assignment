package src;

public class FinishedBoard extends GameBoard {
	/**
	 * Sets the board coordinate to the current player.
	 * @param x X-coordinate of move
	 * @param y Y-coordinate of move
	 * @return True
	*/
	@Override
	protected boolean setBoard(int x, int y) {
		// TODO
	}

	/**
	 * Checks if a move is legal. 
	 * @param x X-coordinate of desired move
	 * @param y Y-coordinate of desired move
	 * @return True on legal move, false otherwise
	*/
	@Override
	protected boolean isMoveLegal(int x, int y) {
		// TODO
	}

	/**
	 * Checks the current state of the game
	 * @return 1 on p1 win, 2 on p2 win, 0 on tie, -1 on continue
	*/
	@Override
	public int checkWin() {
		// TODO
	}


	// -- DO NOT CHANGE BELOW THIS LINE -- \\
	public FinishedBoard() {
		super();
	}

	public FinishedBoard(int size) {
		super(size);
	}

	public FinishedBoard(int width, int height) {
		super(width, height);
	}
}