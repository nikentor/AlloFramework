        package api;

        import static java.lang.Thread.sleep;
        import static org.testng.Assert.*;
        import builders.UserBuilder;
        import dto.request.UserDTO;
        import dto.response.RspUserDTO;
        import dto.response.RspCreateUserDTO;
        import io.restassured.RestAssured;
        import io.restassured.http.ContentType;
        import io.restassured.response.Response;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;


        import static io.restassured.RestAssured.given;

        public class UserApiTest {

            private static final int OK = 200;
            private static final UserDTO USER = UserBuilder.createUser();

            @BeforeClass public void setUp() {
                RestAssured.baseURI = "https://petstore.swagger.io/v2";
            }
            @Test(priority = 1)
            public void createUserTest () throws InterruptedException {
            Response response = given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .body(USER)
                    .when()
                    .post("/user")
                    .then()
                    .statusCode(OK)
                    .extract().response();

                response.prettyPrint();
                RspCreateUserDTO responseDTO = response.as(RspCreateUserDTO.class);

                assertEquals(responseDTO.getCode(), OK);
                assertEquals(responseDTO.getType(), "unknown");
                assertNotNull(responseDTO.getMessage());

                sleep(3000);
                    }

            @Test(priority = 2)
            public void loginUserTest() throws InterruptedException {
                Response response = given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .queryParam("username", USER.getUsername())
                        .queryParam("password", USER.getPassword())
                        .when()
                        .get("/user/login")
                        .then()
                        .statusCode(OK)
                        .extract().response();

                response.prettyPrint();

                RspCreateUserDTO responseDTO = response.as(RspCreateUserDTO.class);

                assertEquals(responseDTO.getCode(), OK);
                assertEquals(responseDTO.getType(), "unknown");
                assertNotNull(responseDTO.getMessage());

                sleep(3000);
            }

            @Test(priority = 3)
            public void getUserByUsernameTest() throws InterruptedException {

                Response response = given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .pathParam("username", USER.getUsername())
                        .when()
                        .get("/user/{username}")
                        .then()
                        .statusCode(OK)
                        .extract().response();

                response.prettyPrint();

                RspUserDTO responseDTO = response.as(RspUserDTO.class);

                assertEquals(responseDTO.getUsername(), USER.getUsername());
                assertEquals(responseDTO.getFirstName(), USER.getFirstName());
                assertEquals(responseDTO.getLastName(), USER.getLastName());
                assertEquals(responseDTO.getEmail(), USER.getEmail());

                sleep(3000);
            }

            @Test(priority = 4)
            public void updateUserTest() throws InterruptedException {

                USER.setFirstName("Andriy Volodymyrovych");

                Response response = given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(USER)
                        .when()
                        .put("/user/" + USER.getUsername())
                        .then()
                        .statusCode(OK)
                        .extract().response();

                response.prettyPrint();

                RspCreateUserDTO responseDTO = response.as(RspCreateUserDTO.class);

                assertEquals(responseDTO.getCode(), OK);
                assertNotNull(responseDTO.getMessage());

                sleep(3000);
            }

            @Test(priority = 5)
            public void getUpdateUserTest() throws InterruptedException {

                Response response = given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .pathParam("username", USER.getUsername())
                        .when()
                        .get("/user/{username}")
                        .then()
                        .statusCode(OK)
                        .extract().response();

                response.prettyPrint();

                RspUserDTO responseDTO = response.as(RspUserDTO.class);

                assertEquals(responseDTO.getUsername(), USER.getUsername());
                assertEquals(responseDTO.getFirstName(), "Andriy Volodymyrovych");

                sleep(3000);
            }

            @Test(priority = 6)
            public void deleteUserTest() throws InterruptedException {

                Response response = given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .pathParam("username", USER.getUsername())
                        .when()
                        .delete("/user/{username}")
                        .then()
                        .statusCode(OK)
                        .extract().response();

                response.prettyPrint();

                RspCreateUserDTO responseDTO = response.as(RspCreateUserDTO.class);

                assertEquals(responseDTO.getCode(), OK);
                assertNotNull(responseDTO.getMessage());

                sleep(3000);
            }

            @Test(priority = 7)
            public void getDeletedUserTest() throws InterruptedException {

                Response response = given()

                        .log().all()
                        .contentType(ContentType.JSON)
                        .pathParam("username", USER.getUsername())
                        .when()
                        .get("/user/{username}")
                        .then()
                        .statusCode(404)
                                .extract().response();

                response.prettyPrint();

                RspCreateUserDTO responseDTO = response.as(RspCreateUserDTO.class);

                assertEquals(responseDTO.getCode(), 1);
                assertEquals(responseDTO.getType(), "error");
                assertEquals(responseDTO.getMessage(), "User not found");

                sleep(3000);
            }

            @Test(priority = 8)
            public void logoutUserTest() throws InterruptedException {

                Response response = given()
                        .log().all()
                        .when()
                        .get("/user/logout")
                        .then()
                        .statusCode(OK)
                        .extract().response();

                response.prettyPrint();

                RspCreateUserDTO responseDTO = response.as(RspCreateUserDTO.class);

                assertEquals(responseDTO.getCode(), OK);
                assertEquals(responseDTO.getType(), "unknown");
                assertNotNull(responseDTO.getMessage());

                sleep(3000);
            }
        }
