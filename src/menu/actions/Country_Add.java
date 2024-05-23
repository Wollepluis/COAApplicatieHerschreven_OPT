package menu.actions;

import appModels.Country;
import utils.ClosedQuestion;
import utils.CountryManager;
import utils.MyScanner;

public class Country_Add implements IAction{

    @Override
    public void execute() {

        String name;
        boolean isSafe;

        System.out.print("Enter name of country: ");
        name = MyScanner.nextLine();

        if (!CountryManager.hasCountry(name)) {

            if (ClosedQuestion.question("Is this country considered 'safe'?")){
                isSafe = true;
            }
            else {
                isSafe = false;
            }
            System.out.println("Country " + name + " successfully added!");
            CountryManager.addCountry(new Country(name, isSafe));
        }
        else {
            System.out.println("This country is already registered.");
        }
    }
}
