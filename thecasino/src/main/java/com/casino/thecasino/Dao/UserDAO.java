package com.casino.thecasino.Dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.casino.thecasino.form.UserForm;
import com.casino.thecasino.model.User;
@Component
@Repository
public class UserDAO {
 
	
    // Config in WebSecurityConfig
    @Autowired
    private PasswordEncoder passwordEncoder;
 
    private  final static Map<Integer, User> USERS_MAP = new HashMap<>();
 
    static {
        initDATA();
    }
 
    private static void initDATA() {
        String encrytedPassword = "";
 
        User akane = new User(1 ,"akane", "akane", 100000, encrytedPassword);
 
 
        USERS_MAP.put(akane.getId(), akane);
    }
 
    public Integer getMaxUserId() {
        int max = 0;
        for (Integer id : USERS_MAP.keySet()) {
            if (id > max) {
                max = id;
            }
        }
        return max;
    }
 
    //
 
    public User findUserByUserPseudo(String userPseudo) {
        Collection<User> Users = USERS_MAP.values();
        for (User u : Users) {
            if (u.getPseudo().equals(userPseudo)) {
                return u;
            }
        }
        return null;
    }
 

 
    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
 
        list.addAll(USERS_MAP.values());
        return list;
    }
 
    // Création utilisateur avec une somme de départ définit
    
    public User createUser(UserForm form) {
        Integer userId = this.getMaxUserId() + 1;
        String encrytedPassword = this.passwordEncoder.encode(form.getPassword());
 
        User user = new User(userId, form.getPseudo(), //
                form.getPassword(),1000, //
                encrytedPassword);
 
        USERS_MAP.put(userId, user);
        return user;
    }
 
}