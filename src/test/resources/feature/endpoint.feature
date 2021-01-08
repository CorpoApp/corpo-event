Feature: find postal code

  Background:
    * url baseUrl

  Scenario: Testing valid GET endpoint
    Given path 'corporation'
    When method GET
    Then status 200
    Then print response