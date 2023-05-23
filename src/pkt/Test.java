package pkt;

import java.util.ArrayList;
import pktRandomSymbol.RandomSymbol;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<Colony> colonies = new ArrayList<Colony>();
		
		RandomSymbol randomCharacter =new RandomSymbol();
		
		colonies.add(new Colony(12, randomCharacter.getRandomSymbol()));
		colonies.add(new Colony(8, randomCharacter.getRandomSymbol()));	
		colonies.add(new Colony(162, randomCharacter.getRandomSymbol()));
		colonies.add(new Colony(35, randomCharacter.getRandomSymbol()));
		colonies.add(new Colony(7, randomCharacter.getRandomSymbol()));
		colonies.add(new Colony(95, randomCharacter.getRandomSymbol()));
	
		Game game = new Game(colonies);
		
		
		do
		{
			
			game.collide();
			game.endTurnOperations();
			game.printColonies();
			
			
			
		}while(game.aliveColonyCount >1);
			
		
	}

}
