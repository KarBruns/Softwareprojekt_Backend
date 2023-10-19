package awk.security.facade;


import de.kursverwaltung.security.entity.User;
import jakarta.ejb.Local;

@Local
public interface IUserFacade {
	public User findUserByName(String username);
}