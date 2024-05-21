package menu.actions;

import utils.Security;

public class Login implements IAction {

    @Override
    public void execute() {
        Security.getInstance().login();
    }
}
