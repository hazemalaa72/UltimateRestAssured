import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class getRequestNonBDD {
    public static void main(String[] args) {
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
        RequestSpecification request=RestAssured.given();
        request.queryParam("userId","9");
        Response response=request.get();
        response.prettyPrint();
        //Assertion
        response.then().statusCode(200);
        int statuscode=response.getStatusCode();
        Assert.assertEquals(statuscode,200);
    }
}
