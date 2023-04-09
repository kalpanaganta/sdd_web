package com.sdd.home.page;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",},
        tags = "@acceptance",
        features = {"src/test/resources/com/sdd/home/web/sddLandingPage.feature"},
        glue = {"com.sdd.home.page"},
        dryRun = false,
        monochrome = true)

public class SDD_Test {

}
