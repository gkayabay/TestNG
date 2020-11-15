package SelfTestNG;

import org.testng.Assert;
import org.testng.annotations.*;

import com.utils.CommonMethods;

public class Assertion extends CommonMethods {
	
	@BeforeMethod
	public void openBrowser () {	
		setUp();
	}
	
	@Test
	public void titleValidation () {	
		String expectedTitle = "Online Bookstore: Books, NOOK ebooks, Music, Movies & Toys | Barnes & Noble®";
		String actualTitle= driver.getTitle();
		//System.out.println(driver.getTitle());
		Assert.assertEquals(actualTitle, expectedTitle, "Titles are matched");
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
