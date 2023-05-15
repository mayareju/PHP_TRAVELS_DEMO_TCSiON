package page.objects.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {

public WebDriver driver;
	
	public CustomerPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://phptravels.net/account/bookings']/i")
	private WebElement booking;
	
	@FindBy(xpath="//div[@class='form-box']")
	private WebElement checkbookings;
	
	@FindBy(xpath="(//a[text()=' View Voucher'])[1]")
	private WebElement voucher;
	
	@FindBy(xpath="//button[@id='download']")
	private WebElement voucherdownload;
	
	@FindBy(xpath="//a[@href='https://phptravels.net/account/add_funds']/i")
	private WebElement addfunds;
	
	@FindBy(xpath="//input[@id='gateway_paypal']")
	private WebElement radiobutton;	
	
	@FindBy(xpath="//button[@type='submit']/i")
	private WebElement paynow;	
	
	@FindBy(xpath="//div[@id='buttons-container']")
	private WebElement paypalbutton;	
	
	@FindBy(xpath="//a[@href='https://phptravels.net/account/profile']/i")
	private WebElement profile;
	
	@FindBy(xpath="//input[@name='address1']")
	private WebElement address;
	
	@FindBy(xpath="//button[text()='Update Profile']")
	private WebElement update;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement sucesstext;
	
	@FindBy(xpath="//a[@href='https://phptravels.net/account/logout']/i")
	private WebElement logout;
	
	public void clickMyBooking() {
		booking.click();
	}
	
	public boolean getCheckBookings() {
		boolean check = checkbookings.getText().contains("Total Bookings");
		return check;
	}
	
	public void clickVoucher() {
		voucher.click();
	}
	
	public void clickAddFunds() {
		addfunds.click();
	}

	public void clickPaywithPaypal() {
		radiobutton.click();
	}

	public void clickPayNow() {
		paynow.click();
	}

	public boolean getPayPalButton() {
		boolean button = paypalbutton.isEnabled();
		return button;
	}
	
	public void clickMyProfile() {
		profile.click();
	}
	
	public void strAddress(String strAddress) {
		address.clear();
		address.sendKeys(strAddress);
	}
	
	public void clickUpdate() {
		update.click();
	}
	
	public boolean downloadInvoice() {
		boolean invoice = voucherdownload.isEnabled();
		return invoice;
	}

	
	public String Window() {
		String parent = driver.getWindowHandle();
		return parent;
	}
	
	public boolean checkUpdatesucessText() {
		boolean check = sucesstext.getText().contains("Profile updated successfully");
		return check;
	}
	public void clickLogout() {
		logout.click();
	}
}
