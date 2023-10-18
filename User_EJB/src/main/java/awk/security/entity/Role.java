package awk.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "HA2_Bruns_Roles")
public class Role implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String rolename;
	
	public Role() {}
	
	

}
