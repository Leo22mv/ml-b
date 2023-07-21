FROM eclipse-temurin:17-jdk-focal

WORKDIR /ml-b-s

COPY .mvn/ .mvn
COPY mvnw pom.xml
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]