package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"C:\\Users\\ssathi\\eclipse-workspace-bench\\HTTPMethods_RestAssured_BDD\\src\\test\\resources"},
		//tags="@GET",
		//tags="@POST",
		//tags="@PUT",
		//tags="@Patch",
		tags="@Delete",
		glue="StepDefinitions",
		dryRun=false,
		monochrome=true
		)
public class Runner {

}
