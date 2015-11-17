
public class Board
	{
		private String board[][][] = new String[3][3][3];
		private int numBoard[][][] = new int [3][3][3];
		public Board()
			{
				for(int i = 0; i < 3; i++)
					{
						for(int j = 0; j < 3; j++)
							{
								for(int k = 0; k < 3; k++)
									{
										board[i][j][k] = " ";
										numBoard[i][j][k] = 0;
									}
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
				if(s.equals("X"))
					numBoard[a][b][c] = 1;
				else if(s.equals("O"))
					numBoard[a][b][c] = 2;
			}
		
		public int checkLinear(int row, int col, int dep, int dir)
			{
				int sum = 0;
				for(int i = 0; i < 3; i++)
					{
						switch(dir)
						{
							case 0:
								sum += numBoard[row][i][dep];
								break;
							case 1:
								sum += numBoard[i][col][dep];
								break;
							case 2:
								sum += numBoard[row][col][i];
								break;
						}
					}
				if(sum == 3 || sum == 6)
					return 1;
				else
					return 0;
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
