import java.util.Random;
import java.util.Scanner;

public class Main
{
    static int playerScore = 0;
    static int computerScore = 0;
    static Scanner input = new Scanner(System.in);
    public static void main( String[] args )
    {
        // declaring and initializing a 2D-Array (2D-char type array)
        char [][] gameBoard = { {'_','|','_','|','_'},
                                {'_','|','_','|','_'},
                                {' ','|',' ','|',' '} };
        boolean gameOver = false;
        boolean playAgain = true;

        while( playAgain)
        {
            while (!gameOver) {
                playerMove(gameBoard);
                gameOver = isGameOver(gameBoard);

                if (gameOver) {
                    break;
                }

                computerMove(gameBoard);
                gameOver = isGameOver(gameBoard);

                if (gameOver) {
                    break;
                }

            }
        }
            System.out.println("player Score:" + playerScore);
            System.out.println("Computer Score" + playerScore);
            System.out.println("Would you like to play again? Y/N ");
            String decision = input.nextLine();

            switch (decision){
                case "Y":
                case "y":
                    playAgain = true;
                    System.out.println("Cool! Let's play again");
                    // reset the game board
                    resetGameBoard(gameBoard);
                    gameOver = false;
                    printBoard(gameBoard);
                    break;

                case "N":
                case "n":
                    playAgain = false;
                    System.out.println("Cool! Thanks for playing");
                    break;

                default:
                    break;
            }
        }

    // Create a method that prints out our 2D-Array using a nested for-loop.
    public static void printBoard ( char [][] gameBoard )
    {
        // printing the 2D array
        for ( int row = 0 ; row < gameBoard.length; row++ )
        {
            for( int column = 0; column < gameBoard[row].length; column++ )
            {
                System.out.print( gameBoard[row][column] );
            }
                System.out.println( );
        }
    }

    // Create a method to place a piece on the game board.
    public static void updateBoard( int player, int position, char[][] gameBoard)
    {
        char character;

        if (player == 1)
        {
            character = 'X';
        }
        else
        {
            character = 'O';
        }

        switch ( position )
        {
            case 1:
                gameBoard[0][0] = character;
                printBoard(gameBoard);
                break;

            case 2:
                gameBoard[0][2] = character;
                printBoard(gameBoard);
                break;

            case 3:
                gameBoard[0][4] = character;
                printBoard(gameBoard);
                break;

            case 4:
                gameBoard[1][0] = character;
                printBoard(gameBoard);
                break;

            case 5:
                gameBoard[1][2] = character;
                printBoard(gameBoard);
                break;

            case 6:
                gameBoard[1][4] = character;
                printBoard(gameBoard);
                break;

            case 7:
                gameBoard[2][0] = character;
                printBoard(gameBoard);
                break;

            case 8:
                gameBoard[2][2] = character;
                printBoard(gameBoard);
                break;

            case 9:
                gameBoard[2][4] = character;
                printBoard(gameBoard);
                break;


        }
    }

    // Create a Scanner class to save the input from the user.
    public static void playerMove ( char[][] gameBoard )
    {
        // Create a Scanner class to save the input from the user.
        System.out.println("Please make a move. (1-9): " );
        int move = input.nextInt();

        //testing the input of the player move against the boolean method
        boolean result = isValidMove( move, gameBoard );

        while (!result)
        {
            System.out.println(" Sorry! Invalid Move. Try again");
            move = input.nextInt();
            result = isValidMove( move, gameBoard);
        }
        System.out.println("Player moved at position " + move);
        updateBoard( 1, move, gameBoard);
    }

    public static void computerMove ( char[][] gameBoard )
    {
        Random random = new Random();
        int move = random.nextInt(9)+1;

        //testing the input of the computer move against the boolean method
        boolean result = isValidMove( move, gameBoard );

        while (!result)
        {
            move = random.nextInt(9)+1;
            result = isValidMove( move, gameBoard);
        }

        System.out.println("Computer moved at position " + move);
        updateBoard( 2, move, gameBoard);
    }

    // Create a method to verify whether move is a valid move.
    public static boolean isValidMove( int move, char[][]gameBoard )
    {
        switch( move )
        {
            case 1:
                if( gameBoard[0][0] == '_')
                {
                    return true;
                }
                else
                {
                    return false;
                }

            case 2:
                if( gameBoard[0][2] == '_')
                {
                    return true;
                }
                else
                {
                    return false;
                }

            case 3:
                if( gameBoard[0][4] == '_')
                {
                    return true;
                }
                else
                {
                    return false;
                }

            case 4:
                if( gameBoard[1][0] == '_')
                {
                    return true;
                }
                else
                {
                    return false;
                }

            case 5:
                if( gameBoard[1][2] == '_')
                {
                    return true;
                }
                else
                {
                    return false;
                }

            case 6:
                if( gameBoard[1][4] == '_')
                {
                    return true;
                }
                else
                {
                    return false;
                }

            case 7:
                if( gameBoard[2][0] == ' ')
                {
                    return true;
                }
                else
                {
                    return false;
                }

            case 8:
                if( gameBoard[2][2] == ' ')
                {
                    return true;
                }
                else
                {
                    return false;
                }

            case 9:
                if( gameBoard[2][4] == ' ')
                {
                    return true;
                }
                else
                {
                    return false;
                }

            default:
                return false;
        }

    }

    public static boolean isGameOver( char[][] gameBoard )
    {
        //Horizontal Wins
        if (gameBoard[0][0] == 'X' && gameBoard[0][2] == 'X' && gameBoard[0][4] == 'x')
        {
            System.out.println("Player Wins!");
            playerScore++;
            return true;
        }

        if (gameBoard[0][0] == 'O' && gameBoard[0][2] == 'O' && gameBoard[0][4] == 'O')
        {
            System.out.println("Computer Wins!");
            computerScore++;
            return true;
        }

        if (gameBoard[1][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[1][4] == 'x')
        {
            System.out.println("Player Wins!");
            playerScore++;
            return true;
        }

        if (gameBoard[1][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[1][4] == 'O')
        {
            System.out.println("Computer Wins!");
            computerScore++;
            return true;
        }

        if (gameBoard[2][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'x')
        {
            System.out.println("Player Wins!");
            playerScore++;
            return true;
        }

        if (gameBoard[2][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[2][4] == 'O')
        {
            System.out.println("Computer Wins!");
            computerScore++;
            return true;
        }
        // Vertical Wins

        if (gameBoard[0][0] == 'X' && gameBoard[1][0] == 'X' && gameBoard[2][0] == 'x')
        {
            System.out.println("Player Wins!");
            playerScore++;
            return true;
        }

        if (gameBoard[0][0] == 'O' && gameBoard[1][0] == 'O' && gameBoard[2][0] == 'O')
        {
            System.out.println("Computer Wins!");
            computerScore++;
            return true;
        }

        if (gameBoard[0][2] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][2] == 'x')
        {
            System.out.println("Player Wins!");
            playerScore++;
            return true;
        }

        if (gameBoard[0][2] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][2] == 'O')
        {
            System.out.println("Computer Wins!");
            computerScore++;
            return true;
        }

        if (gameBoard[0][4] == 'X' && gameBoard[1][4] == 'X' && gameBoard[2][4] == 'x')
        {
            System.out.println("Player Wins!");
            playerScore++;
            return true;
        }

        if (gameBoard[0][4] == 'O' && gameBoard[1][4] == 'O' && gameBoard[2][4] == 'O')
        {
            System.out.println("Computer Wins!");
            computerScore++;
            return true;
        }

        // Diagonal Wins

        if (gameBoard[0][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][4] == 'x')
        {
            System.out.println("Player Wins!");
            playerScore++;
            return true;
        }

        if (gameBoard[0][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][4] == 'O')
        {
            System.out.println("Computer Wins!");
            computerScore++;
            return true;
        }

        if (gameBoard[2][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[0][4] == 'x')
        {
            System.out.println("Player Wins!");
            playerScore++;
            return true;
        }

        if (gameBoard[2][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[0][4] == 'O')
        {
            System.out.println("Computer Wins!");
            computerScore++;
            return true;
        }

        //tie when it's not equal to its empty state.

        if (gameBoard[0][0] != '_' && gameBoard[0][2] != '_' && gameBoard[0][4] != '_' &&
                gameBoard[1][0] != '_' && gameBoard[1][2] != '_' && gameBoard[1][4] != '_' &&
                    gameBoard[2][0] != ' ' && gameBoard[2][2] != ' ' && gameBoard[2][4] != ' ')
        {
            System.out.println("It's a tie! ");
            return true;
        }
        return false;

    }

    // method to reset game board
    public static void resetGameBoard(char[][] gameBoard )
    {
        gameBoard[0][0] = '_';
        gameBoard[0][2] = '_';
        gameBoard[0][4] = '_';
        gameBoard[1][0] = '_';
        gameBoard[1][2] = '_';
        gameBoard[1][4] = '_';
        gameBoard[2][0] = ' ';
        gameBoard[2][2] = ' ';
        gameBoard[2][4] = ' ';

    }
}