package awk.security.facade.impl;


import de.kursverwaltung.security.dao.UserDAO;
import de.kursverwaltung.security.entity.User;
import de.kursverwaltung.security.facade.IUserFacade;
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