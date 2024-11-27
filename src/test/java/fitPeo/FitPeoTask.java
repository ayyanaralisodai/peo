package fitPeo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FitPeoTask {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// 1- Navigate to FitPeo Homepage
		driver.get("https://www.fitpeo.com/");

		// 2 - Navigate to Revenue Calculator Page
		driver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();

		// 3 - Scroll down the page to Revenue Calculator 
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Scroll down
		jse.executeScript("window.scrollBy(0,450)");


		// 4 -  Adjust Slider to 820
		WebElement sliderHandle = driver.findElement(By.xpath("//input[@data-index='0']"));
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(sliderHandle, 93, 0).perform();

	
//		 5 - Update the Text Field
		WebElement val = driver.findElement(By.xpath("//input[@id=\":r0:\"]"));
		 val.clear();
		//WebElement val2 = driver.findElement(By.xpath("//input[@id=\":R57alklff9da:\"]"));
		val.sendKeys("560");
		

//		// 7 - Select CPT Codes:
		jse.executeScript("window.scrollBy(0,450)");
		Thread.sleep(3000);

		WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));

		WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		WebElement checkBox3 = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));

		checkBox1.click();
		checkBox2.click();
		checkBox3.click();

		jse.executeScript("window.scrollBy(0,550)");
		WebElement checkBox4 = driver.findElement(By.xpath("(//input[@type='checkbox'])[8]"));
		checkBox4.click();
		
		// 8 - Validate Total Recurring Reimbursement:
		WebElement total = driver.findElement(By.xpath("//div[@class=\"MuiBox-root css-m1khva\"]//child::p[@class=\"MuiTypography-root MuiTypography-body1 inter css-12bch19\"]"));
		String text = total.getText();
		System.out.println("Validated the Total Recurring Reimbursement: = "+text);
		
		
		// 9 - Verify that the header displaying Total Recurring 
		WebElement verify = driver.findElement(By.xpath("(//div[@class=\"MuiBox-root css-rfiegf\"]//child::header[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-elevation4 MuiAppBar-root "
				+ "MuiAppBar-colorDefault MuiAppBar-positionFixed mui-fixed css-nq2yav\"]//child::p[@class=\"MuiTypography-root MuiTypography-body1 inter css-1bl0tdj\"])[4]"));
		 String text1 = verify.getText();
		if (text.equals(text1)) {
			System.out.println(" Total Recurring Reimbursement for all Patients Per Month value is " +text1 );
		}else {
			System.out.println("Not Equal");
			
		}
			driver.quit();
		}
	
	}






