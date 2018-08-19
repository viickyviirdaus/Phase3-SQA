package com.blibli.future.training.api.petstore;


import lombok.Data;
import net.serenitybdd.core.pages.PageObject;

import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.given;

@Data
public class PetController extends PageObject {

    private int id;
    private String petName;
    private Response responseAddPet;

    public Response addPet(){

        String requestBody = "{\n" +
                "  \"id\": "+getId()+",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"mammals\"\n" +
                "  },\n" +
                "  \"name\": \""+getPetName()+"\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        Response response = given().log().all()
                .header("content-type", "application/json")
                .header("charset", "UTP-8")
                .body(requestBody)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();
        response.getBody().prettyPrint();

        return response;
    }
}
