package de.termin.awk.usecase;

import java.util.Collection;

import de.termin.awk.entity.FotoTO;

public interface IFotosManagen {
    public boolean deleteFoto(long id);
    public long createFoto(FotoTO tTO);
    public Collection<FotoTO> getAllFotos();
    public FotoTO findFoto(long id);
}
