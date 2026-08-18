package com.contacts.app.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//Spring boots your whole app + starts a real Tomcat server on a free port.

class ContactControllerTest {

    @LocalServerPort //grabs that random port number into a variable.
    private int port;

    @BeforeEach //configures REST Assured to send requests to localhost:<that port>
    void setUp(){
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }

    //tests go here

    @Test
    void shouldFindContactsMatchingName(){
        given()
                .queryParam("name", "John")
                .when()
                .get("/api/contacts/search")
                .then()
                .statusCode(200)
                .body("size()", greaterThanOrEqualTo(1))
                .body("[0].name", containsStringIgnoringCase("john"));
    }

    @Test
    void shouldReturnEmptyListForNonExistentName(){
        given()
                .queryParam("name", "Zzznonexistent")
                .when()
                .get("/api/contacts/search")
                .then()
                .statusCode(200)
                .body("size()", equalTo(0));
    }

    @Test
    void shouldGetAllContacts(){
        given()
                .queryParam("page",0)
                .queryParam("size",10)
                .when()
                .get("/api/contacts")
                .then()
                .statusCode(200)
                .body("content.size()",greaterThanOrEqualTo(3)); //from data.sql seed
    }

    @Test
    void shouldGetContactsSortedByNameDescending(){
        List<String> names = given()
                .queryParam("sortBy", "name")
                .queryParam("direction", "desc")
                .queryParam("size", 50) // large enough to include all seeded + created contacts
                .when()
                .get("/api/contacts")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("content.name", String.class);

        List<String> sortedCopy = new ArrayList<>(names);
        sortedCopy.sort(Comparator.reverseOrder());

        assertEquals(sortedCopy, names, "Contacts should be sorted by name in descending order");
    }

    @Test
    void shouldReturnEmptyContentForPageBeyondAvailableData(){
        given()
                .queryParam("page", 999)
                .queryParam("size", 10)
                .when()
                .get("/api/contacts")
                .then()
                .statusCode(200)
                .body("content.size()", equalTo(0))
                .body("last", equalTo(true));
    }

    @Test
    void shouldGetContactById(){
        given()
                .pathParam("id",1)
                .when()
                .get("/api/contacts/{id}")
                .then()
                .statusCode(200)
                .body("name", equalTo("John Doe"));
    }

    @Test
    void shouldCreateContact(){
        given()
                .contentType(ContentType.JSON)
                .body("""
                        {
                            "name" : "Bhuvnesh Singh",
                            "phone" : "7451099213",
                            "email" : "bhuvneshsingh292@gmail.com"
                        }
                        """)
                .when()
                .post("/api/contacts")
                .then()
                .statusCode(201)
                .body("name", equalTo("Bhuvnesh Singh"))
                .body("id", notNullValue());
    }

    @Test
    void shouldFailedToCreateContactWithInvalidEmail(){
        given()
                .contentType(ContentType.JSON)
                .body("""
                        {
                            "name" : "Anubhav",
                            "phone" : "9090909090",
                            "email" : "gjjksk"
                        }
                        """)
                .when()
                .post("/api/contacts")
                .then()
                .statusCode(400); //validation should reject this
    }

    @Test
    void shouldUpdateContact(){
        given()
                .contentType(ContentType.JSON)
                .pathParam("id",3)
                .body("""
                        {
                            "name" : "Alice Jackson",
                            "phone" : "9989898767",
                            "email" : "alice.jackson@example.com"
                        }
                        """)
                .when()
                .put("/api/contacts/{id}")
                .then()
                .statusCode(200)
                .body("name",equalTo("Alice Jackson"));
    }

    @Test
    void shouldDeleteContact(){
        given()
                .pathParam("id",2)
                .when()
                .delete("/api/contacts/{id}")
                .then()
                .statusCode(204);
    }
}
