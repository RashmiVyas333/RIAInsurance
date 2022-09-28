Feature: Verify the searched products
  Verify the product matches search and filter criteria

  Background:
    Given I am on the home page of site https://amazon.in

  Scenario:Verify the searched products
    Given I search for the Wrist Watches
    And I apply following filter
    |Display  | Brand|Material|Discount|
    |Analogue | Titan|Leather |25% Off or more |
    When I get the product number 5,10 and 15 from the search
    Then I validate that the products match the search and filter criteria
    And I verify that delivery is fulfilled by Amazon
    And I verify that delivery is free