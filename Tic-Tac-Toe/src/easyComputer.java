
public class easyComputer extends Player
	{

		public easyComputer()
			{
				marker = "O";
				score = 0;
			}
		
		public easyComputer(String s)
			{
				marker = s;
				score = 0;
			}
		
		public void move(FourthDimension b)
			{
				int spots[] = new int[4];
				while(true)
					{
						for(int i = 0; i < 4; i++)
							spots[i] = (int)(Math.random() * 3);
						if(b.getBoard(spots[0]).getNumber(spots[1], spots[2], spots[3]) == 7)
							{
								b.getBoard(spots[0]).setSpot(marker, spots[1], spots[2], spots[3]);
								break;
							}
					}
				score += checkMove(b, spots[0], spots[1], spots[2], spots[3]);
			}
		
		public int[] moveTest(FourthDimension f)
			{
				int spots[] = new int[4];
				while(true)
					{
						for(int i = 0; i < 4; i++)
							spots[i] = (int)(Math.random() * 3);
						if(f.getBoard(spots[0]).getNumber(spots[1], spots[2], spots[3]) == 7)
							{
								f.getBoard(spots[0]).setSpot(marker, spots[1], spots[2], spots[3]);
								break;
							}
					}
				int num = 0;
				num += checkMove(f, spots[0], spots[1], spots[2], spots[3]);
				score += num;
				int win[] = {3, 3, 3};
				if(num > 0)
					{
						for(int i = 0; i < 3; i++)
							win[i] = spots[i + 1];
						return win;
					}
				else
					return win;
			}
		
		public int checkMove(FourthDimension f, int a, int b, int c, int d)
			{
				int sum = 0;
				sum += f.getBoard(a).check(b, c, d);
				sum += f.check(b, c, d);
				return sum;
			}
		
		@Override
		public String toString()
			{
				return "Computer: Marker = " + marker;
			}

	}
