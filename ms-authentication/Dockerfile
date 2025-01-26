# Usando a imagem base do Maven para compilar e construir o projeto com Java 17
FROM maven:3.8.4-openjdk-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Usando a imagem base do OpenJDK para rodar a aplicação com Java 17
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/authentication-0.0.1-SNAPSHOT.jar authentication.jar
ENTRYPOINT ["java", "-jar", "authentication.jar"]