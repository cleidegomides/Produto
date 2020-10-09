## Projeto_Criar_Produto 🛒

### 📜Sobre
O Projeto foi desenvolvido para criar produtos, atualizar, deletar e listar.
___

### 💻Tecnologias

- Java8
- Spring Boot
- Swagger2
- Spring Data
___

### 🔨 Ferramentas 

- Docker
- MySQL
- Intellij
- Dbeaver
- Postman
___
### 📖 Documentação

- URL para acesso à Documentação da API: http://localhost:8080/swagger-ui.html
___
### 🖱 Comandos Utilizados no cmdr para Rodar o MYSQL no Docker:

```bash

#criar um novo container
docker run -p 3306:3306 --name some-mysql -e MYSQL_ROOT_PASSWORD=xxxxx -d mysql

#listar todos container
docker container ls -a;

#Startar o container
docker container start some-mysql;

#Para o container
docker container stop some-mysql.