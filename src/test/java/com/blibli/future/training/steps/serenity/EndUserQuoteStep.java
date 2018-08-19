package com.blibli.future.training.steps.serenity;

import com.blibli.future.training.pages.QuotePage;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class EndUserQuoteStep {

    QuotePage quotePage;


    @Step
    public void openPage(){
    quotePage.open();
    }
    @Step
    public void inputQuote(String quote){
    quotePage.setInputQuote(quote);
    }
    @Step
    public void author(String author){
    quotePage.setInputAuthor(author);
    }
    @Step
    public void selectColour(String colour){
    quotePage.setSelectColour(colour);
    }
    @Step
    public void clickAddButton(){
    quotePage.ButtonAddQuote();
    }
    @Step
    public void seeQuote(String quote){
        List<String> result = quotePage.getTextQuotes();
        assertThat("Quote not found", result, hasItem(quote));
    }
}

