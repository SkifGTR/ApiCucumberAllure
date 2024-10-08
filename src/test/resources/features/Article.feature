Feature: Get Articles List
  User should be able to get a list of articles

  Scenario Template: Send requests on different urls
    Given GET Articles by "<URL>" request
    Then Response status code is "<status_code>"
    Examples:
    | URL | status_code |
    | articles.json | 200 |
    | articles1.json | 404 |
    | | 401 |