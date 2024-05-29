package appModels;

import userClasses.Vluchteling;

public class Woning {

    private Vluchteling bewoner;
    private Adres adres;

    public Adres getAdres() {
        return this.adres;
    }

    public Vluchteling getBewoner() {
        return this.bewoner;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public void setBewoner(Vluchteling bewoner) {
        this.bewoner = bewoner;
    }

    public Woning(Vluchteling bewoner, Adres adres) {
        this.setBewoner(bewoner);
        this.setAdres(adres);
    }
}
