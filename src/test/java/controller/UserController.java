package controller;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.User;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class UserController {
    RequestSpecification requestSpecification;
    private static final String BASE_URL = "https://petstore.swagger.io/v2/";
    private static final String USER_ENDPOINT = "user";

    public UserController() {
        requestSpecification = given()
                .accept(JSON)
                .contentType(JSON)
                .baseUri(BASE_URL);
    }

    public Response createUser(User user) {
        return given(requestSpecification)
                    .body(user)
                .when()
                    .post(USER_ENDPOINT)
                    .andReturn();
    }

    public Response updateUser(User user) {
        return given(requestSpecification)
                    .body(user)
                .when()
                    .put(USER_ENDPOINT + "/" + user.username())
                    .andReturn();
    }
}
