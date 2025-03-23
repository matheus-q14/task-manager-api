# TarefaAPI - Gerenciamento de Tarefas

Este é um projeto de uma API RESTful simples para o gerenciamento de usuários e suas tarefas. Desenvolvida seguindo o
padrão MVC (Model-View-Controller) e a arquitetura de camadas,
promovendo boa organização e escalabilidade.  
Este projeto foi desenvolvido com o objetivo de aprender e aplicar as
tecnologias mencionadas, focando em práticas recomendadas de desenvolvimento.

---

## Endpoints

### Usuários

**GET /users:** Retorna todos os usuários cadastrados.

**GET /users/{userId}:** Retorna os detalhes de um usuário específico, incluindo suas tarefas.

**POST /users:** Cria um novo usuário.

**DELETE /users/{userId}:** Remove um usuário e todas as suas tarefas associadas.

### Tarefas

**GET /tasks:** Retorna todas as tarefas cadastradas.

**GET /tasks/users/{userId}:** Retorna todas as tarefas associadas a um usuário específico.

**POST /tasks/user/{userId}:** Cria uma nova tarefa com nome, descrição e data de criação que é vinculada a um usuário.

**DELETE /tasks/{taskId}:** Remove uma tarefa.

---

## Como Rodar o Projeto

### Pré-requisitos

Antes de rodar a aplicação, é necessário ter os seguintes itens instalados:

**JDK 21** (Java Development Kit)

**Maven** (para gerenciamento de dependências e build)

**PostgreSQL** (ou qualquer outro banco de dados relacional compatível com JPA)

**IDE** de sua escolha (Ex: IntelliJ IDEA, Eclipse, VS Code)

### Passo a passo

#### Clone o repositório:

```shell
    git clone https://github.com/seu-usuario/tarefaapi.git
```

#### Configure o banco de dados:

Crie um banco de dados no `PostgreSQL` (exemplo: tasks_db).

No arquivo `application.properties`, configure a conexão com o banco de dados:

```properties
# Banco de dados PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/seu-banco-de-dados
spring.datasource.username=usuario-do-seu-banco
spring.datasource.password=senha-do-seu-usuario
spring.jpa.database-plataform=org.hibernate.dialect.PostgreSQLDialect
# Configuraçoes do JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.format_sql=true
```

#### Instale as dependências:

Navegue até o diretório do projeto e execute o comando abaixo para instalar as dependências via
Maven:

```shell
    mvn clean install
```

#### Execute a aplicação:

Para rodar a aplicação, execute o seguinte comando:

```shell
    mvn spring-boot:run
```

A API estará disponível em http://localhost:8080 (por padrão).

---

## Tecnologias Utilizadas

**Java 21:** Utilizado como linguagem principal para o desenvolvimento da aplicação.

**Spring Boot:** Framework para a criação de APIs RESTful, facilitando a configuração e o desenvolvimento.

**Spring JPA:** Utilizado para a integração com o banco de dados e persistência das entidades.

**PostgreSQL:** Banco de dados relacional utilizado para armazenar os dados dos usuários e das tarefas.

**Maven:** Gerenciador de dependências e construção do projeto.

**Swagger:** Documentação interativa da API.

---

## Melhorias a serem feitas

**Autenticação** de usuário via **JWT**(Json Web Token) para garantir a segurança da
API ao garantir que somente usuários autenticados possam criar e remover tarefas

**Testes** unitários para testar as funcionalidades da aplicação durante o processo de melhoria

**Logs** durante todo o funcionamento da aplicação para garantir um bom monitoramento da API e identificar erros mais
facilmente

Tratar as possíveis **exceções** que possam acontecer durante o uso da aplicação