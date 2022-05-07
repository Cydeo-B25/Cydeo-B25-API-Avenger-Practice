package day2;


import io.restassured.*;
import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class day2 {

    @BeforeEach
    public void init(){ RestAssured.baseURI = "http://44.201.135.133:8000";};


    /*
    1. find male spartan call Mark:(using query param map)
     */

    @Test
    public void test1(){
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("nameContains","Mark");
        userInfo.put("gender","Male");

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().queryParams(userInfo)
                .when().get("api/spartans/search");

        response.prettyPrint();

    }

    // 2. get all spartans and get me name of #5 spartan, #19 gender using jsonPath method.

    @Test
    public void test2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("api/spartans");

        JsonPath jsonPath = response.jsonPath();
        String name = response.path("name[4]");
        String gender = response.path("gender[18]");

        System.out.println(name);
        System.out.println(gender);

    }


}