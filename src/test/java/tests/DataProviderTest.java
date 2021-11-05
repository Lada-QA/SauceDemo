package tests;

import org.testng.annotations.DataProvider;

public class DataProviderTest {

    @DataProvider(name = "User data")
    public static Object[][] inputForITechTask() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "Sauce Labs Bolt T-Shirt", "$15.99" },
                {"problem_user", "secret_sauce", "Sauce Labs Backpack", "$29.99" }

        };
    }
}
