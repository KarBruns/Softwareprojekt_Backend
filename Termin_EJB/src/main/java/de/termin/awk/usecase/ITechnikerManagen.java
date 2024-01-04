package de.termin.awk.usecase;

import java.util.Collection;

import de.termin.awk.entity.TechnikerTO;

public interface ITechnikerManagen {
	
	public Collection<TechnikerTO> getAllTechniker();
    public TechnikerTO findTechniker(long id);

}
