package org.example.GfgExplore.Myprofile;

import org.example.Screenshot.Screenshot;
import org.example.Scroll.scroll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class profile {
    WebDriver driver;
    public profile(WebDriver driver)
    {
        this.driver=driver;
    }
    public void Progress(String year)
    {
        try
        {
            WebElement heatMap=this.driver.findElement(By.cssSelector(".heatmap-year-select.browser-default"));
            Select se=new Select(heatMap);
            se.selectByValue(year);
            if(heatMap.isDisplayed()) {
                Screenshot sc=new Screenshot(driver);
                sc.capture("progress");
                problems("easy");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
    public void problems(String difficulty)
    {
        scroll sc=new scroll(driver);
        sc.scrollByVisibleElement(driver.findElement(By.cssSelector(".solved_problem_section")));
        List<WebElement> list=driver.findElements(By.xpath("//ul[@class=\"tabs tabs-fixed-width linksTypeProblem\"]/li"));
        for(WebElement i:list)
        {
            if(i.getText().toLowerCase(Locale.ROOT).contains(difficulty))
            {
                i.click();
                break;
            }
        }
        switch (difficulty)
        {
            case("school"):{
                List<WebElement> list1 = driver.findElements(By.xpath("//div[@id=\"school\"]/ul/li"));
                for (WebElement i : list1) {
                    System.out.println(i.getText());
                }
            }
            case("basic"):
            {
                List<WebElement> list1 = driver.findElements(By.xpath("//div[@id=\"basic\"]/ul/li"));
                for (WebElement i : list1) {
                    System.out.println(i.getText());
                }
            }
            case("easy"):
            {
                List<WebElement> list1 = driver.findElements(By.xpath("//div[@id=\"easy\"]/ul/li"));
                for (WebElement i : list1) {
                    System.out.println(i.getText());
                }
            }
            case("medium"):
            {
                List<WebElement> list1 = driver.findElements(By.xpath("//div[@id=\"medium\"]/ul/li"));
                for (WebElement i : list1) {
                    System.out.println(i.getText());
                }
            }
            case("hard"):
            {
                List<WebElement> list1 = driver.findElements(By.xpath("//div[@id=\"hard\"]/ul/li"));
                for (WebElement i : list1) {
                    System.out.println(i.getText());
                }
            }
        }
    }
}
