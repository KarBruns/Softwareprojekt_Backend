package awk.entity.impl;

import awk.entity.TechnikerTO;

public class Techniker {

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
