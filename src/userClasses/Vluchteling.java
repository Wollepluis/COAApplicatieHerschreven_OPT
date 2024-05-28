package userClasses;

import appModels.Land;
import appModels.Woning;
import menu.Menu;
import utils.MenuType;
import utils.Seeder;

public class Vluchteling extends Gebruiker {

    private String naam;
    private Land landVanHerkomst;
    private boolean geregistreerd;
    private boolean heeftVergunning;

    private boolean heeftPaspoort;
    private boolean rechterToegewezen;
    private int uitspraak;

    private boolean plaatsingWoning;
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

    public void setUitspraak(int uitspraak) {
        this.uitspraak = uitspraak;
    }

    public void setWoning(Woning woning) {
        this.woning = woning;
    }

    public void setGeregistreerd(boolean geregistreerd) {
        this.geregistreerd = geregistreerd;
    }

    public void setRechterToegewezen(boolean toegewezen) {
        this.rechterToegewezen = toegewezen;
    }

    public void setPlaatsingWoning(boolean plaatsing) {
        this.plaatsingWoning = plaatsing;
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
            case 0 -> "Geaccepteerd";
            case 1 -> "Afgewezen";
            default -> "Nee";
        };
    }

    public Woning getWoning() {
        return this.woning;
    }

    public boolean getGeregistreerd() {
        return this.geregistreerd;
    }

    public String getRechterToegewezen() {
        return jaOfNee(this.rechterToegewezen);
    }

    public String getPlaatsingWoning() {

        if (this.woning == null && this.plaatsingWoning) {
            return "Gestart";
        }
        else if (this.woning != null && this.plaatsingWoning) {
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
        setPlaatsingWoning(false);
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
