import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
public class FiscalGrdlstTest extends BaseTest {
@Test
    public void grdLstLApiTest() {
        Response response =
                RestAssured.given()
                        .baseUri("https://app.skeyerp.com:30027")
                        .body("{\n" +
                                "    \"pageNo\": 1,\n" +
                                "    \"pageSize\": 10,\n" +
                                "    \"lstTyp\": 0,\n" +
                                "    \"scrPrmtrLstFlg\": 0\n" +
                                "}")
                        .header("Content-Type", "application/json")
                        .header("Authorization","Bearer "+token)
                        .header("Clientid","63")
                        .when()
                        .post("/erp/api/v1/stp/fsclPrd/grdLst");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}

