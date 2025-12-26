package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;


public class MovedorDeArquivos {

    private Path caminhoDiretorioValido;
    private Path caminhoDiretorioInvalido;

    Scanner scanner = new Scanner(System.in);

    public void moverArquivoValido (String arquivo) throws IOException {
        if (!sobreescreverArquivo(arquivo)) {
            return;
        }

        Path origemArquivo = Paths.get(arquivo);
        Path dirMover = Paths.get("")
                .toAbsolutePath()
                .resolve("diretorios-csv")
                .resolve("INVALIDADO")
                .resolve("teste_validado.csv");
        setCaminhoDiretorioValido(dirMover);

        Files.move(origemArquivo, getCaminhoDiretorioValido(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Arquivo movido " + arquivo + " Para diretorio: " + caminhoDiretorioValido);
    }

    public void moverArquivoInvalido (String arquivo) throws IOException {

        if (!sobreescreverArquivo(arquivo)) {
            return;
        }

        Path origemArquivo = Paths.get(arquivo);
        Path dirMover = Paths.get("").toAbsolutePath()
                        .resolve("diretorios-csv")
                        .resolve("VALIDADO")
                        .resolve("teste_invalidado");
        setCaminhoDiretorioInvalido(dirMover);

        Files.move(origemArquivo, getCaminhoDiretorioInvalido(), StandardCopyOption.REPLACE_EXISTING);
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

    public void setCaminhoDiretorioValido(Path caminhoDiretorioValido) {
        this.caminhoDiretorioValido = caminhoDiretorioValido;
    }

    public void setCaminhoDiretorioInvalido(Path caminhoDiretorioInvalido) {
        this.caminhoDiretorioInvalido = caminhoDiretorioInvalido;
    }

    public Path getCaminhoDiretorioValido() {
        return caminhoDiretorioValido;
    }

    public Path getCaminhoDiretorioInvalido() {
        return caminhoDiretorioInvalido;
    }
}
