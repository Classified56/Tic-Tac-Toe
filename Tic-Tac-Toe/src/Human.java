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
				System.out.print("Which plane do you want it in? ");
				int dep = userInput.nextInt() - 1;
				System.out.print("Which row do you want it in? ");
				int row = userInput.nextInt() - 1;
				System.out.print("Which column do you want it in? ");
				int col = userInput.nextInt() - 1;
				b.setSpot(marker, row, col, dep);
				score += b.check(row, col, dep);
				System.out.println("Your score is now: " + score);
			}

		@Override
		public String toString()
			{
				return "Human: Marker = " + marker;
			}
		
		
	}
