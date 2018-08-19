package com.blibli.future.training.steps;

import com.blibli.future.training.api.petstore.PetController;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreStep {

    PetController petController;

    @Given("^prepare add pet per request data with Id \"([^\"]*)\" and path name \"([^\"]*)\"$")
    public void prepareAddPetPerRequestDataWithIdAndPathName(int id, String name) throws Throwable {

        petController.setId(id);
        petController.setPetName(name);
    }

    @When("^send add pet request$")
    public void sendAddPetRequest() throws Throwable {
        Response respone = petController.addPet();
        petController.setResponseAddPet(respone);
    }

    @Then("^add pet response data id should be \"([^\"]*)\"$")
    public void addPetResponseDataIdShouldBe(int id) throws Throwable {
        Response response = petController.getResponseAddPet();
        Integer resultId = response.path("id");
        assertThat("ID not same", resultId, equalTo(id));
    }

    @And("^add pet response data pet name should be \"([^\"]*)\"$")
    public void addPetResponseDataPetNameShouldBe(String name) throws Throwable {
        Response response = petController.getResponseAddPet();
        String resultPetName = response.path("name");
        assertThat("Name not same", resultPetName, equalTo(resultPetName));
    }
}
