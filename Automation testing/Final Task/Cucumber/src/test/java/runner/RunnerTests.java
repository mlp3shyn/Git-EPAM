package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// Даний клас є початковою точкою входження в тестування
//features - шлях до папки з features файлами
//glue - пакет де знаходяться клааси з реалізацією кроків

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/main/resources/finaltests.feature",
    glue = "stepdefinitions"
)
public class RunnerTests {

}
