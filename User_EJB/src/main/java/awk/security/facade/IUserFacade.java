package awk.security.facade;


import awk.security.entity.User;
import jakarta.ejb.Local;

@Local
public interface IUserFacade {
	public User findUserByName(String username);
}