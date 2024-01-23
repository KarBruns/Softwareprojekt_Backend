package de.termin.awk.usecase;

import java.util.Collection;
import java.util.List;

import de.termin.awk.entity.FotoTO;
import de.termin.awk.entity.TerminTO;

public interface IFotosInTerminManagen {

    public boolean addFoto(long fotoId, long terminId);
    public  boolean removeFoto(long fotoId, long terminId);
    public List<String> getAllFotosOfTermin(long terminId);
    public Collection<TerminTO> getTerminOfFoto(long fotoId);
}
