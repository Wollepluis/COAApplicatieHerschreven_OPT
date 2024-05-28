package userClasses;

import appModels.Land;
import appModels.Woning;
import menu.Menu;
import utils.MenuType;
import utils.RechterUitspraak;
import utils.Seeder;

public class Vluchteling extends Gebruiker {

    private String naam;
    private Land landVanHerkomst;
    private boolean isGeregistreerd;
    private boolean heeftVergunning;

    private boolean heeftPaspoort;
    private boolean rechterToegewezen;
    private RechterUitspraak uitspraak;

    private boolean plaatsingInWoning;
    private Woning woning;

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

    public void setUitspraak(RechterUitspraak uitspraak) {
        this.uitspraak = uitspraak;
    }

    public void setWoning(Woning woning) {
        this.woning = woning;
    }

    public void setGeregistreerd(boolean geregistreerd) {
        this.isGeregistreerd = geregistreerd;
    }

    public void setRechterToegewezen(boolean toegewezen) {
        this.rechterToegewezen = toegewezen;
    }

    public void setPlaatsingInWoning(boolean plaatsing) {
        this.plaatsingInWoning = plaatsing;
    }

    public String getNaam() {
        return this.naam;
    }

    public Land getLandVanHerkomst() {
        return this.landVanHerkomst;
    }

    public String getHeeftPaspoort() {
        return jaOfNee(this.heeftPaspoort);
    }

    public String getHeeftVergunning() {
        return jaOfNee(this.heeftVergunning);
    }

    public String getUitspraak() {

        return switch (this.uitspraak) {
            case RechterUitspraak.GEACCEPTEERD -> "Geaccepteerd";
            case RechterUitspraak.AFGEWEZEN -> "Afgewezen";
            case RechterUitspraak.GEEN_BESLUIT -> "Geen besluit";
        };
    }

    public Woning getWoning() {
        return this.woning;
    }

    public boolean isGeregistreerd() {
        return this.isGeregistreerd;
    }

    public String getRechterToegewezen() {
        return jaOfNee(this.rechterToegewezen);
    }

    public String getPlaatsingInWoning() {

        if (this.woning == null && this.plaatsingInWoning) {
            return "Gestart";
        }
        else if (this.woning != null && this.plaatsingInWoning) {
            return "Afgerond";
        }
        else {
            return "Nee";
        }
    }

    public Vluchteling(String naam, Land land) {
        super(naam);
        setNaam(naam);
        setLandVanHerkomst(land);
        setGeregistreerd(false);
        setHeeftVergunning(false);
        setHeeftPaspoort(false);
        setRechterToegewezen(false);
        setPlaatsingInWoning(false);
    }

    public String jaOfNee(boolean var) {
        if (var) {
            return "Ja";
        }
        else {
            return "Nee";
        }
    }

    @Override
    public Menu getMenu() {
        return Seeder.getInstance().getMenu(MenuType.VLUCHTELING);
    }
}
