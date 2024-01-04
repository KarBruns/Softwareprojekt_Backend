package de.termin.awk.entity.impl;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.termin.awk.entity.TerminTO;

@Entity
@Table(name = "Softwareprojekt_Termin")
public class Termin implements Serializable {

    private static final long serialVersionUID = -8403978423917160557L;

    @Id
    @SequenceGenerator(name="SP_Termin_Id", sequenceName="SEQ_Termin_Id", allocationSize = 10)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SP_Termin_Id")
    private long terminId;

    private long technikerId;
    private long kundenId;
    private String datum;
    private String adresse;
    private String notizen;

    @ElementCollection
    @CollectionTable(name = "Softwareprojekt_Termin_Fotos", joinColumns = @JoinColumn(name = "terminId"))
    private List<Long> fotos;

    public Termin() {
    }

    public Termin(long terminId, long techniker, long kundenId, String datum, String adresse, String notizen) {
        this.terminId = terminId;
        this.technikerId = techniker;
        this.kundenId = kundenId;
        this.datum = datum;
        this.adresse = adresse;
        this.notizen = notizen;
        this.setFotos(new ArrayList<Long>());
    }

    public TerminTO toTerminTO() {
        return new TerminTO(
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
