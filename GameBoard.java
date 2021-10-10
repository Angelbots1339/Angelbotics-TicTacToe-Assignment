// Password: help

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import java.awt.Dimension;

public abstract class GameBoard extends JPanel implements MouseInputListener{

	protected boolean player1Turn;
	protected int[][] board;
	private JFrame frame;
	private int width;
	private int height;
	private final int defaultSize = 500;
	private boolean update = true;

	/**
	 * Sets the board coordinate to the current player.
	 * @param x X-coordinate of move
	 * @param y Y-coordinate of move
	 * @return True when finished
	*/
	protected abstract boolean setBoard(int x, int y);

	/**
	 * Checks if a move is legal. 
	 * @param x X-coordinate of desired move
	 * @param y Y-coordinate of desired move
	 * @return True on legal move, false otherwise
	*/
	protected abstract boolean isMoveLegal(int x, int y);

	/**
	 * Checks the current state of the game
	 * @return 1 on p1 win, 2 on p2 win, 0 on tie, -1 on continue
	*/
	public abstract int checkWin();

	public GameBoard() {
		createBoard(defaultSize, defaultSize);
	}

	/**
	 * Creates a new object with custom size (wid)
	 * @param size
	*/
	public GameBoard(int size) {
		createBoard(size, size);
	}

	/**
	 * Creates a new object with custom width/height
	 * @param width Width of the game window
	 * @param height Height of the game window
	*/
	public GameBoard(int width, int height) {
		createBoard(width, height);
	}

	/**
	 * Instantiates members for the constructor.
	 * @param width Width of the game window
	 * @param height Height of the game window
	*/
	private void createBoard(int width, int height) {
		board = new int[3][3];
		player1Turn = true;
		this.width = width;
		this.height = height;

		frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(false);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setContentPane(this);
        this.setPreferredSize(new Dimension(width, height));
        this.setFocusTraversalKeysEnabled(false);
        this.addMouseListener(this);
        frame.pack();

        repaint();
        frame.toFront();
        frame.requestFocus();
	}

	@Override
	public void paint(Graphics g) {
		paintBoard(g);
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				int player = board[x][y];
				paintMove(player, x, y, g);
			}
		}
	}

	/**
	 * Draws the lines that separate valid squares
	 * @param g Graphics component to paint to
	*/
	private void paintBoard(Graphics g) {
		for(int i = 1; i < 3; i++) {
			int partWidth = width / 3 * i;
			int partHeight = height / 3 * i;
			g.drawLine(0,partHeight,width,partHeight); // Horizontal
			g.drawLine(partWidth,0,partWidth,height); // Vertical
		}
	}

	/**
	 * Draws a player icon to designated square
	 * @param player Player (1 or 2 are valid, others left blank)
	 * @param x X-coordinate of square
	 * @param y Y-coordinate of square
	 * @param g Graphics componnt to paint to
	*/
	private void paintMove(int player, int x, int y, Graphics g) {
		int squareX = width / 3;
		int squareY = height / 3;
		int offsetX = squareX * x;
		int offsetY = squareY * y;
		if(player == 1) { // X
			g.drawLine(offsetX, offsetY, offsetX + squareX, offsetY + squareY);
			g.drawLine(offsetX + squareX, offsetY, offsetX, offsetY + squareY);
		} else if(player == 2) { // O
			g.drawOval(offsetX, offsetY, squareX, squareY);
		}
	}

	/**
	 * Runs the game until it is finished (will block)
	*/
	public void playGame() {
		boolean run = true;
		int result = 0;
		while(run) {
			repaint();
			result = doGame();
			run = (result == -1);
		}
		switch(result) {
			case 1:
				System.out.println("Player 1 wins!");
				break;
			case 2:
				System.out.println("Player 2 wins!");
				break;
			case 0:
				System.out.println("Tie!");
				break;
			default:
				System.out.println("An error ocurred.");
				break;
		}
		//frame.dispose();
	}

	/**
	 * Does game logic for a single step
	 * @return 1 on p1 win, 2 on p2 win, 0 on tie, -1 on continue
	*/
	public int doGame() {
		if(!update) { // No new user input
			try {
				Thread.sleep(100); // Sleep for 100ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return -1;
		} else { // New user input
			update = false;
			return checkWin();
		}
	}

	/**
	 * Attempts to make a move in the desired square
	 * @param x X-coordinate of desired move
	 * @param y Y-coordinate of desired move
	*/
	public void makeMove(int x, int y) {
		if(isMoveLegal(x, y)) {
			setBoard(x, y);
			player1Turn = !player1Turn;
			update = true;
		}
	}

	public void mouseClicked(MouseEvent e) {
		makeMove(e.getX() / (width / 3), e.getY() / (height / 3));
	}

	public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
}