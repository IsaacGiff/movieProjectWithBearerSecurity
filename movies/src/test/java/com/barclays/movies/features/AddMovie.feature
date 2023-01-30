Feature:  Add a Movie

  Scenario: Everything works for a romcom movie
    Given I have the browser open
    When I navigate to "http://localhost:8080/movie/add"
    And I enter "1234" in the ISBN box
    And I enter "Random" in the Title box
    And I Select "romcom" from the dropdown
    And I click the submit button
    Then I see that "Random" was successfully added

  Scenario: Everything works for a comedy movie
    Given I have the browser open
    When I navigate to "http://localhost:8080/movie/add"
    And I enter "1234" in the ISBN box
    And I enter "Random" in the Title box
    And I Select "comedy" from the dropdown
    And I click the submit button
    Then I see that "Random" was successfully added

  Scenario: Everything works for a drama movie
    Given I have the browser open
    When I navigate to "http://localhost:8080/movie/add"
    And I enter "1234" in the ISBN box
    And I enter "Random" in the Title box
    And I Select "drama" from the dropdown
    And I click the submit button
    Then I see that "Random" was successfully added

  Scenario: Everything works for a thriller movie
    Given I have the browser open
    When I navigate to "http://localhost:8080/movie/add"
    And I enter "1234" in the ISBN box
    And I enter "Random" in the Title box
    And I Select "thriller" from the dropdown
    And I click the submit button
    Then I see that "Random" was successfully added

  Scenario: ISBN error check
    Given I have the browser open
    When I navigate to "http://localhost:8080/movie/add"
    And I enter "" in the ISBN box
    And I enter "Random" in the Title box
    And I Select "thriller" from the dropdown
    And I click the submit button
    Then I see that "ISBN" appeared in error message

  Scenario: Title error check
    Given I have the browser open
    When I navigate to "http://localhost:8080/movie/add"
    And I enter "1234" in the ISBN box
    And I enter "" in the Title box
    And I Select "thriller" from the dropdown
    And I click the submit button
    Then I see that "title" appeared in error message

  Scenario: Both error check
    Given I have the browser open
    When I navigate to "http://localhost:8080/movie/add"
    And I enter "" in the ISBN box
    And I enter "" in the Title box
    And I Select "thriller" from the dropdown
    And I click the submit button
    Then I see that "title" appeared in error message
    And I see that "title" appeared in error message



