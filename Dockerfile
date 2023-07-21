# FROM eclipse-temurin:17-jdk-focal

# WORKDIR /ml-b-s

# COPY .mvn/ .mvn
# COPY --chown=root:root .mvn/ /ml-b-s/.mvn/
# COPY mvnw pom.xml
# RUN ./ml-b-s/mvnw.cmd dependency:go-offline

# COPY src ./src

# CMD ["./mvnw", "spring-boot:run"]

# Etapa de construcción
FROM eclipse-temurin:17-jdk-focal as builder

WORKDIR /ml-b-s

COPY .mvn/ .mvn
COPY mvnw mvnw.cmd pom.xml ./
RUN chmod +x mvnw mvnw.cmd && ./mvnw dependency:go-offline

COPY src ./src

# Etapa de producción
FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

COPY --from=builder /ml-b-s/.mvn/ .mvn/
COPY --from=builder /ml-b-s/mvnw /app/mvnw
COPY --from=builder /ml-b-s/pom.xml /app/pom.xml
COPY --from=builder /ml-b-s/target /app/target

CMD ["./mvnw", "spring-boot:run"]
