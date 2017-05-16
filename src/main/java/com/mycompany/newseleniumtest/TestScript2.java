/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.newseleniumtest;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author prasetyo
 */
public class TestScript2 {
    public String email;
    public String promo_code;
    public boolean isPromo;
    public String testLocation;
    public WebDriver driver;
    public boolean isReferred;
    public boolean isCampaign;
    public String campaign;
    public String referralCode;
    
    public String nama;
    public String alamat;
    
     TestScript2 (String email) {
        this.email = email;
        this.promo_code = null;
        this.isPromo = false;
        this.testLocation = "dev";
        this.isReferred = false;
        this.isCampaign = false;
        this.campaign = "?utm_source=affiliates&utm_medium=affiliate&utm_term=aff&utm_content=affiliator_WVmVs&utm_campaign=UT Affiliate";
        this.referralCode = "";
        
        this.nama = "Prasetyo Budi Putranto";
        this.alamat = "Jl. Siaga Raya Komplek LAN C 5";
        
    }

    TestScript2(String email, String promo_code, boolean isPromo) {
        this.email = email;
        this.promo_code = promo_code;
        this.isPromo = isPromo;
        this.testLocation = "dev";
        this.isReferred = false;
        this.isCampaign = false;
        this.campaign = "?utm_source=affiliates&utm_medium=affiliate&utm_term=aff&utm_content=affiliator_WVmVs&utm_campaign=UT Affiliate";
        this.referralCode = "";
    }

    
     public void startDriver(String browser) {
        switch (browser) {
            case "firefox":

                FirefoxProfile fp = new FirefoxProfile();
                fp.setPreference("browser.startup.homepage", "about:blank");
                fp.setPreference("startup.homepage_welcome_url", "about:blank");
                fp.setPreference("startup.homepage_welcome_url.additional", "about:blank");

                this.driver = new FirefoxDriver(fp);
                this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                driver.manage().window().maximize(); //pras

                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/Users/kevinwibowo/Documents/Project/chromedriver");
                this.driver = new ChromeDriver();
                this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                break;
            default:

                break;
        }
    }
//Test Script 1 -Apply new layout
    public boolean Apply_new() throws InterruptedException, AWTException {
        boolean output = false;
        this.startDriver("firefox");
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
       
        //Open the page
        if (this.testLocation.equals("local")) {
            this.driver.get("localhost:80/uang-teman/");
        } else //  this.driver.get("https://dev.uangteman.com/___organic"); 
        {
            if (this.isCampaign) {
                this.driver.get("https://" + this.testLocation + ".uangteman.com/" + campaign);
            } else {
//                this.driver.get("https://hotfix.uangteman.com");
                this.driver.get("https://" + this.testLocation + ".uangteman.com/");  //https://dev.uangteman.com/a/NHeHv
            }
        }
        
        WebElement main;

        //IntroPage
        
//        main=driver.findElement(By.cssSelector("div[id='pinjaman-side'"));
//        Point point = main.getLocation();
//        int xcord = point.getX();
//        System.out.println("Element's Position from left side Is "+xcord +" pixels.");
//        int ycord = point.getY();
//        System.out.println("Element's Position from top side Is "+ycord +" pixels.");
//        main = this.driver.findElement(By.cssSelector("div[id='pinjaman-side']"));
//        main = this.driver.findElement(By.cssSelector("div[id='ajukan-pinjaman-box']"));
        
         if (this.testLocation.equals("hotfix")) {
           Thread.sleep(5000);
           main = this.driver.findElement(By.id("colorbox"));
           //main = driver.findElement(By.cssSelector("div[id='colorbox']")); 
           //main = this.driver.findElement(By.id("colorbox"));
           main.findElement(By.cssSelector("button[id='cboxClose']")).click();
           Thread.sleep(3000);  
           main = this.driver.findElement(By.cssSelector("div[id='home']"));
           main = this.driver.findElement(By.cssSelector("div[id='ajukan-pinjaman-box']"));
           main.findElement(By.cssSelector("a[href='https://hotfix.uangteman.com/loan-calculator")).click();
                 
         } else {
            if (this.testLocation.equals("dev")){
                Thread.sleep(5000);
                main = this.driver.findElement(By.id("colorbox"));
                main.findElement(By.cssSelector("button[id='cboxClose']")).click();
                Thread.sleep(3000); 
                main = this.driver.findElement(By.cssSelector("div[id='home']"));
                main = this.driver.findElement(By.cssSelector("div[id='ajukan-pinjaman-box']"));
                main.findElement(By.cssSelector("a[href='https://dev.uangteman.com/loan-calculator")).click();
                }
            else {
                Thread.sleep(5000);
                main = this.driver.findElement(By.id("colorbox"));
                main.findElement(By.cssSelector("button[id='cboxClose']")).click();
                Thread.sleep(3000); 
                main = this.driver.findElement(By.cssSelector("div[id='home']"));
                main = this.driver.findElement(By.cssSelector("div[id='ajukan-pinjaman-box']"));
                main.findElement(By.cssSelector("a[href='https://staging.uangteman.com/loan-calculator")).click();
            }
         }
       
        /* 
        main = this.driver.findElement(By.cssSelector("div[id='pinjaman-side']"));
        
        // case when
        main.findElement(By.cssSelector("a[href='https://hotfix.uangteman.com/loan-calculator")).click();
        **/
         
        //calculator
        //main.findElement(By.id("ap_email_address")).clear();
        main = driver.findElement(By.cssSelector("div[class='container']")); 
        main = driver.findElement(By.cssSelector("div[class='row']"));
        main = driver.findElement(By.cssSelector("div[class='col-xs-12']"));
        main = driver.findElement(By.cssSelector("form[id='form-calculator']"));
        main = driver.findElement(By.cssSelector("div[class='ut-form-container']"));
        main = driver.findElement(By.cssSelector("div[class='ut-form-box1']"));
        /*
        //start slide
        WebElement dragElementFrom = driver.findElement(By.xpath("//span[contains(@class, 'ui-slider-handle')]")); 
        
        new Actions(driver).dragAndDropBy(dragElementFrom, 100, 0).build().perform();
        Thread.sleep(5000);
        //end slide
        new Actions(driver).clickAndHold(dragElementFrom).moveByOffset(100,0).release().perform();
        **/
        
        if (this.isPromo) {
            main.findElement(By.id("promo_code")).sendKeys(this.promo_code, Keys.ENTER);
            Thread.sleep(4000);
        }
        
        Thread.sleep(4000);
        main.findElement(By.cssSelector("a[class='btn btn-medium monserat btn-pinjam-sekarang']")).click();
        
        //term and condition
        main = driver.findElement(By.cssSelector("div[class='container']")); 
        main = driver.findElement(By.cssSelector("form[id='agreement-form']"));
        main = driver.findElement(By.cssSelector("div[class='col-md-12 ut-form-container']")); 
        main.findElement(By.cssSelector("button[id='checklist-button']")).click();
//        main.findElement(By.id("ajukan-pinjaman-final")).submit();
        Thread.sleep(1000);
        
        
        //detail kontak
        main = driver.findElement(By.cssSelector("div[id='applicant-form']"));
        main.findElement(By.id("ap_email_address")).clear();
        main.findElement(By.id("ap_email_address")).sendKeys(this.email);
        main.findElement(By.id("ap_mobile_no")).clear();
        main.findElement(By.id("ap_mobile_no")).sendKeys("82288724193");
        main.findElement(By.id("ap_personal_id_no")).clear();
        main.findElement(By.id("ap_personal_id_no")).sendKeys("3174041211920005");
//        main.findElement(By.id("ap_personal_id_no")).sendKeys(SupportController.createRandom(17));
        Thread.sleep(1000);
        
        main = driver.findElement(By.cssSelector("div[id='applicant-form']"));
        main = driver.findElement(By.cssSelector("form[id='step1']")); 
        main = driver.findElement(By.cssSelector("div[class='ut-form-box2 clearfix']"));
        main.findElement(By.cssSelector("button[class='btn-next']")).click();
        Thread.sleep(11000);
        
        //form purpose loan
        main = driver.findElement(By.cssSelector("div[id='applicant-form']"));
        main = driver.findElement(By.cssSelector("form[id='step2']"));
        main = driver.findElement(By.cssSelector("div[class='ut-form-box2 clearfix']"));
        main = driver.findElement(By.cssSelector("div[class='ut-form-content']"));
        main = driver.findElement(By.cssSelector("div[class='selection-box-first']"));
        main.findElement(By.cssSelector("div[class='selection-radio']")).click();
        Thread.sleep(1000);
      
        driver.findElement(By.xpath("//*[@id='step2']/div/div[2]/button[2]")).click();
        
        //form know ut
        driver.findElement(By.xpath("//*[@id='step3']/div/div[1]/div[1]/div[2]/label/span")).click();
        
        driver.findElement(By.xpath("//*[@id='step3']/div/div[2]/button[2]")).click();
        Thread.sleep(1000);

        //more detail kontak
        main = driver.findElement(By.cssSelector("div[id='applicant-form']"));
        main = main.findElement(By.cssSelector("form[id='step4']"));
        main.findElement(By.id("ap_full_name")).clear();
        main.findElement(By.id("ap_full_name")).sendKeys(this.nama);
        main.findElement(By.id("ap_gender")).sendKeys("l", Keys.ENTER);
        main.findElement(By.id("ap_pob")).clear();
        main.findElement(By.id("ap_pob")).sendKeys("Jakarta");
        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.getElementById('ap_dob').value='12/11/1992'");
        Thread.sleep(1000);
        main.findElement(By.id("ap_religion")).sendKeys("k", Keys.ENTER);
        main.findElement(By.id("ap_marital_status")).sendKeys("l", Keys.ENTER);
         Thread.sleep(1000);
       
        main.findElement(By.xpath("//*[@id='step4']/div/div[12]/button[2]")).click();
       
        //pendidikan terakhir anda
        main.findElement(By.xpath("//*[@id='step5']/div/div[1]/div[4]/div[2]/label/span")).click();
        
        main.findElement(By.xpath("//*[@id='step5']/div/div[2]/button[2]")).click();
        
        //suku dan jumlah tanggungan anda
        main = driver.findElement(By.cssSelector("div[id='applicant-form']"));
        main = main.findElement(By.cssSelector("form[id='step6']"));
        main.findElement(By.id("ap_race_id")).sendKeys("J", Keys.ENTER);
        main.findElement(By.id("dependents")).sendKeys("0", Keys.ENTER);
        Thread.sleep(1000);
        
        main.findElement(By.xpath("//*[@id='step6']/div/div[5]/button[2]")).click();
        
        //nomor telepon domisili
        main = driver.findElement(By.cssSelector("div[id='applicant-form']"));
        main = main.findElement(By.cssSelector("form[id='step7']"));
        main.findElement(By.id("ap_telp_no")).sendKeys(SupportController.createRandom(16));
        Thread.sleep(1000);
        
        main.findElement(By.xpath("//*[@id='step7']/div/div[3]/button[2]")).click();
        
        //alamat domisili
        main = driver.findElement(By.cssSelector("div[id='applicant-form']"));
        main = main.findElement(By.cssSelector("form[id='step8']"));
//        main.findElement(By.id("ap_dom_address")).sendKeys("domisili selenium"+ this.email, Keys.ENTER);
        main.findElement(By.id("ap_dom_address")).sendKeys(this.alamat);
        Thread.sleep(1000);
        
        main.findElement(By.id("ap_dom_province")).sendKeys("DKI Jakarta", Keys.ENTER);
        SupportController.waittoLoad(main.findElement(By.id("ap_dom_kab_kot")).findElement(By.cssSelector("option[value='434']")), wait);
        main.findElement(By.id("ap_dom_kab_kot")).sendKeys("Kota Jakarta Selatan", Keys.ENTER);
        SupportController.waittoLoad(main.findElement(By.id("ap_dom_kecamatan")).findElement(By.cssSelector("option[value='488']")), wait);
        main.findElement(By.id("ap_dom_kecamatan")).sendKeys("Pasar Minggu", Keys.ENTER);
        SupportController.waittoLoad(main.findElement(By.id("ap_dom_kelurahan")).findElement(By.cssSelector("option[value='4753']")), wait);
        main.findElement(By.id("ap_dom_kelurahan")).sendKeys("Pejaten Barat", Keys.ENTER);
        Thread.sleep(1000);
        
        main.findElement(By.xpath("//*[@id='step8']/div/div[14]/button[2]")).click();
        
        //status rumah
        main.findElement(By.xpath("//*[@id='step9']/div/div[1]/div[4]")).click(); //RUMAH orang tua
        
        main.findElement(By.xpath("//*[@id='step9']/div/div[2]/button[2]")).click();
        
        //data keluarga
        main = driver.findElement(By.cssSelector("div[id='applicant-form']"));
        main = main.findElement(By.cssSelector("form[id='step10']"));
        main.findElement(By.id("ap_fam1_name")).sendKeys("keluarga selenium");
        main.findElement(By.id("ap_telp_fam1")).sendKeys(SupportController.createRandom(16));
        main.findElement(By.id("ap_fam1_address")).sendKeys("keluarga selenium");

        main.findElement(By.id("ap_fam1_province")).sendKeys("Jawa Tengah", Keys.ENTER);
        SupportController.waittoLoad(main.findElement(By.id("ap_fam1_kab_kot")).findElement(By.cssSelector("option[value='324']")), wait);
        main.findElement(By.id("ap_fam1_kab_kot")).sendKeys("Kab. Semarang", Keys.ENTER);
        SupportController.waittoLoad(main.findElement(By.id("ap_fam1_kecamatan")).findElement(By.cssSelector("option[value='1771']")), wait);
        main.findElement(By.id("ap_fam1_kecamatan")).sendKeys("Jambu", Keys.ENTER);
        SupportController.waittoLoad(main.findElement(By.id("ap_fam1_kelurahan")).findElement(By.cssSelector("option[value='19723']")), wait);
        main.findElement(By.id("ap_fam1_kelurahan")).sendKeys("Kebondalem", Keys.ENTER);
        Thread.sleep(1000);
        
        main.findElement(By.xpath("//*[@id='step10']/div/div[16]/button[2]")).click();
        
        //data bank
        main = driver.findElement(By.cssSelector("div[id='applicant-form']"));
        main = main.findElement(By.cssSelector("form[id='step11']"));
        SupportController.waittoLoad(main.findElement(By.id("ap_bank_name_id")).findElement(By.cssSelector("option[value='11']")), wait);
        main.findElement(By.id("ap_bank_name_id")).sendKeys("Bank CIMB Niaga", Keys.ENTER);
        main.findElement(By.id("ap_bank_number")).sendKeys("703553708000");
        main.findElement(By.id("ap_bank_username")).sendKeys(this.nama);
        
        //click checkbox
        WebElement element = main.findElement(By.id("ibc_checkbox")); 
        ((JavascriptExecutor) this.driver).executeScript("arguments[0].click();", element);
        Thread.sleep(10000);
        main.findElement(By.xpath("//*[@id='step11']/div/div[7]/button[2]")).click();
        
        //data lokasi bekerja
        main = driver.findElement(By.cssSelector("div[id='applicant-form']"));
        main = main.findElement(By.cssSelector("form[id='step12']"));
        main.findElement(By.id("ap_employer_name")).sendKeys("perusahaan testing");
        main.findElement(By.id("ap_telp_work")).sendKeys(SupportController.createRandom(15));
        main.findElement(By.id("ap_employer_address")).sendKeys("jalan selenium uanggeman");
        Thread.sleep(1000);
        
        main.findElement(By.id("ap_employer_province")).sendKeys("Jawa Barat", Keys.ENTER);
        SupportController.waittoLoad(main.findElement(By.id("ap_employer_kab_kot")).findElement(By.cssSelector("option[value='61']")), wait);
        main.findElement(By.id("ap_employer_kab_kot")).sendKeys("Kab. Bogor", Keys.ENTER);
        SupportController.waittoLoad(main.findElement(By.id("ap_employer_kecamatan")).findElement(By.cssSelector("option[value='800']")), wait);
        main.findElement(By.id("ap_employer_kecamatan")).sendKeys("Bojonggede", Keys.ENTER);
        SupportController.waittoLoad(main.findElement(By.id("ap_employer_kelurahan")).findElement(By.cssSelector("option[value='7847']")), wait);
        main.findElement(By.id("ap_employer_kelurahan")).sendKeys("Bojong Gede", Keys.ENTER);
        Thread.sleep(1000);
        
        main.findElement(By.xpath("//*[@id='step12']/div/div[16]/button[2]")).click();
        
        //pekerjaan dan gaji
        main = driver.findElement(By.cssSelector("div[id='applicant-form']"));
        main = main.findElement(By.cssSelector("form[id='step13']"));
        main.findElement(By.id("ap_mrtw_id")).sendKeys("N", Keys.ENTER);
        main.findElement(By.id("ap_employer_role")).sendKeys("Notaris");
        main.findElement(By.id("hll_years_work")).sendKeys("1", Keys.ENTER);
        main.findElement(By.id("hll_months_work")).sendKeys("3", Keys.ENTER);
        //testcase1
        main.findElement(By.id("ap_monthly_income")).sendKeys("9000000");
        main.findElement(By.id("mainexpenses")).sendKeys("2000000");
        main.findElement(By.id("houseloan")).sendKeys("0");
        
        main.findElement(By.xpath("//*[@id='step13']/div/div[15]/button[2]")).click();
        
        //upload dokumen
        driver.findElement(By.cssSelector("a[id='uploadBtnOther_1']")).click();

        //File Need to be imported
        File file1 = new File("/Users/prasetyo/Documents/Test/file upload/KTP SAYA.png");
        StringSelection stringSelection1= new StringSelection(file1.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection1, null);

        Robot robot1 = new Robot();
       
         // Cmd + Tab is needed since it launches a Java app and the browser looses focus
        
        robot1.keyPress(KeyEvent.VK_META);
        robot1.keyPress(KeyEvent.VK_TAB);
        robot1.keyRelease(KeyEvent.VK_META);
        robot1.keyRelease(KeyEvent.VK_TAB);
        robot1.delay(800);
        //Open Goto window
        robot1.keyPress(KeyEvent.VK_META);
        robot1.keyPress(KeyEvent.VK_SHIFT);
        robot1.keyPress(KeyEvent.VK_G);
        robot1.keyRelease(KeyEvent.VK_META);
        robot1.keyRelease(KeyEvent.VK_SHIFT);
        robot1.keyRelease(KeyEvent.VK_G);
        //Paste the clipboard value
        robot1.keyPress(KeyEvent.VK_META);
        robot1.keyPress(KeyEvent.VK_V);
        robot1.keyRelease(KeyEvent.VK_META);
        robot1.keyRelease(KeyEvent.VK_V);
        //Press Enter key to close the Goto window and Upload window
        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.keyRelease(KeyEvent.VK_ENTER);
        robot1.delay(800);
        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(7000);
        
/*
        //upload file 2
        driver.findElement(By.cssSelector("a[id='uploadBtnOther_2']")).click();
        Thread.sleep(1000);
        
        File file2 = new File("/Users/prasetyo/Documents/Test/file upload/KTP-600x416.jpg");
        StringSelection stringSelection2= new StringSelection(file2.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection1, null);

        Robot robot2 = new Robot();
        
        robot2.keyPress(KeyEvent.VK_META);
        robot2.keyPress(KeyEvent.VK_TAB);
        robot2.keyRelease(KeyEvent.VK_META);
        robot2.keyRelease(KeyEvent.VK_TAB);
        robot2.delay(800);
        //Open Goto window
        robot2.keyPress(KeyEvent.VK_META);
        robot2.keyPress(KeyEvent.VK_SHIFT);
        robot2.keyPress(KeyEvent.VK_G);
        robot2.keyRelease(KeyEvent.VK_META);
        robot2.keyRelease(KeyEvent.VK_SHIFT);
        robot2.keyRelease(KeyEvent.VK_G);
        //Paste the clipboard value
        robot2.keyPress(KeyEvent.VK_META);
        robot2.keyPress(KeyEvent.VK_V);
        robot2.keyRelease(KeyEvent.VK_META);
        robot2.keyRelease(KeyEvent.VK_V);
        //Press Enter key to close the Goto window and Upload window
        robot2.keyPress(KeyEvent.VK_ENTER);
        robot2.keyRelease(KeyEvent.VK_ENTER);
        robot2.delay(800);
        robot2.keyPress(KeyEvent.VK_ENTER);
        robot2.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(7000);
**/
        
        //upload file 3
        driver.findElement(By.cssSelector("a[id='uploadBtnOther_3']")).click();
        Thread.sleep(5000);
        
        File file3 = new File("/Users/prasetyo/Documents/Test/file upload/KTP SAYA.png");
        StringSelection stringSelection3= new StringSelection(file3.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection3, null);
        

        Robot robot3 = new Robot();
        
        robot3.keyPress(KeyEvent.VK_META);
        robot3.keyPress(KeyEvent.VK_TAB);
        robot3.keyRelease(KeyEvent.VK_META);
        robot3.keyRelease(KeyEvent.VK_TAB);
        robot3.delay(800);
        //Open Goto window
        robot3.keyPress(KeyEvent.VK_META);
        robot3.keyPress(KeyEvent.VK_SHIFT);
        robot3.keyPress(KeyEvent.VK_G);
        robot3.keyRelease(KeyEvent.VK_META);
        robot3.keyRelease(KeyEvent.VK_SHIFT);
        robot3.keyRelease(KeyEvent.VK_G);
        //Paste the clipboard value
        robot3.keyPress(KeyEvent.VK_META);
        robot3.keyPress(KeyEvent.VK_V);
        robot3.keyRelease(KeyEvent.VK_META);
        robot3.keyRelease(KeyEvent.VK_V);
        //Press Enter key to close the Goto window and Upload window
        robot3.keyPress(KeyEvent.VK_ENTER);
        robot3.keyRelease(KeyEvent.VK_ENTER);
        robot3.delay(800);
        robot3.keyPress(KeyEvent.VK_ENTER);
        robot3.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(7000);
        
        //main = main.findElement(By.cssSelector("form[id='step13']"));
        //main.findElement(By.id("skip-doc")).click();
        main.findElement(By.xpath("//*[@id='step14']/div/div[5]/button[2]")).click();
        //*[@id='step14']/div/div[5]/button[2]

        //dokumen persetujuan
        main = driver.findElement(By.cssSelector("div[id='applicant-form']"));
        main = main.findElement(By.cssSelector("form[id='step15']"));
        main.findElement(By.cssSelector("button[class='btn-agreement1']")).click();
        
        //sms confirmation
        Thread.sleep(15000);
        String sms_code = (String) SupportController.getfromDatabase("SELECT asp_code_sent FROM application_sms_process ORDER BY asp_sent_datetime DESC LIMIT 1;", this.testLocation);
        
        main.findElement(By.xpath("//*[@id='ap_mobile_code']")).sendKeys(sms_code, Keys.ENTER);
        //main.findElement(By.xpath("//*[@id='submit-token']/div/div[6]/button']")).click();
        //Result  
        output = true;
        System.out.println("TestScript Apply-Success");
 
       return output;
     
    }

    
    public void processFraud() throws InterruptedException {

        this.workbenchLogin("fraudcheck");
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        WebElement main;
        String ap_id = SupportController.getApID(this.email, this.testLocation);
        Thread.sleep(2000);
         this.driver.manage().window().maximize();
         //error
         
        if(driver.getPageSource().contains(this.email)){
        main = this.driver.findElement(By.cssSelector("a[href='https://" + this.testLocation + ".uangteman.com/admin/workbench/detail-fraud/" + ap_id + "']"));
        main.click();
//      String js = String.format("window.scrollBy(%s, %s)", 100, -100);
//      ((JavascriptExecutor) this.driver).executeScript(js);
//      main.click();
        SupportController.waittoLoad(this.driver.findElement(By.cssSelector("a[href='#panel_tab_3']")), wait);
        this.driver.findElement(By.cssSelector("a[href='#panel_tab_3']")).click();
        this.driver.findElement(By.cssSelector("button[href='#update_fraud_modal']")).click();
        SupportController.waittoLoad(this.driver.findElement(By.id("update_fraud_modal")), wait);
        main = this.driver.findElement(By.id("update_fraud_modal"));

        main.findElement(By.cssSelector("select[name='fraud_status']")).sendKeys("N", Keys.ENTER);
        Thread.sleep(2000);
        main.findElement(By.cssSelector("textarea[name='fraud_note']")).sendKeys("AutoProcessing to CS");
        main.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(5000);  
        }else{
        processsupercs();
        }
        
    }

    public void processsupercs() throws InterruptedException {

        this.workbenchLogin("customerservice");
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        WebElement main;
        String ap_id = SupportController.getApID(this.email, this.testLocation);
        Thread.sleep(2000);
        //ini yg dicontoh
        main = this.driver.findElement(By.cssSelector("div[class='col-md-12']"));
        main = main.findElement(By.cssSelector("div[class='panel-body']"));
        main = main.findElement(By.cssSelector("table[id='sample-table-1']"));
        this.driver.manage().window().maximize();
        Thread.sleep(2000);
        // System.out.println(ap_id);
        if(driver.getPageSource().contains(this.email)){
        main = main.findElement(By.cssSelector("a[href='#start_to_call'][call-id='" + ap_id + "']"));
        main.click();
        main = this.driver.findElement(By.cssSelector("div[id=start_to_call]"));
        SupportController.waittoLoad(main.findElement(By.cssSelector("select[class='form-control phone'][name='note1']")), wait);
        main.findElement(By.cssSelector("select[class='form-control phone'][name='note1']")).sendKeys("Yes", Keys.ENTER);
        main.findElement(By.cssSelector("button[class='btn btn-warning btn-loading']")).click();
        Thread.sleep(5000);  
        }else{
            try {
                processStaff();
            } catch (AWTException ex) {
                Logger.getLogger(TestScript.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
        /*
        main = main.findElement(By.cssSelector("a[href='#start_to_call'][call-id='" + ap_id + "']"));
        main.click();
        main = this.driver.findElement(By.cssSelector("div[id=start_to_call]"));
        SupportController.waittoLoad(main.findElement(By.cssSelector("select[class='form-control phone'][name='note1']")), wait);
        main.findElement(By.cssSelector("select[class='form-control phone'][name='note1']")).sendKeys("Yes", Keys.ENTER);
        main.findElement(By.cssSelector("button[class='btn btn-warning btn-loading']")).click();
        **/
    
    }

    public void processStaff() throws InterruptedException, AWTException {

        this.workbenchLogin("staff");
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        WebElement main;
        String ap_id = SupportController.getApID(this.email, this.testLocation);
        Thread.sleep(2000);

        main = this.driver.findElement(By.cssSelector("div[class='col-md-12']"));
        main = main.findElement(By.cssSelector("div[class='panel panel-default form-loading']"));
        main = main.findElement(By.cssSelector("div[class='panel-body']"));
        main = main.findElement(By.cssSelector("table[id='sample-table-1']"));
        if(driver.getPageSource().contains(this.email)){
        this.driver.manage().window().maximize();
        Thread.sleep(2000);
        // System.out.println(ap_id);
        //if(driver.getPageSource().contains(this.email)){
            main = main.findElement(By.cssSelector("a[href='#pcs_doc'][upload-id='" + ap_id + "']"));
            main.click();
            main = this.driver.findElement(By.cssSelector("div[id=pcs_doc]"));
            SupportController.waittoLoad(main.findElement(By.cssSelector("input[id='dateSurvey']")), wait);

            main.findElement(By.cssSelector("input[id='dateSurvey']")).sendKeys("02/01/2016 1:08 PM", Keys.ENTER);
        
            driver.findElement(By.cssSelector("a[id='uploadBtnOther_7']")).click();
            Thread.sleep(3000);
        
            File file4 = new File("/Users/prasetyo/Documents/Test/file upload/KTP-600x416.jpg");
            StringSelection stringSelection4= new StringSelection(file4.getAbsolutePath());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection4, null);
        
            Robot robot4 = new Robot();
        
            robot4.keyPress(KeyEvent.VK_META);
            robot4.keyPress(KeyEvent.VK_TAB);
            robot4.keyRelease(KeyEvent.VK_META);
            robot4.keyRelease(KeyEvent.VK_TAB);
            robot4.delay(500);
        //Open Goto window
            robot4.keyPress(KeyEvent.VK_META);
            robot4.keyPress(KeyEvent.VK_SHIFT);
            robot4.keyPress(KeyEvent.VK_G);
            robot4.keyRelease(KeyEvent.VK_META);
            robot4.keyRelease(KeyEvent.VK_SHIFT);
            robot4.keyRelease(KeyEvent.VK_G);
        //Paste the clipboard value
            robot4.keyPress(KeyEvent.VK_META);
            robot4.keyPress(KeyEvent.VK_V);
            robot4.keyRelease(KeyEvent.VK_META);
            robot4.keyRelease(KeyEvent.VK_V);
        //Press Enter key to close the Goto window and Upload window
            robot4.keyPress(KeyEvent.VK_ENTER);
            robot4.keyRelease(KeyEvent.VK_ENTER);
            robot4.delay(500);
            robot4.keyPress(KeyEvent.VK_ENTER);
            robot4.keyRelease(KeyEvent.VK_ENTER);
            robot4.keyPress(KeyEvent.VK_ENTER);
            robot4.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
            main.findElement(By.cssSelector("button[class='btn btn-default refresh_table']")).click();
            Thread.sleep(5000); 
        }else{
            processManager();
        }
    }

    public void processManager() throws InterruptedException, AWTException {
        
       Integer apli_id;
        apli_id = (Integer) SupportController.getfromDatabase("SELECT a.apli_id FROM application_data AS a INNER JOIN applicant_data AS b ON a.apli_ap_id=b.ap_id WHERE b.ap_email_address='"+email+"';", this.testLocation);
        System.out.println(apli_id);
        
       String masukmanager;
         masukmanager = (String) SupportController.getfromDatabase("SELECT b.bu_name FROM workload_manager AS a INNER JOIN bo_users AS b ON a.bu_id=b.bu_id WHERE a.apli_id='"+apli_id+"';", this.testLocation);
        System.out.println(masukmanager);
        
        //pras_manager=1
        //tulis code
        //int akun = 2;
        switch (masukmanager) {
            case "pras_manager":
                this.workbenchLogin("pras_manager");
                break;
            case "pras_supermanager":
                this.workbenchLogin("pras_supermanager");
                break; 
            case "ddebora_mgr":
                this.workbenchLogin("ddebora_mgr");
                break;
            case "eka":
                this.workbenchLogin("eka");
                break;
            case "fahmy_manager":
                this.workbenchLogin("fahmy_manager");
                break;
        }
        //
        //this.workbenchLogin("masukmanager");
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        WebElement main;
        WebElement main2;
        String ap_id = SupportController.getApID(this.email, this.testLocation);
        Thread.sleep(2000);

        main = this.driver.findElement(By.cssSelector("div[class='col-md-12']"));
        main = main.findElement(By.cssSelector("div[class='panel-body']"));
        main = main.findElement(By.cssSelector("table[id='sample-table-1']"));
        this.driver.manage().window().maximize();
        Thread.sleep(2000);
        // System.out.println(ap_id);
        main = main.findElement(By.cssSelector("a[href='#pcs_doc'][upload-id='" + ap_id + "']"));
        main.click();
        main = this.driver.findElement(By.cssSelector("div[id=pcs_doc]"));
        SupportController.waittoLoad(main.findElement(By.cssSelector("div[id='uploaderContainerOther_1']")), wait);
        //String filePath = System.getProperty("user.dir") + "/src/a.txt";
        
        //upload tax id
        driver.findElement(By.cssSelector("a[id='uploadBtnOther_2']")).click();
        Thread.sleep(2000);
        
        File file5 = new File("/Users/prasetyo/Documents/Test/file upload/KTP-600x416.jpg");
        StringSelection stringSelection5= new StringSelection(file5.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection5, null);

        Robot robot5 = new Robot();
        
        robot5.keyPress(KeyEvent.VK_META);
        robot5.keyPress(KeyEvent.VK_TAB);
        robot5.keyRelease(KeyEvent.VK_META);
        robot5.keyRelease(KeyEvent.VK_TAB);
        robot5.delay(800);
        //Open Goto window
        robot5.keyPress(KeyEvent.VK_META);
        robot5.keyPress(KeyEvent.VK_SHIFT);
        robot5.keyPress(KeyEvent.VK_G);
        robot5.keyRelease(KeyEvent.VK_META);
        robot5.keyRelease(KeyEvent.VK_SHIFT);
        robot5.keyRelease(KeyEvent.VK_G);
        //Paste the clipboard value
        robot5.keyPress(KeyEvent.VK_META);
        robot5.keyPress(KeyEvent.VK_V);
        robot5.keyRelease(KeyEvent.VK_META);
        robot5.keyRelease(KeyEvent.VK_V);
        //Press Enter key to close the Goto window and Upload window
        robot5.keyPress(KeyEvent.VK_ENTER);
        robot5.keyRelease(KeyEvent.VK_ENTER);
        robot5.delay(800);
        robot5.keyPress(KeyEvent.VK_ENTER);
        robot5.keyRelease(KeyEvent.VK_ENTER);
        robot5.keyPress(KeyEvent.VK_ENTER);
        robot5.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        
        //upload family id
        driver.findElement(By.cssSelector("a[id='uploadBtnOther_6']")).click();
        Thread.sleep(2000);
        
        File file6 = new File("/Users/prasetyo/Documents/Test/file upload/KTP-600x416.jpg");
        StringSelection stringSelection6= new StringSelection(file6.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection6, null);

        Robot robot6 = new Robot();
        
        robot6.keyPress(KeyEvent.VK_META);
        robot6.keyPress(KeyEvent.VK_TAB);
        robot6.keyRelease(KeyEvent.VK_META);
        robot6.keyRelease(KeyEvent.VK_TAB);
        robot6.delay(500);
        //Open Goto window
        robot6.keyPress(KeyEvent.VK_META);
        robot6.keyPress(KeyEvent.VK_SHIFT);
        robot6.keyPress(KeyEvent.VK_G);
        robot6.keyRelease(KeyEvent.VK_META);
        robot6.keyRelease(KeyEvent.VK_SHIFT);
        robot6.keyRelease(KeyEvent.VK_G);
        //Paste the clipboard value
        robot6.keyPress(KeyEvent.VK_META);
        robot6.keyPress(KeyEvent.VK_V);
        robot6.keyRelease(KeyEvent.VK_META);
        robot6.keyRelease(KeyEvent.VK_V);
        //Press Enter key to close the Goto window and Upload window
        robot6.keyPress(KeyEvent.VK_ENTER);
        robot6.keyRelease(KeyEvent.VK_ENTER);
        robot6.delay(500);
        robot6.keyPress(KeyEvent.VK_ENTER);
        robot6.keyRelease(KeyEvent.VK_ENTER);
        robot6.keyPress(KeyEvent.VK_ENTER);
        robot6.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        
        //upload family id
        driver.findElement(By.cssSelector("a[id='uploadBtnOther_5']")).click();
        Thread.sleep(2000);
        
        File file7 = new File("/Users/prasetyo/Documents/Test/file upload/KTP-600x416.jpg");
        StringSelection stringSelection7= new StringSelection(file7.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection7, null);

        Robot robot7 = new Robot();
        
        robot7.keyPress(KeyEvent.VK_META);
        robot7.keyPress(KeyEvent.VK_TAB);
        robot7.keyRelease(KeyEvent.VK_META);
        robot7.keyRelease(KeyEvent.VK_TAB);
        robot7.delay(500);
        //Open Goto window
        robot7.keyPress(KeyEvent.VK_META);
        robot7.keyPress(KeyEvent.VK_SHIFT);
        robot7.keyPress(KeyEvent.VK_G);
        robot7.keyRelease(KeyEvent.VK_META);
        robot7.keyRelease(KeyEvent.VK_SHIFT);
        robot7.keyRelease(KeyEvent.VK_G);
        //Paste the clipboard value
        robot7.keyPress(KeyEvent.VK_META);
        robot7.keyPress(KeyEvent.VK_V);
        robot7.keyRelease(KeyEvent.VK_META);
        robot7.keyRelease(KeyEvent.VK_V);
        //Press Enter key to close the Goto window and Upload window
        robot7.keyPress(KeyEvent.VK_ENTER);
        robot7.keyRelease(KeyEvent.VK_ENTER);
        robot7.delay(500);
        robot7.keyPress(KeyEvent.VK_ENTER);
        robot7.keyRelease(KeyEvent.VK_ENTER);
        robot7.keyPress(KeyEvent.VK_ENTER);
        robot6.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        
        main.findElement(By.cssSelector("button[class='btn btn-default refresh_table']")).click();
        Thread.sleep(8000); 
        
        main = this.driver.findElement(By.cssSelector("div[class='col-md-12']"));
        main = main.findElement(By.cssSelector("div[class='panel-body']"));
        main = main.findElement(By.cssSelector("table[id='sample-table-1']"));
        main.findElement(By.cssSelector("a[verify-id='" + ap_id + "']")).click();
        main = this.driver.findElement(By.cssSelector("div[id=verify]"));
        main.findElement(By.cssSelector("button[class='btn btn-warning print_btn']")).click();
        Thread.sleep(5000);
        
    }
    
    public boolean doingdisburse(boolean withDisburse) throws InterruptedException {
        //query
        Thread.sleep(15000);
        Integer apli_id2;
        apli_id2 = (Integer) SupportController.getfromDatabase("SELECT a.apli_id FROM application_data AS a INNER JOIN applicant_data AS b ON a.apli_ap_id=b.ap_id WHERE b.ap_email_address='"+email+"';", this.testLocation);
        System.out.println(apli_id2);
        
        String masukSupManager;
        masukSupManager = (String) SupportController.getfromDatabase("SELECT b.bu_name FROM workload_manager AS a INNER JOIN bo_users AS b ON a.bu_id=b.bu_id WHERE a.apli_id='"+apli_id2+"'ORDER BY a.id DESC;", this.testLocation);
        
        switch (masukSupManager) {
            case "pras_manager":
                this.workbenchLogin("pras_manager");
                break;
            case "pras_supermanager":
                this.workbenchLogin("pras_supermanager");
                break;    
            case "ddebora_mgr":
                this.workbenchLogin("ddebora_mgr");
                break;
            case "eka":
                this.workbenchLogin("eka");
                break;
            case "fahmy_manager":
                this.workbenchLogin("fahmy_manager");
                break;
        }
        //this.workbenchLogin("supermanager");
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        WebElement main;
        WebElement main2;
        String ap_id = SupportController.getApID(this.email, this.testLocation);
        this.driver.manage().window().maximize();
        Thread.sleep(2000);
        
        
        // System.out.println(ap_id);
      
        String authCode;
        if (withDisburse) {
            if (this.testLocation.equals("dev")) {
                authCode = "6ea86d";
            } else {
                authCode = (String) SupportController.getfromDatabase("SELECT bua_auth_code FROM bo_auth_log ORDER BY bua_id DESC LIMIT 1;", this.testLocation);
            }
            main = this.driver.findElement(By.cssSelector("div[class='col-md-12']"));
            main = main.findElement(By.cssSelector("div[class='panel-body']"));
            main = main.findElement(By.cssSelector("table[id='sample-table-1']"));
            Thread.sleep(2000);
        
            main = main.findElement(By.cssSelector("a[class='btn btn-xs btn-warning btn-squared tooltips'][disburse-id='" + apli_id2 + "']"));
            main.click();
            Thread.sleep(2000);

            //SupportController.waittoLoad(main.findElement(By.cssSelector("button[class='btn btn-success btn-loading']")), wait);
            main.findElement(By.xpath("//*[@id='disburse']/div/div/div[2]/form/div[2]/input")).sendKeys(authCode);
            main.findElement(By.xpath("//*[@id='disburse']/div/div/div[2]/form/div[3]/button")).click();
            return true;
           
        }
            /*
            main = this.driver.findElement(By.cssSelector("div[class='navbar navbar-inverse navbar-fixed-top']"));
            main = this.driver.findElement(By.cssSelector("div[class='container']"));
            main = this.driver.findElement(By.cssSelector("div[class='navbar-tools']"));
            main = this.driver.findElement(By.cssSelector("ul[class='nav navbar-right']"));
            main.findElement(By.cssSelector("li[class='dropdown']")).click();
            main.findElement(By.cssSelector("a[href='https://staging.uangteman.com/admin/workbench/index?filter=disburse")).click();
            Thread.sleep(8000);
            
            main = this.driver.findElement(By.cssSelector("div[class='col-md-12']"));
            main = main.findElement(By.cssSelector("div[class='panel-body']"));
            main = main.findElement(By.cssSelector("table[id='sample-table-1']"));
            Thread.sleep(2000);
        
            main = main.findElement(By.cssSelector("a[class='btn btn-xs btn-warning btn-squared tooltips'][disburse-id='" + apli_id + "']"));
            main.click();
            Thread.sleep(2000);
            **/
            return false;
    }
    
        public void Apply_Partner() throws InterruptedException {
        
        //masuk validasi applicant email logs
        
         this.startDriver("firefox");
            this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, 10);
        
            driver.get("https://partner-stag.uangteman.com/login");
            driver.manage().window().maximize();
            
            WebElement main;
            
            //find element intro
            main = this.driver.findElement(By.id("app"));
            main = this.driver.findElement(By.cssSelector("div[class='container']"));
            main = this.driver.findElement(By.cssSelector("div[class='body-login']"));
            main.findElement(By.cssSelector("input[type='text']")).sendKeys("myjne001@gmail.com");
            main.findElement(By.cssSelector("input[type='password']")).sendKeys("uangteman");
            Thread.sleep(2000);
            main.findElement(By.cssSelector("button[class='btn btn-lg btn-ut-login']")).click();
            
            //find element alasan pinjaman
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            
            main = this.driver.findElement(By.id("app"));
            main = this.driver.findElement(By.cssSelector("div[class='wrapper grey']"));
            main = this.driver.findElement(By.cssSelector("div[class='container']"));
            
            //loan purpose
            main = driver.findElement(By.cssSelector("form[class='form-application']"));
            main = this.driver.findElement(By.cssSelector("div[class='form-application-body']"));
            main = main.findElement(By.cssSelector("div[class='loan-purpose']"));
            
            main.findElement(By.id("email")).sendKeys(this.email);
//            main.findElement(By.id("personal_id_no")).sendKeys(SupportController.createRandom(17));
          main.findElement(By.id("personal_id_no")).sendKeys("3174041211920005");
//          main.findElement(By.id("principal-amount-addon")).sendKeys("81210745941");
            main.findElement(By.xpath("//*[@id='form-application']/div[1]/div/div[4]/div[1]/input")).sendKeys("81280085422");
            
//            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            main = this.driver.findElement(By.cssSelector("div[class='form-group form-group-lg']"));           
            //select random reason
            //pilih div radionya yg byk
            Random rnd = new Random();
            List<WebElement> radios = driver.findElements(By.cssSelector("div[class='radio']"));
            radios.get(rnd.nextInt(radios.size())).click();
                       
//            Thread.sleep(10000);
            driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
            
            main = this.driver.findElement(By.cssSelector("div[class='col-xs-12 col-md-8']"));
            main.findElement(By.cssSelector("select[id='know_ut']")).sendKeys("F", Keys.ENTER);
            main.findElement(By.xpath("//*[@id='know_ut']")).click();
            Thread.sleep(10000);
            main = this.driver.findElement(By.id("app"));
            main = this.driver.findElement(By.cssSelector("div[class='wrapper grey']"));
            main = this.driver.findElement(By.cssSelector("div[class='container']"));
            main = driver.findElement(By.cssSelector("form[class='form-application']"));
            main = this.driver.findElement(By.cssSelector("div[class='form-application-footer clearfix']"));
            
            main.findElement(By.cssSelector("button[class='btn btn-info pull-right btn-action']")).click();
           
            //personal data
            main = this.driver.findElement(By.cssSelector("div[class='form-application-body']"));
            main = main.findElement(By.cssSelector("div[class='personal-data']"));

//            main.findElement(By.id("full_name")).clear();
            main.findElement(By.id("full_name")).sendKeys("testing patner");
//            main.findElement(By.id("pob")).clear();
            main.findElement(By.id("pob")).sendKeys("jakarta");
//            main.findElement((By.cssSelector("div[")))
            
//            main = this.driver.findElement(By.cssSelector("form[class='form-application']"));
            driver.findElement(By.xpath("//*[@id='datetimepicker']/input")).clear();
            driver.findElement(By.xpath("//*[@id='datetimepicker']/input")).sendKeys("25/12/1990", Keys.ENTER);
          
            //create random jenis kelamin
            Random rnd2 = new Random();
            List<WebElement> radios2 = driver.findElements(By.cssSelector("div[class='radio-gender']"));
            radios2.get(rnd2.nextInt(radios2.size())).click();
            
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //create random agama
            
            main = this.driver.findElement(By.cssSelector("div[class='radio-religion']"));
            main.findElement(By.cssSelector("input[id='1']")).click();
            /*
            Random rnd3 = new Random();
            List<WebElement> radios3 = driver.findElements(By.cssSelector("div[class='radio-religion']"));
            radios3.get(rnd3.nextInt(radios3.size())).click();
            */
                        
            //select dropdown
            main = this.driver.findElement(By.cssSelector("form[class='form-application']"));
            main.findElement(By.id("race_id")).sendKeys("J", Keys.ENTER);
            main.findElement(By.id("education")).sendKeys("S1", Keys.ENTER);
            
            //create random status pernikahan
            main = this.driver.findElement(By.cssSelector("div[class='radio-marital']"));
            main.findElement(By.cssSelector("input[id='1']")).click();
            /*
            Random rnd4 = new Random();
            List<WebElement> radios4 = driver.findElements(By.cssSelector("div[class='radio-marital']"));
            radios4.get(rnd4.nextInt(radios4.size())).click();
            */

            main = this.driver.findElement(By.cssSelector("form[class='form-application']"));
            main.findElement(By.cssSelector("input[id='dependents']")).sendKeys("0");
            
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            
            main = this.driver.findElement(By.cssSelector("div[class='container']"));
            main = this.driver.findElement(By.cssSelector("form[class='form-application']"));
            main = main.findElement(By.cssSelector("div[class='form-application-footer clearfix']"));
            main.findElement(By.cssSelector("button[class='btn btn-info pull-right btn-action']")).click(); 
            
            //detail kontak
            main = this.driver.findElement(By.id("app"));
            main = this.driver.findElement(By.cssSelector("div[class='wrapper grey']"));
            main = this.driver.findElement(By.cssSelector("div[class='container']"));
            main = this.driver.findElement(By.cssSelector("div[class='form-application-body']"));
            
            main.findElement(By.cssSelector("input[id='telp_no']")).sendKeys("02100929871852");
            main.findElement(By.cssSelector("textarea[id='dom_address']")).sendKeys("testing street delapan delapan"+this.email);
            
            main = this.driver.findElement(By.cssSelector("div[class='radio-status-rumah']"));
            driver.findElement(By.xpath("//*[@id='form-application']/div[1]/div/div[5]/div[1]/div[3]/label")).click();
            
            main = this.driver.findElement(By.cssSelector("div[class='form-application-body']"));
            main.findElement(By.id("dom_province")).sendKeys("Jawa Barat", Keys.ENTER);
            SupportController.waittoLoad(main.findElement(By.id("dom_city")).findElement(By.cssSelector("option[value='19']")), wait);
            main.findElement(By.id("dom_city")).sendKeys("Kab. Bandung Barat", Keys.ENTER);
            SupportController.waittoLoad(main.findElement(By.id("dom_district")).findElement(By.cssSelector("option[value='763']")), wait);
            main.findElement(By.id("dom_district")).sendKeys("Cililin", Keys.ENTER);
            SupportController.waittoLoad(main.findElement(By.id("dom_subdistrict")).findElement(By.cssSelector("option[value='7524']")), wait);
            main.findElement(By.id("dom_subdistrict")).sendKeys("Nanggerang", Keys.ENTER);
            
            Thread.sleep(1000);
            
            main.findElement(By.cssSelector("input[id='fam_name']")).sendKeys("uang teman");
            main.findElement(By.cssSelector("input[id='telp_fam1']")).sendKeys("021021100");
            main.findElement(By.cssSelector("textarea[id='fam_address']")).sendKeys("testing street fam partner");
            
            main = this.driver.findElement(By.cssSelector("div[class='form-application-body']"));
            main.findElement(By.id("fam_province")).sendKeys("Jawa Barat", Keys.ENTER);
            SupportController.waittoLoad(main.findElement(By.id("fam_city")).findElement(By.cssSelector("option[value='43']")), wait);
            main.findElement(By.id("fam_city")).sendKeys("Kab. Bekasi", Keys.ENTER);
            SupportController.waittoLoad(main.findElement(By.id("fam_district")).findElement(By.cssSelector("option[value='777']")), wait);
            main.findElement(By.id("fam_district")).sendKeys("Bojongmangu", Keys.ENTER);
            SupportController.waittoLoad(main.findElement(By.id("fam_subdistrict")).findElement(By.cssSelector("option[value='7661']")), wait);
            main.findElement(By.id("fam_subdistrict")).sendKeys("Karangmulya", Keys.ENTER);
            
            
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            
            main = this.driver.findElement(By.cssSelector("div[class='container']"));
            main = this.driver.findElement(By.cssSelector("form[class='form-application']"));
            main = main.findElement(By.cssSelector("div[class='form-application-footer clearfix']"));
            main.findElement(By.cssSelector("button[class='btn btn-info pull-right btn-action']")).click(); 
            
            //isi detail bank
            main = this.driver.findElement(By.id("app"));
            main = this.driver.findElement(By.cssSelector("div[class='wrapper grey']"));
            main = this.driver.findElement(By.cssSelector("div[class='container']"));
            
            main = this.driver.findElement(By.cssSelector("form[class='form-application']"));
            main = this.driver.findElement(By.cssSelector("div[class='form-application-body']"));
            main = this.driver.findElement(By.cssSelector("div[class='bank-detail']"));
            main.findElement(By.id("bank_name_id")).sendKeys("Bank CIMB Niaga", Keys.ENTER);
            main.findElement(By.cssSelector("input[id='bank_number']")).sendKeys("703553708000");
            main.findElement(By.cssSelector("input[id='bank_username']")).sendKeys("testing patner");
            driver.findElement(By.xpath("//*[@id='is_bankacc_correct']")).click();
            
            main = this.driver.findElement(By.cssSelector("div[class='container']"));
            main = this.driver.findElement(By.cssSelector("form[class='form-application']"));
            main = main.findElement(By.cssSelector("div[class='form-application-footer clearfix']"));
            main.findElement(By.cssSelector("button[class='btn btn-info pull-right btn-action']")).click();
            
            //isi perkerjaan dan penghasilan
            main = this.driver.findElement(By.id("app"));
            main = this.driver.findElement(By.cssSelector("div[class='wrapper grey']"));
            main = this.driver.findElement(By.cssSelector("div[class='container']"));
            
            main = this.driver.findElement(By.cssSelector("form[class='form-application']"));
            main = this.driver.findElement(By.cssSelector("div[class='form-application-body']"));
            main.findElement(By.cssSelector("input[id='office_name']")).sendKeys("pt parner uangteman");
            main.findElement(By.cssSelector("input[id='telp_work']")).sendKeys("021790098172");
            main.findElement(By.cssSelector("textarea[id='office_address']")).sendKeys("jalan menara delapan delapan");
            
            main = this.driver.findElement(By.cssSelector("div[class='form-application-body']"));
            main.findElement(By.id("office_province")).sendKeys("DI Yogyakarta", Keys.ENTER);
            SupportController.waittoLoad(main.findElement(By.id("office_city")).findElement(By.cssSelector("option[value='31']")), wait);
            main.findElement(By.id("office_city")).sendKeys("Kab. Bantul", Keys.ENTER);
            SupportController.waittoLoad(main.findElement(By.id("office_district")).findElement(By.cssSelector("option[value='388']")), wait);
            main.findElement(By.id("office_district")).sendKeys("Bantul", Keys.ENTER);
            SupportController.waittoLoad(main.findElement(By.id("office_subdistrict")).findElement(By.cssSelector("option[value='4178']")), wait);
            main.findElement(By.id("office_subdistrict")).sendKeys("Bantul", Keys.ENTER);
            
            //testcase partner
            main = this.driver.findElement(By.cssSelector("div[class='form-application-body']"));
            main.findElement(By.id("job_title")).sendKeys("N", Keys.ENTER);
            main.findElement(By.cssSelector("input[id='employer_role']")).sendKeys("senior");
            main.findElement(By.cssSelector("input[id='monthly_income']")).sendKeys("3000000");
            driver.findElement(By.xpath("//*[@id='startWork']/inputt")).sendKeys("25/12/2015", Keys.ENTER);
            main.findElement(By.cssSelector("input[id='mainexpenses']")).sendKeys("4000000");
            main.findElement(By.cssSelector("input[id='houseloan']")).sendKeys("0");
            
            main = this.driver.findElement(By.cssSelector("div[class='container']"));
            main = this.driver.findElement(By.cssSelector("form[class='form-application']"));
            main = main.findElement(By.cssSelector("div[class='form-application-footer clearfix']"));
            main.findElement(By.cssSelector("button[class='btn btn-info pull-right btn-action']")).click();
            
            //dokumen persetujuan
            main = this.driver.findElement(By.id("app"));
            main = this.driver.findElement(By.cssSelector("div[class='wrapper grey']"));
            main = this.driver.findElement(By.cssSelector("div[class='container']"));
            main = this.driver.findElement(By.cssSelector("form[class='form-application']"));
            
            //confirmation dokumen persetujuan
            main = main.findElement(By.cssSelector("div[class='doc-agreement-footer clearfix']"));
            main.findElement(By.cssSelector("button[class='btn btn-info pull-rightt']")).click();
            Thread.sleep(10000);
            
//            main = this.driver.findElement(By.cssSelector("div[class='sweet-overlay']"));
            main = this.driver.findElement(By.cssSelector("div[class='sweet-alert showSweetAlert visible']"));
            main = this.driver.findElement(By.cssSelector("div[class='sa-confirm-button-container']"));
            main.findElement(By.cssSelector("button[class='confirm']")).click();
            Thread.sleep(1000);
        }

    public boolean workbenchLogin(String user) {
        boolean output = true;

        try {

            this.startDriver("firefox");
            this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, 10);

            //Open the page
            this.driver.get("http://" + this.testLocation + ".uangteman.com/admin");
//            this.driver.get("localhost:80/uang-teman/admin");
            
            WebElement main;
            switch (user) {
                case ("finance"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("ddebora_fi");
                    break;
                case ("admin"):     
                    this.driver.findElement(By.name("bu_name")).sendKeys("pras_admin");
                    break;
                case ("staff"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("pras_staff");
                    break;
                case ("fraudcheck"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("pras_fc");
                    break;
                case ("customerservice"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("pras_supercs");
                    break;
                case ("pras_supermanager"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("pras_supermanager");
                    break;
                case ("supermanager_redho"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("redho");
                    break;       
                case ("fauzan"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("fauzan");
                    break;
                case ("pras_manager"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("pras_manager");
                    break;    
                case ("ddebora_mgr"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("ddebora_mgr");
                    break;
                case ("fahmy_manager"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("fahmy_manager");
                    break;   
                case ("eka"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("eka");
                    break;      
                case ("collection"):
                    this.driver.findElement(By.name("bu_name")).sendKeys("kevincol");
                    break;
              default:
                    throw new Exception("No user");
            }
            this.driver.findElement(By.name("bu_passwd")).sendKeys("testing");
            main = this.driver.findElement(By.cssSelector("button[class='btn btn-orange btn-squared pull-right ladda-button']"));
            main.submit();

            //SMS verifications
            if (!this.testLocation.equals("dev")) {
                Thread.sleep(5000);

                String sms_code = (String) SupportController.getfromDatabase("SELECT bua_auth_code FROM bo_auth_log ORDER BY bua_id DESC LIMIT 1;", this.testLocation);

                this.driver.findElement(By.name("authcode")).sendKeys(sms_code);

                this.driver.findElement(By.cssSelector("button[class='btn btn-bricky btn-squared pull-right ladda-button']")).click();
            }
        } catch (Exception e) {
            System.out.println("TestScript Login-Error: " + e.getMessage());
            output = false;
        } finally {
            return output;
        }
    }


}
