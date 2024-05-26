package userClasses;

import appModels.Land;
import appModels.Woning;
import menu.Menu;
import utils.MenuType;
import utils.Seeder;

public class Vluchteling extends Gebruiker {

    private String naam;
    private Land landVanHerkomst;
    private boolean heeftPaspoort;
    private boolean heeftVergunning;
    private String uitspraak;
    private Woning woning;

    private boolean geregistreerd;

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setLandVanHerkomst(Land landVanHerkomst) {
        this.landVanHerkomst = landVanHerkomst;
    }

    public void setHeeftPaspoort(boolean heeftPaspoort) {
        this.heeftPaspoort = heeftPaspoort;
    }

    public void setHeeftVergunning(boolean heeftVergunning) {
        this.heeftVergunning = heeftVergunning;
    }

    public void setUitspraak(String uitspraak) {
        this.uitspraak = uitspraak;
    }

    public void setWoning(Woning woning) {
        this.woning = woning;
    }

    public void setGeregistreerd(boolean geregistreerd) {
        this.geregistreerd = geregistreerd;
    }

    public String getNaam() {
        return this.naam;
    }

    public Land getLandVanHerkomst() {
        return this.landVanHerkomst;
    }

    public boolean getHeeftPaspoort() {
        return this.heeftPaspoort;
    }

    public boolean getHeeftVergunning() {
        return this.heeftVergunning;
    }

    public String getUitspraak() {
        return this.uitspraak;
    }

    public Woning getWoning() {
        return this.woning;
    }

    public boolean getGeregistreerd() {
        return this.geregistreerd;
    }

    public Vluchteling(String gebruikersnaam) {
        super(gebruikersnaam);
    }

    @Override
    public Menu getMenu() {
        return Seeder.getInstance().getMenu(MenuType.VLUCHTELING);
    }
}
