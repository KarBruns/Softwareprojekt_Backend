package de.termin.awk.entity;

import java.io.Serializable;

import de.termin.awk.entity.impl.Techniker;
import de.termin.awk.entity.impl.Termin;

public class TerminTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long terminId;
    private long technikerId;
    private long kundenId;
    private String datum;
    private String adresse;
    private String notizen;

    public TerminTO() {
    }

    public TerminTO(long terminId, long techniker, long kundenId, String datum, String adresse, String notizen) {
        this.terminId = terminId;
        this.technikerId = techniker;
        this.kundenId = kundenId;
        this.datum = datum;
        this.adresse = adresse;
        this.notizen = notizen;
    }

    public Termin toTermin() {
        return new Termin(
                this.getTerminId(),
                this.getTechnikerId(),
                this.getKundenId(),
                this.getDatum(),
                this.getAdresse(),
                this.getNotizen()
        );
    }

    public long getTerminId() {
        return terminId;
    }

    public void setTerminId(long terminId) {
        this.terminId = terminId;
    }

    public long getTechnikerId() {
        return technikerId;
    }

    public void setTechnikerId(long techniker) {
        this.technikerId = techniker;
    }

    public long getKundenId() {
        return kundenId;
    }

    public void setKundenId(long kundenId) {
        this.kundenId = kundenId;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNotizen() {
        return notizen;
    }

    public void setNotizen(String notizen) {
        this.notizen = notizen;
    }
}
