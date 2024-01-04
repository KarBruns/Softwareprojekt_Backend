package de.termin.awk.usecase.impl;

import de.termin.awk.dao.FotoDAO;
import de.termin.awk.dao.TerminDAO;
import de.termin.awk.entity.FotoTO;
import de.termin.awk.entity.TerminTO;
import de.termin.awk.entity.impl.Termin;
import de.termin.awk.usecase.IFotosInTerminManagen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.Collection;
import java.util.List;

@Stateless
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
