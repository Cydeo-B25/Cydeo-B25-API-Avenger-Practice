package day3.hr;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class Hr {

    @BeforeEach
    public void init() {
        RestAssured.baseURI = "http://44.201.135.133:1000/ords/hr";
    }

    ;

    @Test
    public void test5() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/locations");

        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        List<String> countryID = jsonPath.getList("items.country_id");
        System.out.println(countryID);
    }

    @Test
    public void test6() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/departments");

        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        List<String> depLinks = jsonPath.getList("items.links.href");
        System.out.println(depLinks);
    }

    @Test
    public void test7(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/jobs");

//        response.prettyPrint();
        Items jobs = response.as(Items.class);
        System.out.println(jobs);
    }

}