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
    private long latitude;
    private long longitude;
    private String dateiURL;

    public Foto() {
    }

    public Foto(long fotoId, long latitude, long longitude, String dateiURL) {
        this.fotoId = fotoId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateiURL = dateiURL;
    }

    public FotoTO toFotoTO() {
        return new FotoTO(
                this.getFotoId(),
                this.getLatitude(),
                this.getLongitude(),
                this.getDateiURL()
        );
    }

	public long getFotoId() {
		return fotoId;
	}

	public void setFotoId(long fotoId) {
		this.fotoId = fotoId;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public String getDateiURL() {
		return dateiURL;
	}

	public void setDateiURL(String dateiURL) {
		this.dateiURL = dateiURL;
	}

    
    
}
