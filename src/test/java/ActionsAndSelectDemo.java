import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ActionsAndSelectDemo {
    WebDriver driver;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();


    }

    @Test
    public void sliderTest() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement slider = driver.findElement(By.cssSelector("input.form-range"));
        Actions moveSlider = new Actions(driver);
        moveSlider.clickAndHold(slider).moveByOffset(40, 0).perform();
    }

    @Test
    public void dragAndDrop() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement first = driver.findElement(By.cssSelector("#column-a"));
        WebElement second = driver.findElement(By.cssSelector("#column-b"));
        Actions dragAndDroper = new Actions(driver);
        dragAndDroper.dragAndDrop(first, second).perform();
    }

    @Test
    public void keyPress() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement inputField = driver.findElement(By.cssSelector("input#target"));
        inputField.sendKeys(Keys.ESCAPE);

        WebElement resultText = driver.findElement(By.cssSelector("p#result"));
        String expectedResultText = "You entered: ESCAPE";
        String actualResultText = resultText.getText();
        Assert.assertEquals(expectedResultText, actualResultText);
    }

    @Test
    public void dropDown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement select = driver.findElement(By.cssSelector("#dropdown"));

        Select dropDown = new Select(select);
        dropDown.selectByVisibleText("Option 1");
        dropDown.selectByValue("2");
    }

    @Test
    public void dropDownSelect() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement ddSelect = driver.findElement(By.cssSelector("select.form-select"));

        Select dropIt = new Select(ddSelect);
        dropIt.selectByVisibleText("One");
        dropIt.selectByValue("2");
        dropIt.selectByIndex(3);
        dropIt.selectByIndex(0);
    }

    @Test
    public void ssss() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\'table1\']/tbody/tr[1]/td[3]"));
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }


    }

    @AfterMethod
    public void after() {
        // driver.quit();
    }
}
