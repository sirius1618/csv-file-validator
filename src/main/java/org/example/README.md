# Leitor e Validador de Arquivos CSV em Java

## 1. Objetivo

> Este mini projeto possui caráter educacional, com foco no estudo e na prática de desenvolvimento de software. O desafio consiste na implementação de uma aplicação em Java, distribuída como um arquivo JAR, responsável por realizar a leitura, validação e organização de arquivos no formato CSV.
No desenvolvimento do projeto, são aplicados os princípios SOLID, bem como a implementação de testes unitários, visando garantir qualidade, manutenibilidade e confiabilidade do código.
- **Tecnologias Usadas:** Java, SOLID, teste unitarios.
---

## 2. Escopo do Projeto

- A aplicação deve realizar a leitura automática de todos os arquivos com extensão `.csv` localizados no diretório:

```
/PENDENTES
```

- Cada arquivo encontrado será analisado individualmente e validado conforme regras previamente definidas. Após a validação, o arquivo será movido para um diretório específico, de acordo com o resultado.

---

## 3. Regras de Validação

Um arquivo CSV será considerado **válido** somente se atender integralmente aos critérios abaixo.

### 3.1 Arquivo não vazio

* O arquivo deve conter ao menos uma linha de dados.
* Arquivos vazios ou sem conteúdo são automaticamente classificados como inválidos.

### 3.2 Estrutura das colunas

Cada linha do arquivo deve conter **exatamente quatro colunas**, na ordem definida abaixo:

1. `NUMERO_DA_VENDA`
2. `NOME_DO_CLIENTE`
3. `DATA_DA_VENDA`
4. `VALOR_DA_VENDA`

Caso qualquer linha possua quantidade incorreta de colunas ou estrutura inconsistente, o arquivo inteiro será considerado inválido.

---

## 4. Tratamento dos Arquivos

Após a validação, os arquivos CSV serão movidos automaticamente para os seguintes diretórios:

* **/VALIDADO**
  Arquivos que atendem a todos os critérios de validação.

* **/INVALIDADO**
  Arquivos que não atendem a um ou mais critérios de validação.

Essa abordagem garante melhor organização, rastreabilidade e controle do processamento dos arquivos.

---

## 5. Funcionalidades Implementadas

* Leitura automática de arquivos CSV a partir de um diretório específico
* Validação de conteúdo e estrutura dos arquivos
* Movimentação de arquivos entre diretórios conforme o resultado da validação
* Geração de um arquivo JAR executável
* Código estruturado visando legibilidade e manutenção

---

## 7. Execução da Aplicação

Para executar o projeto, siga os passos abaixo:

1. Compile o projeto e gere o arquivo `.jar`
2. Crie os seguintes diretórios no mesmo nível de execução do JAR:

   ```
   /PENDENTES
   /VALIDADO
   /INVALIDADO
   ```
3. Insira os arquivos `.csv` a serem processados no diretório `/PENDENTES`
4. Execute o arquivo JAR
5. Os arquivos serão processados automaticamente e movidos para o diretório correspondente ao resultado da validação

---

## 8. Considerações Finais
> Este projeto foi pego como **desafio final do processo seletivo para a vaga de estágio** na empresa **Efretive Sistemas**.
---

