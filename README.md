# LateCommerApp REST API

### Introduction
LateCommerApp is an application that takes an employee’s Name, Email, Address and Time of arrival. The application then aggregates all the input data (including paginated data) and shows how much every employee in the list owes along with other data in order of the employee with highest bill (use any field).
(Based on the time of arrival of each employee assume that for every 1 minute of lateness the employee owes 0.2$)

###Must-Have

*   POST, PUT, DELETE, GET for all reasonable fields
*   Search by Employee name, email or address
*   Sort by the highest owing employee and vice versa
*   Sort by name
*   Pagination
*   Swagger documentation
*   Stack: Java Springboot and any DB modules


###Tables
*   Employees table
    *   Employee_id : Int PK
    *   Name : Varchar (100)
    *   Email : Varchar(70)
    *   Address : Text

*   Employee_resumption modules
    *   employee_resumption_id : Int PK
    *   employee_id : Int FK
    *   time_in: Time

*   Employee_owes
    *   Employee_owes_id : Int PK
    *   Employee_id : Int FK
    *   Late_time_in_minute : int
    *   Amount : decimal
*   Settings table
    *   settings_id : Int PK
    *   max_time_in: TIme
    

### Modules
*   Settings module
    *   This is the module that will represent the settings
    *   Settings like time of arrival. For any time greater than this will be assumed to be late
    *   For the sake of simplicity, we will set threshold time as 8am by default
    *   So, if any employee come after 8am, then it will consider as a late comer.
*   Employee manager module
    *   This is the module representing creation of employee
    *   Add new employee such as name, email and address of employee
    *   Update employee
    *   Delete employee
*   Employee Resumption Module
    *   This is the module that representing the time in of the employee
    *   Representing the employee and time in.
    *   And if employee came late (time in passed threshold time) and event will be fired to create late fees.

###API ENDPOINTS
*   [Update settings PUT:](http://localhost:8085/latecomer/v1/settings)
*   [Create new employee POST:](http://localhost:8085/latecomer/v1/employees)
*   [Update employee: PUT:](http://localhost:8085/latecomer/v1/employees/{id})
*   [Remove employee: DELETE:](http://localhost:8085/latecomer/v1/employees/{id})
*   [Get single employee: GET : ](http://localhost:8085/latecomer/v1/employees/{id})
*   [Employee clock in: POST: ](http://localhost:8085/latecomer/v1/employee/{id}/resumptions/)
*   [All employees: GET: ](http://localhost:8085/latecomer/v1/employees/reports)
*   [Search employee: GET :](http://localhost:8085/latecomer/v1/employees?search=search)
*   All the fetched data will come along with pagination


###UI module
*   Setting page
    *   A field for threshold time and save button
*   Employee Manager page
    *   A employee form that will contain name, email and address fields.
    *   And button to save it.
    *   You can also update employee here
    *   And delete employee as well

*   Employee List page
    *   this will contain text field to search employee by name or email or address
    *   a table that will contain the list of employees with columns like name, email, address, aggregates late times and amount ( NB 1 minute late equivalent to 0.2$)
    *   in table, you can sort by name, aggregates amount
    *   employee list manage will have pagination capability
    
 #Dependencies
*   Major
    *   Spring web
    *   Spring JPA
    *   H2 (in memory database) for sake of simplicity
    *   Thymeleaf
    
*   Minor
    *   REST-Assured for APi Testing
    *   Swagger for documentation



![Alt text](https://github.com/elderjames314/latecommerapp/blob/master/re2.png?raw=true "Entity Relattionship Diagram")
