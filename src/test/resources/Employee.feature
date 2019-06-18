Feature: Employee
  AS a API consumer
  I WANT TO perform curd operations on employee end point
  So that I want verify endpoints working as expected

  Scenario: Employee Crud operation
    Given I create a employee payload
    When I create a record on endpoint "/create"
    Then I verify that record is created successfully
    When I update a record on endpoint "/update"
    Then I verify that record is updated successfully
    When I delete a record on endpoint "/delete"
    Then I verify that record is deleted successfully