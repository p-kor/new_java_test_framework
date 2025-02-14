import controller.UserController;
import io.restassured.response.Response;
import dto.AddUserResponse;
import model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

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
    void createInvalidUserControllerTest() {

        Response response = userController.createUser(INVALID_USER);
        AddUserResponse createdUserResponse = response.as(AddUserResponse.class); // map to Java object

        assertEquals(200, response.statusCode());
        assertEquals(200, createdUserResponse.code());
        assertEquals("unknown", createdUserResponse.type());
        assertEquals("0", createdUserResponse.message());
    }

    private static List<User> users() {

        return List.of(DEFAULT_USER, INVALID_USER);
    }

    @ParameterizedTest
    @MethodSource("users")
    void createUserParameterizedTest(User user) {

        Response response = userController.createUser(user);
        AddUserResponse createdUserResponse = response.as(AddUserResponse.class); // map to Java object

        assertEquals(200, response.statusCode());
        assertEquals(200, createdUserResponse.code());
        assertEquals("unknown", createdUserResponse.type());
        assertFalse(createdUserResponse.message().isEmpty());

    }
}
