Feature: ASOS.com testing

  Scenario Outline: Check search functionality
    Given User opens the main page asos.com
    And Checks if searchFiled is visible
    When  User enter the '<request>' into search field
    Then  Search result should return a list of items that contains the '<request>' key word
    Examples:
      |request|
      |adidas |
      |puma   |

    Scenario: User check man/woman categories.
    Given User opens the main page asos.com
      When User open man categorie
      Then URl cotains word man
      And User click logoAsos


  Scenario Outline: Sign In with incorrect type of email.
  Given User opens the main page asos.com
  And User move to Sign In page
  And User enter email '<email>'
  And User enter password '<password>'
  When User click SignIn Button
  Then User see  Red Error, Email fail!
    Examples:
      |email  |password |
      |nmfm@  |1111111  |
      |nmfm@1 |11111112 |

  Scenario Outline: Sign In as unregistered user data.
    Given User opens the main page asos.com
    And User move to Sign In page
    And User enter email '<email>'
    And User enter password '<password>'
    When User click SignIn Button
    Then User see  ERROR BLOCK!

    Examples:
      |email      |password |
      |nmfm@i.ua |1111111  |

  Scenario Outline: User tries to register using the email, that another user is using
    Given User opens the main page asos.com
    And User move to Join page
    And User enter registration email '<email>'
    And User enter First Name '<firstName>'
    And User enter Last Name '<lastName>'
    And User enter registration password '<password>'
    And User enter date of birth
    And User enter mostly interested in
    And User select all contact preferences
    When User click Join Asos
    Then User see Error

    Examples:
      |email                  |firstName    |lastName  |password  |
      |misharyzhyk@gmail.com  |1111111111   | Mykhailo | Petryshyn|

  Scenario Outline: User wants to change items currency and interface language
    Given User opens the main page asos.com
    When User opens preferences pop- up
    And User changes language interface to '<language>'
    And User changes items currency to '<currency>'
    And User clicks button Update preferences
    And Checks if searchFiled is visible
    And  User enter the '<request>' into search field
    Then User sees items prices with '<currency>'

    Examples:
    Examples:
      |request    |currency |language|
      |adidas     |USD	 	|UA      |
      |nike       |GBP      |UA      |
      |nike       |EU       |UA      |

  Scenario Outline: Sort search result
    Given User opens the main page asos.com
    And Checks if searchFiled is visible
    And User enter the '<request>' into search field
    When User sort search result by'<sort_type>'
    Then User sees sorted by'<sort_type>' result on the page
    Examples:
      |request|sort_type|
      |puma |lowToHigh|

  Scenario Outline: User wants to filter products by color and brand
    Given User opens the main page asos.com
    And Checks if searchFiled is visible
    And User enter the '<request>' into search field
    And User filters by brand '<brand>'
    And User filters by color '<color>'
    When User opens item page
    Then User checks that page contains request '<request>'
    And User checks that page contains color '<color>'
    And User checks that page contains brand '<brand>'
    Examples:
      |request		|brand	|color	|
      |bag      	|adidas	|black  |
      |leggings		 |adidas	|blue	|


  Scenario Outline: Add items to wish List/////////////////асос не дає залогуватись
    Given User opens the main page asos.com
    And User move to Sign In page
    And User enter email '<email>'
    And User enter password '<password>'
    When User click SignIn Button
    Then User see  ERROR BLOCK!

    Examples:
      |email                 |password    |
      |misharyzhyk@gmail.com |1111111111  |

  Scenario Outline: User search for a necessary item, than add to wishList
    Given User opens the main page asos.com
    And Checks if searchFiled is visible
    And  User enter the '<request1>' into search field
    And User add item to wishList
    And  User enter the '<request2>' into search field
    And User add item to wishList
    When User move to wishListPAge
    Then USer check the amount of items in wishList
    Examples:
      | request1 | request2   |
      | watch    | cap        |

  Scenario Outline: User search for a necessary item add to basket and than buy it
    Given User opens the main page asos.com
    And Checks if searchFiled is visible
    And  User enter the '<request1>' into search field
    And User opens item page
    And User add item to the bag
    And  User enter the '<request2>' into search field
    And User opens item page
    And User add item to the bag
    And User click logoAsos
    When User click on basket icon
    And Click View Bag
    Then USer check the total price
    Examples:
      | request1 | request2   |
      | watch    | cap        |