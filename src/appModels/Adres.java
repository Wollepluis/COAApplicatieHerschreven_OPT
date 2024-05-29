package appModels;

import utils.MyScanner;

public class Adres {

    private String postcode;
    private String straatnaam;
    private int huisnummer;

    public String getPostcode() {
        return this.postcode;
    }

    public String getStraatnaam() {
        return this.straatnaam;
    }

    public int getHuisnummer() {
        return this.huisnummer;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }

    public Adres(String postcode, String straatnaam, int huisnummer) {
        this.setPostcode(postcode);
        this.setStraatnaam(straatnaam);
        this.setHuisnummer(huisnummer);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Adres adres = (Adres) obj;
        return huisnummer == adres.huisnummer && postcode.equals(adres.postcode) && straatnaam.equals(adres.straatnaam);
    }

    @Override
    public int hashCode() {
        int result = postcode.hashCode();
        result = 31 * result + straatnaam.hashCode();
        result = 31 * result + huisnummer;
        return result;
    }
}
