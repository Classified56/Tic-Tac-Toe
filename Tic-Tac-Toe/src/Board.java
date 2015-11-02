
public class Board
	{
		private char board[][] = new char [3][3];
		public Board()
			{
				for(int i = 0; i < 3; i++)
					{
						for(int j = 0; j < 3; j++)
							board[i][j] = 'a';
					}
			}
		public char getSpot(int a, int b)
			{
				return board[a][b];
			}
		public void setSpot(char c, int a, int b)
			{
				board[a][b] = c;
			}
		
		@Override
		public String toString()
			{
				String board;
				
				return board;
			}
	}
