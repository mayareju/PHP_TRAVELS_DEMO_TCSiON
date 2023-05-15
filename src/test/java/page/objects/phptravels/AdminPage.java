package page.objects.phptravels;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

public WebDriver driver;
	
	public AdminPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[@href='https://phptravels.net/api/admin/bookings'])[1]")
	private WebElement bookings;
	
	@FindBy(xpath="(//a[@class='btn btn-outline-dark mdc-ripple-upgraded'])[2]")
	private WebElement invoice;
	
	@FindBy(xpath="(//a[@class='btn btn-outline-dark mdc-ripple-upgraded'])[1]")
	private WebElement invoice1;
	
	@FindBy(xpath="//div[@class='infobox infobox-success']")
	private WebElement checkstatus;
	
	@FindBy(xpath="//div[@class= 'infobox infobox-danger']")
	private WebElement checkstatus1;
	
	@FindBy(xpath="//div[@class=\"col-lg-8 mx-auto print\"]")
	private WebElement checkstatusfinal;
	
	@FindBy(xpath="//div[@class='col-lg-8 mx-auto print']")
	private WebElement checkstatuspaid;
	
	
	
	@FindBy(xpath="(//button[@class=\"btn btn-danger mdc-ripple-upgraded\"])[2]")
	private WebElement deleteinvoice;	
	
	@FindBy(xpath="//div[text()='Pending Bookings']")
	private WebElement pending;
	
	@FindBy(xpath="//div[text()='Paid Bookings']")
	private WebElement paidbooking;
	
	@FindBy(xpath="(//select[@class='form-select status pending'])[1]")
	private WebElement selectpending;	
	
	@FindBy(xpath="(//option[text()='Confirmed'])[1]")
	private WebElement selectconform;
	
	@FindBy(xpath="(//div[@class=\"display-5\"])[2]")
	private WebElement pendingnum;
	
	@FindBy(xpath="(//div[@class=\"display-5\"])[1]")
	private WebElement confirmnum;
	
	@FindBy(xpath="//a[text()='Website']")
	private WebElement website;
	
	@FindBy(xpath="//div[text()='Cancelled Bookings']")
	private WebElement cancel;
	
	@FindBy(xpath="//button[@class='btn btn-danger mdc-ripple-upgraded']")
	private WebElement cancelinvoice;
	
	
	public void clickAdminBooking() {
		bookings.click();
	}
	
	public void clickAdminInvoice() {
		invoice.click();
	}
	
	public void clickAdminPaidInvoice() {
		invoice1.click();
	}
	
	public boolean getStatus() {
		boolean status = checkstatus.getText().contains("paid");
		return status;
	}
	public boolean getStatus1() {
		boolean status = checkstatus1.getText().contains("paid");
		return status;
	}
	
	public boolean getStatusfinal() {
		boolean status = checkstatusfinal.getText().contains("paid");
		return status;
	}
	
	public boolean getPaidStatus() {
		boolean status = checkstatuspaid.getText().contains("Paid");
		return status;
	}
	
	public void deleteAdminInvoice() throws Exception {
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("window.scrollBy(100,0)");
		deleteinvoice.click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
	}
	
	public void cancelAdminInvoice() throws Exception {
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("window.scrollBy(100,0)");
		cancelinvoice.click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
	}
	
	public void clickPending() {
		pending.click();
	}
	public void selectPending() {
		selectpending.click();
	}
	public void selectConform() {
		selectconform.click();
	}
	
	public String numPending() {
		String num = pendingnum.getText();
		return num;
	}
	
	public String numConfirm() {
		String num = confirmnum.getText();
		return num;
	}
	
	public void selectWbsite() {
		website.click();
	}
	
	public void cancelBooking() {
		cancel.click();
	}
	public void paidBooking() {
		paidbooking.click();
	}
	
}
