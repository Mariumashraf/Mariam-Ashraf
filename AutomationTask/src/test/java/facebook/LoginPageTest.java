package facebook;

import com.common.helpers.Wrappers.JsonReader;
import com.common.helpers.Wrappers.PropertiesReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class LoginPageTest extends BaseTest {

    JsonReader jsonReader = new JsonReader(PropertiesReader.getProperty("LoginData"));

    @Test
    public void loginSuccessfully() {
        loginPage.typeCredential(jsonReader.getNodeValue("validUsers", "email").get(0), jsonReader.getNodeValue("validUsers", "password").get(0));
        loginPage.clickOnLoginBtn();
        homePage.checkHomePageIsDisplayed();
    }

    @Test(dataProvider = "invalidLoginData")
    public void loginWithInvalidDataAndGetErrorMessage(String email, String password, String errorMessage) {
        loginPage.typeCredential(email, password);
        loginPage.clickOnLoginBtn();
        loginPage.checkErrorMessage(errorMessage);
    }

    @DataProvider
    public Object[][] invalidLoginData() {
        Object[][] invalidLoginData = new Object[4][3];
        ArrayList<String> email;
        ArrayList<String> password;
        ArrayList<String> errorMessage;
        email = jsonReader.getNodeValue("invalidUsers", "email");
        password = jsonReader.getNodeValue("invalidUsers", "password");
        errorMessage = jsonReader.getNodeValue("invalidUsers", "errorMessage");
        for (int i = 0; i < 4; i++) {
            invalidLoginData[i][0] = email.get(i);
            invalidLoginData[i][1] = password.get(i);
            invalidLoginData[i][2] = errorMessage.get(i);
        }
        return invalidLoginData;
    }
}
