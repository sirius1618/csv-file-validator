package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Locale;
import java.util.Scanner;


public class MovedorDeArquivos {
    static final String caminhoDiretorioValido = "/VALIDO";
    static final String caminhoDiretorioInvalido = "/INVALIDO";

    Scanner scanner = new Scanner(System.in);


    public void moverArquivoValido (String arquivo) throws IOException {

        if (!isSobreescreverArquivo(arquivo)) {
            return;
        }

        Path origemArquivo = Paths.get(arquivo);
        Path destinoArquivo = Paths.get(caminhoDiretorioValido);
        Files.move(origemArquivo, destinoArquivo, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Arquivo movido " + arquivo + " Para diretorio: " + caminhoDiretorioValido);
    }

    public void moverArquivoInvalido (String arquivo) throws IOException {

        if (!isSobreescreverArquivo(arquivo)) {
            return;
        }

        // TODO: passar de forma correta o arquivo par ao diretorio.
        Path origemArquivo = Paths.get(arquivo);
        Path destinoArquivo = Paths.get(caminhoDiretorioInvalido);
        Files.move(origemArquivo, destinoArquivo, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Arquivo movido " + arquivo + " Para diretorio: " + caminhoDiretorioInvalido);
    }

    public boolean isVerificarExistenciaArquivo(String arquivoValidarExistencia) {
        Path validar = Paths.get(arquivoValidarExistencia);

        if (Files.exists(validar)) {
                return true;
            }
        return false;
    }

    public boolean isSobreescreverArquivo (String arquivoValidar) {
        if (!isVerificarExistenciaArquivo(arquivoValidar)) {
            return true;
        }


        while (true) {
            String resposta = scanner.nextLine().trim().toLowerCase();
            switch (resposta) {
                case "n": return false;
                case "s": return true;
                default:
                    System.out.println("Resposta invalido, só é aceito (n/s)");

            }
        }
    }
}
