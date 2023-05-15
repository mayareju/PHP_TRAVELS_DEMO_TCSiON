package page.objects.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupplierPage {

	
public WebDriver driver;
	
	public SupplierPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class=\"row gx-3\"]")
	private WebElement summaryview1;
	
	@FindBy(xpath="//div[text()='Sales overview & summary']")
	private WebElement dashboardview1;
	
	@FindBy(xpath="//div[@class='row gx-4']")
	private WebElement revenueview1;
	@FindBy(xpath="//canvas[@id='myPieChart']")
	private WebElement revenueview2;
	@FindBy(xpath="//div[@class='card-footer bg-transparent p-0']")
	private WebElement revenueview3;
	@FindBy(xpath="//h2[text()='Revenue Breakdown 2023']")
	private WebElement dashboardview2;
	
	@FindBy(xpath="//div[text()='Pending Bookings']")
	private WebElement suppending;
	
	@FindBy(xpath="(//select[@id='booking_status'])[1]")
	private WebElement suppendingdrop;
	
	@FindBy(xpath="(//option[text()='Confirmed'])[1]")
	private WebElement supconfirmdrop;
	
	@FindBy(xpath="(//div[@class='display-5'])[1]")
	private WebElement supconfirmnum;
	
	@FindBy(xpath="(//div[@class='display-5'])[2]")
	private WebElement suppendnum;
	
	@FindBy(xpath="//div[text()='Dashboard']")
	private WebElement backdash;
	
	@FindBy(linkText="Bookings")
	private WebElement booking;
	
	@FindBy(xpath="//i[text()='luggage']")
	private WebElement tours;
	
	@FindBy(xpath="//div[@id='toursmodule']")
	private WebElement tours1;
	
	@FindBy(xpath="//a[@href='https://phptravels.net/api/supplier/tours']")
	private WebElement managetours;
	
	public boolean summaryView() {
		boolean view1=summaryview1.isDisplayed();
		return view1;
	}
	
	public String getText1() {
		String summarytext=dashboardview1.getText();
		return summarytext;
	}
	public boolean revenueView1() {
		boolean view1=revenueview1.isDisplayed();
		boolean view2=revenueview2.isDisplayed();
		boolean view3=revenueview3.isDisplayed();
		boolean finalview = false;
		if(view1==view2==view3==true) {
			finalview=true;
			System.out.println("Revenue breakdown can see in dashboard");
		}
		else {
			System.out.println("Revenue breakdown can't see in dashboard");
		}
		return finalview;
	}
	public String getText2() {
		String summarytext=dashboardview2.getText();
		return summarytext;
	}
	
	public void clickPending() {
		suppending.click();
	}
	
	public void selectPendingToConfirm() throws InterruptedException {
		suppendingdrop.click();
		Thread.sleep(2000);
		supconfirmdrop.click();
		
	}
	public String numPendingSupplier() {
		String numP=suppendnum.getText();
		return numP;
	}
	
	public String numConfirmSupplier() {
		String numC=supconfirmnum.getText();
		return numC;
	}
	public void backToDash() {
		backdash.click();
	}
	public void booking() throws InterruptedException {
		booking.click();
		Thread.sleep(2000);
	}
	
	public void getTours() throws InterruptedException {
		tours.click();
		Thread.sleep(2000);
		tours1.click();
		Thread.sleep(3000);
		managetours.click();
	}
}
