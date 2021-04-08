This Framework created by: FRED DAR - QA ENGINEER
-----------------------------------------------------------
TASK 1
-----------
Related website : https://signup.skimlinks.com/

Functionality ; SIGN UP
Test cases below has been created based on Acceptance Criteria. 

*SignUp with valid credentials
*SignUp with invalid password credential
*SignUp with invalid email credential
*SignUp with without accepting privacy policy
*SignUp with no credentials

Also
* email input has to be in valid email format ('____@___.com)
    - at least one character before @ sign 
    - at least one character between @ sign and . sign 
    - at least one character after . sign 
* password input has to be in valid format    
    = at least one lower case letter
    - at least one upper case letter
    - at least one number 
    - at least one symbol
    
Framework; 
-------------

*Written scenarios based on GIven,When,Then structure in Gherkin language.

*Used maven project with Cucumber BDD Framework based on POM

*Used Selenium Web driver to automate browser

*Used Html and Cucumber reports in Target Folders

*Used Step_definitions to keep implementation of cases

*Used hooks class to modify before and after annotations

*Used Cukes runner to triigger test cases and to connect required files

*Which stepdefinitions,features,plugins and others

TASK 2 
=======
SQL Question
-

An organization maintains employment data in three tables: EMPLOYEE, COMPANY, and SALARY.
Write a query to print the names of every company where the average salary is greater than 
or equal to 40000.  Each distinct row of results in the output must contain the name of a company 
whose average employee salary is ≥ 40,000 in the COMPANY.NAME format.

ANSWER
--

SELECT DISTINCT COMPANY.NAME
FROM COMPANY
INNER JOIN SALARY ON COMPANY.ID = SALARY.COMPANY_ID
INNER JOIN EMPLOYEE ON EMPLOYEE.ID = SALARY.EMPLOYEE_ID
GROUP BY COMPANY.NAME HAVING AVG(SAL)>=40000

DISTINCT: to remove duplicate values
INNER JOIN: selects all rows from both participating tables as long as there is a match between the columns



