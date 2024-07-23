import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
public class WarehouseGroupTest extends BaseTest {
    @Test
    public void wrhsGrpOnLoad(){
        Response response =
                RestAssured.given()
                        .baseUri(baseurl+":30027")
                        .header("Content-Type", "application/json")
                        .header("Authorization","Bearer "+token)
                        .header("Clientid","63")
                        .when()
                        .get("/erp/api/v1/stp/inv/grpWrhs/onload");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void wrhsGrpGetByCode(){
        Response response =
                RestAssured.given()
                        .baseUri(baseurl+":30027")
                        .header("Content-Type", "application/json")
                        .header("Authorization","Bearer "+token)
                        .header("Clientid","63")
                        .when()
                        .get("/erp/api/v1/stp/inv/grpWrhs/getByCode/1");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void wrhsGrpGetByPage(){
        Response response =
                RestAssured.given()
                        .baseUri(baseurl+":30027")
                        .header("Content-Type", "application/json")
                        .header("Authorization","Bearer "+token)
                        .header("Clientid","63")
                        .when()
                        .get("/erp/api/v1/stp/inv/grpWrhs/getPage/2");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void wrhsGrpGetChldrnByParnt(){
        Response response =
                RestAssured.given()
                        .baseUri(baseurl+":30027")
                        .header("Content-Type", "application/json")
                        .header("Authorization","Bearer "+token)
                        .header("Clientid","63")
                        .when()
                        .get("/erp/api/v1/stp/inv/grpWrhs/getChldrnByParnt/1");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void wrhsGrpPreAdd(){
        Response response =
                RestAssured.given()
                        .baseUri(baseurl+":30027")
                        .header("Content-Type", "application/json")
                        .header("Authorization","Bearer "+token)
                        .header("Clientid","63")
                        .when()
                        .get("/erp/api/v1/stp/inv/grpWrhs/preAdd");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void wrhsGrpAdd(){
        Response response =
                RestAssured.given()
                        .baseUri(baseurl+":30027")
                        .body("{\n" +
                                "    \"whGrpNo\": 777,\n" +
                                "    \"whGrpLNm\": \"hazem58\",\n" +
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
    @Test
    public void wrhsGrpGrdLst(){
        Response response =
                RestAssured.given()
                        .baseUri(baseurl+":30027")
                        .body("{\n" +
                                "  \"pageNo\": 1,\n" +
                                "  \"pageSize\": 10,\n" +
                                "  \"lstTyp\": 0,\n" +
                                "  \"scrPrmtrLstFlg\": 0\n" +
                                "}")
                        .header("Content-Type", "application/json")
                        .header("Authorization","Bearer "+token)
                        .header("Clientid","63")
                        .when()
                        .post("/erp/api/v1/stp/inv/grpWrhs/grdLst");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void wrhsGrpPrntGrdLst(){
        Response response =
                RestAssured.given()
                        .baseUri(baseurl+":30027")
                        .body("{\n" +
                                "  \"clmsLst\": [\n" +
                                "    {\n" +
                                "      \"field\": \"wh_grp_no\",\n" +
                                "      \"headerTxt\": \"Number\"\n" +
                                "    },\n" +
                                "    {\n" +
                                "      \"field\": \"wh_grp_nm\",\n" +
                                "      \"headerTxt\": \"Name\"\n" +
                                "    },\n" +
                                "    {\n" +
                                "      \"field\": \"inactv_flg\",\n" +
                                "      \"headerTxt\": \"inactv_flg\"\n" +
                                "    }\n" +
                                "  ],\n" +
                                "  \"ScrLstDto\": {\n" +
                                "    \"pageNo\": 1,\n" +
                                "    \"pageSize\": 4\n" +
                                "  },\n" +
                                "  \"rprtNo\": 52\n" +
                                "}")
                        .header("Content-Type", "application/json")
                        .header("Authorization","Bearer "+token)
                        .header("Clientid","63")
                        .when()
                        .post("/erp/api/v1/stp/inv/grpWrhs/prntGrdLst");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void wrhsGrpPrnt(){
        Response response =
                RestAssured.given()
                        .baseUri(baseurl+":30027")
                        .body("{\n" +
                                "  \"rprtPrmtr\": {\n" +
                                "    \"docTypSubNo\": null,\n" +
                                "    \"untNo\": 2,\n" +
                                "    \"pymntTyp\": null,\n" +
                                "    \"docTypNo\": 1062,\n" +
                                "    \"rprtNo\": 52,\n" +
                                "    \"decmlNo\": null,\n" +
                                "    \"pttrnNo\": null,\n" +
                                "    \"styleNo\": 1,\n" +
                                "    \"lngNo\": 2\n" +
                                "  },\n" +
                                "  \"rprtQryWhr\": [\n" +
                                "    {\n" +
                                "      \"opTyp\": 0,\n" +
                                "      \"wldCrd\": 0,\n" +
                                "      \"dataTyp\": 1,\n" +
                                "      \"prmtrNm\": \"m.wh_grp_no\",\n" +
                                "      \"prmtrLbl\": \"label\",\n" +
                                "      \"prmtrVal\": [\n" +
                                "        2\n" +
                                "      ],\n" +
                                "      \"prmtrValScnd\": null,\n" +
                                "      \"prmtrValDsc\": [\n" +
                                "        \"2\"\n" +
                                "      ],\n" +
                                "      \"prmtrValDscScnd\": null,\n" +
                                "      \"existsQry\": null\n" +
                                "    }\n" +
                                "  ]\n" +
                                "}")
                        .header("Content-Type", "application/json")
                        .header("Authorization","Bearer "+token)
                        .header("Clientid","63")
                        .when()
                        .post("/erp/api/v1/stp/inv/grpWrhs/prnt");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void wrhsGrpUpd(){
        Response response =
                RestAssured.given()
                        .baseUri(baseurl+":30027")
                        .body("{\n" +
                                "  \"whGrpNo\": 2,\n" +
                                "  \"whGrpLNm\": \"Retail2\",\n" +
                                "  \"whGrpFNm\": null,\n" +
                                "  \"notes\": null\n" +
                                "}")
                        .header("Content-Type", "application/json")
                        .header("Authorization","Bearer "+token)
                        .header("Clientid","63")
                        .when()
                        .put("/erp/api/v1/stp/inv/grpWrhs/upd");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
