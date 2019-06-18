package com.tradeix.techinical_assement.step_defination;

import com.github.javafaker.Faker;
import com.tradeix.techinical_assement.models.Employee;
import com.tradeix.techinical_assement.utils.Restservices;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;

public class EmployeeSteps {

    private Employee employee = null;
    private Restservices restservices = null;
    private Response response = null;
    private String employeeID;


    public EmployeeSteps(Employee employee, Restservices restservices) {
        this.employee = employee;
        this.restservices = restservices;
    }

    @Given("^I create a employee payload$")
    public void i_create_a_employee_payload() {
        employee.setName(new Faker().name().fullName());
        employee.setAge("28");
        employee.setSalary("43000");
        employee.setProfileImage("http://www.dummy-url.co.uk");

    }

    @When("^I create a record on endpoint \"([^\"]*)\"$")
    public void iCreateARecordOnEndpoint(String endpoint) {
        this.response = restservices.postRequest(RestAssured.baseURI+endpoint, employee);
        this.employeeID=response.then().extract().path("id").toString();
    }

    @Then("^I verify that record is created successfully$")
    public void i_verify_that_record_is_created_successfully() {
        this.response
                .then()
                .body("name", is(equalToIgnoringCase(employee.getName())))
                .body("salary", is(equalToIgnoringCase(employee.getSalary())))
                .body("age", is(equalToIgnoringCase(employee.getAge())))
                .statusCode(200);
    }

    @When("^I update a record on endpoint \"([^\"]*)\"$")
    public void iUpdateARecordOnEndpoint(String endpoint) {
        this.employee.setSalary("50000");
        this.response = this.restservices.putRequest(RestAssured.baseURI+endpoint, employee, response.then().extract().path("id").toString());
    }

    @Then("^I verify that record is updated successfully$")
    public void i_verify_that_record_is_updated_successfully() {
        this.response
                .then()
                .body("salary", is(equalTo(employee.getSalary())))
                .statusCode(200);
    }

    @When("^I delete a record on endpoint \"([^\"]*)\"$")
    public void iDeleteARecordOnEndpoint(String endpoint) {
        this.response = this.restservices.deleteRequest(RestAssured.baseURI+endpoint, employeeID);
    }

    @Then("^I verify that record is deleted successfully$")
    public void i_verify_that_record_is_deleted_successfully() {
        this.response
                .then()
                .body("success.text",is(equalToIgnoringCase("successfully! deleted Records")))
                .statusCode(200);
    }
}
