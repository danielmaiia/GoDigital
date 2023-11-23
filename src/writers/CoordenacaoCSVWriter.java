package writers;

import entities.Coordenacao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CoordenacaoCSVWriter {
    public static final String COORDENACOES_CSV_PATH = "coordenacoes.csv";

    public static void writeCoordenacaoToCSV(Coordenacao coordenacao) {
        try (FileWriter csvWriter = new FileWriter(COORDENACOES_CSV_PATH, true)) {
            File file = new File(COORDENACOES_CSV_PATH);
            if (file.length() == 0) {
                csvWriter.append("ID;Nome;DataNascimento;CPF;Usuario;Senha;CreatedAt;UpdatedAt\n");
            }

            csvWriter.append(convertCoordenacaoToCSVLine(coordenacao));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCoordenacaoFromCSV(UUID coordenacaoId) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(COORDENACOES_CSV_PATH));

            try (PrintWriter writer = new PrintWriter(new FileWriter(COORDENACOES_CSV_PATH))) {
                if (!lines.isEmpty()) {
                    writer.println(lines.get(0));
                }

                for (int i = 1; i < lines.size(); i++) {
                    String line = lines.get(i);
                    String[] columns = line.split(";");
                    UUID currentCoordenacaoId = UUID.fromString(columns[0]);

                    if (!currentCoordenacaoId.equals(coordenacaoId)) {
                        writer.println(line);
                    }
                }

                System.out.println("Coordenacao excluída do arquivo CSV com sucesso!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editCoordenacaoInCSV(UUID coordenacaoId, Coordenacao novosDados) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(COORDENACOES_CSV_PATH));

            try (PrintWriter writer = new PrintWriter(new FileWriter(COORDENACOES_CSV_PATH))) {
                if (!lines.isEmpty()) {
                    writer.println(lines.get(0));
                }

                for (int i = 1; i < lines.size(); i++) {
                    String line = lines.get(i);
                    String[] columns = line.split(";");
                    UUID currentCoordenacaoId = UUID.fromString(columns[0]);

                    if (currentCoordenacaoId.equals(coordenacaoId)) {
                        writer.println(convertCoordenacaoToCSVLine(novosDados));
                    } else {
                        writer.println(line);
                    }
                }

                System.out.println("Coordenacao editada no arquivo CSV com sucesso!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String convertCoordenacaoToCSVLine(Coordenacao coordenacao) {
        return coordenacao.getId() + ";" +
                coordenacao.getNome() + ";" +
                coordenacao.getDataNascimento() + ";" +
                coordenacao.getCpf() + ";" +
                coordenacao.getUsuario() + ";" +
                coordenacao.getSenha() + ";" +
                coordenacao.getCreatedAt() + ";" +
                LocalDateTime.now() +"\n";
    }

}

