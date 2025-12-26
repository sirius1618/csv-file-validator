package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ValidadorCsv{

    public ValidadorCsv(String caminhoArquivo) throws IOException {
        this.caminhoArquivo = caminhoArquivo;

        boolean colunasValidas = validarColunas(caminhoArquivo);
        boolean linhasValidadas = validarLinhas(caminhoArquivo);

        if (!colunasValidas || !linhasValidadas) {
            moverArquivo.moverArquivoInvalido(caminhoArquivo);
        } else {
            moverArquivo.moverArquivoValido(caminhoArquivo);
        }
    }

    public static final List<String> colunas = Arrays.asList(
            "NUMERO_DA_VENDA",
            "NOME_DO_CLIENTE",
            "DATA_DA_VENDA",
            "VALOR_DA_VENDA"
    );

    public String caminhoArquivo;

    public MovedorDeArquivos moverArquivo = new MovedorDeArquivos();

    public BufferedReader getBufferedReader(String caminhoArquivo) throws  IOException{
        return new BufferedReader(new FileReader(caminhoArquivo));
    }

    public boolean validarColunas (String caminhoArquivo) {
        try (BufferedReader reader = getBufferedReader(caminhoArquivo)) {


            String linha = reader.readLine();

            if (linha == null || linha.trim().isEmpty()) {
                System.out.println("Arquivo vazio");
                return false;
            }

            String[] cabecalhoCsv = linha.split(";");

            if (cabecalhoCsv.length != colunas.size()) {
                System.out.println("Quantidade de colunas menor do que o esperado");
                return false;
            }

            for (int i = 0; i < colunas.size(); i++) {
                if (!(cabecalhoCsv[i].trim().equals(colunas.get(i)))) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao ler arquivo:" + caminhoArquivo);
            return false;
        }

        return true;
    }

    public boolean validarLinhas (String caminhoArquivo) {
        try (BufferedReader reader = getBufferedReader(caminhoArquivo)) {
            String linha = reader.readLine(); // pula a primeira linha pois já foi validada no metodo `validadorColunas`
            while((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    return false;
                }

                String[] campos = linha.split(";");
                if (campos.length != colunas.size()) return false;

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao ler arquivo:" + caminhoArquivo);
            return false;
        }
        return true;
    }
}