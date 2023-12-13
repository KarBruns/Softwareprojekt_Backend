package awk.entity;

import awk.entity.impl.Techniker;

import java.io.Serializable;

public class TechnikerTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long technikerId;
    private String name;
    private String vorName;

    public TechnikerTO() {
    }

    public TechnikerTO(long technikerId, String name, String vorName) {
        this.technikerId = technikerId;
        this.name = name;
        this.vorName = vorName;
    }

    public Techniker toTechniker() {
        return new Techniker(
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
