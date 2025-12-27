package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Path dirPendentes = Paths.get("").toAbsolutePath()
                .resolve("diretorios-csv")
                .resolve("PENDENTES");

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