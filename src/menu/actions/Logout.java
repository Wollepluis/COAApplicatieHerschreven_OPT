package menu.actions;

import utils.Security;

public class Logout implements IAction {

    @Override
    public void execute() {
        Security.getInstance().logout();
    }
}
