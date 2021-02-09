Feature: corporation

  Background:
    * url baseUrl


  Scenario: list all corpo
    Given path 'corporation/all'
    When method GET
    Then status 200
    And match response == []

  Scenario: create new corpo
    Given path 'corporation'
    And request {name: "corpo test", sport: "kitesurf"}
    When method post
    Then status 201

  Scenario: check if new corpo is integrated
    Given path 'corporation/all'
    When method GET
    Then status 200
    And match response[0] == {"userList":[],"name":"corpo test","sport":"kitesurf"}