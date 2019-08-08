package com.BriteERP.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BriteERPUtils {

    private static String loaderMaskLocator = "????????????";
    private static String pageSubTitleLocator = "div.o_main_content> div.o_control_panel > ol > li[class='active']";



    /**
     * This method will navigate user to the specific module in BriteERP application
     * For example: if module is equals to Calendar then method will navigate user to Calendar module
     * @param module
     */

      public static void navigateToModule(String module){

        String moduleLocator = "//span[contains(text(),'"+module+"') and contains(@class, 'oe_menu_text')]";
        Driver.getDriver().findElement(By.xpath(moduleLocator)).click();
    }

    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     * @param driver
     */
    public static void waitUntilLoaderScreenDisappear(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Long.valueOf(ConfigurationReader.getProperty("explicitwait")));
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(loaderMaskLocator))));
        }catch (Exception e){
            System.out.println(e+" :: Loader mask is not present.");
        }
    }

    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     *
     */
    public static void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Long.valueOf(ConfigurationReader.getProperty("explicitwait")));
            wait.until(ExpectedConditions.invisibilityOf(Driver.getDriver().findElement(By.cssSelector(loaderMaskLocator))));
        }catch (Exception e){
            System.out.println(e+" :: Loader mask is not present.");
        }
    }

    /**
     *
     * @return page name, for example: Dashboard
     */
    public static String getPageSubTitle(){
        //ant time we are verifying page name, or page subtitle, loader mask appears
        return Driver.getDriver().findElement(By.cssSelector(pageSubTitleLocator)).getText();
    }


}
