package com.api.project.demo.runnerFile;

import org.junit.runner.RunWith;

import com.api.project.demo.base.SerenityBase;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(monochrome = true, strict = false,
        features = "src/test/resources/features",
        glue = { "com.api.project.demo.stepdefinations" }, tags = { "@Demo" },
        plugin = { "pretty", "html:target/cucumber",
                "json:target/cucumber.json", "junit:target/cucumber.xml",
                "json:target/cucumber-json-report.json",
                "html:target/cucumber-html-report" })

public class RunnerCukes extends SerenityBase {

}