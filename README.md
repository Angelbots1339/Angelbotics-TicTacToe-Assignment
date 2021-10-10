# Angelbotics TicTacToe Practice
## About
This is an unfinished game of TicTacToe to help learn Java.
Make a copy, then finish the abstract methods in FinishedBoard.java (setBoard, isMovelegal, and checkWin).
Message me for help with solutions.
Good luck!

## Setting up
1. In [replit.com](replit.com), go to the main menu and click `Create Repl` <br />![image](https://user-images.githubusercontent.com/47835681/136713839-f88169d2-4289-455f-82a0-3be2c0b77742.png)
2. Select `Import from Github` <br />![image](https://user-images.githubusercontent.com/47835681/136713871-cdff3542-d6db-4503-b762-a01145d78016.png)
3. Paste [https://github.com/Angelbots1339/Angelbotics-TicTacToe-Practice](https://github.com/Angelbots1339/Angelbotics-TicTacToe-Practice) into the URL and click `Import` <br />![image](https://user-images.githubusercontent.com/47835681/136713901-f8bac0a6-80b5-4023-b04d-df42598a94e3.png)
4. Your files are found in the `src` folder <br />![image](https://user-images.githubusercontent.com/47835681/136713930-f2178e54-a068-43c6-8e10-e8d97c08aa08.png)
5. Finish the 3 empty methods in `FinishedBoard.java` <br />![image](https://user-images.githubusercontent.com/47835681/136713973-17b1d3c2-5b85-4c1a-8ab3-54878d303408.png)


## src/GameBoard.java
GameBoard.java is an abstract class for you to finish in your own copy. There are several member objects you will need to use:
- `boolean player1Turn`: A boolean, used to indicate which player's turn it is(True if player 1, false if player 2). This will update automatically once a player makes a move
- `int[][] board`: A two dimensional integer array containing the current board. Access at position x and y by using `board[x][y]`. A new game looks like: <br />
`[0] [0] [0]`<br />
`[0] [0] [0]`<br />
`[0] [0] [0]`<br />, where 0 siginifes a blank space, 1 signifies a player one move, and 2 signifies a player two move

## src/FinishedBoard.java
`player1Turn` and `board` are avalible fo you to use in your methods.
### protected boolean setBoard(int x, int y)
Should set the board coordinate at (x,y) to the current player (use `player1Turn`). Return `true`.
### protected boolean isMoveLegal(int x, int y)
Should check if a move is legal (think about error bounds & if space is already occupied)
### public int checkWin()
Checks who has won the game. Return `1` if player one wins, `2` if player 2 wins, `0` if there is a tie (no open spaces left), and `-1` if the game is not yet over. There are multiple correct ways of finishing this method, however some are less time consuming but more difficult. A hint is to write out all possible conditions in english before you write the code. *COMMENT YOUR CODE!!!* If it takes more than one session to finish this method, the easiest way to pick it back up is to read your own comments. Also, it will be easier for others to help you if they can understand what your code is supposed to be doing.

