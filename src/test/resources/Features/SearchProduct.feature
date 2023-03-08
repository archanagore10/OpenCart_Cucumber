Feature: Search product functionality

  @smoke
  Scenario Outline: searching a product
    Given user is on Home page
    When user search a "<product>"
    And clicks on the "<product>"
    And adds it to the cart
    Then add to cart is successful

    @search
    Examples: 
      | product |
      #| MacBook |
      #| Canon   |
      | iPhone  |

    @mac
    Examples: 
      | product |
      | MacBook |
