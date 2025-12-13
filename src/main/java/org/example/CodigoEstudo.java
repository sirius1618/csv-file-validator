package org.example;

public class CodigoEstudo {
    import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

    public class ValidadorCSV {

        public static final List<String> colunasEsperadas = Arrays.asList(
                "NUMERO_DA_VENDA",
                "NOME_DO_CLIENTE",
                "DATA_DA_VENDA",
                "VALOR_DA_VENDA"
        );

        public static boolean validarCSV(String caminhoArquivo) {
            try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
                String linha = reader.readLine(); // lê o cabeçalho

                // Verificar se o arquivo está vazio
                if (linha == null || linha.trim().isEmpty()) {
                    System.out.println("Arquivo vazio!");
                    return false;
                }

                // Separar colunas do cabeçalho
                String[] cabecalho = linha.split(",");
                if (cabecalho.length != colunasEsperadas.size()) {
                    System.out.println("Quantidade de colunas do cabeçalho incorreta!");
                    return false;
                }

                // Verificar nomes e ordem das colunas
                for (int i = 0; i < colunasEsperadas.size(); i++) {
                    if (!cabecalho[i].trim().equalsIgnoreCase(colunasEsperadas.get(i))) {
                        System.out.println("Coluna inválida no cabeçalho: " + cabecalho[i]);
                        return false;
                    }
                }

                // Verificar linhas de dados
                int linhaNumero = 2; // começa depois do cabeçalho
                while ((linha = reader.readLine()) != null) {
                    if (linha.trim().isEmpty()) {
                        linhaNumero++;
                        continue; // pular linhas vazias
                    }

                    String[] dados = linha.split(",");
                    if (dados.length != colunasEsperadas.size()) {
                        System.out.println("Linha " + linhaNumero + " com quantidade de colunas incorreta!");
                        return false;
                    }

                    linhaNumero++;
                }

            } catch (IOException e) {
                System.err.println("Erro ao ler o arquivo: " + caminhoArquivo);
                e.printStackTrace();
                return false;
            }

            System.out.println("CSV válido!");
            return true;
        }

        public static void main(String[] args) {
            String caminho = "caminho/do/arquivo.csv";
            validarCSV(caminho);
        }
    }

}
