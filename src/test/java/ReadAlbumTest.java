
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadAlbumTest {

    @Test
    public void readAlbum() {
        String token = LoginTest.getJwtToken();

        Response response = RestAssured.given()
                .baseUri("https://example.com/api")
                .header("Authorization", "Bearer " + token)
                .get("/albums");

        Assert.assertEquals(response.getStatusCode(), 200);
        // Add assertions to validate album data
    }
}
