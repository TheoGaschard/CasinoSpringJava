package com.casino.thecasino.model;
 
public class User {
    private Integer id;
    private String pseudo;
    private String password;
    private Float solde;
    private String encrytedPassword;
    
    public User() {
 
    }
 
    public User(Integer id,String pseudo, String password, float solde, String encrytedPassword) {
    	this.setId(id);
        this.setPseudo(pseudo);
        this.setPassword(password);
        this.setSolde(solde);
        this.setEncrytedPassword(encrytedPassword);
    }



	public Float getSolde() {
		return solde;
	}

	public void setSolde(Float solde) {
		this.solde = solde;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEncrytedPassword() {
		return encrytedPassword;
	}

	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}



 
}