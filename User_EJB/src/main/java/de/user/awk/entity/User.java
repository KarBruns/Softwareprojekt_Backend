package de.user.awk.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Softwareprojekt_User")
@NamedQuery(name="User.findUserByName", 
	query="select u from User u where u.username = :username")
public class User implements Serializable {

	private static final long serialVersionUID = -3990669569183763170L;

	public static final String FIND_BY_NAME = "User.findUserByName";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(unique = true)
	private String username;
	private String password;
	
	@ElementCollection
	@CollectionTable(name="Softwareprojekt_User_Roles", 
		joinColumns=@JoinColumn(name="username", referencedColumnName="username"))
	List<String> rolename;
	
	public User() {}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}
	
	@Override
	public int hashCode() {
		return (int) getId();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User){
			User user = (User) obj;
			return user.username.equals(getUsername());
		}
		
		return false;
	}

	public List<String> getRoles() {
		return this.rolename;
	}
	
	public String toString() {
		String str = String.valueOf(this.id)+" "+this.username+" Roles[";
		for (String aStr : this.rolename) str = str + aStr+ " ";
		str = str + "]";
		return str;
				
	}
}
