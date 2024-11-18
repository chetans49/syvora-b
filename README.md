#Project Overview
This is the backend of the Syvora application, built using Spring Boot. It handles the server-side logic, including API endpoints, business logic, and database operations.


#Features
RESTful API: Endpoints for CRUD operations.
Spring Boot Framework: Reliable and efficient backend architecture.
Database Integration: Seamless communication with the database.
Tech Stack
Framework: Spring Boot
Language: Java
Build Tool: Maven
Database: Postgresql


#Local Setup
Clone the repository:

bash
Copy code
git clone https://github.com/chetans49/syvora-b.git
cd syvora/backend
Build the project:

bash
Copy code
./mvnw clean install
Run the application:

bash
Copy code
./mvnw spring-boot:run
Access the application on http://localhost:8081.

#Known Issues
Deployment Issue: Current deployment platforms like Render and Heroku only support JDK 17, while my local system uses JDK 21. I am working on resolving this issue using Docker for containerization.
Video Proof
Here’s the video showing the backend working successfully on the localhost: https://www.kapwing.com/videos/673afecae9da35e41e4b523d
Deployment
Deployment is currently under process due to JDK version mismatch challenges.
