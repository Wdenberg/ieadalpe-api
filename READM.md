# 🚀 IEADALPE API

![Java](https://img.shields.io/badge/Java-25-red)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue)
![Docker](https://img.shields.io/badge/Docker-Enabled-blue)
![JWT](https://img.shields.io/badge/Auth-JWT-orange)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)

API backend para gestão da igreja **IEADALPE**, desenvolvida com foco em arquitetura limpa, segurança e boas práticas de mercado.

---

## 📌 Sobre o Projeto

A **IEADALPE API** é uma aplicação RESTful que centraliza processos administrativos e operacionais da igreja, permitindo o gerenciamento de usuários, obreiros, notícias, documentos e solicitações.

💡 Este projeto foi desenvolvido com foco em:
- Portfólio backend Java profissional
- Aplicação real com regras de negócio
- Arquitetura escalável
- Segurança com JWT

---

## 🧠 Arquitetura

```text
src/main/java/com/ieadalpe/api
├── config
├── controller
├── domain
│   ├── entity
│   └── enums
├── dto
│   ├── request
│   └── response
├── exception
├── mapper
├── repository
├── security
├── service
│   ├── impl
│   └── interfaces
└── integration
```
## ⚙️ Stack Tecnológica
🔙 Backend
- Java 25
- Spring Boot 4
- Spring Security
- Spring Data JPA
- Validation
- Actuator

## 🗄️ Banco de Dados
- PostgreSQL
- Flyway

## 🔐 Segurança
- JWT
- BCrypt

## 📄 Documentação
- Swagger / OpenAPI
- 
## 🧪 Testes
- JUnit 5
- Mockito
- MockMvc
- Testcontainers

## 🐳 Infraestrutura
Docker
Docker Compose

## 📑 Sumário

* [🚀 Executando o Projeto ↗](#-executando-o-projeto)
* [🔐 Autenticação ↗](#-autenticação)
* [📡 Endpoints ↗](#-endpoints)
* [📊 Observabilidade ↗](#-observabilidade)
* [🧪 Testes ↗](#-testes)
* [⚙️ Variáveis de Ambiente ↗](#️-variáveis-de-ambiente)
* [📦 Docker ↗](#-docker)
* [📈 Roadmap ↗](#-roadmap)

## 🚀 Executando o Projeto

### 📌 Pré-requisitos

- Java 25
- Maven 3.9+
- Docker

### ▶️ Subir com Docker

```bash
docker compose up --build
```

A aplicação estará disponível em:
```bash
http://localhost:8080
```

▶️ Rodar localmente
```bash
docker compose up -d postgres
mvn spring-boot:run
```

### 🔐 Autenticação
🔑 Login
```http
POST /api/v1/auth/login
```

### 📥 Request

```json
{
  "email": "admin@ieadalpe.com",
  "password": "123456"
}
```

### 📤 Response
```json
{
  "accessToken": "jwt_token",
  "tokenType": "Bearer",
  "expiresIn": 7200
}
```

### 🔓 Usando o token 

No Swagger:
```bash
Bearer seu_token_aqui
```

## 📡 Endpoints

### 🔐 Auth
* `POST /api/v1/auth/login`

### ❤️ Health
* `GET /api/v1/health`

### 👤 Obreiros
* `POST /api/v1/obreiros`
* `GET /api/v1/obreiros`
* `GET /api/v1/obreiros/{id}`
* `PUT /api/v1/obreiros/{id}`
* `DELETE /api/v1/obreiros/{id}`

### 📰 Notícias
* `POST /api/v1/noticias`
* `GET /api/v1/noticias`
* `GET /api/v1/noticias/publicadas`

### 📄 Documentos
* `POST /api/v1/documentos`
* `GET /api/v1/documentos`

### 📥 Solicitações
* `POST /api/v1/solicitacoes-obreiros`
* `GET /api/v1/solicitacoes-obreiros`

### 📊 Observabilidade
🔍 Actuator
* `Health:`
* `GET /actuator/health`
* `Info:`
* `GET /actuator/info`
* `Metrics:`
* `GET /actuator/metrics`

## 🧪 Testes
▶️ Executar testes
  
```bash
mvn test
```
🔎 Tipos de testes
* Unitários (Service)
* Web (Controller)
* Integração (Testcontainers + PostgreSQL real)

## ⚙️ Variáveis de Ambiente

```env
SPRING_PROFILES_ACTIVE=prod
DB_URL=jdbc:postgresql://postgres:5432/ieadalpe_db
DB_USERNAME=postgres
DB_PASSWORD=postgres
JWT_SECRET=sua_chave_super_secreta
```

## 📦 Docker
▶️ Subir ambiente

```bash
docker compose up --build
```
## ⛔ Parar
```bash
docker compose down
```

## 📚 Documentação
Swagger UI

```bash
http://localhost:8080/swagger-ui.html
```

### 🧱 Boas Práticas Aplicadas
* ✔ Arquitetura em camadas
* ✔ DTOs separados
* ✔ Exception Handler global
* ✔ JWT stateless
* ✔ BCrypt
* ✔ Flyway migrations
* ✔ Paginação
* ✔ Testes automatizados
* ✔ Dockerização
* ✔ Configuração por ambiente

## 📈 Roadmap
🔹 v1.0
* JWT
* CRUD completo
* Docker
* Flyway
* Swagger

🔹 v1.1
* 
* Aprovação de obreiros
* Auditoria avançada 

🔹 v1.2
* Upload de arquivos
* Integração com storage

👨‍💻 Autor

Wdenberg Ramos de Barros

Backend Developer Java

🔗 Portfolio: https://wdenbergramos.vercel.app/

🔗 GitHub: https://github.com/Wdenberg

🔗 LinkedIn: https://br.linkedin.com/in/wdenbergramos

🔗 Instagram: https://www.instagram.com/wdenbergramos/

---

## 📄 Licença

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

Este projeto está sob a licença **MIT**. Para mais detalhes, consulte o arquivo [LICENSE](./LICENSE).