import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;

public class getRequestBdd {
    public static void main(String[] args) {
        Response response =
        RestAssured.given()
                .baseUri("https://jsonplaceholder.typicode.com/comments")
                .queryParam("postId",1)
                .when()
                .get();
        response.prettyPrint();
        // Assertion
        response.then().statusCode(200);
        response.then().body("[0].name", Matchers.equalTo("id labore ex et quam laborum"));
        response.then().body("[4].email", Matchers.equalTo("Hayden@althea.biz"));
               
    }
}
