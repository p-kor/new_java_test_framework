import controller.UserController;
import io.restassured.response.Response;
import dto.AddUserResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static testdata.TestData.DEFAULT_USER;
import static testdata.TestData.INVALID_USER;

public class ApiTest {

    private final UserController userController = new UserController();

    @Test
    void createUserControllerTest() {

        Response response = userController.createUser(DEFAULT_USER);
        AddUserResponse createdUserResponse = response.as(AddUserResponse.class); // map to Java object

        assertEquals(200, response.statusCode());
        assertEquals(200, createdUserResponse.code());
        assertEquals("unknown", createdUserResponse.type());
        assertFalse(createdUserResponse.message().isEmpty());
    }

    @Test
    void createUserControllerTest2() {

        Response response = userController.createUser(INVALID_USER);
        AddUserResponse createdUserResponse = response.as(AddUserResponse.class); // map to Java object

        assertEquals(200, response.statusCode());
        assertEquals(200, createdUserResponse.code());
        assertEquals("unknown", createdUserResponse.type());
        assertFalse(createdUserResponse.message().isEmpty());
    }
}
