package appModels;

import utils.Seeder;

import java.util.ArrayList;

public class Country {

    private String name;
    private boolean isSafe;

    public void setName(String name) {
        this.name = name;
    }

    public void setSafe(boolean isSafe) {
        this.isSafe = isSafe;
    }

    public String getName() {
        return this.name;
    }

    public boolean getSafe() {
        return this.isSafe;
    }

    public Country(String name, boolean isSafe) {
        this.setName(name);
        this.setSafe(isSafe);
    }
}
