package awk.dao;

import awk.entity.impl.Kunde;
import jakarta.ejb.Stateless;

@Stateless
public class KundeDAO extends GenericDAO<Kunde>{

	public KundeDAO() {
		super(Kunde.class);
	}
	
	public boolean delete(long id) {
		Kunde k = super.find(id);
		return super.delete(k.getKundenId(), Kunde.class);
	}
	
}
