package day3.zipCode;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class ZipCode {

    @BeforeEach
    public void init(){
        RestAssured.baseURI = "https://api.zippopotam.us";
    }

    @Test
    public void test1(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/us/20113");

        response.prettyPrint();
        Map<String, Object> responseMap = response.as(Map.class);
        System.out.println(responseMap);

    }

    @Test
    public void test2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/us/20113");

        response.prettyPrint();
        ResultZip responseClass = response.as(ResultZip.class);
        System.out.println(responseClass);
    }


}
