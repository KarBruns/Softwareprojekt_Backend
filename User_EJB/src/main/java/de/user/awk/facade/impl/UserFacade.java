package de.user.awk.facade.impl;

import de.user.awk.dao.UserDAO;
import de.user.awk.entity.User;
import de.user.awk.facade.IUserFacade;
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