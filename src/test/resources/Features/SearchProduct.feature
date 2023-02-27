Feature: Search product functionality

  @smoke
  Scenario Outline: searching a product
    Given user launch browser
    And navigates to the application
    When user search a "<product>"
    And clicks on the "<product>"
    And adds it to the cart
    Then add to cart is successful

    @one
    Examples: 
      | product |
      # | macbook |
      #| Canon   |
      | iphone  |

    #  @two
    Examples: 
      | product |
     # | macbook |
