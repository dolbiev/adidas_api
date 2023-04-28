package adidasTest.requests;

import org.junit.Test;
import org.junit.runner.RunWith;
import net.serenitybdd.junit.runners.SerenityRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class UpdatePetStatus {

    //Set URI
    private static final String BASE_URI = "https://petstore.swagger.io/v2";
    //Set endpoint
    private static final String UPDATE_PET_ENDPOINT = "/pet";

    @Test
    public void updatePetStatus() {
        //Set JSON with new data
        String jsonBody = "{\n" +
                "  \"id\": 42069,\n" +
                "  \"status\": \"sold\"\n" +
                "}";
        //Send given JSON to endpoint
        given().baseUri(BASE_URI)
                .contentType("application/json")
                .body(jsonBody)
                .when().put(UPDATE_PET_ENDPOINT)
                //Assert that status code is OK
                .then().assertThat().statusCode(200)
                //Assert that "status" of "pet" had changed
                .and().assertThat().body("status", equalTo("sold"));
    }
}
