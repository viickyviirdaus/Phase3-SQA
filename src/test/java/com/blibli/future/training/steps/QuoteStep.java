package com.blibli.future.training.steps;

import com.blibli.future.training.steps.serenity.EndUserQuoteStep;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.security.KeyStore;

public class QuoteStep {

    @Steps
    EndUserQuoteStep endUserQuoteStep;

    @Given("^User open wonderful quote page$")
    public void userOpenWonderfulQuotePage() throws Throwable {
        endUserQuoteStep.openPage();
    }

    @When("^User input quote \"([^\"]*)\"$")
    public void userInputQuote(String quote) throws Throwable {
        endUserQuoteStep.inputQuote(quote);
    }

    @And("^User type author '(.*)'$")
    public void userTypeAuthorVirdaus(String author) throws Throwable {
        endUserQuoteStep.author(author);
    }

    @And("^User select colour \"([^\"]*)\"$")
    public void userSelectColour(String colour) throws Throwable {
        endUserQuoteStep.selectColour(colour);
    }

    @And("^User click add quote button$")
    public void userClickAddQuoteButton() throws Throwable {
        endUserQuoteStep.clickAddButton();
    }

    @Then("^Quote should save quote \"([^\"]*)\"$")
    public void quoteShouldSaveQuote(String quote) throws Throwable {
        endUserQuoteStep.seeQuote(quote);
    }

}
