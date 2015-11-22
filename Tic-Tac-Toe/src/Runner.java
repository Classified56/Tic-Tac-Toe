import java.util.Scanner;

public class Runner
	{
		static FourthDimension board = new FourthDimension();
		private static Player player[] = new Player[2];
		private static Scanner userInput = new Scanner(System.in);
		
		public static void main(String[] args)
			{
				startUp();
				for(int turns = 0; turns < 81; turns++)
					{
						System.out.println("Player " + (turns % 2 + 1) + " turn.");
						player[turns % 2].move(board.getBoard(askDimension()));
						System.out.println(board);
					}
				System.out.println("Game over. ");
				if(player[0].getScore() > player[1].getScore())
					System.out.println("Player 1 wins! " + player[0].getScore() + " : " + player[1].getScore());
				else if(player[0].getScore() < player[1].getScore())
					System.out.println("Player 2 wins! " + player[0].getScore() + " : " + player[1].getScore());
				else
					System.out.println("It's a tie!");
			}
		
		private static void startUp()
			{
				System.out.println("Welcome to Four Dimensional Tic-Tac-Toe. \n");
				System.out.println(board);
				System.out.print("\nHow many players are there? ");
				int players = userInput.nextInt();
				player[0] = new Human("X");
				switch(players)
				{
					case 1:
						player[1] = new Computer();
						break;
					default:
						System.out.println("A computer was created due to your incompetence.");
					case 2:
						player[1] = new Human("O");
						break;
				}
				for(int i = 0; i < 2; i++)
					System.out.println(player[i]);
				System.out.println();
			}
		
		private static int askDimension()
			{
				while(true)
					{
						System.out.print("Which dimension do you want it in? ");
						int x = userInput.nextInt() - 1;
						if(x <= 2 && x >= 0)
							return x;
						else
							System.out.println("Pick a valid plane. ");
					}
			}
	}
