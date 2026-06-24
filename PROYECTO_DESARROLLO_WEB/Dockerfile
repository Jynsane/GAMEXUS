# 1. Fase de Compilación (Build)
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar el pom.xml y descargar dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el resto del código y compilar el JAR
COPY src ./src
RUN mvn clean package -DskipTests

# 2. Fase de Ejecución (Runtime)
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copiar el JAR generado en la fase anterior
COPY --from=build /app/target/proyecto-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto del servidor
EXPOSE 8080

# Iniciar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
