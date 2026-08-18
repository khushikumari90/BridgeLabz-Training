package com.payroll.app.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTests {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp(){
        RestAssured.port=port;
        RestAssured.baseURI="http://localhost";
    }

    @Test
    void shouldSearchByName(){
        given()
                .accept(ContentType.JSON)
                .queryParam("name","Bhuvnesh")
                .when()
                .get("/employees/search")
                .then()
                .statusCode(200)
                .body("[0].name",containsString("Bhuvnesh"));
    }

    @Test
    void shouldGetAllEmployees(){
        given()
                .accept(ContentType.JSON)
                .when()
                .get("/employees")
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));

    }

    @Test
    void shouldGetEmployeeById(){
        given()
                .accept(ContentType.JSON)
                .pathParam("id",1)
                .when()
                .get("/employees/{id}")
                .then()
                .statusCode(200)
                .body("name",containsStringIgnoringCase("bhuvnesh"));
    }

    @Test
    void shouldCreateEmployee(){
        given()
                .contentType(ContentType.JSON)
                .body("""
                       {"name" : "Satyendra Pal Singh",
                       "department" : "BeeKeeper",
                       "salary" : "45000"}
                        """)
                .when()
                .post("/employees")
                .then()
                .statusCode(201)
                .body("name",containsStringIgnoringCase("satyendra"));
    }

    @Test
        void shouldUpdateEmployee(){
            given()
                    .contentType(ContentType.JSON)
                    .pathParam("id",3)
                    .body("""
                            {
                                "name" : "Sarita Devi",
                                "department" : "Teacher",
                                "salary" : 300000.00   
                            }
                            """)
                    .when()
                    .put("/employees/{id}")
                    .then()
                    .statusCode(200)
                    .body("name",containsStringIgnoringCase("Sarita"));
        }

    @Test
    void shouldDeleteEmployee(){
        given()
                .accept(ContentType.JSON)
                .pathParam("id",2)
                .when()
                .delete("/employees/{id}")
                .then()
                .statusCode(204);
    }
}
