import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args)  {
        // Declare the scanner variable
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Rock, Paper, Scissors");

        // Get the round number
        System.out.println("How many rounds do you want to play? (Maximum: 10, Minimum: 1)");
        String roundStr = scanner.nextLine();
        int roundNum = checkStringToNum(roundStr, 1, 10);
        if (roundNum == 0)  {
            System.out.println("ERROR\nNot a number");
        }
        else if (roundNum == -1) {
            System.out.println("ERROR\nNumber out of range");
        }

        // Start the game
        Game game = new Game(roundNum, scanner);
        game.playGame();

        // Ask the player if they want to play again
        System.out.println("Do you want to play again? Yes or No");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            main(args);
        }
        else    {
            System.out.println("Thanks for playing!");
        }

    }

    // Check if the player entered a valid number
    public static int checkStringToNum(String s, int min, int max)   {
        try {
            int test = Integer.parseInt(s);
            if (test >= min && test <= max)    {
                return test;
            }
            else    {
                return -1;
            }
        } catch (NumberFormatException e)   {
            return 0;
        }
    }
}

class Game {
    int ties;
    int computerWins;
    int playerWins;
    int rounds;
    Scanner scanner;

    public Game(int rounds, Scanner scanner) {
        this.rounds = rounds;
        this.scanner = scanner;
        this.ties = 0;
        this.computerWins = 0;
        this.playerWins = 0;
    }

    public void playGame()  {

        // Loop that goes through all the rounds
        while (this.rounds != 0)    {
            // Let player make a move
            int playerMove = makePlayerMove();

            // Let the computer choose a move
            int computerMove = new Random().nextInt(4)+1;

            // Decide the winner
            decideWinner(playerMove, computerMove);

            // Decrease the amount of rounds
            this.rounds--;
        }
        displayWinner();
    }

    private void displayWinner()    {
        if (this.ties > this.computerWins && this.ties > this.playerWins)   {
            System.out.println("Draw!!!");
        }
        else if (this.playerWins > this.computerWins)   {
            System.out.println("Player Won!!!");
        }
        else    {
            System.out.println("Computer Won!!!");
        }
    }

    private int makePlayerMove()    {
        int move = 0;
        do {
            System.out.println("Pick a move: 1 for Rock, 2 for Paper, 3 for Scissor");
            String moveStr = scanner.nextLine();

            try {
                int tempMove = Integer.parseInt(moveStr);
                if (tempMove >= 1 && tempMove <= 3) {
                    move = tempMove;
                }
                else                            {System.out.println("Please enter a number between 1 and 3");}
            } catch (NumberFormatException e)   {System.out.println("Please enter a valid number");}

        } while (move == 0);
        return move;
    }

    private String moveToString(int move)   {
        switch (move)   {
            case 1: return "Rock";
            case 2: return "Paper";
            case 3: return "Scissors";
            default: return "NULL";
        }
    }

    private void decideWinner(int playerMove, int computerMove) {
        System.out.printf("Computer choose %s%n", moveToString(computerMove));
        System.out.printf("Player choose %s%n", moveToString(playerMove));

        if (playerMove == computerMove) {
            this.ties++;
            System.out.printf("Both players choose %s%n", moveToString(playerMove));
            return;
        }

        // Computer choose rock
        if (computerMove == 1)  {
            // Player choose paper, player wins
            if (playerMove == 2)    {
                this.playerWins++;
                System.out.println("Player won this round");
            }
            // Player choose scissors, computer wins
            else    {
                this.computerWins++;
                System.out.println("Computer won this round");
            }
        }
        // Computer choose paper
        else if (computerMove == 2) {
            // Player choose rock, computer wins
            if (playerMove == 1)    {
                this.computerWins++;
                System.out.println("Computer won this round");
            }
            // Player choose scissors, player wins
            else    {
                this.playerWins++;
                System.out.println("Player won this round");
            }
        }
        // Computer choose scissors
        else    {
            // Player choose rock, player wins
            if (playerMove == 1)    {
                this.playerWins++;
                System.out.println("Player won this round");
            }
            // Player choose paper, computer wins
            else    {
                this.computerWins++;
                System.out.println("Computer won this round");
            }
        }
    }
}
