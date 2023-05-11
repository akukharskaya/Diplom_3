package praktikum.services;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import praktikum.requests.UserRequest;

import static io.restassured.RestAssured.given;

public class UserService {
    public static final String PATH_LOGIN = "api/auth/login";
    public static final String PATH_USER = "api/auth/user";

    public String getToken(UserRequest userRequest){
        var request = auth(userRequest);
        return request.then().extract().path("accessToken");
    }

    public void delete(UserRequest userRequest){
        var token = getToken(userRequest);

        given()
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .and()
                .when()
                .delete(PATH_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_ACCEPTED);
    }

    public Response auth(UserRequest userRequest){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(userRequest)
                .when()
                .post(PATH_LOGIN);
    }


}
