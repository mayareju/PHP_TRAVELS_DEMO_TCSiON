package page.objects.phptravels;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentPage {

	
public WebDriver driver;
	
	public AgentPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Hotels")
	private WebElement hotels;
	
	@FindBy(xpath="//a[@href='https://phptravels.net/flights']")
	private WebElement flights;
	
	@FindBy(linkText="Tours")
	private WebElement tours ;
	
	@FindBy(xpath="//a[@href='https://phptravels.net/visa']")
	private WebElement visa;
	
	@FindBy(linkText="Blog")
	private WebElement blog;
	
	@FindBy(linkText="Offers")
	private WebElement Offers;
	
	@FindBy(xpath="(//img[@src=\"https://phptravels.net/api/uploads/global/logo.png\"])[1]")
	private WebElement home;
	
	@FindBy(xpath="//span[@id='select2-hotels_city-container'and @role='textbox']")
	private WebElement cityname;	
	
	@FindBy(xpath="//input[@aria-controls='select2-hotels_city-results']")
	private WebElement sendcityname;
	
	@FindBy(xpath="//span[@class='select2-results']")
	List<WebElement> options;
	
	@FindBy(xpath="//option[text()='Sindal,Denmark']")
	private WebElement option;
	
	@FindBy(xpath="//button[@id='submit']")
	private WebElement search;
	
	@FindBy(xpath="(//button[@id='currency'])[1]")
	private WebElement clickcurrency;
	
	@FindBy(xpath="//a[text()=' INR']")
	private WebElement changecurrency;
	
	public void clickHotels() {
		hotels.click();
		
	}
	
	public void clickFlights() {
		flights.click();
	}
	
	public void clickTours() {
		tours.click();
	}
	
	public void clickVisa() {
		visa.click();
	}
	
	public void clickBlog() {
		blog.click();
	}
	
	public void clickOffers() {
		Offers.click();
	}
	
	public void clickHome() {
		home.click();
	}
	public void clickCityName() {
		cityname.click();
	}
	
	
	public void strCityName(String strcity) {
		sendcityname.sendKeys(strcity);
	}
	
	public void selectOption() throws InterruptedException {
		for(int i = 0; i<=options.size()-1; i++) {
            if(options.get(i).getText().contains("Sindal")) {
            	Thread.sleep(1000);
            	options.get(i).click();
            	Thread.sleep(1000);
               break;
            }
		}
	}
	

	public void clickOption() {
		option.click();
	}
	public void clickSearch() {
		search.click();
	}
	
	public void clickCurrency() {
		clickcurrency.click();
	}
	
	public void updateCurrency() {
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("window.scrollBy(0,400)");
		changecurrency.click();
	}
	
	public String checkINRupdate() {
		String update = clickcurrency.getText();
		return update;
	}
}
