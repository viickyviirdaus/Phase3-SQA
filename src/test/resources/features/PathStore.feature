@PetStoreFeature
Feature: Pet Store
  @Positive
  Scenario: verify add pet
  Given prepare add pet per request data with Id "123" and path name "Luffy"
  When send add pet request
  Then add pet response data id should be "123"
    And add pet response data pet name should be "Luffy"