package de.termin.awk.usecase.impl;

import de.termin.awk.dao.FotoDAO;
import de.termin.awk.entity.FotoTO;
import de.termin.awk.entity.impl.Foto;
import de.termin.awk.usecase.IFotosManagen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.Collection;

@Stateless
public class FotosManagen implements IFotosManagen {
	
	@Inject
	FotoDAO fotoDAO;
	
	
	
    @Override
    public boolean deleteFoto(long id) {
        return false;
    }

    @Override
    public long createFoto(FotoTO fTO) {
        Foto f = new Foto();
        f = fTO.toFoto();
        if (fotoDAO.save(f)) {
        	return f.getFotoId();
        } else {
        	return 0;
        }
        
    }

    @Override
    public Collection<FotoTO> getAllFotos() {
        return null;
    }

    @Override
    public FotoTO findFoto(long id) {
        return null;
    }
}
