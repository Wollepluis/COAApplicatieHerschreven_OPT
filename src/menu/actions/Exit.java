package menu.actions;

public class Exit implements IAction {

    @Override
    public void execute() {
        System.exit(0);
    }
}
