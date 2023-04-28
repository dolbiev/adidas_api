package adidasTest.requests;

import org.junit.Test;
import org.junit.runner.RunWith;
import net.serenitybdd.junit.runners.SerenityRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class GetAvailablePets {

    //Set URI
    private static final String BASE_URI = "https://petstore.swagger.io/v2";
    //Set endpoint
    private static final String AVAILABLE_PETS_ENDPOINT = "/pet/findByStatus?status=available";

    @Test
    public void getAvailablePets() {
        //Get all "pets" with status "available"
        given().baseUri(BASE_URI)
                .when().get(AVAILABLE_PETS_ENDPOINT)
                //Assert that status code is OK
                .then().assertThat().statusCode(200)
                //Assert that "status" of "pets" is "available"
                .and().assertThat().body("status[0]", equalTo("available"));
    }
}
