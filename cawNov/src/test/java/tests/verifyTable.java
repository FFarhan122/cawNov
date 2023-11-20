package tests;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import tests.Data;

public class verifyTable extends Data
{
	static String text;
	public static void main(String[] args) 
		{
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\browserFile\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
			driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
			
			WebElement tableData = driver.findElement(By.xpath("//summary[text() = 'Table Data']"));
			tableData.click();
			
			WebElement insertBox = driver.findElement(By.xpath("//textarea[@id='jsondata']"));
			insertBox.clear();
			insertBox.sendKeys(Data.data());
			
			WebElement refreshButton = driver.findElement(By.xpath("//button[@id='refreshtable']"));
			refreshButton.click();
	
			
			System.out.println(s);
			
			for(int j = 2;j<7;j++)
			{
			List<WebElement> table = driver.findElements(By.xpath("//table[@id='dynamictable']//tr["+j+"]//td"));
			int cellSize = table.size();
			for(int i = 0;i<cellSize;i++)
			{
				text =table.get(i).getText()+ ",";
				System.out.print(text);
			}
			System.out.println();
			}
			
			
			Assert.assertEquals(text,exp);
		}

}
