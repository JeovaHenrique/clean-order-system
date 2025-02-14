# Etapa 1: Construir a aplicação
FROM maven:3.8.4-openjdk-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Executar a aplicação
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/ms-authentication.jar ms-authentication.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ms-authentication.jar"]