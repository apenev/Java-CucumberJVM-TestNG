Feature: Remove Item from Cart

  Scenario: Removing one item from cart
    Given I am on the inventory page
    When I add 1 item to the cart
    When I add 1 item to the cart
    And I remove an item
    Then I have 1 item in my cart