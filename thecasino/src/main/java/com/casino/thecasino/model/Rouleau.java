package com.casino.thecasino.model;

import java.util.Random;

public class Rouleau {
	
	private String Res;
	private int Nombre;
	
	public String Tirage() {
		this.Res = "I";
		
		Random Ran = new Random();
		
		this.Nombre = Ran.nextInt(100);
		
		if(this.Nombre < 50){
			
			this.Res = "C";
			
		}else if(this.Nombre < 80){
			
			this.Res = "CSS";
			
		}else if(this.Nombre < 90){
			
			this.Res = "Js";
			
		}else if(this.Nombre < 95){
			
			this.Res = "Pyt";
			
		}else if(this.Nombre < 99){
			
			this.Res = "PHP";
			
		}else{
			
			this.Res = "Java";
			
		}
		
		
		return this.Res;
	}

}
