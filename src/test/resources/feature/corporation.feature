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
    And request {name: "corpoTest", sport: "kitesurf"}
    When method post
    Then status 201

  Scenario: check if new corpo is integrated
    Given path 'corporation/all'
    When method GET
    Then status 200
    And match response[0] == {"userList":[],"name":"corpoTest","@id":1,"sport":"kitesurf"}

  Scenario: find our new corpo by name
    Given path 'corporation'
    And param name = "corpoTest"
    When method GET
    Then status 200
    And match response == {"userList":[],"name":"corpoTest","@id":1,"sport":"kitesurf"}

  Scenario: register user to corpo
    Given path 'corporation/register'
    And request {corporationName: "corpoTest", userMail: "test@test.com"}
    When method patch
    Then status 200

  Scenario: test if user is subscribe to corpo
    Given path 'corporation'
    And param name = "corpoTest"
    When method GET
    Then status 200
    And match response == {"userList":[{"mail":"test@test.com","name":"test","@id":2}],"name":"corpoTest","@id":1,"sport":"kitesurf"}

  Scenario: delete our awesome corpo
    Given path 'corporation'
    And param name = "corpoTest"
    When method DELETE
    Then status 204

  Scenario: check if new corpo is gone
    Given path 'corporation/all'
    When method GET
    Then status 200
    And match response == []