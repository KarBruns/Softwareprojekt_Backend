package awk.entity;

import awk.entity.impl.Techniker;
import awk.entity.impl.Termin;

import java.io.Serializable;

public class TerminTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long terminId;
    private TechnikerTO techniker;
    private long kundenId;
    private String datum;
    private String adresse;
    private String notizen;

    public TerminTO() {
    }

    public TerminTO(long terminId, TechnikerTO techniker, long kundenId, String datum, String adresse, String notizen) {
        this.terminId = terminId;
        this.techniker = techniker;
        this.kundenId = kundenId;
        this.datum = datum;
        this.adresse = adresse;
        this.notizen = notizen;
    }

    public Termin toTermin() {
        return new Termin(
                this.getTerminId(),
                this.getTechniker().toTechniker(),
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

    public TechnikerTO getTechniker() {
        return techniker;
    }

    public void setTechniker(TechnikerTO techniker) {
        this.techniker = techniker;
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
