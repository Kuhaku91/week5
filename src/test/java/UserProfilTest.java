
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfilTest {

    @Test
    public void getUserProfile() {
        String token = LoginTest.getJwtToken();

        Response response = RestAssured.given()
                .baseUri("https://example.com/api")
                .header("Authorization", "Bearer " + token)
                .get("/profile");

        Assert.assertEquals(response.getStatusCode(), 200);
        // Add assertions to validate user profile data
    }
}
