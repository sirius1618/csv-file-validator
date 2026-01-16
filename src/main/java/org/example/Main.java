package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {


        Path dirPendentes = Paths.get("").toAbsolutePath()
                .resolve("PENDENTES");

        Util.validarExistenciaDiretorio(dirPendentes);

        try  (var arquivos = Files.list(dirPendentes)) {
            arquivos.filter(Files::isRegularFile)
                    .forEach(arquivo -> {
                        try {
                            ValidadorCsv validadorCsv =  new ValidadorCsv(arquivo.toString());
                            validadorCsv.validar();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}