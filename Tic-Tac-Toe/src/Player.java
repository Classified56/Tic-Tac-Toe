
public abstract class Player
	{
		protected int score;
		protected String marker;
		protected abstract void move(FourthDimension B);
		public int getScore()
			{
				return score;
			}
	}
