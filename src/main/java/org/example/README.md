Este projeto é resultado de um desafio final para o cargo de estágiario na empresa Efretive Sistemas. O objetivo do desafio é criar um leitor de arquivo .csv em JAVA que atenda as seguintes tarefas:

Criar um JAR que leia todos os CSV dentro de um diretório "/PENDENTES";

O JAR deve validar se os CSV possuem no mínimo as seguintes características:

    a) Não esteja vazio;

    b) Cada linha do arquivo tenha a quantidade exata de colunas esperadas a serem importadas, sendo essas:

        NUMERO_DA_VENDA

        NOME_DO_CLIENTE

        DATA_DA_VENDA

        VALOR_DA_VENDA

Caso o arquivo lido atenda às condições do item 2, ele deverá ser movido para o diretório "/VALIDADO";

Caso o arquivo lido não atenda às condições do item 2, ele deverá ser movido para o diretório "/INVALIDADO";