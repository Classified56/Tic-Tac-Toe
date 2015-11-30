
public class Tester
	{
		private static FourthDimension board = new FourthDimension();
		private static easyComputer player[] = new easyComputer[2];
		private static int averageScore;
		private static int lowestScore = 20;
		private static int winSpots[][][] = new int[3][3][3];
		private static int lose = 0;
		public static void main(String[] args)
			{
				for(int i = 0; i < 100000; i++)
					{
						startUp();
						for(int turns = 0; turns < 81; turns++)
							{
								int nums[] = player[turns % 2].moveTest(board);
								if(nums[0] == 3)
									lose++;
								else
									winSpots[nums[0]][nums[1]][nums[2]]++;
							}
						end();
						averageOfLines();
						board = new FourthDimension();
					}
				endGame();
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
		
		private static void endGame()
			{
				averageScore /= 100000;
				System.out.println("The average winning score is: " + averageScore);
				System.out.println("The lowest winning score is: " + lowestScore);
				String printed = "\n";
				for(int i = 0; i < 3; i++)
					{
						for(int j = 0; j < 3; j++)
							{
								for(int k = 0; k < 3; k++)
									{
										double x = (winSpots[i][k][j] / 1000000.0);
										if(k < 2)
											printed += x + " | ";
										else
											printed += x + "   ";
									}
							}	
						if(i < 2)
							printed += "\n";
					}
				System.out.println(printed + "\n");
				lose /= 100000; 
				System.out.println("The number of losing moves is: " + lose);
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
