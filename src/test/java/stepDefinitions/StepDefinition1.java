package stepDefinitions;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.phptravels.AdminPage;
import page.objects.phptravels.AgentPage;
import page.objects.phptravels.CustomerPage;
import page.objects.phptravels.LoginPage;
import page.objects.phptravels.SupplierPage;

public class StepDefinition1 {

	public WebDriver driver;
	public CustomerPage customer;
	public LoginPage login;
	public AgentPage agent;
	public AdminPage admin;
	public SupplierPage supplier;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		driver=new ChromeDriver();
		customer=new CustomerPage(driver);
		login=new LoginPage(driver);
		agent=new AgentPage(driver);
		admin=new AdminPage(driver);
		supplier=new SupplierPage(driver);
	}

	@When("user open url {string}")
	public void user_open_url(String url) throws InterruptedException {
		Thread.sleep(2000);
		driver.get(url);
	    Thread.sleep(2000);
	    driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String Email, String Password) throws InterruptedException {
		Thread.sleep(1000);
		login.userEmail(Email);
		Thread.sleep(1000);
		login.userPassword(Password);
	}

	@When("click Login button")
	public void click_login_button() throws InterruptedException {
		Thread.sleep(1000);
		login.clickLogin();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		Thread.sleep(2000);
		String actual = driver.getTitle();
		Assert.assertEquals(title, actual);
	}

	@When("user click on My Booking link")
	public void user_click_on_my_booking_link() throws InterruptedException {
		Thread.sleep(2000);
		customer.clickMyBooking();
	}

	@When("user click on My Profile link")
	public void user_click_on_my_profile_link() throws InterruptedException {
		Thread.sleep(2000);
		customer.clickMyProfile();
	}

	@Then("user click on Logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		Thread.sleep(2000);
		customer.clickLogout();
	}

	@When("user click on Add_Funds link")
	public void user_click_on_add_funds_link() throws InterruptedException {
		Thread.sleep(2000);
		customer.clickAddFunds();
	}

	@Then("user can select radio button as pay with paypal")
	public void user_can_select_radio_button_as_pay_with_paypal() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor ex= (JavascriptExecutor)driver;
		ex.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		customer.clickPaywithPaypal();
	}

	@When("user click on paynow button for payment")
	public void user_click_on_paynow_button_for_payment() throws InterruptedException {
		Thread.sleep(2000);
		customer.clickPayNow();
	}

	@Then("page for paypal payment url should contain {string}")
	public void page_for_paypal_payment_url_should_contain(String title) throws InterruptedException {
		Thread.sleep(2000);
		if(driver.getCurrentUrl().contains(title)){
	    	Assert.assertTrue(true);}
		else {
			Assert.assertTrue(false);
		}
	}
	

	@Then("user can check the bookings")
	public void user_can_check_the_bookings() throws InterruptedException {
		Thread.sleep(2000);
		boolean checkbooking=customer.getCheckBookings();
		if(checkbooking==true) {
			System.out.println("The User Viewed Total Booking" );
		}
		else {
			System.out.println("The User Can't Viewed Total Booking");
		}
		
	}

	@When("user can click on view voucher button")
	public void user_can_click_on_view_voucher_button() throws InterruptedException {
		Thread.sleep(2000);
		String oldTab = driver.getWindowHandle();
		customer.clickVoucher();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(oldTab);
	    driver.switchTo().window(newTab.get(0));
	}

	@Then("download button for voucher is Enable")
	public void download_button_for_voucher_is_enable() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor ex= (JavascriptExecutor)driver;
		ex.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
		boolean invoice = customer.downloadInvoice();
		Assert.assertTrue(invoice);
	}

	@When("user can click on My Profile button")
	public void user_can_click_on_my_profile_button() throws InterruptedException {
		Thread.sleep(2000);
		customer.clickMyProfile();
	}

	@Then("navigate to profile page")
	public void navigate_to_profile_page() throws InterruptedException {
		Thread.sleep(2000);
		if(driver.getCurrentUrl().contains("profile")){
	    	Assert.assertTrue(true);}
		else {
			Assert.assertTrue(false);
		}
	}

	@Then("user can edit the Address as {string}")
	public void user_can_edit_the_address_as(String address) throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor ex= (JavascriptExecutor)driver;
		ex.executeScript("window.scrollBy(0,800)");
		customer.strAddress(address);
		ex.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
		customer.clickUpdate();
	}

	@Then("user read the message as Profile updated successfully.")
	public void user_read_the_message_as_profile_updated_successfully() throws InterruptedException {
		Thread.sleep(2000);
		boolean sucess=customer.checkUpdatesucessText();
		if(sucess==true) {
			System.out.println("The Profile Updated Sucessfully" );
		}
		else {
			System.out.println("The Profile Not Updated");
		}
	}
	
//AgentPage
	
	@When("user click on Agent My booking Link")
	public void user_click_on_agent_my_booking_link() throws InterruptedException {
		Thread.sleep(2000);
		customer.clickMyBooking();
	}

	@When("user click on Agent Add_funds Link")
	public void user_click_on_agent_add_funds_link() throws InterruptedException {
		Thread.sleep(2000);
		customer.clickAddFunds();
	}
	@When("agent click on My Profile Link")
	public void agent_click_on_my_profile_link() throws InterruptedException {
		Thread.sleep(2000);
		customer.clickMyProfile();
	}

	@Then("user click on Logout")
	public void user_click_on_logout() throws InterruptedException {
		Thread.sleep(2000);
		customer.clickLogout();
	}

	@When("user click on Hotels Link")
	public void user_click_on_hotels_link() throws InterruptedException {
		Thread.sleep(2000);
		agent.clickHotels();
	}

	@When("user click on Flights Link")
	public void user_click_on_flights_link() throws InterruptedException {
		Thread.sleep(2000);
		agent.clickFlights();
	}

	@Then("user click on Visa Link")
	public void user_click_on_visa_link() throws InterruptedException {
		Thread.sleep(2000);
		agent.clickVisa();
	}

	@When("user click on Tours Link")
	public void user_click_on_tours_link() throws InterruptedException {
		Thread.sleep(2000);
		agent.clickTours();
	}

	@Then("user click on Blog Link")
	public void user_click_on_blog_link() throws InterruptedException {
		Thread.sleep(2000);
		agent.clickBlog();
	}

	@Then("user click on Offers Link")
	public void user_click_on_offers_link() throws InterruptedException {
		Thread.sleep(2000);
		agent.clickOffers();
	}

	@When("user click on Home Logo")
	public void user_click_on_home_logo() throws InterruptedException {
		Thread.sleep(2000);
		agent.clickHome();
	}

	@When("user can enter {string} on city name field")
	public void user_can_enter_on_city_name_field(String cityname) throws InterruptedException {
		Thread.sleep(3000);
		agent.clickCityName();
		Thread.sleep(3000);
		agent.strCityName(cityname);
		Thread.sleep(3000);
		agent.selectOption();
	}

	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
		Thread.sleep(2000);
		agent.clickSearch();
	}

	@Then("Then Page title should be {string}")
	public void then_page_title_should_be(String title) throws InterruptedException {
		Thread.sleep(2000);
		String actual = driver.getTitle();
		Thread.sleep(2000);
		Assert.assertEquals(title, actual);
	}

	@When("user click on USD dropdown menu")
	public void user_click_on_usd_dropdown_menu() throws InterruptedException {
		Thread.sleep(2000);
		agent.clickCurrency();
	}

	@When("user can select INR from dropdowm menu")
	public void user_can_select_inr_from_dropdowm_menu() throws InterruptedException {
		Thread.sleep(2000);
	    agent.updateCurrency();
	}
	@Then("navigate to home page and user can view INR instead of USD")
	public void navigate_to_home_page_and_user_can_view_inr_instead_of_usd() throws InterruptedException {
		Thread.sleep(2000);
		String inr=agent.checkINRupdate();
		Assert.assertEquals(inr, "INR");
	}

	
	//Admin Page
	
	@When("admin enters Email as {string} and password as {string}")
	public void admin_enters_email_as_and_password_as(String email, String password) throws InterruptedException {
		Thread.sleep(3000);
		login.adminEmail(email);
		Thread.sleep(1000);
		login.adminPassword(password);
	}

	@When("admin click Login button")
	public void admin_click_login_button() throws InterruptedException {
		Thread.sleep(1000);
		login.clickAdminLogin();
		Thread.sleep(3000);
	}

	@When("admin click on Bookings Link")
	public void admin_click_on_bookings_link() throws InterruptedException {
		Thread.sleep(2000);
	    admin.clickAdminBooking();
	}

	@Then("admin click on paid booking link")
	public void admin_click_on_paid_booking_link() throws InterruptedException {
		Thread.sleep(2000);
		admin.paidBooking();
	}

	@When("user click on invoice button")
	public void user_click_on_invoice_button() throws InterruptedException {
		Thread.sleep(2000);
		String oldTab = driver.getWindowHandle();
		admin.clickAdminPaidInvoice();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(oldTab);
	    driver.switchTo().window(newTab.get(0));
	}

	@Then("user can check the payment status is paid")
	public void user_can_check_the_payment_status_is_paid() throws InterruptedException {
		Thread.sleep(2000);
		boolean status1=admin.getPaidStatus();
		if(status1==true) {
			System.out.println("The payment is sucessful " );
		}
		else {
			System.out.println("The payment is unsucessful ");
		}
	}

	@When("admin click on Cancelled booking Link")
	public void admin_click_on_cancelled_booking_link() throws InterruptedException {
		Thread.sleep(2000);
		admin.cancelBooking();
	}

	@When("user click on delete button and invoice should be deleted after accepting alert message")
	public void user_click_on_delete_button_and_invoice_should_be_deleted_after_accepting_alert_message() throws Exception {
		Thread.sleep(2000);
		admin.cancelAdminInvoice();
	}

	@When("admin click on Pending booking Link on dashboard")
	public void admin_click_on_pending_booking_link_on_dashboard() throws InterruptedException {
		Thread.sleep(2000);
		admin.clickPending();
	}

	@Then("the count before change the status is verified by admin")
	public void the_count_before_change_the_status_is_verified_by_admin() throws InterruptedException {
		Thread.sleep(3000);
		 String oldnum = admin.numPending();
		 String oldnumc = admin.numConfirm();
		 System.out.println("The old pending count is: "+ oldnum);
		 System.out.println("The old confirmed count is: "+ oldnumc);
	}

	@Then("admin click on booking status pending dropdown and change to confirmed")
	public void admin_click_on_booking_status_pending_dropdown_and_change_to_confirmed() throws InterruptedException {
		Thread.sleep(2000);
		admin.selectPending();
		Thread.sleep(2000);
		admin.selectConform();
	}

	@Then("the count after change the status in dashbord is verified by admin")
	public void the_count_after_change_the_status_in_dashbord_is_verified_by_admin() throws InterruptedException {
		Thread.sleep(2000);
		 String newnump = admin.numPending();
		 String newnumc = admin.numConfirm();
		 System.out.println("The new pending count is: "+ newnump);
		 System.out.println("The new confirmed count is: "+ newnumc);
	}

	@When("admin click on Website link")
	public void admin_click_on_website_link() throws InterruptedException {
		Thread.sleep(3000);
		String oldTab = driver.getWindowHandle();
		admin.selectWbsite();
		Thread.sleep(3000);
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(oldTab);
	    driver.switchTo().window(newTab.get(0));
	    Thread.sleep(3000);
	}
	
	
	
	
	//SupplierPage
	
	
	
	@When("supplier open url {string}")
	public void supplier_open_url(String supplierurl) throws InterruptedException {
		Thread.sleep(2000);
		driver.get(supplierurl);
		   Thread.sleep(1000);
		   driver.manage().window().maximize();
	}

	@When("supplier enters Email as {string} and password as {string}")
	public void supplier_enters_email_as_and_password_as(String Email, String Password) throws InterruptedException {
		Thread.sleep(3000);
		login.adminEmail(Email);
		Thread.sleep(1000);
		login.adminPassword(Password);
	}

	@When("supplier click Login button")
	public void supplier_click_login_button() throws InterruptedException {
		Thread.sleep(1000);
		login.clickAdminLogin();
	}

	@When("supplier enters dashboard and can view Sales Overview and summary text")
	public void supplier_enters_dashboard_and_can_view_sales_overview_and_summary_text() throws InterruptedException {
		Thread.sleep(2000);
		boolean summaryview= supplier.summaryView();
	  if(summaryview==true) {
		  System.out.println("The User can view ");
	  }
	  else {
		  System.out.println("The User can't view Sales Overview and summary");
	  }
	}

	@Then("supplier can verify the summary text on dashboard")
	public void supplier_can_verify_the_summary_text_on_dashboard() throws InterruptedException {
		Thread.sleep(2000);
		 String text= supplier.getText1();
	 Assert.assertEquals(text, "Sales overview & summary");
	}

	@When("supplier enters dashboard can view Revenue breakdown text")
	public void supplier_enters_dashboard_can_view_revenue_breakdown_text() throws InterruptedException {
		Thread.sleep(2000);
	
		boolean summaryview= supplier.revenueView1();
		  if(summaryview==true) {
			  System.out.println("The User can view ");
		  }
		  else {
			  System.out.println("The User can't view Revenue breakdown");
		  }
	   
	}
	@Then("supplier can verify the revenue text on dashboard")
	public void supplier_can_verify_the_revenue_text_on_dashboard() throws InterruptedException {
		Thread.sleep(2000);
		String text = supplier.getText2();
		Assert.assertEquals(text, "Revenue Breakdown 2023");
	}

	@When("supplier enters dashboard verify the count before changing the booking status")
	public void supplier_enters_dashboard_verify_the_count_before_changing_the_booking_status() throws InterruptedException {
		Thread.sleep(2000);
		 String oldnum = supplier.numPendingSupplier();
		 String oldnumc = supplier.numConfirmSupplier();
		 System.out.println("The old pending count is: "+ oldnum);
		 System.out.println("The old confirmed count is: "+ oldnumc);
	}

	@When("supplier click on pending button on dashboard")
	public void supplier_click_on_pending_button_on_dashboard() throws InterruptedException {
		Thread.sleep(2000);
		supplier.clickPending();
	}

	@Then("supplier click on booking status pending dropdown and change to confirmed")
	public void supplier_click_on_booking_status_pending_dropdown_and_change_to_confirmed() throws InterruptedException {
		Thread.sleep(2000);
		supplier.clickPending();
		Thread.sleep(2000);
		supplier.selectPendingToConfirm();
	}

	@Then("the count after change the status in dashbord is verified by supplier")
	public void the_count_after_change_the_status_in_dashbord_is_verified_by_supplier() throws InterruptedException {
		Thread.sleep(2000);
		supplier.backToDash();
		 String oldnum = supplier.numPendingSupplier();
		 String oldnumc = supplier.numConfirmSupplier();
		 System.out.println("The new pending count is: "+ oldnum);
		 System.out.println("The new confirmed count is: "+ oldnumc);
	}

	@When("supplier click on flight link")
	public void supplier_click_on_flight_link() {
		 System.out.println("Flight Link is Missing consider as BUG");
		 Assert.assertTrue("Bug", false);
	}

	@When("supplier click on Visa link")
	public void supplier_click_on_visa_link() {
		 System.out.println("Visa Link is Missing consider as BUG");
		 Assert.assertTrue("Bug", false);
	}

	@When("supplier click on Tours link")
	public void supplier_click_on_tours_link() throws InterruptedException {
		Thread.sleep(2000);
		supplier.getTours();
	}

	@When("supplier click on Bookings link")
	public void supplier_click_on_bookings_link() throws InterruptedException {
		Thread.sleep(1000);
		supplier.booking();
	}

	//Login
	
	@When("users enters Email as {string} and password as {string}")
	public void users_enters_email_as_and_password_as(String Email, String Password) throws InterruptedException {
		Thread.sleep(1000);
		login.userEmail(Email);
		Thread.sleep(1000);
		login.userPassword(Password);
	}

	@Then("user Page url should contain {string}")
	public void user_page_url_should_contain(String title) throws InterruptedException {
		Thread.sleep(3000);
		if(driver.getCurrentUrl().contains(title)){
			driver.close();
	    	Assert.assertTrue(true);
		}
	    	else if(driver.getCurrentUrl().contains("failed")){
			driver.close();
	    	Assert.assertTrue(true);
		}
		else if(login.getErrorEmailMsg().contains("Please fill out")) {
			driver.close();
			Assert.assertTrue(true);}
		else if(login.getErrorPassMsg().contains("Please fill out")) {
			driver.close();
			Assert.assertTrue(true);}
		Thread.sleep(3000);
	}

	@When("admin open url {string}")
	public void admin_open_url(String url) throws InterruptedException {
		Thread.sleep(2000);
		driver.get(url);
	    Thread.sleep(2000);
	    driver.manage().window().maximize();
	}

	@Then("admin Page title should contain {string}")
	public void admin_page_title_should_contain(String title) throws InterruptedException {
		Thread.sleep(2000);
		if(driver.getTitle().contains(title)) {
			driver.close();
			Assert.assertTrue(true);
		} 
		else if(driver.getTitle().contains("Administator Login"))
		{
			Assert.assertTrue(true);
		}
	}

	@Then("supplier Page title should contain {string}")
	public void supplier_page_title_should_contain(String title) throws InterruptedException {
		Thread.sleep(2000);
		
		if(driver.getTitle().contains(title)) {
			driver.close();
			Assert.assertTrue(true);
		} 

		else if(login.getErrorMsgsupp().contains("Invalid Login Credentials")) {
			Assert.assertTrue(true);
		}
		else if(login.getErrorMsgsupp().contains("The Email field is required")) {
			Assert.assertTrue(true);
		}
		else if(login.getErrorMsgsupp().contains("The Password field is required")) {
			Assert.assertTrue(true);
		}
	}

	
	@After
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
