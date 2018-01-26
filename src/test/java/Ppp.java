
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ppp {

  private static WebDriver driver;
  

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
			System.setProperty("webdriver.chrome.driver", "e:\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		driver.get("https://www.google.com.ar/");
		driver.findElement(By.xpath("//input[@title='Buscar']")).sendKeys("guru99");
		
	}

}
