package day2;


import io.restassured.*;
import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.hamcrest.Matchers.is;

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
    @Test
    public void test4(){
        RestAssured.given().accept(ContentType.JSON)
                .when().get("api/spartans")
                .then().statusCode(200);

    }

    /*
    5. get me spartans whose id is 20 and verify the below informations:(using hemcrast )
        status code : 200
        Content type: application/Json
        "id": 20,
        "name": "Lothario",
        "gender": "Male",
        "phone": 7551551687
     */

    @Test
    public void test5() {
        RestAssured.given().accept(ContentType.JSON)
                .when().pathParams("id",20)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200)
                .and().contentType("application/Json")
                .and().assertThat()
                .body("id",is(20),"name",is("Lothario"),"gender",is("Male"),"phone",is(7551551687l));

    }

    /*
     6. get me all spartans and verify below informations:(using hemcrast )
        status code : 200
        Content type: application/Json
        31. spartans name: "Maressa",
        52. spartans gender: "Female",
        78. spartans phone: 1853354209
     */

    @Test
    public void test6(){

    }





}