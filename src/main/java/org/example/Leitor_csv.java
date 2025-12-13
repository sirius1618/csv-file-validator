package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Leitor_csv {
    public static final List<String> colunas = Arrays.asList(
            "NUMERO_DA_VENDA",
            "NOME_DO_CLIENTE",
            "DATA_DA_VENDA",
            "VALOR_DA_VENDA"
    );

    public BufferedReader getBufferedReader(String caminhoArquivo) throws  IOException{
        return new BufferedReader(new FileReader(caminhoArquivo));
    }

    public boolean validadorArquivoVazio (String caminhoArquivo) {
        try{
            List<String> linhasArquivo = Files.readAllLines(Paths.get(caminhoArquivo));
            boolean vazio = linhasArquivo.stream().allMatch(l -> l.trim().isEmpty());
            if (vazio) {
                System.out.println("Arquivo " + caminhoArquivo + " vazio");
                return false;
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + caminhoArquivo);
            e.printStackTrace();
        }
        return true;
    }

    public boolean validadorColunas (String caminhoArquivo) {
        try (BufferedReader reader = getBufferedReader(caminhoArquivo)) {
            String linha = reader.readLine();
            String[] cabecalhoCsv = linha.split(",");
            for (int i = 0; i < colunas.size(); i++) {
                if ((cabecalhoCsv[i].trim().equals(colunas.get(i)))) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao ler arquivo:" + caminhoArquivo);
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

                int cont = linha.length() - linha.replace(",","").length();
                if (cont != 3) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao ler arquivo:" + caminhoArquivo);
        }
        return true;
    }
}