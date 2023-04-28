package adidasTest.requests;

import org.junit.Test;
import org.junit.runner.RunWith;
import net.serenitybdd.junit.runners.SerenityRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class DeletePet {

    //Set URI
    private static final String BASE_URI = "https://petstore.swagger.io/v2";
    //Set endpoint
    private static final String DELETE_PET_ENDPOINT = "/pet/42069";

    @Test
    public void deletePet() {
    //Take URI and endpint
        given().baseUri(BASE_URI)
                .when().delete(DELETE_PET_ENDPOINT)
                //Assert that status code is OK
                .then().assertThat().statusCode(200)
                .and().assertThat().body("code", equalTo(200))
                //Assert that "pet" has deleted
                .and().assertThat().body("type", equalTo("unknown"))
                .and().assertThat().body("message", equalTo("42069"));
    }
}
