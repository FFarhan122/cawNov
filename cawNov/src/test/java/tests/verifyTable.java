package tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.lang.Object;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class verifyTable
{
	private static String readJsonFile(String filePath) 
	{
        // Read the entire JSON file as a string
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return "{}"; // Return an empty JSON object if an error occurs
        }
    }
	
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
		String jsonString = readJsonFile("C:\\Users\\hp\\git\\cawNov\\cawNov\\src\\test\\java\\tests\\data.json");
		insertBox.sendKeys(jsonString);
		
		WebElement refreshButton = driver.findElement(By.xpath("//button[@id='refreshtable']"));
		refreshButton.click();
		Object obj = JSONValue.parse(jsonString);
	    JSONArray array = (JSONArray)obj;
           
		for (int i = 0; i < array.size(); i++)
		{
			JSONObject jsonLineItem = (JSONObject) array.get(i);
			String name = jsonLineItem.get("name").toString();
			String age  = jsonLineItem.get("age").toString();
			String gender = jsonLineItem.get("gender").toString();
			System.out.print(name +" ");
			System.out.print(age +" ");
			System.out.print(gender +" "); 
			System.out.println();
	     }
		System.out.println();
		
		for(int j= 2;j<8;j++)
		{
			List<WebElement> cells = driver.findElements(By.xpath("//table[@id='dynamictable']//tr["+j+"]"));
			int cellSize = cells.size();
			for(int i = 0;i<cellSize;i++)
			{
				text =cells.get(i).getText();
				System.out.print(text +" ");
			}
			System.out.println();
		}
		
		Assert.assertEquals(text,"Jennifer 42 female");
	}
		
}
