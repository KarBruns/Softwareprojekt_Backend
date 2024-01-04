package de.termin.awk.usecase.impl;

import java.util.ArrayList;
import java.util.Collection;

import de.termin.awk.dao.TechnikerDAO;
import de.termin.awk.entity.TechnikerTO;
import de.termin.awk.entity.impl.Techniker;
import de.termin.awk.usecase.ITechnikerManagen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class TechnikerManagen implements ITechnikerManagen {
	
	@Inject
	TechnikerDAO technikerDAO;

	@Override
	public Collection<TechnikerTO> getAllTechniker() {
        Collection<Techniker> techniker = technikerDAO.findAll();
        Collection<TechnikerTO> returnTechniker = new ArrayList<>();
        for (Techniker t : techniker) {
            returnTechniker.add(t.toTechnikerTO());
        }
        return returnTechniker;
	}

	@Override
	public TechnikerTO findTechniker(long id) {
		return technikerDAO.find(id).toTechnikerTO();
	}

}
