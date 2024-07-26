
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAlbumTest {

    @Test
    public void deleteAlbum() {
        String token = LoginTest.getJwtToken();

        Response response = RestAssured.given()
                .baseUri("https://example.com/api")
                .header("Authorization", "Bearer " + token)
                .delete("/albums/{id}", "albumId");

        Assert.assertTrue(response.getStatusCode() == 200 || response.getStatusCode() == 204);
        // Add assertions to validate album deletion
    }
}
