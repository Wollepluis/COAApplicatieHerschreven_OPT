package userClasses;

import appModels.Country;
import appModels.Residence;
import menu.Menu;

public class Refugee extends User {

    private String name;
    private Country countryOfOrigin;
    private boolean hasPassport;
    private boolean hasPermit;
    private String verdict;
    private Residence residence;

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryOfOrigin(Country countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public void setHasPassport(boolean hasPassport) {
        this.hasPassport = hasPassport;
    }

    public void setHasPermit(boolean hasPermit) {
        this.hasPermit = hasPermit;
    }

    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;
    }

    public String getName() {
        return this.name;
    }

    public Country getCountryOfOrigin() {
        return this.countryOfOrigin;
    }

    public boolean getHasPassport() {
        return this.hasPassport;
    }

    public boolean getHasPermit() {
        return this.hasPermit;
    }

    public String getVerdict() {
        return this.verdict;
    }

    public Residence getResidence() {
        return this.residence;
    }

    public Refugee(String username) {
        super(username);
    }

    @Override
    public Menu getMenu() {
        return
    }
}
