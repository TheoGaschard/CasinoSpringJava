package com.casino.thecasino.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service

public class UserServiceIm implements UserService {
	@Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
}

	@Override
	public void addUser(String pseudo, String password, float solde) {
		// TODO Auto-generated method stub
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("INSERT INTO user (pseudo,password,solde)VALUES(?,?,?)",pseudo,password,solde);
		
	}
	
}
