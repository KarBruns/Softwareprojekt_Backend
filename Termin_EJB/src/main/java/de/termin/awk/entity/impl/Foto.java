package de.termin.awk.entity.impl;

import jakarta.persistence.*;

import java.io.Serializable;

import de.termin.awk.entity.FotoTO;

@Entity
@Table(name = "Softwareprojekt_Foto")
public class Foto implements Serializable {

    private static final long serialVersionUID = -779999960244416576L;

    @Id
    @SequenceGenerator(name="SP_Foto_Id", sequenceName="SEQ_Foto_Id", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SP_Foto_Id")
    private long fotoId;
    private double latitude;
    private double longitude;
    private String dateipfad;

    public Foto() {
    }

    public Foto(long fotoId, double latitude, double longitude, String dateipfad) {
        this.fotoId = fotoId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateipfad = dateipfad;
    }

    public FotoTO toFotoTO() {
        return new FotoTO(
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
