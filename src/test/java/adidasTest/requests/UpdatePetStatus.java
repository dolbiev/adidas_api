package adidasTest.requests;

import org.junit.Test;
import org.junit.runner.RunWith;
import net.serenitybdd.junit.runners.SerenityRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class UpdatePetStatus {

    private static final String BASE_URI = "https://petstore.swagger.io/v2";
    private static final String UPDATE_PET_ENDPOINT = "/pet";

    @Test
    public void updatePetStatus() {
        String jsonBody = "{\n" +
                "  \"id\": 42069,\n" +
                "  \"status\": \"sold\"\n" +
                "}";
        given().baseUri(BASE_URI)
                .contentType("application/json")
                .body(jsonBody)
                .when().put(UPDATE_PET_ENDPOINT)
                .then().assertThat().statusCode(200)
                .and().assertThat().body("status", equalTo("sold"));
    }
}
