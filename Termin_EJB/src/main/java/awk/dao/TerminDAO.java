package awk.dao;

import awk.entity.impl.Termin;
import jakarta.ejb.Stateless;

@Stateless
public class TerminDAO extends GenericDAO<Termin>{

	public TerminDAO() {
		super(Termin.class);
	}
	
	public boolean delete(long id) {
		Termin t = super.find(id);
		return super.delete(t.getTerminId(), Termin.class);
	}
	
}
