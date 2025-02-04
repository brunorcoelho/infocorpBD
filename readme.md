### Diagramas e Documentação (Partes 1 e 2 do desafio)

Neste repositório, você encontrará alguns diagramas e documentação adicionais para auxiliar na compreensão do sistema:

- **LOGICO.PNG**: Diagrama Lógico do Banco de Dados. Este diagrama mostra como as tabelas e os relacionamentos entre elas estão estruturados.
- **DER.PNG**: Diagrama de Entidade-Relacionamento (ER). Este diagrama ilustra as entidades do sistema e os relacionamentos entre elas.
- **Documentação das Classes.pdf**: Documento que detalha as classes e suas responsabilidades dentro do projeto, incluindo explicações sobre os atributos e métodos de cada uma.

---
# BDInfo - Sistema de Gestão de Pedidos e Produtos

Este é um sistema de gestão de pedidos, produtos, usuários e pagamentos, desenvolvido utilizando Java, JPA (Hibernate), PostgreSQL, Flyway e Maven.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada.
- **JPA (Hibernate)**: Framework de persistência utilizado para interagir com o banco de dados.
- **PostgreSQL**: Banco de dados relacional utilizado para armazenar os dados.
- **Flyway**: Ferramenta para controle de versões de banco de dados e migrações.
- **Maven**: Ferramenta de automação de builds utilizada para gerenciar dependências e construir o projeto.

## Estrutura do Projeto

O projeto é composto pelas seguintes entidades:

1. **Usuario**: Representa os usuários do sistema.
2. **Perfil**: Representa os perfis atribuídos aos usuários.
3. **Produto**: Representa os produtos disponíveis no sistema.
4. **ItemPedido**: Representa os itens que fazem parte de um pedido.
5. **Pagamento**: Representa os pagamentos realizados para pedidos.
6. **Pedido**: Representa os pedidos realizados pelos usuários.

### Estrutura do Banco de Dados

O banco de dados possui as seguintes tabelas:

- **usuarios**
- **perfis**
- **produtos**
- **itens_pedido**
- **pagamentos**
- **pedidos**

## Como Implementar o Projeto

### 1. Clonar o Repositório

Clone este repositório para sua máquina local:

```bash
git clone <URL_DO_REPOSITORIO>
```

### 2. Configuração do Banco de Dados

Este projeto utiliza o PostgreSQL. Para configurar o banco de dados:

1. Instale o PostgreSQL na sua máquina.
2. Crie um banco de dados chamado `bdinfo`.
3. Atualize a URL, o nome de usuário e a senha do banco de dados no arquivo `persistence.xml`:

```xml
<property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/bdinfo"/>
<property name="javax.persistence.jdbc.user" value="SeuUsuarioAqui"/>
<property name="javax.persistence.jdbc.password" value="SuaSenhaAqui"/>
```

### 3. Configuração do Flyway (Parte 3 do desafio)

Flyway é utilizado para gerenciar a versão do banco de dados e aplicar as migrações.

#### Passos para configurar e executar as migrações:

1. No arquivo `pom.xml`, o plugin Flyway já está configurado com a URL do banco de dados e as credenciais. Certifique-se de que as informações estejam corretas de acordo com a sua instalação do PostgreSQL:

```xml
<plugin>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-maven-plugin</artifactId>
    <version>9.16.0</version>
    <configuration>
        <url>jdbc:postgresql://localhost:5432/bdinfo</url>
        <user>SeuUsuarioAqui</user>
        <password>SuaSenhaAqui</password>
    </configuration>
</plugin>
```

2. Para rodar as migrações Flyway, execute o seguinte comando Maven:

```bash
mvn flyway:migrate
```

Isso aplicará todas as migrações disponíveis no diretório `src/main/resources/db/migration`.

### 4. Executar o Projeto

Para compilar e rodar o projeto, execute o seguinte comando Maven:

```bash
mvn clean install
mvn exec:java
```

Isso compilará o código e executará o projeto, iniciando o servidor (caso haja a configuração de um servidor, como Tomcat ou Jetty).

#### O que o arquivo `Main.java` faz:

O arquivo `Main.java` que eu criei serve apenas para mostrar que as classes funcionam e é possível adicionar linhas às colunas do banco utilizando as classes criadas. Ele tem a responsabilidade de inicializar o contexto de persistência (como o `EntityManagerFactory` e o `EntityManager`), que permite a interação com o banco de dados. No arquivo, podem ser feitas simulações de operações, como a criação de usuários, produtos e pedidos, além de executar testes ou validar o funcionamento do sistema.

O código no `Main.java` também pode ser usado para rodar as migrações de banco de dados, garantir que as tabelas e dados estejam configurados corretamente ou simplesmente para testar as funcionalidades básicas do sistema.

## Como Usar

Este projeto implementa as operações de um sistema de pedidos, como:

- Cadastro de usuários
- Criação de pedidos
- Cadastro de produtos
- Registro de pagamentos

A interface de usuário pode ser implementada conforme as necessidades do projeto.

## Comandos Flyway

- **mvn flyway:migrate**: Aplica todas as migrações pendentes no banco de dados.
- **mvn flyway:clean**: Limpa todas as tabelas do banco de dados, útil para um reinício completo.
- **mvn flyway:info**: Exibe informações sobre o estado das migrações.
te arquivo `README.md` cobre o básico sobre como implementar o projeto, como configurar e usar o Flyway para controle de versões do banco de dados, e algumas instruções gerais para executar o projeto.