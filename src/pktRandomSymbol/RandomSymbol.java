package pktRandomSymbol;	
import java.util.ArrayList;
import java.util.Random;


public class RandomSymbol {

		    
		     ArrayList <Character> symbols = new ArrayList <>();
		     
		    // tum sembolleri ekler
		  public RandomSymbol()
		    {

		        for (int i = 33; i <= 126; i++) {
		            symbols.add((char) i);
		        }

		    }
		    // rastgele birini getirir ve o sembolu diziden cikarir (ayni sembol gelmemesi icin)
		  public char getRandomSymbol()
		    {
		        Random rand = new Random();
		        int randomIndex = rand.nextInt(symbols.size());
		        char backup = symbols.get(randomIndex);
		        symbols.remove(randomIndex);
		        return backup;
		    }

		}



