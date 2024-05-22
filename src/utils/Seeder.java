package utils;

import menu.*;
import menu.actions.Country_Modify;
import menu.actions.Exit;
import menu.actions.Login;
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

        addUser(new Admin("admin"));
        addUser(new COAEmployee("coa"));

        this.menus = new HashMap<>();

        //LOGGED_OUT
        Menu loggedOut = new Menu("Not logged in");
        MenuChoice login = new MenuChoice("Login", new Login());
        MenuChoice exit = new MenuChoice("Exit", new Exit());
        loggedOut.addMenuChoice(login);
        loggedOut.addMenuChoice(exit);
        menus.put(MenuType.LOGGED_OUT, loggedOut);

        //ADMIN
        Menu admin = new Menu("Logged in as: Admin");
        admin.addMenuChoice(new MenuChoice("Manage Countries", new Country_Modify()));
    }

    private Seeder() {
        this.users = new ArrayList<>();
        initialize();
    }
}
