import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.path.json.JsonPath.with;

public class CreatewarehouseTest extends BaseTest{
    @Test
    public void preAddforWrhs(){
        Response response =
                RestAssured.given()
                        .baseUri("https://app.skeyerp.com:30027")
                        .header("Content-Type", "application/json")
                        .header("Authorization","Bearer "+token)
                        .header("Clientid","63")
                        .when()
                        .get("/erp/api/v1/stp/inv/wrhsData/preAdd");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
   public void createWrhs(){
       Response response =
               RestAssured.given()
                       .baseUri("https://app.skeyerp.com:30027")
                       .header("Accept-Language", "en")
                       .header("Authorization", "Bearer "+token)
                       .header("Content-Type", "application/json")
                       .header("clientID", "63")
                       .body("{\n" +
                               "  \"whCode\": \"202\",\n" +
                               "  \"whLNm\": \"hazem33\",\n" +
                               "  \"whFNm\": null,\n" +
                               "  \"whGrpNo\": 3,\n" +
                               "  \"whSrl\": 2,\n" +
                               "  \"acCodeTrnsfr\": null,\n" +
                               "  \"addrs\": null,\n" +
                               "  \"empCode\": null,\n" +
                               "  \"fDateInactv\": null,\n" +
                               "  \"tDateInactv\": null,\n" +
                               "  \"geogrphCode\": null,\n" +
                               "  \"noSalFlg\": true,\n" +
                               "  \"notes\": null,\n" +
                               "  \"whMainFlg\": false,\n" +
                               "  \"subldgr1Code\": null,\n" +
                               "  \"subldgr2Code\": null,\n" +
                               "  \"subldgr3Code\": null,\n" +
                               "  \"stpWrhsUntLst\": [\n" +
                               "    {\n" +
                               "      \"untNo\": 2,\n" +
                               "      \"rowStatus\": \"new\",\n" +
                               "      \"inactvFlg\": false,\n" +
                               "      \"dfltFlg\": true\n" +
                               "    }\n" +
                               "  ],\n" +
                               "  \"crtDateClk\": \"22/07/2024 12:25:12.304\"\n" +
                               "}")
                       .when()
                       .post("/erp/api/v1/stp/inv/wrhsData/add/");
       response.prettyPrint();
       response.then().statusCode(201);
   }
   @Test
    public void wrhsDataGrdLst(){
       Response response =
               RestAssured.given()
                       .baseUri("https://app.skeyerp.com:30027")
                       .body("{\n" +
                               "  \"pageNo\": 1,\n" +
                               "  \"pageSize\": 10,\n" +
                               "  \"lstTyp\": 0,\n" +
                               "  \"scrPrmtrLstFlg\": 1\n" +
                               "}")
                       .header("Content-Type", "application/json")
                       .header("Authorization","Bearer "+token)
                       .header("Clientid","63")
                       .when()
                       .post("/erp/api/v1/stp/inv/wrhsData/grdLst\n");
       response.prettyPrint();
       response.then().statusCode(200);
       response.then().body("dataSrcList[0].wh_nm", Matchers.equalTo("Main Warehouse"));
       response.then().body("dataSrcList[1].wh_nm", Matchers.equalTo("hazem33"));

   }
}
