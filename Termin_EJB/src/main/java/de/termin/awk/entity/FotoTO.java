package de.termin.awk.entity;

import java.io.Serializable;

import de.termin.awk.entity.impl.Foto;

public class FotoTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long fotoId;
    private long latitude;
    private long longitude;
    private String dateiURL;

    public FotoTO() {
    }

    public FotoTO(long fotoId, long latitude, long longitude, String dateiURL) {
        this.fotoId = fotoId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateiURL = dateiURL;
    }

    public Foto toFoto() {
        return new Foto(
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
