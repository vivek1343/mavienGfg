package org.example.GfgExplore;
import org.example.GfgExplore.MyCourses.Courses;
import org.example.GfgExplore.Myprofile.profile;
import org.openqa.selenium.*;


public class ExploringProfile {
    WebDriver driver;
    ExploringProfile(WebDriver driver)
    {
        this.driver=driver;

    }
   void Myaccount(String val) throws InterruptedException {
       this.driver.findElement(By.id("userProfileId")).click();
       Thread.sleep(1000);
       myAccountGet(val);
    }
    void myAccountGet(String val)throws InterruptedException
    {
        this.driver.findElement(By.xpath("//span[text()=\""+val+"\"]")).click();
        Thread.sleep(1000);
        if(val.equals("My Courses"))
        {
            System.out.println("Courses page successfully launched");
            Courses c=new Courses(driver);
            try {
                c.enrolled();
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        else if (val.equals("My Profile")) {

            this.driver.findElement(By.xpath("//div/a/span[text()=\"Profile\"]")).click();
            Thread.sleep(2000);
            profile p=new profile(driver);
            p.Progress("2021");
        }
    }
}
