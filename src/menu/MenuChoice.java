package menu;

import menu.actions.IAction;

public class MenuChoice {

    private int index;
    private String title;
    IAction action;

    public void setIndex(int index) {
        this.index = index;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAction(IAction action) {
        this.action = action;
    }

    public MenuChoice(int index, String title, IAction action) {
        this.setIndex(index);
        this.setTitle(title);
        this.setAction(action);
    }

    public void showMenuChoice() {
        System.out.printf("[%d] %s%n", this.index, this.title);
    }

    public void execute() {
        if (action != null) {
            action.execute();
        }
        else {
            System.out.println("This Choice does not execute a command.");
        }
    }
 }
