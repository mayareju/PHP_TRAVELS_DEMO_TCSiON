package page.objects.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Email']")
	private WebElement username;

	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement login;
	
	@FindBy(xpath="//div[@class='alert alert-danger loading wow fadeIn animated animated']")
	private WebElement invalidsupp;
	
	public void userEmail(String stremail) {
		
		username.sendKeys(stremail);
	}
	public void userPassword(String strpass) {
		
		password.sendKeys(strpass);
	}
	public void clickLogin() {
		login.click();
	}
	@FindBy(xpath="(//input[@name='email'])[1]")
	private WebElement adminemail;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement adminpass;	

	@FindBy(xpath="//span[text()='Login']")
	private WebElement adminlogin;
	
	public void adminEmail(String stremail) {
		
		adminemail.sendKeys(stremail);
	}
	
	public void adminPassword(String strpass) {
		
		adminpass.sendKeys(strpass);
	}
	public void clickAdminLogin() {
		adminlogin.click();
	}
	
	public String getErrorEmailMsg() {
		String error = username.getAttribute("validationMessage");
		return error;
	}
	public String getErrorPassMsg() {
		String error = password.getAttribute("validationMessage");
		return error;
	}
	
	public String getErrorMsgsupp() {
		String error = invalidsupp.getText();
		return error;
	}
	
}
