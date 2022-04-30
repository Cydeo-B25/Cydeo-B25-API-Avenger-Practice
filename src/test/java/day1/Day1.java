package day1;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
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


}
