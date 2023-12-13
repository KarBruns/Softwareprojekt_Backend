package awk.usecase.impl;

import awk.dao.KundeDAO;
import awk.dao.TerminDAO;
import awk.entity.KundeTO;
import awk.entity.TerminTO;
import awk.entity.impl.Termin;
import awk.usecase.IKundenInTerminManagen;
import awk.usecase.IKundenManagen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Stateless
public class KundenInTerminManagen implements IKundenInTerminManagen {

    @Inject
    TerminDAO terminDAO;

    @Inject
    KundeDAO kundeDAO;

    @Override
    public boolean addKunde(long kundenId, long terminId) {
        Termin t = terminDAO.find(terminId);
        t.setKunde(kundenId);
        terminDAO.update(t);
        return true;
    }

    @Override
    public boolean removeKunde(long kundenId, long terminId) {
        Termin t = terminDAO.find(terminId);
        t.setKunde(0);
        terminDAO.update(t);
        return true;
    }

    @Override
    public Long getKundeOfTermin(long terminId) {
        Termin t = terminDAO.find(terminId);
        return t.getKundenId();
    }

    @Override
    public Collection<TerminTO> getTermineOfKunde(long kundenId) {
        KundeTO kTO = kundeDAO.find(kundenId).toKundeTO();
        Collection<Termin> allTermine = terminDAO.findAll();
        Collection<TerminTO> termineOfKunde = new ArrayList<>();

        for (Termin t : allTermine) {
            if (t.getKundenId() == kundenId) {
                termineOfKunde.add(t.toTerminTO());
            }
        }
        return termineOfKunde;
    }
}
