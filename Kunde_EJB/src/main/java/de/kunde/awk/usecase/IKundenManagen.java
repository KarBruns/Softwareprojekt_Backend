package de.kunde.awk.usecase;

import de.kunde.awk.entity.KundeTO;

import java.util.Collection;

public interface IKundenManagen {

    public boolean deleteKunde(long id);
    public boolean createKunde(KundeTO kTO);
    public Collection<KundeTO> getAllKunden();
    public boolean updateKunde(KundeTO kTO);
    public KundeTO findKunde(long id);
}
