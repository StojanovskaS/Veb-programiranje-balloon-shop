package mk.ukim.finki.mk.lab.seleniumTestovi;

import mk.ukim.finki.mk.lab.model.Manufacturer;
import mk.ukim.finki.mk.lab.model.User;
import mk.ukim.finki.mk.lab.model.enumerations.Role;
import mk.ukim.finki.mk.lab.service.BalloonService;
import mk.ukim.finki.mk.lab.service.ManufacturerService;
import mk.ukim.finki.mk.lab.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ScenarioTest {
    @Autowired
    UserService userService;

    @Autowired
    ManufacturerService manufacturerService;

    @Autowired
    BalloonService balloonService;

    private HtmlUnitDriver driver;
//    private ChromeDriver driver;


    private static Manufacturer m1;
    private static Manufacturer m2;
    private static User regularUser;
    private static User adminUser;

    private static String user = "user";
    private static String admin = "admin";

    private static boolean dataInitialized = false;
    @BeforeEach
    private void setup() {
        this.driver = new HtmlUnitDriver(true);
//        this.driver=new ChromeDriver();
        initData();
    }

    @AfterEach
    public void destroy() {
        if (this.driver != null) {
            this.driver.close();
        }
    }
    private void initData() {
        if (!dataInitialized) {

            m1 = manufacturerService.save("komanija1", "zemja1","adresa1");
            m2 = manufacturerService.save("komanija12", "zemja2","adresa2");


            regularUser = userService.register(user, user, user, user, Role.ROLE_USER);
            adminUser = userService.register(admin, admin, admin, admin, Role.ROLE_ADMIN);
            dataInitialized = true;
        }

    }
    @Test
    public void testScenario() throws Exception {
        BalloonPage balloonPage = BalloonPage.to(this.driver);
        balloonPage.assertElemts(0, 0, 0, 0);
        LoginPage loginPage = LoginPage.openLogin(this.driver);

        balloonPage = LoginPage.doLogin(this.driver, loginPage, adminUser.getUsername(), admin);
        balloonPage.assertElemts(0, 0, 0, 1);

        balloonPage = AddBalloonPage.addProduct(this.driver, "test", "test des", m1.getName());
        balloonPage.assertElemts(1, 1, 1, 1);

        balloonPage.getDeleteButtons().get(0).click();
        balloonPage.assertElemts(0, 0, 0, 1);

        balloonPage = AddBalloonPage.addProduct(this.driver, "test1", "test1 desc",  m2.getName());
        balloonPage.assertElemts(1, 1, 1, 1);
//        user 2 regularen
        loginPage = LoginPage.logout(this.driver);
        balloonPage = LoginPage.doLogin(this.driver, loginPage, regularUser.getUsername(), user);
        balloonPage.assertElemts(0, 0, 0, 0);


    }








}
