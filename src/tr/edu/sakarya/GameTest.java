package tr.edu.sakarya;

import tr.edu.sakarya.campus.Colony;

import java.util.List;

public class GameTest {
	public static void main(String[] args) {
		List<Colony> colonies = RandomColonyFactory.generate(6);
		Game game = new Game(colonies);
		while (game.collide()>1) {}
	}
}
