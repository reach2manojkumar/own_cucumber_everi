package com.everi.PageLocator;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.everi.actiondriver.Action;
import com.everi.baseclass.BaseClass;

public class EntergityloginLocator extends BaseClass {

	Action act=new Action();
	public EntergityloginLocator() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	//FindAll collection and iteration 
	@FindAll({
		@FindBy(id="login-e-logo"),
		@FindBy(id="mat-input-0"),
		@FindBy(id="mat-input-1"),
		@FindBy(xpath="//span[contains(text(),\" Login \")]"),
		@FindBy(xpath="//h2[contains(text(),\"Entegrity™\")]"),
		@FindBy(xpath="//h5[text()=\"v1.0.0.51\"]"),
				
	})
	private List<WebElement> logcoll;
	public List<WebElement> getLogcoll() {
		return logcoll;
	}

	//Everi Logo picture 
	@FindBy(id="login-e-logo")
	private WebElement Logoid;
	
	//username id
	@FindBy(id="mat-input-0")
	private WebElement userid;
	
	//password id 
	@FindBy(id="mat-input-1")
	private WebElement passid;
	
	//login button 
	@FindBy(xpath="//span[contains(text(),\" Login \")]")
	private  WebElement submitid;
	
	//login box tittle name 
	@FindBy(xpath="//h2[contains(text(),\"Entegrity™\")]")
	private WebElement loginbox_tittle;
	
	//Version name 
	@FindBy(xpath="//h5[text()=\"v1.0.0.51\"]")
	private WebElement version;

	public WebElement getLogoid() {
		return Logoid;
	}

	public WebElement getUserid() {
		return userid;
	}

	public WebElement getPassid() {
		return passid;
	}

	public WebElement getSubmitid() {
		return submitid;
	}

	public WebElement getLoginbox_tittle() {
		return loginbox_tittle;
	}

	public WebElement getVersion() {
		return version;
	}
	
	public void fillLoginUsForm(String username,String password) {
		getUserid().sendKeys(username);
		getPassid().sendKeys(password);
		getSubmitid().click();
	}

	

}
