package menu;

import utils.MyScanner;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private String title;

    private final ArrayList<MenuChoice> menuChoices;

    public void setTitle(String title) {
        this.title = title;
    }

    public Menu(String title) {
        this.setTitle(title);
        this.menuChoices = new ArrayList<>();
    }

    public void addMenuChoice(MenuChoice mc) {
        menuChoices.add(mc);
    }

    public void showMenu() {
        System.out.println();
        System.out.printf("=== %s%n", this.title);

        for (MenuChoice mc : menuChoices) {
            mc.showMenuChoice();
        }

        System.out.print("Choice: ");
        int choice = MyScanner.nextInt();
    }
}
