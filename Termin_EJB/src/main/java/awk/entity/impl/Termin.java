package awk.entity.impl;

import awk.entity.TerminTO;

import java.util.List;

public class Termin {

    private long terminId;
    private Techniker techniker;
    private long kundenId;
    private String datum;
    private String adresse;
    private long fotoId;
    private String notizen;

    private List<Long> fotos;

    public Termin() {
    }

    public Termin(long terminId, Techniker techniker, long kundenId, String datum, String adresse, long fotoId, String notizen) {
        this.terminId = terminId;
        this.techniker = techniker;
        this.kundenId = kundenId;
        this.datum = datum;
        this.adresse = adresse;
        this.fotoId = fotoId;
        this.notizen = notizen;
    }

    public TerminTO toTerminTO() {
        return new TerminTO(
                this.getTerminId(),
                this.getTechniker(),
                this.getKundenId(),
                this.getDatum(),
                this.getAdresse(),
                this.getFotoId(),
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

    public long getKundenId() {
        return kundenId;
    }

    public void setKunde(long kundenId) {
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

    public long getFotoId() {
        return fotoId;
    }

    public void setFotoId(long fotoId) {
        this.fotoId = fotoId;
    }

    public String getNotizen() {
        return notizen;
    }

    public void setNotizen(String notizen) {
        this.notizen = notizen;
    }

    public void addFoto(long fId) {
        this.fotos.add(fId);
    }

    public void removeFoto(long fId) {
        this.fotos.remove(fId);
    }

    public List<Long> getFotos() {
        return fotos;
    }

    public void setFotos(List<Long> fotos) {
        this.fotos = fotos;
    }
}
