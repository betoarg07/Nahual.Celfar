import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class NewTest {
	
	public WebDriver driver;
	public String tit;
	public String baseUrl;
	public String appTit;
	public String val;
	
	
	// esta funcion convierte el valor a probar al formato que usa la aplicacion Celfar
	public String con(String f) {
		
		
		double c = Double.parseDouble(f)*1.8+32;
		NumberFormat nf = new DecimalFormat("##.######");
		
		if (c<-273) {
			
			String z = "El valor ingresado está debajo del 0 absoluto";
			return z;
		}
	
		else {
			String z = String.valueOf(nf.format(c));
			return z;
		}
		
			
	}
	
	//funcion que comprueba si la conversion de grados es correcta
	public void convert (String x) {
		
		driver.get(baseUrl);
		driver.findElement(By.xpath(".//*[@id='input']")).sendKeys(x);
		driver.findElement(By.className("button")).click();
		val = driver.findElement(By.id("output")).getText(); 
		assertEquals(val, con(x));
		
	}
	
	//funcion para casos de pruebas de numeros largos
	public void convertLong (String x) {
		
		driver.get(baseUrl);
		driver.findElement(By.xpath(".//*[@id='input']")).sendKeys(x);
		driver.findElement(By.className("button")).click();
		val = driver.findElement(By.id("output")).getText(); 
		assertEquals(val, "El valor ingresado es muy largo");
		
	}
	
 @Test
  public void Page_Title_CelFar() {
	  
	  driver.get(baseUrl);
	  tit = driver.getTitle();
	  assertEquals(tit, "CelFar");
  }
	  
@Test
  public void App_Title_CelFar2() {
	
	driver.get(baseUrl);
	appTit = driver.findElement(By.xpath("html/body/h1")).getText();
	assertEquals(appTit, "CelFar");	
}
	  
@Test
 public void con_10() {
	
	convert("10");
	
}

@Test
public void conL_1234567() {
	
	convertLong("1234567");
}


@Test
public void con_20() {
	
	convert("20");
	
}

@Test

public void con_0() {
	
	convert("0");
}

@Test

public void con_m300() {
	
	convert("-300");
	
}

  @BeforeClass
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver", "e:\\drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  baseUrl = "http://nahual.github.io/qc-celfar/?v=2";
	  
	  
	  
	  
  }

  @AfterClass
  public void afterTest() throws InterruptedException {
	  
	  Thread.sleep(1000);
	  driver.close();
	  
  }

}
