# Clínica Odontológica API

API REST desenvolvida em **Spring Boot** para o gerenciamento de uma clínica
odontológica (pacientes, dentistas, consultas, exames, pagamentos e salas).
Projeto da disciplina de **Banco de Dados** (UEMA).

## Tecnologias

- Java 21
- Spring Boot 4.1.0
- Spring Data JPA / Hibernate
- Spring Validation (Bean Validation)
- MySQL
- springdoc-openapi (Swagger UI)
- Lombok
- Maven

## Arquitetura

O projeto segue uma arquitetura em camadas:

```
Controller  ->  Service  ->  Repository  ->  Banco de Dados (MySQL)
                  |
                 DTO (objetos de resposta)
```

| Camada | Responsabilidade |
|--------|------------------|
| `controller` | Expõe os endpoints REST |
| `service` | Regras de negócio e conversão entidade ↔ DTO |
| `repository` | Acesso a dados (Spring Data JPA) |
| `entity` | Mapeamento objeto-relacional (JPA) |
| `dto` | Objetos de transferência de dados |
| `exception` | Tratamento global de erros |
| `config` | Configuração do OpenAPI/Swagger |

## Pré-requisitos

- JDK 21 ou superior
- MySQL em execução
- Banco `clinica_odonto` criado com as tabelas do projeto

## Configuração

As credenciais do banco são lidas de variáveis de ambiente
(`src/main/resources/application.properties`):

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/clinica_odonto
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
```

Defina as variáveis antes de executar:

```bash
# Linux/macOS
export DB_USER=seu_usuario
export DB_PASSWORD=sua_senha

# Windows (PowerShell)
$env:DB_USER="seu_usuario"
$env:DB_PASSWORD="sua_senha"
```

> Observação: `spring.jpa.hibernate.ddl-auto=none` — o schema é gerenciado
> manualmente no MySQL (não é criado pela aplicação).

## Como executar

```bash
./mvnw spring-boot:run
```

A API sobe em `http://localhost:8080`.

## Funcionalidades (entidades)

- Pacientes
- Dentistas
- Especialidades
- Consultas
- Exames
- Pagamentos
- Salas de atendimento

Cada uma expõe um CRUD completo (`GET`, `GET /{id}`, `POST`, `PUT`, `DELETE`).

---

## Diferenciais implementados

### 1. Swagger / OpenAPI

Documentação interativa de todos os endpoints, gerada automaticamente.

- **Swagger UI:** http://localhost:8080/swagger-ui.html
- **JSON OpenAPI:** http://localhost:8080/v3/api-docs

> Foi usada a versão **springdoc-openapi 3.0.3**, a única linha compatível
> com Spring Boot 4.x.

### 2. Bean Validation

Validação automática dos dados de entrada nas requisições `POST`/`PUT`,
usando anotações do Jakarta Bean Validation (`@NotBlank`, `@NotNull`,
`@Email`, `@Positive`, `@Past`, `@Pattern`, `@Size` e `@CPF`).

Quando os dados são inválidos, a API retorna **HTTP 400** com a lista de
campos e mensagens. Exemplo:

```bash
curl -X POST http://localhost:8080/pacientes \
     -H "Content-Type: application/json" \
     -d "{}"
```

```json
{
  "timestamp": "2026-06-30T10:00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "nome: O nome é obrigatório; cpf: O CPF é obrigatório; ..."
}
```

> O campo CPF usa `@CPF` (Hibernate Validator), que valida o dígito
> verificador — utilize um CPF válido nos testes.


## Tratamento de erros

Respostas de erro padronizadas via `GlobalExceptionHandler`:

| Situação | Status |
|----------|--------|
| Dados inválidos (Bean Validation) | `400 Bad Request` |
| Recurso não encontrado | `404 Not Found` |
| Erro inesperado | `500 Internal Server Error` |
