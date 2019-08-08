package com.BriteERP.pages;

import com.BriteERP.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMPage {

    private WebDriver driver= Driver.getDriver();

    @FindBy(css ="button[aria-label='pivot']" )
    public WebElement pivotButtonElement;

    @FindBy(css = "button[aria-label='list']")
    public WebElement listButtonElement ;

    @FindBy(css = "tr>td[class='o_pivot_header_cell_opened']")
    public WebElement total_openButtonElement;

    @FindBy(css = "td[class='o_pivot_header_cell_closed']")
    public WebElement total_closedButtonElement;

    @FindBy(css = "li:nth-child(25) > a")
    public WebElement opportunityOptionElement;

    public CRMPage() {
        PageFactory.initElements(driver,this);
    }


}
