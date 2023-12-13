package awk.entity.impl;

import awk.entity.TechnikerTO;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Softwareprojekt_Techniker")
public class Techniker implements Serializable {

    private static final long serialVersionUID = -6294171410019620518L;

    @Id
    @SequenceGenerator(name="Softwareprojekt_Techniker_Id", sequenceName="SEQ_Techniker_Id", allocationSize = 100)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_Techniker_Id")
    private long technikerId;
    private String name;
    private String vorName;

    public Techniker() {
    }

    public Techniker(long technikerId, String name, String vorName) {
        this.technikerId = technikerId;
        this.name = name;
        this.vorName = vorName;
    }

    public TechnikerTO toTechnikerTO() {
        return new TechnikerTO(
                this.getTechnikerId(),
                this.getName(),
                this.getVorName()
        );
    }

    public long getTechnikerId() {
        return technikerId;
    }

    public void setTechnikerId(long technikerId) {
        this.technikerId = technikerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorName() {
        return vorName;
    }

    public void setVorName(String vorName) {
        this.vorName = vorName;
    }
}
