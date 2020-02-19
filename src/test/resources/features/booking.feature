Feature: Booking search
  Scenario: Validation of hotels rating
    Given User on the search page
    And Hotels in "Campanile Varsovie / Warszawa"
    When User performs search
    Then Hotel "Campanile Varsovie / Warszawa" appears in the search
    And Hotel "Campanile Varsovie / Warszawa" has rating "8.2"