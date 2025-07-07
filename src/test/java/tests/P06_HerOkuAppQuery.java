package tests;

import baseUrl.BaseUrl_HOA;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P06_HerOkuAppQuery extends BaseUrl_HOA {
    /*

            https://restful-booker.herokuapp.com/booking endpointine
            gerekli Query parametrelerini yazarak
                “firstname” degeri “Josh”
                ve “lastname” degeri “Allen” olan
            rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
            donen response’un
                status code’unun 200 oldugunu
                ve “Josh Allen” ismine sahip en az bir booking oldugunu test edin
    */

    @Test
    public void HerOkuAppQuery(){

        specHOA.pathParam("first","booking").queryParams("firstName","Bob","lastname","Smith");

        Response response=given().spec(specHOA).when().get("/{first}");

        response.then().assertThat().statusCode(200).body("size()",Matchers.greaterThanOrEqualTo(1));
    }
}
