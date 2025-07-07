package tests;

import baseUrl.BaseUrl_JP;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P05_BaseUrlKullanimiJsonPlace extends BaseUrl_JP {
    /*
        https://jsonplaceholder.typicode.com/posts/44 endpointine
        bir GET request gonderdigimizde donen response'un
            status code'unun 200 oldugunu ve
            "title" degerinin "optio dolor molestias sit"
        oldugunu test edin

 */

    @Test
    public void test(){

        //Endpoint hazırlama
        specJP.pathParams("pp1","posts","pp2","44");

        //Response body verilmemiş

        //Response kaydetme
        Response response=given().spec(specJP).when().get("/{pp1}/{pp2}");

        //Assertions işlemi yapılır
        response.then().assertThat().statusCode(200)
                                    .body("title", Matchers.equalTo("optio dolor molestias sit"));



    }
}
