import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
public class WarehouseTest extends BaseTest{
    @Test
    public void preAddforWrhs(){
        Response response =
                RestAssured.given()
                        .baseUri(baseurl+":30027")
                        .header("Content-Type", "application/json")
                        .header("Authorization","Bearer "+token)
                        .header("Clientid","63")
                        .when()
                        .get("/erp/api/v1/stp/inv/wrhsData/preAdd");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
   public void WrhsAdd(){
       Response response =
               RestAssured.given()
                       .baseUri(baseurl+":30027")
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
    public void wrhsGrdLst(){
       Response response =
               RestAssured.given()
                       .baseUri(baseurl+":30027")
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
       response.then().body("dataSrcList[0].wh_nm", Matchers.equalTo("Main Warehouse3"));
       response.then().body("dataSrcList[1].wh_nm", Matchers.equalTo("hazem33"));
   }
    @Test
    public void wrhsUpd(){
        Response response =
                RestAssured.given()
                        .baseUri(baseurl+":30027")
                        .body("{\n" +
                                "  \"whCode\": \"201\",\n" +
                                "  \"whLNm\": \"Main Warehouse3\",\n" +
                                "  \"whFNm\": \"Main Warehouse\",\n" +
                                "  \"whGrpNo\": 1,\n" +
                                "  \"whSrl\": 1,\n" +
                                "  \"acCodeTrnsfr\": null,\n" +
                                "  \"addrs\": \"Bengaluru\",\n" +
                                "  \"empCode\": null,\n" +
                                "  \"fDateInactv\": null,\n" +
                                "  \"tDateInactv\": null,\n" +
                                "  \"geogrphCode\": \"29\",\n" +
                                "  \"noSalFlg\": false,\n" +
                                "  \"notes\": null,\n" +
                                "  \"whMainFlg\": true,\n" +
                                "  \"subldgr1Code\": null,\n" +
                                "  \"subldgr2Code\": null,\n" +
                                "  \"subldgr3Code\": null,\n" +
                                "  \"stpWrhsUntLst\": [\n" +
                                "    {\n" +
                                "      \"whCode\": \"201\",\n" +
                                "      \"untNo\": 2,\n" +
                                "      \"dfltFlg\": true,\n" +
                                "      \"crtUsrNm\": \"admin\",\n" +
                                "      \"crtDate\": \"26/05/2024 09:11:11.988\",\n" +
                                "      \"updUsrNm\": \"admin\",\n" +
                                "      \"updDate\": \"30/06/2024 12:15:40.169\",\n" +
                                "      \"updCnt\": 1,\n" +
                                "      \"inactvFlg\": false,\n" +
                                "      \"inactvUsrNm\": null,\n" +
                                "      \"inactvDate\": null,\n" +
                                "      \"inactvDsc\": null,\n" +
                                "      \"rowStatus\": \"original\"\n" +
                                "    }\n" +
                                "  ],\n" +
                                "  \"crtDateClk\": \"23/07/2024 11:11:48.202\"\n" +
                                "}")
                        .header("Content-Type", "application/json")
                        .header("Authorization","Bearer "+token)
                        .header("Clientid","63")
                        .when()
                        .put("/erp/api/v1/stp/inv/wrhsData/upd");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}