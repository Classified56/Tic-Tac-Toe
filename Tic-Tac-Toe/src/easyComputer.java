
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
		
		public void move(FourthDimension f)
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
				score += f.getBoard(spots[0]).check(spots[1], spots[2], spots[3]);
				score += f.check(spots[1], spots[2], spots[3]);
			}
		
		@Override
		public String toString()
			{
				return "Computer: Marker = " + marker;
			}
	}
