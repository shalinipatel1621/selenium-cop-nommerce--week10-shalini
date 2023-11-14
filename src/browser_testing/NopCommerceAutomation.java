package browser_testing;
/**
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.
 * “https://demo.nopcommerce.com/login?returnUrl=
 * %2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button.
 * 15. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class NopCommerceAutomation {
    static String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the browser name (Chrome/Firefox/Edge): ");
        String browser = scanner.nextLine();
        //Multi browser choice
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if
        (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
            return;//exit the program if the browser name is incorrect
        }
        //Set up Chrome browser

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//add implicit warning
        driver.manage().window().maximize();
        //open URL
        driver.get(baseUrl);
        //Print the title of the page
        System.out.println("Title of the page: " + driver.getTitle());
        //print the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());
        //Print the page source
        System.out.println("Page Source: " + driver.getPageSource());
        //Navigate to URL
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        Thread.sleep(5000);//for holding or slowing down
        driver.navigate().to(loginUrl);
        //print the current url
        System.out.println("Current URL after navigation: " + driver.getCurrentUrl());
        //navigate back to the homepage
        driver.navigate().back();
        //navigate to login page
        driver.navigate().to(loginUrl);
        //print the current Url
        System.out.println("Current URL on login page: " + driver.getCurrentUrl());
        //Refresh the page
        driver.navigate().refresh();
        //enter email to email field
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("prime@gmail.com");
        //Enter password to password field
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("123456");
        //click on login button
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
        loginButton.click();
        //close the browser
        driver.quit();
        scanner.close();


    }
}


