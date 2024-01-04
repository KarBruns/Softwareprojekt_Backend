package de.termin.awk.usecase.impl;

import de.kunde.awk.dao.KundeDAO;
import de.kunde.awk.entity.KundeTO;
import de.termin.awk.dao.TechnikerDAO;
import de.termin.awk.dao.TerminDAO;
import de.termin.awk.entity.TerminTO;
import de.termin.awk.entity.impl.Techniker;
import de.termin.awk.entity.impl.Termin;
import de.termin.awk.usecase.ITermineManagen;

import com.sun.xml.xsom.impl.Ref;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

@Stateless
public class TermineManagen implements ITermineManagen {

    @Inject
    TerminDAO terminDAO;
    
    @Inject
    TechnikerDAO technikerDAO;
    
    @Inject
    KundeDAO kundeDAO;
    
    

    @Override
    public boolean deleteTermin(long id) {
        return terminDAO.delete(id);
    }

    @Override
    public boolean createTermin(TerminTO tTO) {

    	Collection<Techniker> techniker = technikerDAO.findAll();
    	
    	KundeTO kTO = null;
    	kTO = kundeDAO.find(tTO.getKundenId()).toKundeTO();
    	 	
    	Termin t = new Termin();
    	
    	if (kTO != null) {
        	for (Techniker tech : techniker) {
        		if (tTO.getTechnikerId() == tech.getTechnikerId()) {
        			t = tTO.toTermin();
        			return terminDAO.save(t);
        		}
        	}
    	}    	
        
        return false;
    }

    @Override
    public Collection<TerminTO> getAllTermine() {
        Collection<Termin> termine = terminDAO.findAll();
        Collection<TerminTO> returnTermine = new ArrayList<>();
        for (Termin t : termine) {
            returnTermine.add(t.toTerminTO());
        }
        return returnTermine;
    }

    @Override
    public boolean updateTermin(TerminTO tTO) {
    	Termin t = terminDAO.find(tTO.getTerminId());
    	t.setNotizen(tTO.getNotizen());
        return terminDAO.update(t);
    }

    @Override
    public TerminTO findTermin(long id) {
        return terminDAO.find(id).toTerminTO();
    }
}
