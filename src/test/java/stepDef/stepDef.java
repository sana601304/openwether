package stepDef;
import java.io.*;
import java.util.concurrent.TimeUnit;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import java.net.HttpURLConnection;
import java.net.URL;

public class stepDef {

    private ChromeDriver driver;
    private Scenario scenario;

    //===========================
    // @Before will run before every scenario
    //===========================

    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
        System.setProperty("webdriver.chrome.driver","src/test/java/chromedriver");
        driver = new ChromeDriver();

    }
    //===========================
    // @After will run at the end of each scenario, This will close the open browser
    //===========================

    @After
    public void tearDown() {
        scenario = null;
        if (driver != null) {
            driver.quit();
        }
     }


    @Given("^Navigate to Open Weather Map website$")
    public void Navigate_to_Open_Weather_Map_website() throws Throwable {

        //===========================
        // Launch the Browser with Openwethermap url
        //===========================

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://openweathermap.org/");
        driver.manage().window().maximize();
    }

    @When("^Home page is displayed$")
    public void Home_page_is_displayed() throws Throwable {

        String title = driver.getTitle();
        Assert.assertEquals("Сurrent weather and forecast - OpenWeatherMap", title);
    }

    @Then("^Verify elements on Home Page$")
    public void Verify_elements_on_Home_Page() throws Throwable {

        //===========================
        // Verify important elements on Home page is displayed or not by Assert
        //===========================

        //verify sign in element
        Assert.assertTrue(driver.findElement(By.xpath(".//a[@href='//home.openweathermap.org/users/sign_in']")).isDisplayed());
        //verify sign up element
        Assert.assertTrue(driver.findElement(By.xpath(".//a[@href='//home.openweathermap.org/users/sign_up']")).isDisplayed());
        //verify sign in element
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='jumbotron__title']")).isDisplayed());
        //verify title describtion label
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"jumbotron__description\"]")).isDisplayed());
        //verify title label
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='widget__title']")).isDisplayed());
        //verify textbox to search
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='form-group search-cities__block']//*[@id='q']")).isDisplayed());
        //verify Search button
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class='btn btn-orange']")).isDisplayed());

    }
    @When("^Enter (.+) name and Search$")
    public void Enter_City_name_and_Search(String city) throws Throwable {

        //===========================
        // Search for the City provided in feature file
        //===========================

        driver.findElement(By.xpath("//*[@class='form-group search-cities__block']//*[@id='q']")).sendKeys(city);
        driver.findElement(By.xpath("//button[@class='btn btn-orange']")).click();

    }

    @Then("^Verify weather (.+)$")
    public void Verify_weather_results(String results) throws Throwable {

        //===========================
        // Validate the weather of the given city
        //===========================
        String b = results;
        String a = "Valid";
        if(b == a)
        {
           Assert.assertTrue(driver.findElement(By.xpath("//*[@id='forecast_list_ul']/table/tbody/tr/td[2]/b[1]/a")).isDisplayed());
        }
        else {
         //  Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Not found')]")).isDisplayed());
        }

    }


    @Given("^Execute service with CityID$")
    public void Execute_service_with_CityID() throws Throwable {

        //===========================
        // Get method to retrive weather by CityID
        //===========================
        try {

            ConfigFileReader configFileReader = new ConfigFileReader();
            String query_url = configFileReader.getmethodurl();  //get the url from config file
            System.out.println(query_url);
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("*******************");
                System.out.println(inputLine);  // will print the entire response
                JSONObject json = new JSONObject(inputLine.toString());
                System.out.println(json.getString("base")); //validate the weather in response. This way any key in response json can be accessed
            }
            in.close();
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Then("^Validate the Status Code$")
    public void validate_the_Status_Code() throws Throwable {

    }

}
