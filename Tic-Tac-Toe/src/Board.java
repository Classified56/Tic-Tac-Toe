
public class Board
	{
		private String board[][][] = new String[3][3][3];
		public Board()
			{
				for(int i = 0; i < 3; i++)
					{
						for(int j = 0; j < 3; j++)
							{
								for(int k = 0; k < 3; k++)
									board[i][j][k] = " ";
							}
					}
			}
		public String getSpot(int a, int b, int c)
			{
				return board[a][b][c];
			}
		public void setSpot(String s, int a, int b, int c)
			{
				board[a][b][c] = s;
			}
		
		@Override
		public String toString()
			{
				String printed = "    1     \t    2               3\n";
				for(int row = 0; row < 3; row++)
					{
						for(int plane = 0; plane < 3; plane++)
							{
								for(int col = 0; col < 3; col++)
									{
										if(col < 2)
											printed += board[row][col][plane] + " | ";
										else
											printed += board[row][col][plane] + " \t";
									}
							}
						if(row < 2)
							printed += "\n---------\t---------\t---------\n";
					}
				return printed;
			}
	}
