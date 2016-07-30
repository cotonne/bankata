package com.arolla.functionnal;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:scenarios/bank.feature"
)

public class RunCucumberTest {

}
