package awk.entity;

import awk.entity.impl.Foto;

public class FotoTO {

    private long fotoId;
    private String geoDaten;
    private String dateipfad;

    public FotoTO() {
    }

    public FotoTO(long fotoId, String geoDaten, String dateipfad) {
        this.fotoId = fotoId;
        this.geoDaten = geoDaten;
        this.dateipfad = dateipfad;
    }

    public Foto toFoto() {
        return new Foto(
                this.getFotoId,
                this.getGeoDaten(),
                this.getDateipfad()
        );
    }

    public long getFotoId() {
        return fotoId;
    }

    public void setFotoId(long fotoId) {
        this.fotoId = fotoId;
    }

    public String getGeoDaten() {
        return geoDaten;
    }

    public void setGeoDaten(String geoDaten) {
        this.geoDaten = geoDaten;
    }

    public String getDateipfad() {
        return dateipfad;
    }

    public void setDateipfad(String dateipfad) {
        this.dateipfad = dateipfad;
    }
}
