/*
 * package fr.humanbooster.fx.plage;
 * 
 * import java.nio.file.FileSystems; import java.util.List;
 * 
 * import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.WebElement; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.chrome.ChromeOptions; import
 * org.springframework.boot.test.context.SpringBootTest;
 * 
 * @SpringBootTest public class AppTest {
 * 
 * private WebDriver webDriver; String separator =
 * FileSystems.getDefault().getSeparator();
 * 
 * @BeforeEach public void setUp() throws Exception {
 * 
 * String os = System.getProperty("os.name").toLowerCase().split(" ")[0];
 * 
 * String chromeDriver =
 * "C:\\Users\\robin\\eclipse-workspace\\plage20230418\\drivers\\chromedriver.exe";
 * System.out.println(chromeDriver);
 * 
 * System.setProperty("webdriver.chrome.driver", chromeDriver);
 * System.setProperty("webdriver.chrome.bin",
 * "C:\\Users\\robin\\eclipse-workspace\\plage20230418\\drivers\\chromedriver.exe"
 * );
 * 
 * webDriver = new ChromeDriver();
 * 
 * ChromeOptions options = new ChromeOptions();
 * options.addArguments("--remote-allow-origins=*");
 * options.addArguments("-allow-origins", "http://127.0.0.1:8180/"); webDriver =
 * new ChromeDriver(options); Thread.sleep(9000);
 * webDriver.get("http://127.0.0.1:8180/"); Thread.sleep(3000); }
 * 
 * @Test public void testQuestion1() throws Exception { // On demande au
 * webdriver de se rendre sur l'url
 * webDriver.get("http://localhost:8180/connexion");
 * 
 * // On attend 2 secondes Thread.sleep(2000); WebElement champDeRecherche =
 * webDriver.findElement(By.xpath("/html/body/form/input[1]"));
 * champDeRecherche.click(); champDeRecherche.clear();
 * champDeRecherche.sendKeys("peppe@humanbooster.fr");
 * 
 * Thread.sleep(2000);
 * 
 * 
 * }
 * 
 * }
 */
