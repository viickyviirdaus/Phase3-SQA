@QuoteFeature
Feature: Quote feature

  @Positive
  Scenario: Add quote
    Given User open wonderful quote page
    When User input quote "Blibli is the best!"
    And User type author 'virdaus'
    And User select colour "aqua"
    And User click add quote button
    Then Quote should save quote "Blibli is the best!"