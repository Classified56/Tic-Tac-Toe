import java.util.Scanner;

public class Human extends Player
	{
		private Scanner userInput = new Scanner(System.in);
		public Human(String s)
			{
				marker = s;
				score = 0;
			}
		
		public void move(Board b)
			{
				int dep, col, row;
				while(true)
					{
						System.out.print("Which plane do you want it in? ");
						dep = userInput.nextInt() - 1;
						System.out.print("Which row do you want it in? ");
						row = userInput.nextInt() - 1;
						System.out.print("Which column do you want it in? ");
						col = userInput.nextInt() - 1;
						if((dep <= 2 && dep >= 0) && (row <= 2 && row >= 0) && (col <= 2 && col >= 0))
							{
								if(b.getNumber(row, col, dep) == 7)
									break;
							}
						else
							System.out.println("Make a valid move.");
					}
				b.setSpot(marker, row, col, dep);
				score += b.check(row, col, dep);
				System.out.println("Your score is now: " + score);
			}

		@Override
		public String toString()
			{
				return "Human: Marker = " + marker + ". Score is " + score;
			}
		
		
	}
