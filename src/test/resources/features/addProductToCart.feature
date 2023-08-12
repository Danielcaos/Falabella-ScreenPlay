Feature: Add product to cart

  Scenario: Add product to cart success
    Given that user open page Falabella and search any product
    When user click on product tittle and modify the quantity and user click on add to cart
    Then user will be able to see the selected product with its quantity