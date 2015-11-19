
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
										numBoard[i][j][k] = 7;
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
		
		public int check(int row, int col, int dep)
			{
				int score = 0;
				score += checkLinear(row, col, dep, 0);
				score += checkLinear(row, col, dep, 1);
				score += checkLinear(row, col, dep, 2);
				if(row == 0 && col == 0 && dep == 0)
					{
						score += checkDiagnol(row, col, dep, 0);
						score += checkDiagnol(row, col, dep, 2);
						score += checkDiagnol(row, col, dep, 4);
					}
				else if(row == 0 && col == 2 && dep == 0)
					{
						score += checkDiagnol(row, col, dep, 1);
						score += checkDiagnol(row, col, dep, 2);
						score += checkDiagnol(row, col, dep, 5);
					}
				else if(row == 0 && col == 0 && dep == 2)
					{
						score += checkDiagnol(row, col, dep, 0);
						score += checkDiagnol(row, col, dep, 3);
						score += checkDiagnol(row, col, dep, 5);
					}
				else if(row == 0 && col == 2 && dep == 2)
					{
						score += checkDiagnol(row, col, dep, 1);
						score += checkDiagnol(row, col, dep, 3);
						score += checkDiagnol(row, col, dep, 4);
					}
				else if(row == 0 && col == 1 && dep == 0)
					score += checkDiagnol(row, col, dep, 2);
				else if(row == 0 && col == 0 && dep == 1)
					score += checkDiagnol(row, col, dep, 0);
				else if(row == 0 && col == 1 && dep == 2)
					score += checkDiagnol(row, col, dep, 3);
				else if(row == 0 && col == 2 && dep == 1)
					score += checkDiagnol(row, col, dep, 1);
				else if((row == 1 && col == 0 && dep == 0) || (row == 1 && col == 2 && dep == 2))
					score += checkDiagnol(row, col, dep, 4);
				else if((row == 1 && col == 2 && dep == 0) || (row == 1 && col == 0 && dep == 2))
					score += checkDiagnol(row, col, dep, 3);
				else if(row == 2 && col == 0 && dep == 0)
					{
						score += checkDiagnol(row, col, dep, 1);
						score += checkDiagnol(row, col, dep, 3);
						score += checkDiagnol(row, col, dep, 4);
					}
				else if(row == 2 && col == 2 && dep == 0)
					{
						score += checkDiagnol(row, col, dep, 0);
						score += checkDiagnol(row, col, dep, 3);
						score += checkDiagnol(row, col, dep, 5);
					}
				else if(row == 2 && col == 0 && dep == 2)
					{
						score += checkDiagnol(row, col, dep, 1);
						score += checkDiagnol(row, col, dep, 2);
						score += checkDiagnol(row, col, dep, 5);
					}
				else if(row == 2 && col == 2 && dep == 2)
					{
						score += checkDiagnol(row, col, dep, 0);
						score += checkDiagnol(row, col, dep, 2);
						score += checkDiagnol(row, col, dep, 4);
					}
				if((row == 0 && col == 0 && dep == 0) || (row == 2 && col == 2 && dep == 2))
					score += checkDiagnol(0);
				else if((row == 0 && col == 2 && dep == 0) || (row == 2 && col == 0 && dep == 2))
					score += checkDiagnol(1);
				else if((row == 0 && col == 0 && dep == 2) || (row == 2 && col == 2 && dep == 0))
					score += checkDiagnol(2);
				else if((row == 0 && col == 2 && dep == 2) || (row == 2 && col == 0 && dep == 0))
					score += checkDiagnol(3);
				else if(row == 1 && col == 1 && dep == 1)
					{
						checkDiagnol(row, col, dep, 0);
						checkDiagnol(row, col, dep, 1);
						checkDiagnol(row, col, dep, 2);
						checkDiagnol(row, col, dep, 3);
						checkDiagnol(row, col, dep, 4);
						checkDiagnol(row, col, dep, 5);
						checkDiagnol(0);
						checkDiagnol(1);
						checkDiagnol(2);
						checkDiagnol(3);
					}
				return score;
			}
		
		private int checkDiagnol(int row, int col, int dep, int dir)
			{
				int sum = 0;
						switch(dir)
						{
							case 0:
								sum += loopForward(0, dep);
								break;
							case 1:
								sum += loopBackward(0, dep);
								break;
							case 2: 
								sum += loopForward(1, col);
								break;
							case 3:
								sum += loopBackward(1, col);
								break;
							case 4:
								sum += loopForward(2, row);
								break;
							case 5:
								sum += loopBackward(2, row);
								break;
						}
				if(sum == 3 || sum == 6)
					return 1;
				else
					return 0;
			}
		
		private int checkDiagnol(int dir)
			{
				int sum = 0;
				switch(dir)
				{
					case 0:
						for(int i = 0; i < 3; i++)
							sum += numBoard[i][i][i];
						break;
					case 1:
						sum += numBoard[0][2][0];
						sum += numBoard[1][1][1];
						sum += numBoard[2][0][2];
						break;
					case 2:
						sum += numBoard[0][0][2];
						sum += numBoard[1][1][1];
						sum += numBoard[2][2][0];
						break;
					case 3:
						sum += numBoard[0][2][2];
						sum += numBoard[1][1][1];
						sum += numBoard[2][0][0];
						break;
				}
				if(sum == 3 || sum == 6)
					return 1;
				else
					return 0;
			}
		
		private int loopForward(int constant, int spot)
			{
				int sum = 0;
				switch(constant)
				{
					case 0:
						for(int i = 0; i < 3; i++)
							sum += numBoard[i][i][spot];
						break;
					case 1:
						for(int i = 0; i < 3; i++)
							sum += numBoard[i][spot][i];
						break;
					case 2:
						for(int i = 0; i < 3; i++)
							sum += numBoard[spot][i][i];
						break;
				}
				return sum;
			}
		
		private int loopBackward(int constant, int spot)
			{
				int sum = 0;
				switch(constant)
				{
					case 0:
						for(int i = 2; i >= 0; i--)
							sum += numBoard[i][i][spot];
						break;
					case 1:
						for(int i = 2; i >= 0; i--)
							sum += numBoard[i][spot][i];
						break;
					case 2:
						for(int i = 2; i >= 0; i--)
							sum += numBoard[spot][i][i];
						break;
				}
				return sum;
			}
		
		private int checkLinear(int row, int col, int dep, int dir)
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
				String printed = "\n    1     \t    2               3\n";
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
				printed += "\n";
				return printed;
			}
	}
