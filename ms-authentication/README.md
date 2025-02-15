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
- **Banco de Dados H2 / PostgreSQL**
- **Docker** (para containerização)

## 🏗️ Arquitetura do Projeto

O microsserviço segue a **Clean Architecture**, garantindo um design modular e de fácil manutenção. A estrutura do projeto é organizada da seguinte forma:

```
src/
├── main/
│   ├── java/com/cleanordersystem/authentication/
│   │   ├── adapters/         # Adaptadores para persistência e mapeamento
│   │   │   ├── in/            # Interfaces de entrada (controladores, DTOs)
│   │   │   │   ├── controllers/
│   │   │   │   │   ├── AuthenticationController.java
│   │   │   │   │   ├── UserController.java
│   │   │   │   ├── dto/
│   │   │   │   │   ├── ChangePasswordRequest.java
│   │   │   │   │   ├── LoginRequest.java
│   │   │   │   │   ├── RefreshTokenRequest.java
│   │   │   │   │   ├── RegisterRequest.java
│   │   │   │   │   ├── UpdateProfileRequest.java
│   │   │   ├── out/           # Interfaces de saída (repositórios, serviços externos)
│   │   │   │   ├── AuthenticationResponse.java
│   │   │   │   ├── LogoutResponse.java
│   │   │   ├── persistence/
│   │   │   │   ├── entities/
│   │   │   │   │   ├── UserEntity.java
│   │   │   │   ├── mappers/
│   │   │   │   │   ├── UserMapper.java
│   │   │   │   ├── repositories/
│   │   │   │   │   ├── JpaUserRepository.java
│   │   │   │   │   ├── JpaUserRepositorySpringData.java
│   │   ├── config/            # Configurações de segurança
│   │   │   ├── security/
│   │   │   │   ├── JwtAuthenticationFilter.java
│   │   │   │   ├── JwtService.java
│   │   │   │   ├── SecurityConfig.java
│   │   ├── core/              # Lógica de negócios e domínio
│   │   │   ├── constants/
│   │   │   │   ├── TokenConstants.java
│   │   │   ├── domain/
│   │   │   │   ├── enums/
│   │   │   │   ├── RolesEnum.java
│   │   │   │   ├── models/
│   │   │   │   │   ├── User.java
│   │   │   │   ├── ports/
│   │   │   │   │   ├── in/
│   │   │   │   │   │   ├── AuthenticationUseCase.java
│   │   │   │   │   │   ├── UserUseCase.java
│   │   │   │   │   ├── out/
│   │   │   │   │   │   ├── UserRepository.java
│   │   │   ├── service/
│   │   │   │   ├── AuthenticationService.java
│   │   │   │   ├── CustomUserDetailsService.java
│   │   │   │   ├── UserService.java
│   │   ├── AuthenticationApplication.java
├── resources/                 # Arquivos de configuração
│   ├── application-h2.yml
│   ├── application-postgre-sql.yml
pom.xml                        # Gerenciamento de dependências
docker-compose.yml             # Configuração de containerização
Dockerfile                     # Configuração de containerização
README.md                      # Documentação do projeto
```

## 📜 Como Rodar o Projeto

### 1️⃣ Escolha o Profile do Banco de Dados

Este microsserviço suporta **H2 (memória)** e **PostgreSQL**. Escolha o perfil adequado ao iniciar a aplicação.

#### 🔹 Usando H2 (Banco em Memória)
**Windows (PowerShell):**
```powershell
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=h2"
```

#### 🔹 Usando PostgreSQL(Docker)
**Windows (PowerShell):**
```powershell
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=postgre-sql"
```

### 2️⃣ Subindo o Microsserviço com Docker
```sh
docker-compose up -d
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