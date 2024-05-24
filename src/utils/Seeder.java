package utils;

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
            Gebruiker gebruiker = security.getActiveUser();
            return gebruiker.getMenu();
        }
    }

    public Menu getMenu(MenuType menuType) {
        return menus.get(menuType);
    }

    private void initialize() {

        Land_Controller landController = Land_Controller.getInstance();

        landController.voegLandToe(new Land("Ghana", false));
        landController.voegLandToe(new Land("Afghanistan", true));

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

        //ADMIN
        Menu admin = new Menu(printUser());
        admin.voegMenukeuzeToe(new Menukeuze("Landen beheren", new Land_Beheer()));
        admin.voegMenukeuzeToe(new Menukeuze("Gemeente beheren", new Gemeente_Wijzig()));
        admin.voegMenukeuzeToe(terug);
        menus.put(MenuType.BEHEERDER, admin);

        //COUNTRYMANAGE
        Menu manageCountry = new Menu("Landen beheren");
        manageCountry.voegMenukeuzeToe(new Menukeuze("Alle geregistreerde landen", new Land_ShowAll()));
        manageCountry.voegMenukeuzeToe(new Menukeuze("Voeg nieuw land toe", new Land_voegToe()));
        manageCountry.voegMenukeuzeToe(new Menukeuze("Wijzig geregistreerd land", new Land_Wijzig()));
        manageCountry.voegMenukeuzeToe(terug);
        menus.put(MenuType.LAND_BEHEER, manageCountry);

        //COUNTRYMODIFY
        Menu modifyCountry = new Menu("");
        modifyCountry.voegMenukeuzeToe(new Menukeuze("Naam Wijzigen", new Land_Wijzig_Naam()));
        modifyCountry.voegMenukeuzeToe(new Menukeuze("Veiligheid aanpassen", new Land_Wijzig_Veiligheid()));
        modifyCountry.voegMenukeuzeToe(terug);
        menus.put(MenuType.LAND_WIJZIG, modifyCountry);
    }

    private String printUser() {
        Security security = Security.getInstance();
        return "Ingelogd als " + security.getActiveUser().getGebruikersnaam();
    }

    private Seeder() {
        this.gebruikers = new ArrayList<>();
        this.menus = new HashMap<>();
        initialize();
    }
}
