package de.user.awk.dao;

import jakarta.ejb.Stateless;

import java.util.HashMap;
import java.util.Map;

import de.user.awk.entity.User;

@Stateless
public class UserDAO extends GenericDAO<User> {

    public UserDAO() {
    	super(User.class);
    }

    public User findUserByName(String username) {
    	Map<String, Object> parameters = new HashMap<String, Object>();
    	System.out.println("Username: "+username);
    	parameters.put("username", username);

    	return super.findOneResult(User.FIND_BY_NAME, parameters);
    }
}