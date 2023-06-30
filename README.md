### Test task for Digital Chief

### Task:
1. Choose a subject area. Based on the selected area, come up with a composition consisting of at least 2 objects, the relationship between which is "one to many". 
2. It is necessary to make a description of the subject area, the selected composition and the objects used in it in an arbitrary form. 
3. For each object, describe at least 5 properties.

4. Create a Git repository that will store all the files needed to build and run the future application.
5. Install a relational database (DB) of your choice: MySQL or PostgreSQL. 
6. Create a DB schema for storing and managing data for modeled objects. 
7. Add data schema initialization files to the Git repository. 
8. An additional, completely optional plus would be to use a Docker container for the DB.
9. Create a REST API application in the MVC architectural style based on the Spring Boot framework. 
10. Requirements:
   - Java, version 8+
   - the application contains a connection pool to the DB
   - Java model classes are implemented to display modeled objects
   - the task of object-relational mapping is solved
   - an API (Application Programming Interface) interface is created based on the REST architectural style for conducting CRUD (Create, Read, Update, Delete) operations on objects. Interaction with the API is implemented in JSON format
   - there is a README.md file at the root of the project. README.md contains a description of all dependencies connected to the project, as well as step-by-step instructions for building and running the application

- one example request is prepared for each endpoint in one of the following formats: 
  - cURL
  - HTTP
  - wget

##### For dependencies check pom.xml
### Ports:
Tomcat port : 8080.
DB connection properties are stored in resources/application.properties
Creation of DB named "films" needed before using sql-scripts.