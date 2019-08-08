package com.BriteERP.tests.crm;

import com.BriteERP.pages.CRMPage;
import com.BriteERP.pages.LoginPage;
import com.BriteERP.utilities.BriteERPUtils;
import com.BriteERP.utilities.ConfigurationReader;
import com.BriteERP.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CRMTests extends TestBase {

    @Test
    public void verifyPivotVersusListValues(){
        extentLogger = report.createTest("Verify that the value for an opportunity in the pivot display matches to its corresponding value in the List display ");
        LoginPage loginPage=new LoginPage();
        CRMPage crmPage=new CRMPage();

        loginPage.login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));

        BriteERPUtils.navigateToModule("CRM");

        crmPage.pivotButtonElement.click();

        crmPage.total_openButtonElement.click();

        crmPage.total_closedButtonElement.click();

        crmPage.opportunityOptionElement.click();

        String secondrowvalue_pivot=driver.findElement(By.xpath("//tbody//tr[3]//td[2]")).getText();

        crmPage.listButtonElement.click();

        String secondrowvalue_list=driver.findElement(By.xpath("//tbody/tr[3]/td[9]")).getText();

        Assert.assertEquals(secondrowvalue_pivot, secondrowvalue_list);

        extentLogger.pass("Verified that the value for an opportunity in the pivot display and list display matches correctly");


    }

}
