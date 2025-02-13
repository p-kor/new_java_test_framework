import controller.UserController;
import io.restassured.response.Response;
import dto.AddUserResponse;
import model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ApiTest {

    private final UserController userController = new UserController();

    @Test
    void createUserControllerTest() {
        User user = new User(
                0,
                "username",
                "firstName",
                "lastName",
                "email",
                "password",
                "phone",
                0);

        Response response = userController.createUser(user);
        AddUserResponse createdUserResponse = response.as(AddUserResponse.class);

        assertEquals(200, response.statusCode());
        assertEquals(200, createdUserResponse.code());
        assertEquals("unknown", createdUserResponse.type());
        assertFalse(createdUserResponse.message().isEmpty());


    }
}
