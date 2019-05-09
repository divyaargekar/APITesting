package com.qspiders.pnhs;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by nishiveg on 5/29/2018.
 */
@RunWith(CucumberWithSerenity.class)
//@CucumberOptions(features="src/test/resources/features/AddBranch.feature")
//@CucumberOptions(features="src/test/resources/features/GetBranch.feature")
@CucumberOptions(features="src/test/resources/features/DeleteBranch.feature")
public class AutomationRunner {
}
