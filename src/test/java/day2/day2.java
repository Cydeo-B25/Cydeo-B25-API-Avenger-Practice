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

        List<String> names = jsonPath.getList("name");
        List<String> genders = jsonPath.getList("gender");

        System.out.println(names.get(4));
        System.out.println(genders.get(18));

    }

    //    3. find out all male spartans whose name has g and get me second one's name and last one's phone using jsonPath method.
    @Test
    public void test3(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().queryParam("gender","Male")
                .when().queryParam("nameContains",'g')
                .when().get("/api/spartans/search");

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        String name = jsonPath.get("content[1].name");
        Long phone = jsonPath.get("content[-1].phone");

        System.out.println(name);
        System.out.println(phone);

    }

    //     4. get all spartans and verify status code 200 (using hemcrast )



}