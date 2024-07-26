
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateAlbumTest {

    @Test
    public void updateAlbum() {
        String token = LoginTest.getJwtToken();

        Response response = RestAssured.given()
                .baseUri("https://example.com/api")
                .header("Authorization", "Bearer " + token)
                .body("{ \"title\": \"Updated Album\", \"artist\": \"Updated Artist\" }")
                .put("/albums/{id}", "albumId");

        Assert.assertEquals(response.getStatusCode(), 200);
        // Add assertions to validate album update
    }
}
