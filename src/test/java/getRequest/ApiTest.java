package getRequest;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.glassfish.pfl.tf.spi.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class ApiTest extends SpesificMovie {




    @Test
    @Description(" ")
    public void searchMovie() {

        MovieResponse movieResult = searchSpecificMovie();
        Assert.assertNotNull(movieResult);
        searchById(movieResult);
    }




}
