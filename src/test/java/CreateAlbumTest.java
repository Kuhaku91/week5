
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAlbumTest {

    @Test
    public void createAlbum() {
        String token = LoginTest.getJwtToken();

        Response response = RestAssured.given()
                .baseUri("https://example.com/api")
                .header("Authorization", "Bearer " + token)
                .body("{ \"title\": \"New Album\", \"artist\": \"Artist Name\" }")
                .post("/albums");

        Assert.assertEquals(response.getStatusCode(), 201);

    }

}
