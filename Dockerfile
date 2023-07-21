FROM eclipse-temurin:17-jdk-focal

WORKDIR /ml-b-s

COPY .mvn/ .mvn
COPY --chown=root:root .mvn/ /ml-b-s/.mvn/
COPY mvnw pom.xml
RUN ./ml-b-s/mvnw.cmd dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]