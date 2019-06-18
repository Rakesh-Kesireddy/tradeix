# How to Run
### via Intellj IDE
A Cucumber runner class is defined in (/src/test/java/com/tradeix/techinical_assement/RunCukesTest)
### via Command line 
mvn clean test (execute command at project root directory)
# Tool/Libraries/Framework Used
  - Cucumber-Java framework 
  - Hamcrest-all (for Asserts)
  - Rest-assured (for api's)
  - javafaker (For generating random names)
  - Maven
  - Java
  
# Bug found 
If we delete a record it response as ""successfully! deleted Records"",But if we try to re-create a record with same name throws exception as below
    
```sh
{"error":{"text":SQLSTATE[23000]: Integrity constraint violation: 1062 Duplicate entry 'mahesh' for key 'employee_name_unique'}}
```