package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Locale;
import java.util.Scanner;


public class MovedorDeArquivos {
    static final String caminhoDiretorioValido = "/VALIDADO";
    static final String caminhoDiretorioInvalido = "/INVALIDADO";

    Scanner scanner = new Scanner(System.in);


    public void moverArquivoValido (String arquivo) throws IOException {

        if (!sobreescreverArquivo(arquivo)) {
            return;
        }

        Path origemArquivo = Paths.get(arquivo);
        Path destinoArquivo = Paths.get(caminhoDiretorioValido, origemArquivo.getFileName().toString());
        Files.move(origemArquivo, destinoArquivo, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Arquivo movido " + arquivo + " Para diretorio: " + caminhoDiretorioValido);
    }

    public void moverArquivoInvalido (String arquivo) throws IOException {

        if (!sobreescreverArquivo(arquivo)) {
            return;
        }

        // TODO: passar de forma correta o arquivo par ao diretorio.
        Path origemArquivo = Paths.get(arquivo);
        Path destinoArquivo = Paths.get(caminhoDiretorioInvalido, origemArquivo.getFileName().toString());
        Files.move(origemArquivo, destinoArquivo, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Arquivo movido " + arquivo + " Para diretorio: " + caminhoDiretorioInvalido);
    }

    public boolean isVerificarExistenciaArquivo(String arquivoValidarExistencia) {
        Path validar = Paths.get(arquivoValidarExistencia);
        return Files.exists(validar);
    }

    public boolean sobreescreverArquivo (String arquivoValidar) {
        if (!isVerificarExistenciaArquivo(arquivoValidar)) {
            return true;
        }

        while (true) {
            System.out.println("Arquivo já existe. Deseja sobrescrever? (s/n)");
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
