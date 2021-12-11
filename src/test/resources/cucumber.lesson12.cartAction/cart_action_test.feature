Feature: Cart Action Test


  Scenario: Add 3 product in cart and remove all from cart
    Given the cart is empty
    When I add three product into cart
    Then the cart contains three product
    When I remove everything from the cart
    Then the cart is empty
