# Sistema de Microserviço

## Visão Geral
Este projeto é uma aplicação de microserviços desenvolvida com tecnologias modernas para garantir escalabilidade, manutenção e facilidade de integração. O sistema lida com funcionalidades específicas do domínio e se comunica com outros serviços de forma assíncrona.

## Principais Funcionalidades
- **Arquitetura orientada a eventos** utilizando RabbitMQ.
- APIs RESTful para interação e integração.
- Uso do PostgreSQL para persistência de dados.
- Integração de testes de e-mail utilizando o MailHog.

## Tecnologias Utilizadas

| Tecnologia       | Finalidade                         |
|------------------|-----------------------------------|
| **Spring Boot 3** | Framework para construção da aplicação. |
| **RabbitMQ**     | Message broker para comunicação assíncrona. |
| **Java 21**      | Linguagem de programação.         |
| **Postman**      | Teste e desenvolvimento de APIs. |
| **Docker**       | Containerização da aplicação.    |
| **Maven**        | Gerenciamento de dependências e builds. |
| **Beekeeper**    | Gerenciamento e consultas ao banco de dados. |
| **PostgreSQL**   | Banco de dados relacional.        |
| **MailHog**      | Ferramenta de testes de e-mail.   |
| **GIT/GitHub**   | Controle de versão e colaboração. |

## Pré-Requisitos
Antes de configurar o projeto, certifique-se de que os seguintes itens estejam instalados na sua máquina:

- Java 21
- Docker
- Maven
- RabbitMQ (pode ser executado em um contêiner Docker)
- PostgreSQL

## Instruções de Configuração

1. **Clone o Repositório**
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
   ```

2. **Configure a Aplicação**
   Atualize o arquivo `application.yml` com suas credenciais do PostgreSQL e RabbitMQ.

3. **Compile o Projeto**
   ```bash
   mvn clean install
   ```

4. **Execute os Serviços com Docker**
   ```bash
   docker-compose up
   ```

5. **Execute a Aplicação**
   ```bash
   java -jar target/sua-aplicacao.jar
   ```

## Testes

- **Postman**: Use a coleção fornecida para testar os endpoints da API.
- **MailHog**: Acesse `http://localhost:8025` para verificar os testes de e-mail.

## Contribuições
Contribuições são bem-vindas! Por favor, faça um fork do repositório, realize suas alterações e envie um pull request.

## Licença
Este projeto está licenciado sob a [Licença MIT](LICENSE).

## Contato
Para dúvidas, entre em contato pelo e-mail [seu-email@exemplo.com](mailto:seu-email@exemplo.com).

