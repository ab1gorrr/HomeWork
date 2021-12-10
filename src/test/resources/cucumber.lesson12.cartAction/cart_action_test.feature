Feature: Cart Action Test


  Scenario: Add 3 product in cart and remove all from cart
    Given Open main page shop
    And Add the first product from the main page three times
    Then Open cart page
    And Removed all product in cart
    And Close this browser
