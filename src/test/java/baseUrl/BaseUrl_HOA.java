package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public class BaseUrl_HOA {
    protected RequestSpecification specHOA;

    @BeforeEach
    public void setup(){

        specHOA=new RequestSpecBuilder()
                                .setBaseUri("https://restful-booker.herokuapp.com")
                                .build();
    }
}
