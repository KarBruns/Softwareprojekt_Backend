package awk.entity.impl;

import awk.entity.FotoTO;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Softwareprojekt_Foto")
public class Foto implements Serializable {

    private static final long serialVersionUID = -779999960244416576L;

    @Id
    @SequenceGenerator(name="Softwareprojekt_Foto_Id", sequenceName="SEQ_Foto_Id", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_Foto_Id")
    private long fotoId;
    private String geoDaten;
    private String dateipfad;

    public Foto() {
    }

    public Foto(long fotoId, String geoDaten, String dateipfad) {
        this.fotoId = fotoId;
        this.geoDaten = geoDaten;
        this.dateipfad = dateipfad;
    }

    public FotoTO toFotoTO() {
        return new FotoTO(
                this.getFotoId(),
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
