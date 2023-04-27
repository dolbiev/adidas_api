package adidasTest.requests;

import org.junit.Test;
import org.junit.runner.RunWith;
import net.serenitybdd.junit.runners.SerenityRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class GetAvailablePets {

    private static final String BASE_URI = "https://petstore.swagger.io/v2";
    private static final String AVAILABLE_PETS_ENDPOINT = "/pet/findByStatus?status=available";

    @Test
    public void getAvailablePets() {
        given().baseUri(BASE_URI)
                .when().get(AVAILABLE_PETS_ENDPOINT)
                .then().assertThat().statusCode(200)
                .and().assertThat().body("status[0]", equalTo("available"));
    }
}
