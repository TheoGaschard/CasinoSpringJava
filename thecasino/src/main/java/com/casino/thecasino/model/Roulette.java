package com.casino.thecasino.model;

public class Roulette {
	
	private int Choix;
	private String Message = "";
	private int Res;
	private float Pari;
	
	

	public void setPari(float pari) {
		this.Pari = pari;
	}
	
	public void setChoix(int Choix) {
		
		this.Choix = Choix;
		
	}
	
	public void Jouer() {
		
		int Res;
		int Multi;
		float Solde = newUser.getSolde();
		
		if (this.Pari > Solde) {
			this.Message = "Pas assez de fonds";
			return;
		}
		
		int MapA[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,34,35,36};
		int MapB[][] = {{2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36},{1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35},{1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,35,36},{2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33}};
		
		Bille B1 = new Bille();
		Res = B1.Tirage();
		
		boolean Win = false;
		
		if (this.Choix > 36) {
			
			Multi = 2;
			int Choix = this.Choix - 36;
			
			int MapWin[] = MapB[Choix];
			
			
			for(int i = 0; i < MapWin.length; i++)
			{
				if (MapWin[i] == Res) {
					Win = true;
				}
			}
			
		}else {
			
			Multi = 36;
			int Goal = MapA[Choix];
			
			if(Res == Goal) {
				Win = true;
			}
			
		}
		
		if (Win == true) {
			
			this.Message = " Vous avez gagné ! " ;
			
			float Gain = this.Pari * Multi;
			
			newUser.setSolde(Solde + Gain);
			// SQL.Update();
			
		}else {
			
			this.Message = " Vous avez perdu ! " ;
			
			newUser.setSolde(Solde - this.Pari);
			// SQL.Update();
			
		}
		
		
		
	
	
	}	
	
}
