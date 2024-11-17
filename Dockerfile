# Use a base image that supports Java 21
FROM openjdk:21-jdk-slim

# Set the JAVA_HOME environment variable
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64

# Add JAVA_HOME to the PATH environment variable
ENV PATH="${JAVA_HOME}/bin:${PATH}"

# Set the working directory
WORKDIR /app

# Copy your project files into the Docker container
COPY . .

# Build the project (if needed)
RUN ./mvnw clean install

# Run the Spring Boot application
CMD ["./mvnw", "spring-boot:run"]
