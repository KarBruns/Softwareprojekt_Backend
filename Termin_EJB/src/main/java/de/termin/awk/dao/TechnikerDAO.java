package de.termin.awk.dao;

import de.termin.awk.entity.impl.Techniker;
import jakarta.ejb.Stateless;

@Stateless
public class TechnikerDAO extends GenericDAO<Techniker>{

	public TechnikerDAO() {
		super(Techniker.class);
	}
	
	public boolean delete(long id) {
		Techniker t = super.find(id);
		return super.delete(t.getTechnikerId(), Techniker.class);
	}
	
}
