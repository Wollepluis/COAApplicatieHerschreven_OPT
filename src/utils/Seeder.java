package utils;

import appModels.Country;
import menu.*;
import menu.actions.*;
import userClasses.*;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Seeder {

    private static Seeder instance = null;

    private Map<MenuType, Menu> menus;
    private ArrayList<User> users;


    public static Seeder getInstance() {

        if (instance == null) {
            instance = new Seeder();
        }
        return instance;
    }

    public User getUser(String username) {

        for (User user : users) {

            if (user.login(username)) {
                return user;
            }
        }
        return null;
    }

    private void addUser(User user) {

        for (User u : users) {

            if (u.getUsername().equals(user.getUsername())) {
                return;
            }
        }
        users.add(user);
    }

    public Menu getMenu() {

        Security security = Security.getInstance();

        if (!security.isLoggedIn()) {
            return menus.get(MenuType.LOGGED_OUT);
        }
        else {
            User user = security.getActiveUser();
            return user.getMenu();
        }
    }

    public Menu getMenu(MenuType menuType) {
        return menus.get(menuType);
    }

    private void initialize() {

        CountryController countryController = CountryController.getInstance();

        countryController.addCountry(new Country("Ghana", false));
        countryController.addCountry(new Country("Afghanistan", true));

        addUser(new Admin("admin"));
        addUser(new COAEmployee("coa"));

        MenuChoice login = new MenuChoice("Login", new Login());
        MenuChoice logout = new MenuChoice("Logout", new Logout());
        MenuChoice terug = new MenuChoice(9, "Back", true, new Return());
        MenuChoice exit = new MenuChoice(9,"Exit", true, new Exit());

        //LOGGED_OUT
        Menu loggedOut = new Menu("Not logged in");
        loggedOut.addMenuChoice(login);
        loggedOut.addMenuChoice(exit);
        menus.put(MenuType.LOGGED_OUT, loggedOut);

        //ADMIN
        Menu admin = new Menu("Logged in as: Admin");
        admin.addMenuChoice(new MenuChoice("Manage Countries", new Country_Manage()));
        admin.addMenuChoice(new MenuChoice("Manage local authorities", new LocalAuthority_Modify()));
        admin.addMenuChoice(terug);
        menus.put(MenuType.ADMIN, admin);

        //COUNTRYMANAGE
        Menu manageCountry = new Menu("Manage Country");
        manageCountry.addMenuChoice(new MenuChoice("Show all countries", new Country_ShowAll()));
        manageCountry.addMenuChoice(new MenuChoice("Add new country", new Country_Add()));
        manageCountry.addMenuChoice(new MenuChoice("Modify existing country", new Country_Modify()));
        manageCountry.addMenuChoice(terug);
        menus.put(MenuType.COUNTRY_MANAGE, manageCountry);

        //COUNTRYMODIFY
        Menu modifyCountry = new Menu("");
        modifyCountry.addMenuChoice(new MenuChoice("Change name", new Country_NameChange()));
        modifyCountry.addMenuChoice(new MenuChoice("Change safety", new Country_SafetyChange()));
        modifyCountry.addMenuChoice(terug);
        menus.put(MenuType.COUNTRY_MODIFY, modifyCountry);
    }

    private Seeder() {
        this.users = new ArrayList<>();
        this.menus = new HashMap<>();
        initialize();
    }
}
