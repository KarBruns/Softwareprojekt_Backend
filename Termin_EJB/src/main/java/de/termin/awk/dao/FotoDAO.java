package de.termin.awk.dao;

import de.termin.awk.entity.impl.Foto;
import jakarta.ejb.Stateless;

@Stateless
public class FotoDAO extends GenericDAO<Foto>{

	public FotoDAO() {
		super(Foto.class);
	}
	
	public boolean delete(long id) {
		Foto f = super.find(id);
		return super.delete(f.getFotoId(), Foto.class);
	}
	
}