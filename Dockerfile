# Use OpenJDK 21 as the base image
FROM openjdk:17-jdk-slim

# Define the location of the JAR file
ARG JAR_FILE=/target/demo-0.0.1-SNAPSHOT.jar

ENV PATH=/usr/local/openjdk-17/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin


ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64

# Copy the built JAR file into the container
COPY ${JAR_FILE} app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]


CMD ["./mvnw" "spring-boot:run"]