
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private static String jwtToken;

    @BeforeClass
    public void login() {
        Response response = RestAssured.given()
                .baseUri("https://example.com/api")
                .body("{ \"username\": \"user\", \"password\": \"pass\" }")
                .post("/login");

        Assert.assertEquals(response.getStatusCode(), 200);
        jwtToken = response.jsonPath().getString("token");
    }

    public static String getJwtToken() {
        return jwtToken;
    }
}
