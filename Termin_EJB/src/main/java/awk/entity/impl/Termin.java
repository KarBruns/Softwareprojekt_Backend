package awk.entity.impl;

import awk.entity.TerminTO;

public class Termin {

    private long terminId;
    private Techniker techniker;
    private KundeTO kunde;
    private String datum;
    private String adresse;
    private Foto foto;
    private String notizen;

    public Termin() {
    }

    public Termin(long terminId, Techniker techniker, KundeTO kunde, String datum, String adresse, Foto foto, String notizen) {
        this.terminId = terminId;
        this.techniker = techniker;
        this.kunde = kunde;
        this.datum = datum;
        this.adresse = adresse;
        this.foto = foto;
        this.notizen = notizen;
    }

    public TerminTO toTerminTO() {
        return new TerminTO(
                this.getTerminId(),
                this.getTechniker(),
                this.getKunde(),
                this.getDatum(),
                this.getAdresse(),
                this.getFoto(),
                this.getNotizen()
        );
    }

    public long getTerminId() {
        return terminId;
    }

    public void setTerminId(long terminId) {
        this.terminId = terminId;
    }

    public Techniker getTechniker() {
        return techniker;
    }

    public void setTechniker(Techniker techniker) {
        this.techniker = techniker;
    }

    public KundeTO getKunde() {
        return kunde;
    }

    public void setKunde(KundeTO kunde) {
        this.kunde = kunde;
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

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public String getNotizen() {
        return notizen;
    }

    public void setNotizen(String notizen) {
        this.notizen = notizen;
    }
}
