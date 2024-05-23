package menu;

import utils.MyScanner;

import java.util.ArrayList;

public class Menu {

    private String title;
    private int lastChoice;
    private ArrayList<MenuChoice> menuChoices;

    public void setTitle(String title) {
        this.title = title;
    }

    private void setLastChoice(int lastChoice) {
        this.lastChoice = lastChoice;
    }

    private void resetLastChoice() {
        setLastChoice(-1);
    }

    public void resetMenuChoice() {
        menuChoices = new ArrayList<>();
        resetLastChoice();
    }

    public int getLastChoice() {
        return this.lastChoice;
    }

    public Menu(String title) {
        this.setTitle(title);
        this.resetMenuChoice();
        this.resetLastChoice();
    }

    public void addMenuChoice(MenuChoice mc) {
        menuChoices.add(mc);
        mc.setChoice(menuChoices.size());
    }

    public MenuChoice getRightMenuChoice(int choice) {

        for (MenuChoice mc : menuChoices) {

            if (mc.getChoice() == choice) {
                return mc;
            }
        }
        return null;
    }

    public void showMenu() {
        System.out.println();
        System.out.printf("=== %s%n", this.title);

        for (MenuChoice mc : menuChoices) {
            mc.showMenuChoice();
        }

        System.out.println();
        System.out.print("Choice: ");
        setLastChoice(MyScanner.nextInt());
        MenuChoice mc = getRightMenuChoice(getLastChoice());

        if (mc != null) {
            mc.execute();
        }
        else {
            System.out.println("ERROR: Invalid Choice.");
        }
    }
}
