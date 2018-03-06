package com.mycompany.steps;

import com.mycompany.pages.SignIn;
import com.mycompany.utils.Price;
import com.mycompany.utils.UserDetails;
import com.mycompany.utils.WebDriverUtility;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.it.Ma;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyStepdefs {
    private Map<String, Integer> priceList;
    private Map<String, Price> intlPriceList;
    private int totalEuroSum;
    private int totalSekSum;
    private int totalSum;

    @Given("^I visit the website$")
    public void iVisitTheWebsite() throws Throwable {
        WebDriverUtility.openUrl("www.gmail.com");
    }

    @And("^I close the website after some time$")
    public void iCloseTheWebsiteAfterSomeTime() throws Throwable {
        WebDriverUtility.waitFor();
        WebDriverUtility.closeBrowser();
    }

//    @And("^I entered username and click continue$")
//    public void iEnteredUsernameAndClickContinue() throws Throwable {
//        SignIn signIn = new SignIn(new WebDriverUtility().getDriver());
//        signIn.userLogin("utpal.kumar74","test123");
//    }


    @And("^I entered username password and click continue$")
    public void iEnteredUsernamePasswordAndClickContinue(List<UserDetails> user) throws Throwable {
        UserDetails userDetails = user.get(0);
        SignIn signIn = new SignIn(new WebDriverUtility().getDriver());
        signIn.userLogin(userDetails.getUsername(), userDetails.getPassword());
    }

    @Given("^the price list for a coffee shop$")
    public void thePriceListForACoffeeShop(Map<String, Integer> priceList) throws Throwable {
        this.priceList = priceList;
    }

    @When("^I order (\\d+) coffee and (\\d+) donut$")
    public void iOrderCoffeeAndDonut(int coffeeCount, int donutCount) throws Throwable {
        int coffeePrice = priceList.get("coffee") * coffeeCount;
        int donutPrice = priceList.get("donut") * donutCount;
        totalSum = coffeePrice + donutPrice;
    }

    @Then("^should I pay (\\d+)$")
    public void shouldIPay(int paidTotal) throws Throwable {
        Assert.assertTrue("You didn't pay well", paidTotal == totalSum);
    }

    @Given("^the price list for an international coffee shop$")
    public void thePriceListForAnInternationalCoffeeShop(List<Price> prices) throws Throwable {
        intlPriceList = new HashMap<String, Price>();

        for (Price price : prices) {
            String key = price.getProduct();
            intlPriceList.put(key, price);
        }
    }

    @When("^I buy (\\d+) (.*) and (\\d+) (.*)$")
    public void iBuyCoffeeAndDonut(int coffeeCount, String coffee,
                                   int donutCount, String donut) throws Throwable {
        Price coffeePrice = intlPriceList.get(coffee);
        calculate(coffeeCount, coffeePrice);
        Price donutPrice = intlPriceList.get(donut);
        calculate(donutCount, donutPrice);
    }

    @Then("^should I pay (\\d+) EUR and (\\d+) SEK$")
    public void shouldIPayEURAndSEK(int expectedCoffeePay, int expecteddonutPay) throws Throwable {
        Assert.assertTrue("Coffee is not paid well", expectedCoffeePay == totalEuroSum);
        Assert.assertTrue("Donut is not paid well", expecteddonutPay == totalSekSum);
    }

    private void calculate(int numOfItem, Price price) {
        if (price.getCurrency().equals("EUR")) {
            totalEuroSum = numOfItem * price.getPrice();
            return;
        } else if (price.getCurrency().equals("SEK")) {
            totalSekSum = numOfItem * price.getPrice();
            return;
        }
        throw new IllegalArgumentException("The currency is unknown");
    }
}
