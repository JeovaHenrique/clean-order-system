# Clean Order System - Authentication

## 📌 Sobre o Projeto

O **Clean Order System - Authentication** é um microsserviço responsável pela autenticação e gestão de usuários na arquitetura do Clean Order System. Ele utiliza **Spring Security, JWT e OAuth2** para garantir a segurança dos acessos, seguindo princípios de **Clean Architecture** e boas práticas de desenvolvimento.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.4.0**
- **Spring Security**
- **OAuth2 Authorization Server**
- **JWT (JSON Web Token)**
- **Lombok**
- **MapStruct**
- **Hibernate & JPA**
- **Banco de Dados PostgreSQL**
- **Docker** (para containerização)

## ⚙️ Funcionalidades Implementadas

- 📌 **Registro de Usuários**
- 🔐 **Autenticação com JWT**
- 🔄 **Renovação de Token**
- ✨ **Autorizacão baseada em perfis de usuários (Roles)**
- 📩 **Validação de credenciais e regras de senha**
- 🔄 **Recuperação e Redefinição de Senha**

## 📜 Como Rodar o Projeto

### 1️⃣ Configuração do Banco de Dados

Certifique-se de ter um banco **PostgreSQL** rodando e configure o **application.yml**:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/clean_order_system_auth
    username: seu_usuario
    password: sua_senha
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
```

### 2️⃣ Subindo o Microsserviço

#### 🔹 Via Docker

```sh
docker-compose up -d
```

#### 🔹 Sem Docker (Maven)

```sh
mvn spring-boot:run
```

## 📡 Endpoints Principais

### 🔐 Autenticação

- **POST** `/auth/login` - Gera um token JWT ao autenticar um usuário.
- **POST** `/auth/register` - Registra um novo usuário.
- **POST** `/auth/refresh-token` - Atualiza o token JWT.
- **POST** `/auth/logout` - Realiza o logout do usuário.

### 👤 Gestão de Usuários

- **GET** `/api/users/me` - Obtém informações do usuário autenticado.
- **PUT** `/api/users/update-profile` - Atualiza informações do usuário.
- **DELETE** `/api/users/delete` - Deleta o usuário autenticado.

## 🔨 O que será Adicionado

- 🔹 **Autenticação Multifator (MFA) com Azure**
- 🔹 **Suporte para Login com Biometria**
- 🔹 **Integração com outras APIs do Clean Order System**
- 🔹 **Melhoria nos Testes Automatizados**

## 🛠 Contribuição

Sinta-se livre para contribuir! Faça um fork do repositório, crie uma branch e envie um pull request.

## 📜 Licença

Este projeto está sob a **MIT License**. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

Desenvolvido com ❤️ por [Jeova Henrique](https://github.com/JeovaHenrique).