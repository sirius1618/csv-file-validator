package org.example;

import java.nio.file.Files;
import java.nio.file.Path;

public class Util{
    public static void validarExistenciaDiretorio(Path diretorioValidar) {
        if (!Files.exists(diretorioValidar) || !Files.isDirectory(diretorioValidar)) {
            System.out.println("Erro: O diretorio não existe ou o caminho é invalido: " + diretorioValidar);
            return;
        }
    }
}
