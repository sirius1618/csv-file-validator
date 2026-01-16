package org.example;

import java.io.File;
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
        Path origemArquivo = Paths.get(arquivo);
        String nomeArquivo = origemArquivo.getFileName().toString();

        Path dirMover = Paths.get("")
                .toAbsolutePath()
                .resolve("VALIDADO")
                .resolve(nomeArquivo);
        setCaminhoDiretorioValido(dirMover);

        if (!Files.isDirectory(dirMover)) {
            dirMover = Files.createDirectories(dirMover);
        }

        if (!sobreescreverArquivo(getCaminhoDiretorioValido().toString())) {
            return;
        }

        Files.move(origemArquivo, getCaminhoDiretorioValido(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Arquivo movido " + arquivo + " Para diretorio: " + caminhoDiretorioValido);
    }

    public void moverArquivoInvalido (String arquivo) throws IOException {

        Path origemArquivo = Paths.get(arquivo);
        String nomeArquivo = origemArquivo.getFileName().toString();
        Path dirMover = Paths.get("").toAbsolutePath()
                .resolve("INVALIDADO")
                .resolve(nomeArquivo );
        setCaminhoDiretorioInvalido(dirMover);

        if (!Files.isDirectory(dirMover)) {
            dirMover = Files.createDirectories(dirMover);
        }

        if (!sobreescreverArquivo(getCaminhoDiretorioInvalido().toString())) {
            return;
        }

        Files.move(origemArquivo, getCaminhoDiretorioInvalido(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Arquivo movido " + arquivo + " Para diretorio: " + caminhoDiretorioInvalido);
    }

    public boolean isVerificarExistenciaArquivo(String arquivoValidarExistencia) {
        Path validar = Paths.get(arquivoValidarExistencia);
        return Files.exists(validar);
    }

    public boolean sobreescreverArquivo (String arquivoValidar) {
        if (isVerificarExistenciaArquivo(arquivoValidar)) {
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
        return true;
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
