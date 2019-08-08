package com.BriteERP.tests.login;

import com.BriteERP.pages.LoginPage;
import com.BriteERP.utilities.BriteERPUtils;
import com.BriteERP.utilities.ConfigurationReader;
import com.BriteERP.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginTest1(){
        extentLogger = report.createTest("Login as CRM Manager");
        LoginPage loginPage = new LoginPage();
        String username= ConfigurationReader.getProperty("username");
        String password= ConfigurationReader.getProperty("password") ;

        loginPage.login(username,password);

        // verify that page is loaded by checking whether  the page title "Dashboard" displays
        Assert.assertEquals(BriteERPUtils.getPageSubTitle(),"#Inbox");
        extentLogger.pass("Verified that page name is #Inbox");
    }

    @Test
    public void negativeLoginTest() {
        extentLogger = report.createTest("Login with invalid credentials");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("login with wrong username and wrong password");
        loginPage.login("wrongusername" , "wrongpassword");
        Assert.assertEquals(loginPage.getErrorMessage() , "Wrong login/password");
        extentLogger.pass("Verified that warning message is displayed : Wrong login/password");
    }

}
