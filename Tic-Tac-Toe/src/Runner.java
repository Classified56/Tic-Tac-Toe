import java.util.Scanner;

public class Runner
	{
		private static Board board = new Board();
		private static Player player[] = new Player[2];
		private static Scanner userInput = new Scanner(System.in);
		
		public static void main(String[] args)
			{
				startUp();
				for(int turns = 0; turns < 27; turns++)
					{
						System.out.println("Player " + (turns % 2 + 1) + " turn.");
						player[turns % 2].move(board);
						System.out.println(board);
					}
			}
		
		public static void startUp()
			{
				System.out.println("Welcome to Three Dimensional Tic-Tac-Toe. \n");
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
	}
