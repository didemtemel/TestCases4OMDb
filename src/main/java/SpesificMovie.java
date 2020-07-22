import getRequest.MovieResponse;
import getRequest.SearchResponse;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.glassfish.pfl.tf.spi.annotation.Description;

import static io.restassured.RestAssured.given;

public class SpesificMovie {

    private static String URL = "http://omdbapi.com";
    private static String API_KEY = "59390783";


    @Description("Search for specific name with parameters under \"By Search\"")
    public MovieResponse searchSpecificMovie() {
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
            Assert.assertEquals(mr.getTitle(),"Harry Potter and the Sorcerer's Stone");

            if (mr.getTitle().equals("Harry Potter and the Sorcerer's Stone")) {
                return mr;
            }
        }
        return null;
    }

    @Description("Search for specific id with parameters under \"By ID or Title\"")
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
        Assert.assertEquals(mr.getTitle(),"Harry Potter and the Sorcerer's Stone");
        Assert.assertEquals(mr.getYear(),"2001");
        Assert.assertEquals(mr.getReleased(),"16 Nov 2001");

    }

}
