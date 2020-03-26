package skeleton;

import cucumber.api.java.en.Given;

import static org.javalite.test.jspec.JSpec.the;

public class Stepdefs {
    @Given("^I have (\\d+) cukes in my belly$")
    public void I_have_cukes_in_my_belly(int cukes) throws Throwable {
        Belly belly = new Belly();
        belly.eat(cukes);
        the(belly).shouldNotBe("hungry");
    }
}
