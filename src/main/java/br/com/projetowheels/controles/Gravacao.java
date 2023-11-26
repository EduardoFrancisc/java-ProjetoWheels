package br.com.projetowheels.controles;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Gravacao {
    public static void SalvarEmArquivo(String nome, List<String> dados) {
        try {
            String diretorio = "arquivos";
            Path dir = Paths.get(diretorio);

            String filename = "arquivos/" + nome + ".csv";
            Path path = Paths.get(filename);

            if (!Files.exists(dir)) {
                Files.createDirectory(dir);
            }
            if (!Files.exists(path)) {
                Files.createFile(path);
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {

                StringBuilder resultado = new StringBuilder();
                for (String item : dados) {
                    resultado.append(item).append(";");
                }

                // Remove o último ponto e vírgula, se houver
                if (resultado.length() > 0) {
                    resultado.setLength(resultado.length() - 1);
                }

                writer.println(resultado.toString());
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }
    }
}
