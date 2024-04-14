# Selenium Web

```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>3.141.59</version>
</dependency>
```

---

## getText()

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.wikipedia.org");
        WebElement englishButton = driver.findElement(By.id("js-link-box-en"));

        englishButton.click();

        String expectedTitle = "Welcome to Wikipedia,";
        WebElement titleOfEnglishPage = driver.findElement(By.id("mp-welcome"));

        if(titleOfEnglishPage.getText().equals(expectedTitle)){
            System.out.println("Test has passed! Page is the English one");
        }

        else{
            System.out.println("Test has failed! Click() was not successful.");
        }

        driver.close();
    }
}
```

---

## .click() method

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.wikipedia.org");

        WebElement searchBox = driver.findElement(By.id("searchInput"));
        String searchStr = "Selenium Webdriver";
        searchBox.sendKeys(searchStr);

        WebElement searchButton = driver.findElement(By.cssSelector("#search-form > fieldset > button"));
        searchButton.click();

        //driver.close();
    }
}
```

---

## Table

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("file:///D:/tablePage.html");

        //System.out.println(driver.findElement(By.xpath("/html/body/table/tbody[1]/tr[2]/td[1]")).getText());
        //System.out.println(driver.findElement(By.xpath("/html/body/table/tbody[1]/tr[1]/th[2]")).getText());

        List<WebElement> listOfWebElements = driver.findElements(By.xpath("/html/body/table/tbody[1]/tr"));

        for(WebElement element : listOfWebElements){
            System.out.println(element.getText());
        }

        driver.close();
    }
}
```

---

## Tipi di wait

implicit, explicit

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class App {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");

        System.out.println(driver.getTitle());

        //Explicit Wait

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("js-link-box-en"))));

        //Fluent Wait
        Wait fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        fluentWait.until(new Function<WebDriver, WebElement>(){

            public WebElement apply(WebDriver driver ) {
                return driver.findElement(By.id("js-link-box-en"));
            }
        });

        driver.close();
    }
}
```

---

## Exceptions

Eccezione | Commento
---|---
ElementNotVisibleException|This type of Selenium exception occurs when an existing element in DOM has a feature set as hidden.
ElementNotSelectableException|The element is visible, but not selectable. Use the respective expected condition to avoid this.
NoSuchElementException|The element is not found in the DOM by Selenium. It might not be loaded, so use a type of wait.
NoSuchFrameException|This Exception occurs if the frame target to be switched to does not exist.
NoAlertPresentException|This Exception occurs when you switch to no presented alert.
NoSuchWindowException|This Exception occurs if the window target to be switch does not exist.
StaleElementReferenceException|The element is old and might not be available in the DOM anymore.
SessionNotFoundException|The WebDriver is called after it has been closed.
TimeoutException|Thrown when there is not enough time for a command to be completed. For Example, the element searched wasn't found in the specified time.
WebDriverException|The WebDriver is called after it has been closed.
ConnectionClosedException|You disconnected the driver most probably.
ElementClickInterceptedException|The element may not receive the click. Try the javascriptExecutor class to click it. 
ElementNotInteractableException|Element is in the DOM, however you cannot interact with it. Use the appropiate expected condition.
InsecureCertificateException|Self-signed, invalid or expired certificate.
InvalidArgumentException|It occurs when an argument does not belong to the expected type. For example, the url is malformed and you perform driver.get() on it. 
InvalidCoordinatesException|This type of Exception matches an interacting operation that is not valid.
InvalidElementStateExceptio|It occurs when command can't be finished when the element is invalid.
InvalidSessionIdException|The driver session is inactive. Maybe you are using a different webdriver, instead of using an existing one.
InvalidSwitchToTargetException|The target window to be switched does not exist.
JavascriptException|Invalid javascript sent to javascriptExecutor object.
NoSuchAttributeException|This kind of Exception occurs when the attribute of an element could not be found.
MoveTargetOutOfBoundsException|It takes place if the target provided to the ActionChains move() methodology is not valid. For Example, out of the document.
NoSuchContextException|ContextAware does mobile device testing.
NotFoundException|This Exception is a subclass of WebDriverException. This will occur when an element on the DOM does not exist.
RemoteDriverServerException|This Selenium exception is thrown when the server is not responding because of the problem that the capabilities described are not proper.
ScreenshotException|It is not possible to capture a screen.
SessionNotCreatedException|It happens when a new session could not be successfully created.
UnableToSetCookieException|This occurs if a driver is unable to set a cookie.
UnexpectedTagNameException|Happens if a support class did not get a web element as expected.
UnhandledAlertException|This expectation occurs when there is an alert, but WebDriver is not able to perform Alert operation.
UnexpectedAlertPresentException|It occurs when there is the appearance of an unexpected alert.
UnreachableBrowserException|Browser crashes most probably. Update you webdriver and browser.
UnsupportedCommandException|This occurs when remote WebDriver does not send valid commands as expected.

---

## Javascript Executor

```java
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.udemy.com/course/core-java-programming-language-tutorial/");

        WebElement signUpButton = driver.findElement(By.cssSelector("#udemy > div.main-content-wrapper > div.ud-app-loader.ud-component--header-v6--header.udlite-header.ud-app-loaded > div.udlite-text-sm.header--header--3sK1h.header--flex-middle--2Xqjv > div:nth-child(9) > a > span"));

        //Clicking with JavascriptExecutor
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signUpButton);

        //Setting up timeouts
        ((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length-1], 1000);");

        //Changing the webpage
        ((JavascriptExecutor) driver).executeScript("window.location = 'https://wikipedia.com'");

        //Scroll the webpage
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");

        driver.close();
    }
}
```

---

## Alerts

```java
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("file:///D:/Projects/Video/youtube/bitheap/DesignPatterns/seleniumDemo/alerts.html");
        WebElement basicAlertButton = driver.findElement(By.cssSelector("body > button:nth-child(2)"));
        WebElement confirmationAlertButton = driver.findElement(By.cssSelector("body > button:nth-child(5)"));
        WebElement promptAlertButton = driver.findElement(By.cssSelector("body > button:nth-child(8)"));

        //Basic Alert Demo
        basicAlertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert basicAlert = driver.switchTo().alert();
        basicAlert.accept();

        //Confirmation Alert Demo
        confirmationAlertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.dismiss();

        //Prompt Alert Demo
        promptAlertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert promptAlert = driver.switchTo().alert();

        System.out.println(promptAlert.getText());
        promptAlert.sendKeys("Laurentiu");
        promptAlert.accept();

        //driver.close();
    }
}
```

```html
<!DOCTYPE html>
<html>
<body>

<p>Gestione di basic alert.</p>

<button onclick="basicAlert()">Basic Alert</button>

<script>
function basicAlert() {
  alert("Ciao! Sono un messaggio di Alert!");
}
</script>


<p>Gestione di confirmation alert.</p>

<button onclick="confirmationAlert()">Confirmation Alert</button>

<script>
function confirmationAlert() {
  confirm("Vuoi eliminare il record?");
}
</script>


<p>Gestione di prompt alert.</p>

<button onclick="promptAlert()">Prompt Alert</button>

<p id="demo"></p>

<script>
function promptAlert() {
  var person = prompt("Scrivi il tuo nome", "Paolo Rossi");
  if (person != null) {
    document.getElementById("demo").innerHTML =
    "Ciao " + person + "! Come stai?";
  }
}
</script>

</body>
</html>
```

---

## IFrame

```java
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/html_iframe.asp");

        String title = driver.switchTo().frame(0).findElement(By.cssSelector("#main > h1")).getText();
        System.out.println(title);

        WebElement iframe = driver.findElement(By.cssSelector("#main > div:nth-child(7) > iframe"));

        driver.switchTo().frame(iframe).findElement(By.cssSelector("#topnav > div > div.w3-bar.w3-left > a:nth-child(5)")).click();

        driver.close();
    }
}
```

---

## Select

```java
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
        WebElement selectable = driver.findElement(By.id("cars"));

        Select select = new Select(selectable);
        select.selectByIndex(1);

        driver.close();
    }
}
```

---

## Actions Class

```java
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(driver.findElement(By.cssSelector("#content > iframe")));

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        Actions dragAndDrop = new Actions(driver);
        dragAndDrop.dragAndDrop(draggable, droppable).build().perform();

        Actions contextClick = new Actions(driver);

        contextClick.contextClick().build().perform();

        Actions actionObj = new Actions(driver);
        actionObj.keyDown(Keys.F1);

        driver.close();
    }
}
```

---

## 