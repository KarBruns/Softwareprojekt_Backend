package awk.dao;

import awk.entity.impl.Termin;
import jakarta.ejb.Stateless;

@Stateless
public class TechnikerDAO extends GenericDAO<Termin>{

	public TechnikerDAO() {
		super(Termin.class);
	}
	
	public boolean delete(long id) {
		Termin t = super.find(id);
		return super.delete(t.getTerminId(), Termin.class);
	}
	
}
