
public class Computer extends Player
	{

		public Computer()
			{
				marker = "O";
				score = 0;
			}
		
		public void move(Board b)
			{
				
			}

		@Override
		public String toString()
			{
				return "Computer: Marker = " + marker;
			}
	}
