# Use a base image that supports Java 21
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the project files to the container
COPY . .

# Ensure that the mvnw script is executable
RUN chmod +x mvnw

# Build the project using Maven (skip tests)
RUN ./mvnw clean install -DskipTests

# Expose the port your application will run on
EXPOSE 8081

# Run the Spring Boot application
CMD ["./mvnw", "spring-boot:run"]
