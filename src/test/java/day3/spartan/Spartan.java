package day3.spartan;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class Spartan {

    @BeforeEach
    public void init(){
        RestAssured.baseURI = "http://44.201.135.133:8000";
    }

    @Test
    public void test10(){

        String newSpartan = "{\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"name\": \"Mike\",\n" +
                "  \"phone\": 2589631478\n" +
                "}";

        Response response = RestAssured.given().accept(ContentType.JSON).log().all()
                .and()
                .contentType(ContentType.JSON)
                .body(newSpartan)
                .when()
                .post("/api/spartans");

        response.prettyPrint();

    }

    @Test
    public void test11(){
        Map<String, Object> newSpartan = new HashMap<>();
        newSpartan.put("gender","Male");
        newSpartan.put("name","John");
        newSpartan.put("phone",7896541235l);

        Response response = RestAssured.given().accept(ContentType.JSON).log().all()
                .and()
                .contentType(ContentType.JSON)
                .body(newSpartan)
                .when()
                .post("/api/spartans");

        response.prettyPrint();

    }

    @Test
    public void test12(){

        AddSpartan newSpartan = new AddSpartan();
        newSpartan.setGender("Female");
        newSpartan.setName("Jessica");
        newSpartan.setPhone(4567891235l);

        Response response = RestAssured.given().accept(ContentType.JSON).log().all()
                .and()
                .contentType(ContentType.JSON)
                .body(newSpartan)
                .when()
                .post("/api/spartans");

        response.prettyPrint();
    }

    @Test
    public void test13(){
        AddSpartan putSpartan = new AddSpartan();
        putSpartan.setGender("Male");
        putSpartan.setName("Ahmet");
        putSpartan.setPhone(4567891234l);


        Response response = RestAssured.given().accept(ContentType.JSON).log().all()
                .and()
                .contentType(ContentType.JSON)
                .body(putSpartan)
                .when()
                .pathParams("id",115)
                .and()
                .put("/api/spartans/{id}");

        System.out.println(response.statusCode());
        response.prettyPrint();
    }
}
