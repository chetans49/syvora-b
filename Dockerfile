# Use a base image that supports Java 21
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy all files from your local machine to the container's working directory
COPY . .

# Expose the port that your Spring Boot application will run on (typically 8080)
EXPOSE 8080

# Build the project using Maven (replace with appropriate command if you use Gradle or other tools)
RUN ./mvnw clean install

# Run the Spring Boot application
CMD ["./mvnw", "spring-boot:run"]
