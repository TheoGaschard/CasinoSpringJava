package com.casino.casino.model;

import java.util.Random;

public class Bille {
	
	public Bille() {
		
	}

	public int Tirage() {
		
		int Res = 0;
		
		Random Ran = new Random();
		
		Res = Ran.nextInt(37);
		
		return Res;
	}
	
}
