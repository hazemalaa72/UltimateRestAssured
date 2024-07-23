import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import static io.restassured.path.json.JsonPath.with;
public class BaseTest {
    protected String token;
    protected  String baseurl;
    @BeforeClass
    public void getToken () {
        baseurl="https://app.skeyerp.com";
        Response response=
                RestAssured.given()
                        .baseUri(baseurl+":30001")
                        .body("{\n" +
                                "  \"usrCode\": \"admin\",\n" +
                                "  \"usrPswrd\": \"AubgrZeg\",\n" +
                                "  \"yrNo\": 2024,\n" +
                                "  \"untNo\": null,\n" +
                                "  \"clientCode\": \"ultind\",\n" +
                                "  \"lgnSys\": 1,\n" +
                                "  \"lgnTyp\": 1,\n" +
                                "  \"trmnlIp\": \"41.33.33.196\",\n" +
                                "  \"lgnDate\": \"2024-07-18T11:34:25.683Z\",\n" +
                                "  \"browserNm\": \"Chrome\"\n" +
                                "}")
                        .header("Content-Type","application/json")
                        .header("Clientcode","ultind")
                        .when()
                        .post("/api/Auth/Login");
        response.then().statusCode(200);
        token=with((response.body().asInputStream())).get("token");
    }
}