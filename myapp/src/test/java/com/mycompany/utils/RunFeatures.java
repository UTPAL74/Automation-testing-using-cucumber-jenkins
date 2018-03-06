package com.mycompany.utils;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/Features/InternationalPriceList.feature",
        glue = "com.mycompany.steps",
        format = {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"})
public class RunFeatures {

}
