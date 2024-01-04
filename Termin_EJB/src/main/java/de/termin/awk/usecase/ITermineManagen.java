package de.termin.awk.usecase;

import java.util.Collection;

import de.termin.awk.entity.TerminTO;

public interface ITermineManagen {

    public boolean deleteTermin(long id);
    public boolean createTermin(TerminTO tTO);
    public Collection<TerminTO> getAllTermine();
    public boolean updateTermin(TerminTO tTO);
    public TerminTO findTermin(long id);
}
