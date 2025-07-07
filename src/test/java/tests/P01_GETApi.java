package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P01_GETApi {
      /*
        https://restful-booker.herokuapp.com/booking/10 url’ine
                bir GET request gonderdigimizde donen Response’un,
 	            status code’unun 200,
	            ve content type’inin application/json; charset=utf-8,
	            ve Server isimli Header’in degerinin Heroku,
	            ve status Line’in HTTP/1.1 200 OK
	            ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.

      */

 /*
        API Sorugusu yaparken 4 aşamda işlem yapılır
            1- EndPoint haırlanır[ Eğer PUT-POST-PATCH sorgusu ise reqBody burada hazırlanır ]
            2- Soruda verilmişse ExpectedBody hazırlanır
            3- Response bir obje içine kaydedilir
            4- Assertion işlemleri yapılır
  */
    @Test
    public void test(){

        //1- EndPoint haırlanır
        String url="https://restful-booker.herokuapp.com/booking/10";

        //2- Soruda verilmişse ExpectedBody hazırlanır
            //Verilmemiş

        //3- Response bir obje içine kaydedilir
        Response response=given().when().get(url);

        //4- Assertion işlemleri yapılır

       // response.prettyPrint(); //Sorgunun body'sini yazdırır
       // response.prettyPeek(); // Sorgunun tüm özelliklerini yazdırır
            //Manuel Kontrol
       // System.out.println("Status Code: "+response.getStatusCode());
       // System.out.println("Content-Type: "+response.getContentType());
       // System.out.println("Server isimli Header: "+response.getHeader("Server"));
       // System.out.println("Status Line: "+response.getStatusLine());
       // System.out.println("Proses Time:(ms) "+response.getTime());


        //Otomasyonla Kontrol

        response.then().assertThat().statusCode(200)
                                    .contentType("application/json; charset=utf-8")
                                    .statusLine("HTTP/1.1 200 OK")
                                    .header("Server","Heroku");







    }



}
