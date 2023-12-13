package awk.usecase.impl;

import awk.entity.FotoTO;
import awk.usecase.IFotosManagen;
import jakarta.ejb.Stateless;

import java.util.Collection;

@Stateless
public class FotosManagen implements IFotosManagen {
    @Override
    public boolean deleteFoto(long id) {
        return false;
    }

    @Override
    public boolean createFoto(FotoTO tTO) {
        return false;
    }

    @Override
    public Collection<FotoTO> getAllFotos() {
        return null;
    }

    @Override
    public FotoTO findFoto(long id) {
        return null;
    }
}
