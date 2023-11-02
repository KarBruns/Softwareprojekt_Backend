package awk.usecase;

import awk.entity.TerminTO;

import java.util.Collection;

public interface ITermineManagen {

    public boolean deleteTermin(long id);
    public boolean createTermin(TerminTO tTO);
    public Collection<TerminTO> getAllTermine();
    public boolean updateTermin(TerminTO tTO);
    public TerminTO findTermin(long id);
}
