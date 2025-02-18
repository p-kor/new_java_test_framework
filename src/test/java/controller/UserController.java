package controller;

import config.TestPropertiesConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.User;
import org.aeonbits.owner.ConfigFactory;

import static constant.CommonConstant.BASE_URI;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class UserController {
    RequestSpecification requestSpecification;
    private static final String USER_ENDPOINT = "user";
    TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    public UserController() {
        requestSpecification = given()
                .accept(JSON)
                .contentType(JSON)
                .baseUri(configProperties.getApiBaseUrl());
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
