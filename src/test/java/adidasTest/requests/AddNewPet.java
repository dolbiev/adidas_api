package adidasTest.requests;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class AddNewPet {

    //Set URI
    private static final String BASE_URI = "https://petstore.swagger.io/v2";
    //Set endpoint
    private static final String ADD_PET_ENDPOINT = "/pet";

    @Test
    public void addNewPet() {
        //Set JSON with information about "pet"
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
        //Send JSON to endpoint
        given().baseUri(BASE_URI)
                .contentType("application/json")
                .body(jsonBody)
                .when().post(ADD_PET_ENDPOINT)
                //Assert that status code is OK
                .then().assertThat().statusCode(200)
                //Assert that "name" of "pet" had changed
                .and().assertThat().body("name", equalTo("Nibbler"));
    }
}
