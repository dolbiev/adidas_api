package adidasTest.requests;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class AddNewPet {

    private static final String BASE_URI = "https://petstore.swagger.io/v2";
    private static final String ADD_PET_ENDPOINT = "/pet";

    @Test
    public void addNewPet() {
        String jsonBody = "{\n" +
                "  \"id\": 42069,\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Nibblerians\"\n" +
                "  },\n" +
                "  \"name\": \"Nibbler\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"https://static1.srcdn.com/wordpress/wp-content/uploads/2019/11/lord-nibbler-futurama-cartoon-hd-background-lumia.jpg\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 777,\n" +
                "      \"name\": \"Lord\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        given().baseUri(BASE_URI)
                .contentType("application/json")
                .body(jsonBody)
                .when().post(ADD_PET_ENDPOINT)
                .then().assertThat().statusCode(200)
                .and().assertThat().body("name", equalTo("Nibbler"));
    }
}
