package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public class BaseUrl_JP {

    protected RequestSpecification specJP;

    @BeforeEach
    public void setup(){
        specJP=new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
    }
}

