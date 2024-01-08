Feature: Buses controller

  Background:
    * url 'http://localhost:8080'

  Scenario: Create Bus details

    Given path '/buses'
    When method POST
    Then status 201
    And match $ == '#object'