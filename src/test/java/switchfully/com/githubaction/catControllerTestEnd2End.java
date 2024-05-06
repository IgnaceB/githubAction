package switchfully.com.githubaction;

import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import static io.restassured.http.ContentType.JSON;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class catControllerTestEnd2End {
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void viewReport_givenCustomerIsConnectedAndAllowed_thenReturnNewReportDTO() {
        String listOfCats =
                RestAssured.given()
                        .accept(JSON)
                        .contentType(JSON)
                        .when()
                        .port(port)
                        .get("/cats")
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.OK.value())
                        .extract()
                        .asString();

        Assertions.assertThat(listOfCats).isEqualTo("Oh no... cats are removed");
    }
}
