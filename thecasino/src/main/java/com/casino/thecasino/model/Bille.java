package com.casino.thecasino.model;

import java.util.Random;

public class Bille {

	public int Tirage() {
		
		int Res = 0;
		
		Random Ran = new Random();
		
		Res = Ran.nextInt(37);
		
		return Res;
	}
	
}
