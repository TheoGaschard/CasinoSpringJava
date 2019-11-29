package com.casino.thecasino.form;

public class UserForm {
    private Integer id;
    private String pseudo;
    private String password;
    private String confirmPassword;
    private Float solde;
    private String encrytedPassword;
    
    public UserForm() {
    	
    };
    
    public UserForm(Integer id, String pseudo, String password, float solde,String encrytedPassword) {
    	this.setId(id);
        this.setPseudo(pseudo);
        this.setPassword(password);
        this.setConfirmPassword(confirmPassword);
        this.setSolde(solde);
        this.setEncrytedPassword(encrytedPassword);
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
	public Float getSolde() {
		return solde;
	}
	public void setSolde(Float solde) {
		this.solde = solde;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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