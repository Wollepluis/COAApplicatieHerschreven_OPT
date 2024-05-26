package utils;

import appModels.AZC;
import appModels.Gemeente;
import appModels.Land;
import menu.*;
import menu.actions.*;
import userClasses.*;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Seeder {

    private static Seeder instance = null;

    private final Map<MenuType, Menu> menus;
    private final ArrayList<Gebruiker> gebruikers;


    public static Seeder getInstance() {

        if (instance == null) {
            instance = new Seeder();
        }
        return instance;
    }

    public Gebruiker getGebruiker(String gebruikersnaam) {

        for (Gebruiker gebruiker : this.gebruikers) {

            if (gebruiker.login(gebruikersnaam)) {
                return gebruiker;
            }
        }
        return null;
    }

    private void voegGebruikerToe(Gebruiker gebruiker) {

        for (Gebruiker g : gebruikers) {

            if (g.getGebruikersnaam().equals(gebruiker.getGebruikersnaam())) {
                return;
            }
        }
        gebruikers.add(gebruiker);
    }

    public Menu getMenu() {

        Security security = Security.getInstance();

        if (!security.isLoggedIn()) {
            return menus.get(MenuType.LOGGED_OUT);
        }
        else {
            Gebruiker gebruiker = security.getActiveGebruiker();
            return gebruiker.getMenu();
        }
    }

    public Menu getMenu(MenuType menuType) {
        return menus.get(menuType);
    }

    private void initialize() {

        Land_Controller landController = Land_Controller.getInstance();
        Gemeente_Controller gemeenteController = Gemeente_Controller.getInstance();
        AZC_Controller azcController = AZC_Controller.getInstance();

        landController.voegLandToe(new Land("Ghana", false));
        landController.voegLandToe(new Land("Afghanistan", true));

        gemeenteController.voegGemeenteToe(new Gemeente("Amsterdam",918000));
        gemeenteController.voegGemeenteToe(new Gemeente("Rotterdam",663000));
        gemeenteController.voegGemeenteToe(new Gemeente("Den Haag", 562000));
        Gemeente amsterdam = gemeenteController.getGemeente("Amsterdam");
        Gemeente rotterdam = gemeenteController.getGemeente("Rotterdam");
        Gemeente denHaag = gemeenteController.getGemeente("Den Haag");

        azcController.voegAZCToe(amsterdam, new AZC(amsterdam, "1067SL", "Willinklaan", 3, 700));
        azcController.voegAZCToe(denHaag, new AZC(denHaag, "2517AS", "Laan van Meerdervoort", 108, 600));

        voegGebruikerToe(new Beheerder("beheerder"));
        voegGebruikerToe(new COAMedewerker("coa"));

        Menukeuze login = new Menukeuze("Login", new Login());
        Menukeuze terug = new Menukeuze(9, "Terug", true, new Return());
        Menukeuze exit = new Menukeuze(9,"Exit", true, new Exit());

        //LOGGED_OUT
        Menu uitgelogd = new Menu("Niet ingelogd");
        uitgelogd.voegMenukeuzeToe(login);
        uitgelogd.voegMenukeuzeToe(exit);
        menus.put(MenuType.LOGGED_OUT, uitgelogd);

        //BEHEERDER
        Menu admin = new Menu("");
        admin.voegMenukeuzeToe(new Menukeuze("Landen beheren", new Land_Beheer()));
        admin.voegMenukeuzeToe(new Menukeuze("Gemeente beheren", new Gemeente_Beheer()));
        admin.voegMenukeuzeToe(new Menukeuze("AZCs beheren", new AZC_Beheer()));
        admin.voegMenukeuzeToe(terug);
        menus.put(MenuType.BEHEERDER, admin);

        //LAND_BEHEER
        Menu beheerLand = new Menu("Landen beheren");
        beheerLand.voegMenukeuzeToe(new Menukeuze("Alle geregistreerde landen tonen", new Land_ShowAll()));
        beheerLand.voegMenukeuzeToe(new Menukeuze("Nieuw land toevoegen", new Land_VoegToe()));
        beheerLand.voegMenukeuzeToe(new Menukeuze("Geregistreerd land wijzigen", new Land_Wijzig()));
        beheerLand.voegMenukeuzeToe(terug);
        menus.put(MenuType.LAND_BEHEER, beheerLand);

        //LAND_WIJZIG
        Menu wijzigLand = new Menu("");
        wijzigLand.voegMenukeuzeToe(new Menukeuze("Naam Wijzigen", new Land_Wijzig_Naam()));
        wijzigLand.voegMenukeuzeToe(new Menukeuze("Veiligheid aanpassen", new Land_Wijzig_Veiligheid()));
        wijzigLand.voegMenukeuzeToe(terug);
        menus.put(MenuType.LAND_WIJZIG, wijzigLand);

        //GEMEENTE_BEHEER
        Menu beheerGemeente = new Menu("Gemeentes beheren");
        beheerGemeente.voegMenukeuzeToe(new Menukeuze("Alle geregistreerde gemeentes tonen", new Gemeente_showAll()));
        beheerGemeente.voegMenukeuzeToe(new Menukeuze("Nieuwe gemeente toevoegen", new Gemeente_VoegToe()));
        beheerGemeente.voegMenukeuzeToe(terug);
        menus.put(MenuType.GEMEENTE_BEHEER, beheerGemeente);

        //AZC_BEHEER
        Menu beheerAZC = new Menu("AZCs beheren");
        beheerAZC.voegMenukeuzeToe(new Menukeuze("Nieuw AZC toevoegen", new AZC_VoegToe()));
        beheerAZC.voegMenukeuzeToe(new Menukeuze("AZC aanpassen", new AZC_Wijzig()));
        beheerAZC.voegMenukeuzeToe(new Menukeuze("AZC verwijderen", new AZC_Verwijder()));
        beheerAZC.voegMenukeuzeToe(terug);
        menus.put(MenuType.AZC_BEHEER, beheerAZC);
    }

    private Seeder() {
        this.gebruikers = new ArrayList<>();
        this.menus = new HashMap<>();
        initialize();
    }
}
