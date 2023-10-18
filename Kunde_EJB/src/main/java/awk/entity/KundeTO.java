package awk.entity;
import awk.entity.impl.Kunde;
public class KundeTO {
    private long kundenId;
    private String name;
    private String vorname;
    private String gebDatum;
    private String strasse;
    private String hausNr;
    private long plz;
    private String ort;
    private String telNr;
    private String eMail;
    public KundeTO() {
    }
    public KundeTO(long kundenId, String name, String vorname, String gebDatum,
                   String strasse, String hausNr, long plz, String ort, String telNr,
                   String eMail) {
        this.kundenId = kundenId;
        this.name = name;
        this.vorname = vorname;
        this.gebDatum = gebDatum;
        this.strasse = strasse;
        this.hausNr = hausNr;
        this.plz = plz;
        this.ort = ort;
        this.telNr = telNr;
        this.eMail = eMail;
    }
    public Kunde toKunde() {
        return new Kunde(
                this.getKundenId(),
                this.getName(),
                this.getVorname(),
                this.getGebDatum(),
                this.getStrasse(),
                this.getHausNr(),
                this.getPlz(),
                this.getOrt(),
                this.getTelNr(),
                this.geteMail());

    }

    public long getKundenId() {
        return kundenId;
    }

    public void setKundenId(long kundenId) {
        this.kundenId = kundenId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    public String getGebDatum() {
        return gebDatum;
    }
    public void setGebDatum(String gebDatum) {
        this.gebDatum = gebDatum;
    }
    public String getStrasse() {
        return strasse;
    }
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
    public String getHausNr() {
        return hausNr;
    }
    public void setHausNr(String hausNr) {
        this.hausNr = hausNr;
    }
    public long getPlz() {
        return plz;
    }
    public void setPlz(long plz) {
        this.plz = plz;
    }
    public String getOrt() {
        return ort;
    }
    public void setOrt(String ort) {
        this.ort = ort;
    }
    public String getTelNr() {
        return telNr;
    }
    public void setTelNr(String telNr) {

        this.telNr = telNr;
    }
    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}