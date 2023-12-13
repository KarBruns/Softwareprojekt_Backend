package awk.security.facade.impl;

import awk.security.dao.UserDAO;
import awk.security.entity.User;
import awk.security.facade.IUserFacade;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class UserFacade implements IUserFacade {

	@Inject
	private UserDAO userDAO;
	
	public User findUserByName(String name) {
		return userDAO.findUserByName(name);
	}
}