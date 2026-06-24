# 1. Fase de Compilación del Frontend (Angular)
FROM node:20-alpine AS frontend-build
WORKDIR /app/frontend
COPY frontend/package*.json ./
RUN npm install
COPY frontend/ ./
RUN npm run build -- --configuration=production

# 2. Fase de Compilación del Backend (Maven)
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
# Copiar los archivos compilados de Angular al directorio static de Spring Boot
COPY --from=frontend-build /app/frontend/dist/frontend/browser src/main/resources/static
RUN mvn clean package -DskipTests

# 3. Fase de Ejecución (Runtime)
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/proyecto-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

