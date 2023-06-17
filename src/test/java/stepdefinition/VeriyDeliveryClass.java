package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VeriyDeliveryClass {

	@Given("^All the assets$")
	public void testGiven(){
		System.out.println("provided all the assets");
	}
	
	@When("^All students are arrived$")
	public void testWhen(){
		System.out.println("when all the students are arrvied");
	}
	
	@Then("^I will explain cucumber$")
	public void testThen(){
		System.out.println("I will deliver cucumber");
	}
	
	
}
