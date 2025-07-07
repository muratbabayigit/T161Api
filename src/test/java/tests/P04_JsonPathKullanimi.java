package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P04_JsonPathKullanimi {
     /*
            https://restful-booker.herokuapp.com/booking url’ine
            asagidaki body'ye sahip bir POST request gonderdigimizde

                {
                      "firstname" : "Murat",
                      "lastname" : "Yiğit",
                      "totalprice" : 200,
                      "depositpaid" : true,
                      "bookingdates" : {
                                        "checkin" : "2025-06-01",
                                        "checkout" : "2025-06-10"
                                       },
                      "additionalneeds" : "wi-fi
                  }

                     donen Response’un,
             status code’unun 200,
             content type’inin applicatio/json,
             response body’sindeki
                    "firstname"'in,"Murat",
                    ve "lastname“in, "Yiğit",
                    ve "totalprice“in,200,
                    ve "depositpaid“in,true,
                    ve "checkin" tarihinin 2025-06-01
                    ve "checkout" tarihinin 2025-06-10
                    ve "additionalneeds“in,"wi-fi"

              oldugunu test edin

  */
    @Test
    public void test(){

        String url="https://restful-booker.herokuapp.com/booking";
        //eğer JSONobje içinde başka bir data varsa önce iç data oluşturulur
        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin" , "2025-06-01");
        bookingdates.put("checkout", "2025-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname" ,"Murat");
        reqBody.put("lastname","Yiğit");
        reqBody.put("totalprice",200);
        reqBody.put("depositpaid",true);
        reqBody.put("bookingdates",bookingdates);
        reqBody.put("additionalneeds","wifi");

        //response body verilmemiş

        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);
       // response.prettyPrint();

        //Response JsonPath'e çevrilir
        JsonPath resJP=response.jsonPath();

        assertEquals("Murat",resJP.get("booking.firstname"));
        assertEquals("Yiğit",resJP.get("booking.lastname"));
        int resTot=resJP.get("booking.totalprice");
        assertEquals(200,resTot);
        assertEquals(true,resJP.get("booking.depositpaid"));
        assertEquals("wifi",resJP.get("booking.additionalneeds"));
        assertEquals("2025-06-01",resJP.get("booking.bookingdates.checkin"));
        assertEquals("2025-06-10",resJP.get("booking.bookingdates.checkout"));

        System.out.println("Tüm kontroller doğrulandı. Test Tamamlandı");








    }

}
