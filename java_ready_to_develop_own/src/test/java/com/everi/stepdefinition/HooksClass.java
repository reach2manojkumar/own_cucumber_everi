package com.everi.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.everi.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {

	@Before(order = 2)
	public void beforeScenario_2() {
		System.out.println("Before Load _2");
		try {
			toselectBrowser("chrome");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver issue");
		}
	}

	@Before(order = 1)
	public void beforeScenario_1() {
		System.out.println("Before Load _1");
	}

	@After(order = 2)
	public void afterScenario_2(Scenario shot) {
		System.out.println("Fail Test ");

		if (shot.isFailed()) {
			byte[] failScreen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			if (failScreen != null) {
				shot.attach(failScreen, "image/png", shot.getName());
			}
		}
	}

	@After(order = 1)
	public void afterScenario_1() throws InterruptedException {
		System.out.println("After Load _1");
		waitAndexit(10);
	}
}
