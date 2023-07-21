# # Use a base image with OpenJDK and Alpine Linux
# FROM openjdk:11-jre-slim

# # Set the working directory
# WORKDIR /ml-b-s

# # Copy the compiled JAR file to the container
# COPY target/MlBS.jar app.jar

# # Expose the port on which your Spring Boot app is running (change 8080 to your app's port if necessary)
# EXPOSE 8080

# # Command to run the application
# CMD ["java", "-jar", "app.jar"]

FROM eclipse-temurin:17-jdk-focal

WORKDIR /ml-b-s

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]