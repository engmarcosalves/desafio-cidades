# desafio-cidades

Desafio Cidades (API em REST feito em JAVA com Spring que Carrega Arquivo CSV e outras regras de negócio)

Web API desenvolvido em JAVA com as seguintes tecnologias:

* Java 8
* Spring Framework 4
* Jackson (RESTful Web Services)
* Spring JPA (Hibernate 5.3.6.Final)
* MySQL Community Server 8.0.12
* Maven 3
* Postman (para testes da API)
* IntelliJ IDEA 2018.2.2 (Community Edition)

--- 

OBS: Para funcionar deverá renomear o CSV para desafio-cidades.csv e alterar o path na classe "CidadeServiceImpl.java"

#1. Ler o arquivo CSV das cidades para a base de dados;
> Rota ("/api/cidades/carregarcsv") com GET, irá popular o database com base no csv desafio-cidades.csv 

#2. Retornar somente as cidades que são capitais ordenadas por nome; 
> Rota ("/api/cidades/capitais") com GET, irá retornar todas as capitais ordenadas de for ascendente

#3. Retornar o nome do estado com a maior e menor quantidade de cidades e a
quantidade de cidades;
> Rota ("/estadomaiormenor") com GET, irá retornar o maior estado e o menor estado
