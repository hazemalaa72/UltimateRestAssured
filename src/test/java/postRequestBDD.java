import io.restassured.RestAssured;

public class postRequestBDD {
    public static void main(String[] args) {
        RestAssured.given()
                .baseUri("https://reqres.in/api/users")
                .body("{\"name\": \"morpheus\",\"job\": \"leader\"}")
                .header("Content-Type","application/json")
                .when()
                .post()
                .prettyPrint();
    }
}
