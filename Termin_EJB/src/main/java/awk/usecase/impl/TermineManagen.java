package awk.usecase.impl;

import awk.dao.TerminDAO;
import awk.entity.TerminTO;
import awk.entity.impl.Termin;
import awk.usecase.ITermineManagen;
import com.sun.xml.xsom.impl.Ref;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.Collection;

@Stateless
public class TermineManagen implements ITermineManagen {

    @Inject
    TerminDAO terminDAO;

    @Override
    public boolean deleteTermin(long id) {
        return terminDAO.delete(id);
    }

    @Override
    public boolean createTermin(TerminTO tTO) {
        Termin t = new Termin();
        t = tTO.toTermin();
        return terminDAO.save(t);
    }

    @Override
    public Collection<TerminTO> getAllTermine() {
        Collection<Termin> termine = terminDAO.findAll();
        Collection<TerminTO> returnTermine = new ArrayList<>();
        for (Termin t : termine) {
            returnTermine.add(t.toTerminTO());
        }
        return returnTermine;
    }

    @Override
    public boolean updateTermin(TerminTO tTO) {
        return true;
    }

    @Override
    public TerminTO findTermin(long id) {
        return terminDAO.find(id).toTerminTO();
    }
}
