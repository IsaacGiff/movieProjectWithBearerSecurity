Feature: Navigating the site with a Scenario outline

  Scenario Outline: Navigate to index
    Given I have the browser open
    When I navigate to <url>
    Then I am on the <page title> page


    Examples:
      | url                               | page title  |
      | "http://localhost:8080"           | "Index"     |
      | "http://localhost:8080/movie"     | "Get All"   |
      | "http://localhost:8080/movie/add" | "Add Movie" |
