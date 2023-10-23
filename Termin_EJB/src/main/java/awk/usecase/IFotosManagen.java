package awk.usecase;

import awk.entity.FotoTO;

import java.util.Collection;

public interface IFotosManagen {
    public boolean deleteFoto(long id);
    public boolean createFoto(FotoTO tTO);
    public Collection<FotoTO> getAllFotos();
    public FotoTO findFoto(long id);
}
