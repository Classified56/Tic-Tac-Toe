
public class Tester
	{
		private static FourthDimension board = new FourthDimension();
		private static Player player[] = new Player[2];
		private static int averageScore;
		private static int lowestScore = 20;
		public static void main(String[] args)
			{
				for(int i = 0; i < 10000; i++)
					{
						startUp();
						for(int turns = 0; turns < 81; turns++)
								player[turns % 2].move(board);
						end();
						averageOfLines();
						board = new FourthDimension();
					}
				averageScore /= 10000;
				System.out.println("The average winning score is: " + averageScore);
				System.out.println("The lowest winning score is: " + lowestScore);
			}
		
		private static void startUp()
			{
				player[0] = new easyComputer();
				player[1] = new easyComputer("X");
			}
		
		private static void end()
			{
				if(player[0].getScore() > player[1].getScore())
					System.out.println("Player 1 wins! " + player[0].getScore() + " : " + player[1].getScore());
				else if(player[0].getScore() < player[1].getScore())
					System.out.println("Player 2 wins! " + player[0].getScore() + " : " + player[1].getScore());
				else
					System.out.println("It's a tie!");
			}
		
		private static void averageOfLines()
			{
				int score;
				if(player[0].getScore() > player[1].getScore())
					score = player[0].getScore();
				else
					score = player[1].getScore();
				averageScore += score;
				if(lowestScore > score)
					lowestScore = score;
			}

	}
