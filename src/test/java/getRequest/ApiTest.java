package getRequest;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.glassfish.pfl.tf.spi.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class ApiTest {

    private static String URL = "http://omdbapi.com";
    private static String API_KEY = "59390783";

    @Test
    @Description(" ")
    public void searchMovie() {

        MovieResponse movieResult = searchSpesificMovie();
        Assert.assertNotNull(movieResult);
        searchById(movieResult);
    }

    @Description("Search for spesific name with parameters under \"By Search\"")
    public MovieResponse searchSpesificMovie() {
        ValidatableResponse response = given()
                .param("s", "Harry Potter")
                .param("apikey", API_KEY)
                .when()
                .get(URL)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

        SearchResponse r = response.extract().response().as(SearchResponse.class);
        for (MovieResponse mr: r.getSearch())  {
            if (mr.getTitle().equals("Harry Potter and the Sorcerer's Stone")) {
                return mr;
            }
        }
        return null;
    }

    @Description("Search for spesific id with parameters under \"By ID or Title\"")
    private void searchById(MovieResponse movieResult) {
        ValidatableResponse response = given()
                .param("i", movieResult.getImdbID())
                .param("apikey", API_KEY)
                .when()
                .get(URL)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

        MovieResponse mr = response.extract().response().as(MovieResponse.class);
        System.out.println(mr.getReleased());

    }
}
