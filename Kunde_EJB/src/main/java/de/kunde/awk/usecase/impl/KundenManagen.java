package de.kunde.awk.usecase.impl;

import de.kunde.awk.dao.KundeDAO;
import de.kunde.awk.entity.KundeTO;
import de.kunde.awk.entity.impl.Kunde;
import de.kunde.awk.usecase.IKundenManagen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.Collection;

@Stateless
public class KundenManagen implements IKundenManagen {

    @Inject
    KundeDAO kundeDAO;

    @Override
    public boolean deleteKunde(long id) {
        return kundeDAO.delete(id);
    }

    @Override
    public boolean createKunde(KundeTO kTO) {
        Kunde k = new Kunde();
        k = kTO.toKunde();
        return kundeDAO.save(k);
    }

    @Override
    public Collection<KundeTO> getAllKunden() {
        Collection<Kunde> kunden = kundeDAO.findAll();
        Collection<KundeTO> returnKunden = new ArrayList<>();
        for (Kunde k : kunden) {
            returnKunden.add(k.toKundeTO());
        }
        return returnKunden;
    }

    @Override
    public boolean updateKunde(KundeTO kTO) {
        Kunde k = kundeDAO.find(kTO.getKundenId());
        k.setKundenId(kTO.getKundenId());
        k.setName(kTO.getName());
        k.setVorname(kTO.getVorname());
        k.setStrasse(kTO.getStrasse());
        k.setHausNr(kTO.getHausNr());
        k.setPlz(kTO.getPlz());
        k.setOrt(kTO.getOrt());
        k.setGebDatum(kTO.getGebDatum());
        k.seteMail(kTO.geteMail());
        k.setTelNr(kTO.getTelNr());

        return kundeDAO.update(k);
    }

    @Override
    public KundeTO findKunde(long id) {
        return kundeDAO.find(id).toKundeTO();
    }
}
