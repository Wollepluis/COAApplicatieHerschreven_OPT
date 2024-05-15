package utils;

import appModels.*;
import menu.*;
import userClasses.*;

import java.util.ArrayList;

public class Seeder {

    private static Seeder instance = null;

    private ArrayList<Menu> menus;
    private ArrayList<User> users;

    private void initialize() {

    }

    private Seeder() {
        initialize();
    }

    public static Seeder getInstance() {

        if (instance == null) {
            instance = new Seeder();
        }
        return instance;
    }
}
