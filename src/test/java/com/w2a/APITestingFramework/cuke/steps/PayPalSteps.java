package com.w2a.APITestingFramework.cuke.steps;

import org.testng.Assert;

import com.w2a.APITestingFramework.cuke.apis.OrderAPI;
import com.w2a.APITestingFramework.cuke.base.BaseTest;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PayPalSteps {

	
	@Before
	public void setUp() {
		
		BaseTest.init();
		
	}
	
	
	
	@Given("^I want to get access token from PayPal api$")
	public void i_want_to_get_access_token_from_PayPal_api() {
		
		
		OrderAPI.getAccessToken();
		
	}

	@When("^I set currency code as \"([^\"]*)\" and value as \"([^\"]*)\"$")
	public void i_set_currency_code_and_value(String currencyCode, String currencyValue) {
		

		BaseTest.response = OrderAPI.createOrder(currencyCode, currencyValue);
		
		
	}
	
	
	@When("^I get order from the paypal api$")
	public void i_get_order_from_the_paypal_api() {
		
		BaseTest.response = OrderAPI.getOrder();
	}
	
	

	@And("^I verify the status as CREATED$")
	public void i_verify_the_status_as_created() {
		
		
		Assert.assertEquals(BaseTest.response.jsonPath().get("status").toString(), "CREATED");
		
		
	}
	
	
	@And("^I verify the status code as \"([^\"]*)\"$")
	public void i_verify_the_status_code_as(int statusCode) {
		
		Assert.assertEquals(BaseTest.response.getStatusCode(), statusCode);
	}
	
	
	
}
