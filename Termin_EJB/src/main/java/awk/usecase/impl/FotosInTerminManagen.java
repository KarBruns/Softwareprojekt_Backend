package awk.usecase.impl;

import awk.dao.FotoDAO;
import awk.dao.TerminDAO;
import awk.entity.FotoTO;
import awk.entity.TerminTO;
import awk.entity.impl.Termin;
import awk.usecase.IFotosInTerminManagen;
import jakarta.inject.Inject;

import java.util.Collection;
import java.util.List;

public class FotosInTerminManagen implements IFotosInTerminManagen {

    @Inject
    FotoDAO fotoDAO;

    @Inject
    TerminDAO terminDAO;

    @Override
    public boolean addFoto(long fotoId, long terminId) {
        Termin t = terminDAO.find(terminId);
        Collection<Long> fotosInTermin = t.getFotos();

        if (fotosInTermin.contains(fotoId)) {
            return false;
        } else {
            t.addFoto(fotoId);
            terminDAO.update(t);
            return true;
        }
    }

    @Override
    public boolean removeFoto(long fotoId, long terminId) {
        Termin t = terminDAO.find(terminId);
        Collection<Long> fotosInTermin = t.getFotos();

        if (!(fotosInTermin.contains(fotoId))) {
            return false;
        } else {
            t.removeFoto(fotoId);
            terminDAO.update(t);
            return true;
        }
    }

    @Override
    public List<Long> getAllFotosOfTermin(long terminId) {
        Termin t = terminDAO.find(terminId);
        return t.getFotos();
    }

    @Override
    public Collection<TerminTO> getTerminOfFoto(long fotoId) {
        return null;
    }
}
