
public abstract class Player
	{
		protected int score;
		protected String marker;
		protected abstract void move(FourthDimension B);
		protected abstract int[] moveTest(FourthDimension board);
		public int getScore()
			{
				return score;
			}
	}
