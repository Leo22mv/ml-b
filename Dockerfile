# FROM eclipse-temurin:17-jdk-focal

# WORKDIR /ml-b-s

# COPY .mvn/ .mvn
# COPY --chown=root:root .mvn/ /ml-b-s/.mvn/
# COPY mvnw pom.xml
# RUN ./ml-b-s/mvnw.cmd dependency:go-offline

# COPY src ./src

# CMD ["./mvnw", "spring-boot:run"]




# # Etapa de construcción
# FROM eclipse-temurin:17-jdk-focal as builder

# WORKDIR /ml-b-s

# COPY .mvn/ .mvn
# COPY mvnw mvnw.cmd pom.xml ./
# RUN chmod +x mvnw mvnw.cmd && ./mvnw dependency:go-offline

# COPY src ./src

# # Etapa de producción
# FROM eclipse-temurin:17-jdk-focal

# WORKDIR /app

# COPY --from=builder /ml-b-s/.mvn/ .mvn/
# COPY --from=builder /ml-b-s/mvnw /app/mvnw
# COPY --from=builder /ml-b-s/pom.xml /app/pom.xml
# COPY --from=builder /ml-b-s/target /app/target

# CMD ["./mvnw", "spring-boot:run"]



# Utiliza una imagen base de Java 17
FROM adoptopenjdk:17-jdk-hotspot

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR de tu aplicación en el contenedor
COPY ml-b-s-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que tu aplicación Java se ejecuta (ajústalo según tu aplicación)
EXPOSE 8080

# Comando para ejecutar la aplicación Java (ajústalo según el nombre del JAR y otros parámetros)
CMD ["java", "-jar", "app.jar"]
