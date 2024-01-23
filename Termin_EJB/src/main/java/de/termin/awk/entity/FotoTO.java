package de.termin.awk.entity;

import java.io.Serializable;

import de.termin.awk.entity.impl.Foto;

public class FotoTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long fotoId;
    private double latitude;
    private double longitude;
    private String dateipfad;

    public FotoTO() {
    }

    public FotoTO(long fotoId, double latitude, double longitude, String dateipfad) {
        this.fotoId = fotoId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateipfad = dateipfad;
    }

    public Foto toFoto() {
        return new Foto(
                this.getFotoId(),
                this.getLatitude(),
                this.getLongitude(),
                this.getDateipfad()
        );
    }

	public long getFotoId() {
		return fotoId;
	}

	public void setFotoId(long fotoId) {
		this.fotoId = fotoId;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getDateipfad() {
		return dateipfad;
	}

	public void setDateipfad(String dateiURL) {
		this.dateipfad = dateiURL;
	}
    
    

}
