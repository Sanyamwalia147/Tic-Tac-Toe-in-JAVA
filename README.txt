 README file
 Created by Sanyam Walia
	    2020CSB1122
	    
 FILES: This directory contains the following files-
        TicTacToe.java - main code containg all the required classes (Grid, Computer, TicTacToe)
        TicTacToe.class
        Grid.class
        Computer.class
        README.txt	    
	
------------------------------------------------------------------------------------------------------
 
 To run the programme, open the terminal on your system.
 Navigate to the directory containing the TicTacToe.java file and execute the below two commands
 	"javac TicTacToe.java"    //compiles and creates TicTacToe.class file
	"java TicTacToe"          //runs to programme   
	   
	   
=======================================================================================================

 The interface of the game is as follows:
  ___ ___ ___
 |   |   |   |     This is the reference grid. To place your symbol on a particular spot in the grid,        
 | 1 | 2 | 3 |     you need to enter the number (from 1 to 9) corresponding to that location. 
 |___|___|___|     
 |   |   |   |     This grid will also be available in game to look up.
 | 4 | 5 | 6 |
 |___|___|___| 
 |   |   |   |
 | 7 | 8 | 9 |
 |___|___|___|

=======================================================================================================

 The game has two modes:
 1. Player vs Computer
 2. Mulitplayer
 You will be asked to enter the choice of game mode by pressing 1 or 2.

-------------------------------------------------------------------------------------------------------
 
 1. PLAYER VS COMPUTER-
    The player is 'X' and gets to play first. Whenever it's your turn, simply enter the number (1 to 9) 
    where you want to place 'X'. The Computer will place 'O' on the grid on it's own and the location 
    selected by the computer will be shown to you.
    
    The game ends when either player or coputer wins, or if it's a draw with no space left on the grid. 
    The result of the game will be displayed.
    
-------------------------------------------------------------------------------------------------------

 2. MULTIPLAYER-
    Player 1 gets to choose his symbol ('X'/'O') first. Player 2 is automatically alloted the other 
    symbol.
    The player who is 'X' has the first turn.
    Both players on their turn must enter the number (1 to 9) where they want to play on the grid.
    
    The game ends if any player wins or it's a draw with no space left on the grid.
    The result of the game will be displayed.
    
-------------------------------------------------------------------------------------------------------
 
 To play again, you must enter y/Y when asked for, to exit press n/N instead. 
    
=======================================================================================================
 
 
 You have reached the end of the file.  
