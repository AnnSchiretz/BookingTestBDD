Feature: Booking search
  Scenario: Validation of hotels rating
    Given User on the search page
    And Hotels name "Чисто"
    When User performs search
    Then Hotel "Чисто" appears in the search
    And Hotel "Чисто" has rating "9.6"