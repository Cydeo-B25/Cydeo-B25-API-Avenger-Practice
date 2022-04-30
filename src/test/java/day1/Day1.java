package day1;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.apache.commons.lang3.builder.*;
import org.junit.jupiter.api.*;

public class Day1 {

    /*
    We will practice below questions in manual(postman) and automation(intellij). In the practice session, you will send me
    screenshot for postman and code for intellij.
    1. Send request to get all spartans  and get me the status code
    2. get me headers for above request
    3. get me header value for Content-Type and Date
    4. get me all spartans printed
    5. get me 7th spartan (2 different ways)
    6. get me spartans name Allen
    7. get me all male spartans
    8. get me the spartan that female and name has z
    9. get name, gender, phone separately of No.15 spartans
    10. get me all spartans and get 10st spartan's name, 20st spartans gender, 30st spartans id.


     */

    String url_spartans = "http://44.201.135.133:8000/api/spartans";

    @Test
    public void test1(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(url_spartans);
//        System.out.println(response.getStatusCode());
//        System.out.println(response.getHeaders());
//        System.out.println(response.headers());
//        System.out.println(response.getHeader("Content-Type"));
//        System.out.println(response.getHeader("Date"));
        response.prettyPrint();
        response.body().prettyPrint();

    }

    @Test
    public void test2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(url_spartans + "/7");
        response.prettyPrint();

        Response response1 = RestAssured.given().accept(ContentType.JSON)
                .when().pathParams("id", 7)
                .when().get(url_spartans + "/{id}");
        response1.prettyPrint();

    }

    @Test
    public void test3(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().queryParam("nameContains", "Allen")
                .when().get(url_spartans + "/search");

        response.prettyPrint();
    }

    @Test
    public void test4(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().queryParam("gender", "Male")
                .when().get(url_spartans + "/search");
        response.prettyPrint();
    }

    @Test
    public void test5(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().queryParam("gender", "Female")
                .when().queryParam("nameContains","z")
                .when().get(url_spartans + "/search");

        response.prettyPrint();
    }

    @Test
    public void test6(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().pathParams("id", 15)
                .when().get(url_spartans + "/{id}");

        // first way
        System.out.println(response.path("name").toString());
        System.out.println(response.path("gender").toString());
        System.out.println(response.path("phone").toString());

        // sencon way using jsonpath

        JsonPath jsonPath = response.jsonPath();
        byte id = jsonPath.getByte("id");
        String name = jsonPath.getString("name");
        String gender = jsonPath.getString("gender");
        Long phone = jsonPath.getLong("phone");

        System.out.println(id);
        System.out.println(name);
        System.out.println(gender);
        System.out.println(phone);


    }

    @Test
    public void test7(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(url_spartans);

        String name10 = response.path("name[9]");
        String gender20 = response.path("gender[19]");
        int id30 = response.path("id[29]");

        System.out.println(name10);
        System.out.println(gender20);
        System.out.println(id30);
    }


}
