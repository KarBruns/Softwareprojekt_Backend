package de.user.awk.facade;


import de.user.awk.entity.User;
import jakarta.ejb.Local;

@Local
public interface IUserFacade {
	public User findUserByName(String username);
}