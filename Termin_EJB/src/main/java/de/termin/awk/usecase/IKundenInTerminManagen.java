package de.termin.awk.usecase;

import java.util.Collection;
import java.util.List;

import de.termin.awk.entity.TerminTO;

public interface IKundenInTerminManagen {

    public boolean addKunde(long kundenId, long terminId);
    public boolean removeKunde(long kundenId, long terminId);
    public Long getKundeOfTermin(long terminId);
    public Collection<TerminTO> getTermineOfKunde(long kundenId);
}
