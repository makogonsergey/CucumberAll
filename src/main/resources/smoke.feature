Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: User can't create account using password less than 6 characters
    Given User opens '<homePage>' page
    And Click on login button
    And Click on create account button
    When User enters '<name>' registration name
    And User enters '<login>' registration login
    And User enters '<password>' registration password
    And User enters again '<re-password>' registration password
    And User clicks 'Continue' button
    Then User sees invalid password notification

    Examples:
      | homePage                  | name           | login                        | password     | re-password    |
      | https://www.amazon.com/   | Sergii         | fatal.buzooka@gmail.com      | 1            | 1              |
      | https://www.amazon.com/   | Sergii         | fatal.buzooka@gmail.com      | 12           | 12             |
      | https://www.amazon.com/   | Sergii         | fatal.buzooka@gmail.com      | 123          | 123            |
      | https://www.amazon.com/   | Sergii         | fatal.buzooka@gmail.com      | six          | six            |
      | https://www.amazon.com/   | Sergii         | fatal.buzooka@gmail.com      | four         | four           |
      | https://www.amazon.com/   | Sergii         | fatal.buzooka@gmail.com      | five5        | five5          |

  Scenario Outline: User unsuccessful login with empty password
    Given User opens '<homePage>' page
    And Click on login button
    When User enters '<login>' login
    And User click on 'Continue' button
    And User enters '<password>' password
    And User click on 'Sign-In' button
    Then User sees empty password notification

    Examples:
      | homePage                            | login                        | password                    |
      | https://www.amazon.com/             | makogonsergey@gmail.com      |                             |

  Scenario Outline: User unsuccessful login with empty login
    Given User opens '<homePage>' page
    And Click on login button
    When User enters '<login>' login
    And User click on 'Continue' button
    Then User sees empty login notification

    Examples:
      | homePage                            | login                        |
      | https://www.amazon.com/             |                              |


  Scenario Outline: User successful login
    Given User opens '<homePage>' page
    And Click on login button
    When User enters '<login>' login
    And User click on 'Continue' button
    And User enters '<password>' password
    And User click on 'Sign-In' button
    Then User logins on the site

    Examples:
      | homePage                            | login                        | password                    |
      | https://www.amazon.com/             | makogonsergey@gmail.com      | makogonsergeymakogonsergey2 |

  Scenario Outline: Registered user checks adding product to wishlist
    Given User opens '<homePage>' page
    And Click on login button
    When User enters '<login>' login
    And User click on 'Continue' button
    And User enters '<password>' password
    And User click on 'Sign-In' button
    Then User logins on the site
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on desired product
    Then User checks that product page is opened
    And User adds that product page to wishlist
    And User checks that product added to wish list

    Examples:
      | homePage                            | login                        | password                    | keyword                  |
      | https://www.amazon.com/             | makogonsergey@gmail.com      | makogonsergeymakogonsergey2 | playstation 5 console    |

  Scenario Outline: User adds product to cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on product they wish to buy
    Then User checks that product page is opened
    When User adds that product to cart
    Then User checks that product added to cart
    And User checks visibility of checkout button

    Examples:
      | homePage                            | keyword                          |
      | https://www.amazon.com/             | Sony PULSE 3D Wireless Headset   |

  Scenario Outline: Unregistered user can't add product to wishlist, login needed
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on desired product
    Then User checks that product page is opened
    And Unregistered user adds that product page to wishlist
    And User proceeded to login page

    Examples:
      | homePage                            | keyword                          |
      | https://www.amazon.com/             | playstation 5 console            |

  Scenario Outline: User can search in specific category
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User changes search category by keyword '<keyword>'
    Then User checks selected search category

    Examples:
      | homePage                            | keyword        |
      | https://www.amazon.com/             | Books          |


  Scenario Outline: User sees similar items for unavailable product
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on desired product
    Then User checks that product page is opened
    When User presses button to see similar items
    And User sees similar items

    Examples:
      | homePage                            | keyword                          |
      | https://www.amazon.com/             | playstation 5 console            |

  Scenario Outline: Unegistered user can't pre-order product, login needed
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on pre-order product
    Then User checks that product page is opened
    And Unregistered user pre-order that product
    And User proceeded to login page

    Examples:
      | homePage                            | keyword                          |
      | https://www.amazon.com/             | Tails of Iron - PlayStation 5    |


