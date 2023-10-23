package awk.usecase;

import awk.entity.FotoTO;
import awk.entity.TerminTO;

import java.util.Collection;
import java.util.List;

public interface IFotosInTerminManagen {

    public boolean addFoto(long fotoId, long terminId);
    public  boolean removeFoto(long fotoId, long terminId);
    public List<Long> getAllFotosOfTermin(long terminId);
    public Collection<TerminTO> getTerminOfFoto(long fotoId);
}
