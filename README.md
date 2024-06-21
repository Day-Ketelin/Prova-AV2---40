# Prova-AV2---40


Projeto acadêmico criado para avaliação junto à disciplina de Arquitetura de Aplicações Web - professor João Paulo Aramuni,do Centro Universitário Newton Paiva, produzido em Java e com a compilação pela plataforma IntelliJ IDEA.

* Sistema de autenticação e autorização de usuários utilizando Java, MongoDB e JWT (JSON Web Token).


# Objetivo

Sistema desenvolvido para autenticação e autorização em uma aplicação de e-commerce, garantindo que apenas usuários autenticados e autorizados possuem acesso a determinados recursos da aplicação.


***Link do Projeto:*** **<https://github.com/Day-Ketelin/Prova-AV2---40>**
#


# Diagrama Lógico

Diagrama com os pacotes, endpoints, dependências e organização dos arquivos utilizados na construção do projeto, de modo a prover maior segurança e praticidade dos métodos utilizados:

![](XXXXXXXX)

**URL Figma:** *<XXXXXXXX>*

##


##  Autenticação de usuários

|Requisitos|    Descrição         |
|---------:|--------------------- |
|     1    | Registro de Usuário  |
|     2    | Login Seguro         |
|     3    | Geração de Token JWT |

**Registro de Usuário**
na aplicação é implementada a funcionalidade de registro permitindo que somente os gerentes cadastrem novos usuários, utilizando nome de usuário e senhal. Cada usuário é identificado como cliente, vendedor ou gerente.
*-*

**Login Seguro**
O sistema de login é seguro e os usuários podem entrar na plataforma fornecendo suas credenciais (nome de usuário/ login e senha). As credenciais são então verificadas em relação às informações armazenadas no banco de dados para permitir ou não o acesso.

*-*

**Geração de Token JWT**
Após um login bem-sucedido, é gerado um token JWT (JSON Web Token) para o usuário autenticado. Este token contém informações sobre o usuário, como seu ID e tipo de conta.

## Controle de acesso com JWT

|Requisitos|       Descrição                |
|---------:|--------------------------------|
|     1    | Registro e login               |
|     2    | Geração e validação de tokens  |
|     3    | Controle de acesso             |


**Registro e login**

Foram criados os endpoints para registro e login dos usuários, de modo que as senhas são armazenadas de forma segura utilizando hashing.

*-*

**Geração e validação de tokens**
Foi implementada a geração de tokens JWT, contendo informações relevantes do usuário e a lógica de validação para esses tokens em cada requisição protegida.

*-*



**Controle de acesso**
A aplicação implementa uma lógica de controle de acesso nos endpoints, garantindo que apenas usuários autorizados possam acessar determinados recursos.

#



#

# Funcionamento da aplicação e verificação das requisições:
![](XXXXXXX)
*
### Linguagem utilizada: JAVA

---
>**Bibliotecas Necessárias**
---
>spring-boot-starter-web: Para criar uma aplicação web usando Spring Boot.
>
>spring-boot-starter-data-mongodb: Para integração com o MongoDB.
>
>spring-boot-starter-security: Para inplementação das configurações de segurança.
>
>jjwt: Para geração e validação de JWTs.

---

## Prints do Projeto

![](xxxxxx)

###

![](xxxxxx)

#



#

⚠️🛠️🛠️🛠️⭐⭐⭐🛠️🛠️🛠️⚠️
