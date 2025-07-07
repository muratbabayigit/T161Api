package tests;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class P02_JsonDataCreate {
 /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.

	{
	"title":"Ahmet",
	"body":"Merhaba",
	"userId":1
	}

 */
    @Test
    public void JsonDataCreate(){

        JSONObject data=new JSONObject();
        data.put("title","Ahmet");
        data.put("body","Merhaba");
        data.put("userId",1);

        System.out.println(data);
    }


}
