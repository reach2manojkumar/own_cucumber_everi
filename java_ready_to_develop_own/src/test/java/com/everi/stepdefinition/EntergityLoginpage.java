package com.everi.stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.everi.PageLocator.EntergityloginLocator;
import com.everi.actiondriver.Action;
import com.everi.baseclass.BaseClass;
import com.everi.utilities.ExcelReader;

import cucumber.api.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EntergityLoginpage extends BaseClass {
	public Action act;

	public EntergityloginLocator loginLoc;

	@Given("Lanuch Everi Entegrity Login page")
	public void lanuch_everi_entegrity_login_page() throws InterruptedException, IOException {
		// Write code here that turns the phrase above into concrete actions
//		launchApp("chrome", "website_url");
		String site = "https://entegrity-qa01.purplecheckpoint.com/Entegrity/";
		openURL(site);
		Thread.sleep(5000);

	}

	@When("verify UI element are Display")
	public void verify_ui_element_are_display() {
		// Write code here that turns the phrase above into concrete actions
		loginLoc = new EntergityloginLocator();
		act = new Action();
		// collection of page element which present in login page.
		List<WebElement> colls = loginLoc.getLogcoll();
		System.out.println(colls.size());
		// iterate each element
		for (WebElement Ele : colls) {
			act.isDisplayed(driver, Ele);
		}

	}

	@When("User Enter usernmae and password {string} Sheet and RowNumber {int}")
	public void user_enter_usernmae_and_password_sheet_and_row_number(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testData = reader.getData(
				"C:\\Everi Project\\Everi Work Space\\java_ready_to_develop\\src\\test\\resources\\TestDataDriven\\EntegrityTestdata.xlsx",
				sheetName);
		String username = testData.get(rowNumber).get("username");
		String password = testData.get(rowNumber).get("password");
		loginLoc = new EntergityloginLocator();
		loginLoc.fillLoginUsForm(username, password);

	}
	@Then("Check whether page logged to homepage")
	public void check_whether_page_logged_to_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	    getcurtittle();
	    }
	

}
