package com.mycompany.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class MyArithmeticStepDef {
    private List<Integer> numbers;
    private int sum;

    @Given("^a list of numbers$")
    public void aListOfNumbers(List<Integer> numbers) throws Throwable {
        this.numbers = numbers;
    }

    @When("^I summarize them$")
    public void iSummarizeThem() throws Throwable {
        for (Integer num : numbers){
            sum += num;
        }
    }

    @Then("^I should get (\\d+)$")
    public void iShouldGet(int expectedSum) throws Throwable {
        Assert.assertTrue("Sum is not correct!",expectedSum == this.sum);
    }
}
