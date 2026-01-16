# Leitor e Validador de Arquivos CSV em Java

## 1. Objetivo

> Este mini projeto possui caráter educacional, com foco no estudo e na prática de desenvolvimento de software. O desafio consiste na implementação de uma aplicação em Java, distribuída como um arquivo JAR, responsável por realizar a leitura, validação e organização de arquivos no formato CSV.
No desenvolvimento do projeto, são aplicados os princípios SOLID, bem como a implementação de testes unitários, visando garantir qualidade, manutenibilidade e confiabilidade do código.
- **Tecnologias Usadas:** Java, SOLID, teste unitarios.
---

### Requisitos:

1. Realizar a leitura automática de todos os arquivos com extensão `.csv` localizados no diretório: `/PENDENTES` 
2. Cada arquivo encontrado será analisado individualmente e validado conforme as regras: 
    - Arquivo não pode estar vazio. 
    - A estrutura de colunas deve seguis o padrão de forma rigida: `NUMERO_DA_VENDA`, `NOME_DO_CLIENTE`, `DATA_DA_VENDA`, `VALOR_DA_VENDA`. 
4. Se não comprir nenhuma alguma das duas regras sera movido para o diretorio `\INVALIDADO`.
5. Caso cumpra as regras sera movido para o diretorio `\VALIDADO`.
6. Se os diretorios`/VALIDADOS` e `/INVALIDADOS` não existirem serão criados. 
6. Gera um arquivo `.jar`

###  Execução da Aplicação

Para executar o projeto, siga os passos abaixo:

1. Crie o diretorio `PENDENTES` e coloque os arquivos `.csv` a serem valdiados
2. Execute o arquivo jar `desafio-validador-csv-1.0-SNAPSHOT-jar-with-dependencies.jar` no diretorio onde esta diretorio `PENDENTES`, da seguinte forma:

``` shell
java -jar desafio-validador-csv-1.0-SNAPSHOT-jar-with-dependencies.jar
``` 


