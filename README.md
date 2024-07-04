# 📚 Fórum HUB API

## 📝 Descrição

Este projeto é uma API REST para um fórum, desafio proposto no programa ONE. A API permite a criação, leitura, atualização e exclusão de tópicos e respostas. Além disso, inclui um sistema de autenticação e autorização de usuários utilizando JWT. Usuários podem ter os perfis de `user` e `admin`, sendo que um usuário pode ter ambos os perfis, mas nunca apenas o perfil de `admin`.

## 🛠️ Tecnologias Utilizadas

- **Java 17**: Linguagem de programação utilizada.
- **Spring Boot**: Framework para criação de aplicações Java.
- **Spring Data JPA**: Para persistência de dados.
- **Spring Security**: Para segurança da API.
- **MySQL Database**: Base de dados principal da API.
- **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
- **JWT (JSON Web Token)**: Para autenticação e autorização de usuários.
- **Maven**: Gerenciador de dependências e build.

## ⚙️ Configuração do Projeto

### 📦 Dependências do Maven

As principais dependências utilizadas no projeto incluem:

- `spring-boot-starter-web`: Para criação de APIs REST.
- `spring-boot-starter-data-jpa`: Para integração com o JPA.
- `spring-boot-starter-security`: Para configuração de segurança.
- `jjwt`: Para manipulação de tokens JWT.
- `mysql-connector-j`: Conexão com o banco de dados MySQL.
- `h2`: Para o banco de dados em memória H2.
- `spring-boot-starter-test`: Para testes unitários e de integração.

### 🗂️ Configuração do application.properties

O arquivo `application.properties` é configurado para usar o banco de dados H2 e para definir parâmetros do JWT:

- Configurações do banco de dados MySQL.
- Configurações de segurança e JWT.


## 🚀 Exemplos de Uso

### ➕ Criar um Tópico

Para criar um novo tópico, envie uma requisição `POST` para `/api/topico` com o corpo da requisição contendo os dados do tópico.

### 📄 Listar Tópicos

Para listar todos os tópicos, envie uma requisição `GET` para `/api/topico`.

### ✏️ Atualizar um Tópico

Para atualizar um tópico existente, envie uma requisição `PUT` para `/api/topico` com o corpo da requisição contendo os dados atualizados do tópico.

### 🗑️ Deletar um Tópico

Para deletar um tópico, envie uma requisição `DELETE` para `/api/topico/{id}`.

## 🔒 Segurança

A segurança é configurada para usar JWT. As rotas de autenticação e visualização de tópicos são públicas, enquanto outras rotas são protegidas e requerem um token JWT válido.

### 🔑 Autenticação

Para autenticar um usuário, envie uma requisição `POST` para `/api/login` com as credenciais do usuário, foram criados dois usuarios de teste: usuario01@example.com e usuario02@example.com, ambos com a senha 12345. A resposta será um token JWT que deve ser usado em requisições subsequentes no cabeçalho `Authorization`.

## 🤝 Contribuição

Se você deseja contribuir com este projeto, por favor, envie um pull request ou abra uma issue para discutir as mudanças que você gostaria de fazer.
