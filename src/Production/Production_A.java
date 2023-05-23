package Production;

import java.util.Random;
public class Production_A extends Production{

		@Override
		public int Produce() {
			Random rand = new Random();
			
			
			return   1+rand.nextInt(10);
		}

	

}
