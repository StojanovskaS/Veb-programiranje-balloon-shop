package mk.ukim.finki.mk.lab.seleniumTestovi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddBalloonPage extends AbstractPage{

    private WebElement name;
    private WebElement description;
    private WebElement idmanufacturer;
    private WebElement submit;

    public AddBalloonPage(WebDriver driver) {
        super(driver);
    }
    public static BalloonPage addProduct(WebDriver driver, String name, String description, String idmanufacturer) {
        get(driver, "/balloons/add-form");
        AddBalloonPage addOrEditProduct = PageFactory.initElements(driver, AddBalloonPage.class);
        addOrEditProduct.name.sendKeys(name);
        addOrEditProduct.description.sendKeys(description);
        addOrEditProduct.idmanufacturer.click();
        addOrEditProduct.idmanufacturer.findElement(By.xpath("//option[. = '" + idmanufacturer + "']")).click();

        addOrEditProduct.submit.click();
        return PageFactory.initElements(driver, BalloonPage.class);
    }

}
