package Selenium_Test;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

//import Selenium_Test.AmazonElements;

public class Automation extends Reusable {

	//static WebDriver driver = new FirefoxDriver();
	//static WebDriver driver = new ChromeDriver();
	static WebDriver driver = new InternetExplorerDriver();
	// Tc1
	public static void TC1() throws Exception {

		
		// Step1: Amazon Web Page
		driver.get("https://www.amazon.com/");
		String actualTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		String expectedTitle = driver.getTitle();
		System.out.println(expectedTitle);
		//Update_Report("Pass", "Amazon", "Amazon Website", driver);
		Report_Update(expectedTitle, actualTitle,"Open website", "Amazon Webpage is Displayed", "Amazon Webpage is not Displayed");

		// Step2: Search Iphone 6
		Thread.sleep(3000);
		System.out.println("Ex1");
		WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		enterText(searchBox, "Iphone 6", "Search");

		WebElement go = driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input"));
		clickButton(go, "Go");

		String actualTitle2 = "Amazon.com: Iphone 6 - Unlocked Cell Phones / Cell Phones: Cell Phones & Accessories";
		String expectedTitle2 = driver.getTitle();
		Report_Update(expectedTitle2, actualTitle2, "Verify Iphone6","Iphone 6 is Dispalyed", "Iphone 6 is not Dispalyed");

		// Step3: iphone 6 Product page

		driver.findElement(By.xpath("//*[@id='result_3']/div/div/div/div[2]/div[1]/div[1]/a/h2")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);

		// Step4:Check the count in the cart.
		driver.findElement(By.xpath("//*[contains(@href,'/gp/cart/view.html/ref=nav_cart')]")).click();
		String count = driver.findElement(By.id("nav-cart-count")).getText();
		System.out.println(count);
		String actualCount = "1";
		// String expectedTitle3 = AmazonElements.Title();
		Report_Update(count, actualCount,"CartCount", "1 Phone", "No Phone");
		driver.quit();
	}

	// Tc2
	public static void TC2() throws Exception {

		
		// Step1 : Navigate to Amazon.com
		driver.get("https://www.amazon.com");
		String actualTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		String expectedTitle = driver.getTitle();
		Report_Update(expectedTitle, actualTitle,"Amazon website", "Amazon Webpage is Displayed", "Amazon Webpage is not Displayed");

		// Step2: hover over the mouse on Departments
		// Department
		WebElement department = driver.findElement(By.xpath("//*[@id='nav-link-shopall']/span[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(department).build().perform();

		if (department.isDisplayed()) {
			String text = department.getText();
			String expectedText = "Departments";
			System.out.println(text);
			Report_Update(expectedText, text,"Mouse-Department", "Department Link is Dispalyed", "Department Link is not Dispalyed");
		}

		//// Step3:Check if Your Amazon.com is present
		// Your Amazon.Com
		WebElement amazonLink = driver.findElement(By.xpath("//a[contains(.,'Your Amazon.com')]"));
		// action.moveToElement(amazonLink).build().perform();
		if (amazonLink.isDisplayed()) {
			String text2 = amazonLink.getText();
			String expectedText2 = "Your Amazon.com";
			Report_Update(expectedText2, text2,"Your Amazon", "Amazon Link is Dispalyed", "Amazon Link is not Dispalyed");
			System.out.println(text2);
		}

		// Step4: Check if Today's Deals is present
		// Today's Deals
		WebElement Deals = driver.findElement(By.xpath("//a[contains(@href,'/gp/goldbox/ref=nav_cs_gb')]"));
		// action.moveToElement(Deals).build().perform();
		if (Deals.isDisplayed()) {
			String text3 = Deals.getText();
			String expectedText3 = "Today's Deals";
			Report_Update(expectedText3, text3, "Todays Deals","Deals Link is Dispalyed", "Deals Link is not Dispalyed");
			System.out.println(text3);
		}
		driver.quit();
	}

	// Tc3
	public static void TC3() throws Exception {

		
		// Step1 : Navigate to Amazon.com
		driver.get("https://www.amazon.com");
		String actualTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		String expectedTitle = driver.getTitle();
		Report_Update(expectedTitle, actualTitle, "Amazon Website","Amazon Webpage is Displayed", "Amazon Webpage is not Displayed");

		// Step2 : Department
		WebElement department = driver.findElement(By.xpath("//*[@id='nav-link-shopall']/span[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(department).build().perform();

		if (department.isDisplayed()) {
			String text = department.getText();
			String expectedText = "Departments";
			System.out.println(text);
			Report_Update(expectedText, text,"Amazon-Mouse", "Department Link is Dispalyed", "Department Link is not Dispalyed");
		}

		// Step3: Links in Department
		List<WebElement> departmentLinks = driver.findElements(By.xpath("//*[@id='nav-flyout-shopAll']/div[2]/span"));

		for (WebElement e : departmentLinks) {
			System.out.println(e.getText());
			
		}
		WebElement Full = driver.findElement(By.xpath("//*[@id='nav-flyout-shopAll']/div[2]/a/span"));
		departmentLinks.add(Full);
		System.out.println(departmentLinks.size() - 1);

		List<String> ExpectedLinks = new ArrayList<>();
		ExpectedLinks.add("Amazon Video");
		ExpectedLinks.add("Amazon Music");
		ExpectedLinks.add("Appstore for Android");
		ExpectedLinks.add("Kindle E-readers & Books");
		ExpectedLinks.add("Fire Tablets");
		ExpectedLinks.add("Fire TV");
		ExpectedLinks.add("Echo & Alexa");
		ExpectedLinks.add("AmazonFresh");
		ExpectedLinks.add("Books & Audible");
		ExpectedLinks.add("Movies, Music & Games");
		ExpectedLinks.add("Electronics, Computers & Office");
		ExpectedLinks.add("Home, Garden & Tools");
		ExpectedLinks.add("Food & Grocery");
		ExpectedLinks.add("Beauty & Health");
		ExpectedLinks.add("Toys, Kids & Baby");
		ExpectedLinks.add("Clothing, Shoes & Jewelry");
		ExpectedLinks.add("Handmade");
		ExpectedLinks.add("Sports & Outdoors");
		ExpectedLinks.add("Automotive & Industrial");
		ExpectedLinks.add("Home Services");
		ExpectedLinks.add("Credit & Payment Products");
		ExpectedLinks.add("Full Store Directory");

		List<String> strings = new ArrayList<String>();

		for (WebElement e : departmentLinks) {
			strings.add(e.getText());
		}
		if (strings.size() - 1 == 21) {
			System.out.println("Pass");
			Update_Report("Pass", "Verify Department ", "All Links are Present", driver);
		} else {
			Update_Report("Fail", "Verify Department", " Links do not match", driver);
		}

		driver.quit();

	}

	public static void TC4() throws Exception {
		
		
		// Step1 : Navigate to Amazon.com
		driver.get("https://www.amazon.com");
		String actualTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		String expectedTitle = driver.getTitle();
		Report_Update(expectedTitle, actualTitle, "Amazon Website","Amazon Webpage is Displayed", "Amazon Webpage is not Displayed");
		
		////Step2: SignIn DropDown
		WebElement SignIn = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
		Actions action = new Actions(driver);
		action.moveToElement(SignIn).build().perform();
		System.out.println(SignIn.getText());
		
		if (SignIn.isDisplayed()) {
			Update_Report("Pass", "Verify Sign ", "Sign In Link is Present", driver);
		} else {
			Update_Report("Fail", "Verify Sign", " Sign In Link is not Present", driver);
		}
		
		//Step3: Your Account Elements
		List<WebElement> SigninList = driver.findElements(By.xpath("//*[@id='nav-al-your-account']/a"));
		
		List<String> signString = new ArrayList<String>();

		for (WebElement e : SigninList) {
			signString.add(e.getText());
		}
		
		for (String e : signString) {
			System.out.println(e);
		}
		
		if (signString.size()  == 20) {
			System.out.println("Pass");
			Update_Report("Pass", "Account Ele ", "All Links are Present", driver);
		} else {
			Update_Report("Fail", "Account Ele ", " Links do not match", driver);
		}

		driver.quit();

	}

	public static void TC5() throws Exception {
		
		// Step1 : Navigate to Amazon.com
		driver.get("https://www.amazon.com");
		String actualTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		String expectedTitle = driver.getTitle();
		Report_Update(expectedTitle, actualTitle,"Amazon Website", "Amazon Webpage is Displayed", "Amazon Webpage is not Displayed");
		
		// Step2: Search Item is Present?
		WebElement search = driver.findElement(By.xpath("//*[@id='nav-search']/form/div[1]/div/div"));
		
		if (search.isDisplayed()) {
			System.out.println("Search Passed");
			Update_Report("Pass", "SearchItem ", "Search Icon is present", driver);
		} else {
			Update_Report("Fail", "SearchItem", " Search Icon is not Present", driver);
		}
		
		//Step3: Search is Clicked
		search.click();
		if (search.isEnabled()) {
			Update_Report("Pass", "Click ", "Search is clicked", driver);
		} else {
			Update_Report("Fail", "Click ", " Search is not clicked", driver);
		}
		
		//Step4: Clothing Links are Present
		if (driver.findElement(By.xpath("//*[@id='searchDropdownBox']/option[15]")).isDisplayed()) {
			System.out.println("Clothing is Present");
			if (driver.findElement(By.xpath("//*[@id='searchDropdownBox']/option[16]")).isDisplayed()) {
				System.out.println("Women is present");
				if (driver.findElement(By.xpath("//*[@id='searchDropdownBox']/option[17]")).isDisplayed()) {
					System.out.println("Men is Preset");
					if (driver.findElement(By.xpath("//*[@id='searchDropdownBox']/option[18]")).isDisplayed()) {
						System.out.println("Girl is Preset");
						if (driver.findElement(By.xpath("//*[@id='searchDropdownBox']/option[19]")).isDisplayed()) {
							System.out.println("Boy is Preset");
							if (driver.findElement(By.xpath("//*[@id='searchDropdownBox']/option[20]")).isDisplayed()) {
								System.out.println("Baby is Preset");
								Update_Report("Pass", "Clothing-Sub ", "All Clothing Links are Present", driver);
							} else {
								Update_Report("Fail", "Clothing-Sub ", " All Clothing Links are not Present", driver);
							}
						}
					}
				}
			}
		}	
			
		
		driver.quit();
	}

	public static void TC6()throws Exception {
		
		// Step1 : Navigate to Amazon.com
		driver.get("https://www.amazon.com");
		String actualTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		String expectedTitle = driver.getTitle();
		Report_Update(expectedTitle, actualTitle,"AmazonWebsite", "Amazon Webpage is Displayed", "Amazon Webpage is not Displayed");
		
		//Step2: Search for
		WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		enterText(searchBox, "Iphone 6S", "Search");

		WebElement go = driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input"));
		clickButton(go, "Go");

		String actualTitle2 = "Amazon.com: Iphone 6S: Cell Phones & Accessories";
		String expectedTitle2 = driver.getTitle();
		System.out.println(expectedTitle2 + "");
		Report_Update(expectedTitle2, actualTitle2,"Search", "Iphone 6S is Dispalyed", "Iphone 6S is not Dispalyed");
		
		// Step3&4: iphone 6 Product page

		driver.findElement(By.xpath("//*[@id='result_3']/div/div/div/div[2]/div[1]/div[1]/a/h2")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);

		// Step5: Select the cart.
		driver.findElement(By.xpath("//*[contains(@href,'/gp/cart/view.html/ref=nav_cart')]")).click();
		String carttitle = driver.getTitle();
		
		String actualtitle = "Amazon.com Shopping Cart";
		// String expectedTitle3 = AmazonElements.Title();
		Report_Update(carttitle, actualtitle,"Cart", "The cart page", "Wrong Page");

		//Step6		
		WebElement delete = driver.findElement(By.xpath("//*[@id='activeCartViewForm']/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/span[1]/span/input"));
		delete.click();
		if(delete.isDisplayed()){
			Update_Report("Pass", "TC6 Delete ", "Delte button is Removed", driver);
		} else {
			Update_Report("Fail", "TC6 Delete"," Delte button is not Removed", driver);
		}
		
		Thread.sleep(3000);
		String count = driver.findElement(By.id("nav-cart-count")).getText();
		System.out.println(count);
		String actualCount = "0";
		Report_Update(count, actualCount,"Cart Update", "CArt Value is Zero", "Cart value is not Zero");
		
		Thread.sleep(3000);

		driver.quit();
	}

	public static void TC7() throws Exception {
		
				// Step1: Amazon Web Page
		driver.get("https://www.amazon.com/");
		String actualTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		String expectedTitle = driver.getTitle();
		Report_Update(expectedTitle, actualTitle,"Amazon Webpage", "Amazon Webpage is Displayed", "Amazon Webpage is not Displayed");

		// Step2: Click on Help
		WebElement help = driver.findElement(By.xpath("//*[@id='nav-xshop']/a[5]"));
		help.click();
		String helpTitle = driver.getTitle();

		String actualtitle = "Amazon.com Help";
		Report_Update(helpTitle, actualtitle,"ClickHelp", "The Help page", "Wrong Page");
		
		//Step3: Heading
		String message ="Hello. What can we help you with?";
		String hMessage = driver.findElement(By.xpath("//h1[contains(.,'Hello.')]")).getText();
		if(hMessage.equals(message)){
			Update_Report("Pass", "TC7 Heading", "Heading Matched", driver);
		} else {
			Update_Report("Fail", "TC7 Heading"," Heading not x	Matched", driver);
		}
		
		//Step4: Help Menu
		if (driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[1]/div[1]/div/div[2]/a"))
				.isDisplayed()) {
			System.out.println("Your Orders");

			if (driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[1]/div[2]/div/div[2]/a"))
					.isDisplayed()) {
				System.out.println("Returns and Refunds");

				if (driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[1]/div[3]/div/div[2]/a"))
						.isDisplayed()) {
					System.out.println("Device Support");

					if (driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/div[2]/a"))
							.isDisplayed()) {
						System.out.println("Manage Prime");

						if (driver
								.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[2]/div/div[2]/a"))
								.isDisplayed()) {
							System.out.println("Payments");

							if (driver
									.findElement(
											By.xpath("/html/body/div[2]/div[3]/div/div[1]/div[2]/div[3]/div/div[2]/a"))
									.isDisplayed()) {
								Update_Report("Pass", "TC7 6 Menu", "^Menu is displayed", driver);
							} else {
								Update_Report("Fail", "TC7 6 Menu", "^Menu is not displayed", driver);
							}
						}
					}
				}
			}
		}
		
		//Step5: Search Box
		if(driver.findElement(By.xpath("//*[@id='helpsearch']")).isDisplayed()){
			System.out.println("Search Box is displayed");
			Update_Report("Pass", "TC7 Menu Search", "Search Box is displayed", driver);
		} else {
			Update_Report("Fail", "TC6 Menu Search", "Search Box is not displayed", driver);
		}
		
		driver.quit();
	}
	
	public static void TC8() throws Exception {
		
		
		// Step1: Amazon Web Page
		driver.get("https://www.amazon.com/");
		String actualTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		String expectedTitle = driver.getTitle();
		Report_Update(expectedTitle, actualTitle,"Amazon", "Amazon Webpage is Displayed", "Amazon Webpage is not Displayed");

		// Step2
		WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		enterText(searchBox, "Head First Java in Books", "Search");

		WebElement go = driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input"));
		clickButton(go, "Go");

		String actualTitle2 = "Amazon.com: Head First Java in Books";
		String expectedTitle2 = driver.getTitle();
		Report_Update(expectedTitle2, actualTitle2, "Head First", "Book Found", "Book not found");

		// Step3: Head First JAva Page
		// Head First Java, 2nd Edition: Kathy Sierra, Bert Bates:
		// 8601404235726: Amazon.com: Books
		driver.findElement(By.xpath("//h2[contains(.,'Head First Java, 2nd Edition')]")).click();
		Thread.sleep(3000);
		driver.getTitle();
		String actualHeadtitle = "Head First Java, 2nd Edition: Kathy Sierra, Bert Bates: 8601404235726: Amazon.com: Books";
		String headTitle =driver.getTitle(); 
		Report_Update(headTitle, actualHeadtitle, "Head First","Page displayed", "Link not Found");

		// Step4: Enter the Quantity
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

		WebElement value = driver.findElement(By.xpath("//*[@id='a-autoid-1-announce']/span[2]"));
		value.click();

		WebElement five = driver.findElement(By.xpath("//*[@id='quantity_4']"));
		five.click();

		Thread.sleep(3000);
		String valueText = value.getText(); 
		String aCtualValue = "5";
		Report_Update(valueText, aCtualValue,"Quantity", "5  ", "!5");
		
		driver.findElement(By.id("add-to-cart-button")).click();
		// Step5: Check the Count
		String count = driver.findElement(By.id("nav-cart-count")).getText();
		System.out.println(count);
		String actualCount = "5";
		// String expectedTitle3 = AmazonElements.Title();
		Report_Update(count, actualCount,"CartCount", "5", "!5");
		
		
	}
	
	public static void TC9() throws Exception{
		
		
		//Step1: 5 Quantity in Cart
		TC8();
		WebElement cartButton = driver.findElement(By.xpath("//*[@id='hlb-view-cart-announce']"));
		cartButton.click();
		String cartTitle = driver.getTitle();
		Report_Update(cartTitle, "Amazon.com Shopping Cart", "Cart ","Page is Displayed", "Different page is Displayed");
		
		//Step2: Update the quantity to 4
		WebElement quantity = driver.findElement(By.xpath("//*[@id='a-autoid-2-announce']"));
		quantity.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='dropdown1_3']")).click();
		Thread.sleep(3000);
		
		String count = driver.findElement(By.id("nav-cart-count")).getText();
		System.out.println(count);
		String actualCount = "4";
		// String expectedTitle3 = AmazonElements.Title();
		Report_Update(count, actualCount, "UpdateCount","4", "!4");
		
		WebElement save = driver.findElement(By.xpath("//*[@id='activeCartViewForm']/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/span[2]/span/input"));
		save.click();
		
		Thread.sleep(3000);
		WebElement move = driver.findElement(By.xpath("//*[@id='savedCartViewForm']/div[3]/div/div[4]/div/div[1]/div/div/div[2]/div/span[2]/span/input"));
		if(move.isDisplayed()){
			System.out.println("pass");
			Update_Report("Pass", "TC9 Saved", "Item is saved for later", driver);
		} else {
			Update_Report("Fail", "TC9 Saved", "Item is not saved for later", driver);
		}
		
		driver.quit();
	}

	
	

	
}