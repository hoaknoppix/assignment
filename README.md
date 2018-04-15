Assignment

Build a working web application on Java SpringMVC(v), Mybatis(using spring JPA right now, will be updated soon) and MySQL(v)
Endpoints to manage products(v)
Endpoints to manage cart(v)
A README.md telling how it works.(v)

TODO LIST:
Automation Integration tests
Implementing the front end
Run as Docker image
Migration from Spring JPA to Mybatis

--------------------------------------
HOW TO OPEN THE PROJECT
1. If you have mysql, go to step 5.
2. Install docker
3. Install docker mysql image by: docker pull mysql
4. Run mysql: docker -p 3306:3306 run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:latest
5. Create database assignment
6. Open the project by IntelliJ
7. Run AssignmentApplication
8. Go to localhost:8080/swagger-ui.html for the api document and manual test
--------------------------------------
DOCKER
1. This project can be built by: ./mvnw install dockerfile:build
2. There is an issue when running this built image by docker run -p 8080:8080 -t assignment/assignment:latest, missing inspecting with mysql might be the solution.
---------------------------------------
