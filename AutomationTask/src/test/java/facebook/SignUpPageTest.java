package facebook;

import com.common.helpers.Wrappers.ExcelReader;
import com.common.helpers.Wrappers.JsonReader;
import com.common.helpers.Wrappers.PropertiesReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class SignUpPageTest extends BaseTest {

    JsonReader jsonReader = new JsonReader(PropertiesReader.getProperty("InvalidSignUpData"));

    @Test(dataProvider = "validUsersData")
    public void signUpSuccessfully(String fName, String lName, String email, String password, String birthData, String gender) {
        signUpPage.clickOnCreateNewAccountBtn();
        signUpPage.createNewAccount(fName, lName, email, email, password, birthData, gender);
        signUpPage.clickOnSignUpBtn();
        homePage.checkHomePageIsDisplayed();
    }

    @DataProvider
    public Object[][] validUsersData() throws IOException {
        // get data from Excel Reader class
        ExcelReader excelReader = new ExcelReader();
        return excelReader.getExcelData(PropertiesReader.getProperty("ValidSignUpData"), 6);
    }

    @Test(dataProvider = "invalidSignUpData")
    public void signUpWithInvalidData(String fName, String lName, String email, String confirmEmail, String password, String birthData, String gender, String errorMessage) throws InterruptedException {
        signUpPage.clickOnCreateNewAccountBtn();
        signUpPage.createNewAccount(fName, lName, email, confirmEmail, password, birthData, gender);
        signUpPage.clickOnSignUpBtn();
        signUpPage.checkErrorMessage(errorMessage);
    }

    @DataProvider
    public Object[][] invalidSignUpData() {
        Object[][] invalidSignUpData = new Object[7][8];
        ArrayList<String> fName;
        ArrayList<String> lName;
        ArrayList<String> email;
        ArrayList<String> confirmEmail;
        ArrayList<String> password;
        ArrayList<String> bDate;
        ArrayList<String> gender;
        ArrayList<String> errorMessage;

        fName = jsonReader.getNodeValue("invalidUsers", "fName");
        lName = jsonReader.getNodeValue("invalidUsers", "lName");
        email = jsonReader.getNodeValue("invalidUsers", "email");
        confirmEmail = jsonReader.getNodeValue("invalidUsers", "confirmEmail");
        password = jsonReader.getNodeValue("invalidUsers", "password");
        bDate = jsonReader.getNodeValue("invalidUsers", "bDate");
        gender = jsonReader.getNodeValue("invalidUsers", "gender");
        errorMessage = jsonReader.getNodeValue("invalidUsers", "errorMessage");

        for (int i = 0; i < 7; i++) {
            invalidSignUpData[i][0] = fName.get(i);
            invalidSignUpData[i][1] = lName.get(i);
            invalidSignUpData[i][2] = email.get(i);
            invalidSignUpData[i][3] = confirmEmail.get(i);
            invalidSignUpData[i][4] = password.get(i);
            invalidSignUpData[i][5] = bDate.get(i);
            invalidSignUpData[i][6] = gender.get(i);
            invalidSignUpData[i][7] = errorMessage.get(i);
        }
        return invalidSignUpData;
    }
}
