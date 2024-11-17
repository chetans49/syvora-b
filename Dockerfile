# Use an OpenJDK 17 image
FROM openjdk:17-jdk-slim

# Set the JAVA_HOME environment variable
ENV JAVA_HOME=/usr/local/openjdk-17

# Add JAVA_HOME to PATH
ENV PATH="$JAVA_HOME/bin:${PATH}"

# Set the working directory in the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml to the container
COPY . /app

# Run Maven build to install dependencies (skip tests for faster builds)
RUN ./mvnw clean install -DskipTests

# Expose the port your application will run on
EXPOSE 8081

# Run the Spring Boot application
CMD ["./mvnw", "spring-boot:run"]
