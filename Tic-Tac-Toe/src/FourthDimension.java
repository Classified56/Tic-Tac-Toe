
public class FourthDimension
	{
		Board board[] = new Board[3];
		public FourthDimension()
			{
				for(int i = 0; i < 3; i++)
					{
						board[i] = new Board();
					}
			}
		
		public int check(int a, int b, int c)
			{
				int sum = 0;
				for(int i = 0; i < 3; i++)
					sum += board[i].getNumber(a, b, c);
				if(sum == 3 || sum == 6)
					return 1;
				else
					return 0;
			}
		
		public Board getBoard(int x)
			{
				return board[x];
			}

		@Override
		public String toString()
			{
				System.out.println(board[0]);
				System.out.println(board[1]);
				System.out.println(board[2]);
				return "";
			}
		
		

	}
