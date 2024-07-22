import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
public class CreateWarehouseGroupTest extends BaseTest {
    @Test
    public void createWarehouse(){
        Response response =
                RestAssured.given()
                        .baseUri("https://app.skeyerp.com:30027")
                        .body("{\n" +
                                "    \"whGrpNo\": 3,\n" +
                                "    \"whGrpLNm\": \"hazem50\",\n" +
                                "    \"whGrpFNm\": null,\n" +
                                "    \"notes\": null,\n" +
                                "    \"crtDateClk\": \"22/07/2024 09:50:43.865\"\n" +
                                "}")
                        .header("Content-Type", "application/json")
                        .header("Authorization","Bearer "+token)
                        .header("Clientid","63")
                        .when()
                        .post("/erp/api/v1/stp/inv/grpWrhs/add");
        response.prettyPrint();
        response.then().statusCode(201);


    }
}
