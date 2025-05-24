package uo294255.cpm.modulo.game;

import java.util.Random;

public class Dado {
	
	public static int lanzar()
	{ 
		Random random = new Random();
		return random.nextInt(2) + 1;
	}
}
