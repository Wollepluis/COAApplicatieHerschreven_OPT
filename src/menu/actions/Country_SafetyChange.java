package menu.actions;

import appModels.Country;
import utils.ClosedQuestion;
import utils.CountryManager;
import utils.MyScanner;

import java.util.ArrayList;

public class Country_SafetyChange implements IAction {

    public String printSafety(boolean safety) {

        if (safety) {
            return "safe";
        }
        else {
            return "not safe";
        }
    }

    @Override
    public void execute() {

        String countryName = CountryManager.getActiveCountry().getName();
        boolean safety = CountryManager.getActiveCountry().getSafe();

        if (ClosedQuestion.question("Do you want to switch " + countryName + "'s safety from '" + printSafety(safety) + "' to '" + printSafety(!safety) + "'?")){
            CountryManager.getActiveCountry().setSafe(!safety);
            System.out.println(countryName + "'s safety set to '" + printSafety(!safety) + "'.");
        }
        else {
            System.out.println(countryName + "'s safety not switched");
        }


    }
}
