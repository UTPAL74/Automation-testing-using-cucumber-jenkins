Feature: Sample feature file for datatable operation.

  @single_column
  Scenario: Add numbers.
    Given a list of numbers
    | 17 |
    | 42 |
    | 4711 |
    When I summarize them
    Then I should get 4770