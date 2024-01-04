package de.termin.awk.usecase.impl;

import de.kunde.awk.dao.KundeDAO;
import de.kunde.awk.entity.KundeTO;
import de.kunde.awk.usecase.IKundenManagen;
import de.termin.awk.dao.TerminDAO;
import de.termin.awk.entity.TerminTO;
import de.termin.awk.entity.impl.Termin;
import de.termin.awk.usecase.IKundenInTerminManagen;
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
