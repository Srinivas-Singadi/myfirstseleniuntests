import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ImdbTests {
  private WebDriver driver;
  private String baseUrl;

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "http://www.imdb.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testImdbTests() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("navbar-query")).clear();
    driver.findElement(By.id("navbar-query")).sendKeys("blade runner");
    driver.findElement(By.id("navbar-submit-button")).click();
    driver.findElement(By.linkText("Blade Runner")).click();
    assertEquals("Blade Runner (1982) - IMDb", driver.getTitle());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();

  }
}
