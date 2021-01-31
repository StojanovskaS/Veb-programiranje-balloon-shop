package mk.ukim.finki.mk.lab.seleniumTestovi;

import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class BalloonPage extends AbstractPage{

    @FindBy(css = "tr[class=balloons]")
    private List<WebElement> balloonRows;


    @FindBy(className = "delete-balloon")
    private List<WebElement> deleteButtons;


    @FindBy(className = "edit-balloon")
    private List<WebElement> editButtons;


    @FindBy(className = "add-balloon")
    private List<WebElement> addProductButton;

    public BalloonPage(WebDriver driver) {
        super(driver);
    }

    public static BalloonPage to(WebDriver driver) {
        get(driver, "/balloons");
        System.out.println(driver.getCurrentUrl());
        return PageFactory.initElements(driver, BalloonPage.class);
    }

    public void assertElemts(int productsNumber, int deleteButtons, int editButtons, int addButtons) {
        Assert.assertEquals("rows do not match", productsNumber, this.getBalloonRows().size());
        Assert.assertEquals("delete do not match", deleteButtons, this.getDeleteButtons().size());
        Assert.assertEquals("edit do not match", editButtons, this.getEditButtons().size());
        Assert.assertEquals("add is visible", addButtons, this.getAddProductButton().size());
    }

}
