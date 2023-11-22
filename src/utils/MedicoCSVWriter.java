package utils;

import entities.Medico;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class MedicoCSVWriter {
    private static final String CSV_FILE_PATH = "medicos.csv";

    public static void writeMedicoToCSV(Medico medico) {
        try (FileWriter csvWriter = new FileWriter(CSV_FILE_PATH, true)) {
            File file = new File(CSV_FILE_PATH);
            if (file.length() == 0) {
                csvWriter.append("ID,Nome,DataNascimento,CRM,Usuario,Senha,CreatedAt,UpdatedAt\n");
            }

            csvWriter.append(convertMedicoToCSVLine(medico));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMedicoFromCSV(UUID medicoId) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(CSV_FILE_PATH));

            try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH))) {
                if (!lines.isEmpty()) {
                    writer.println(lines.get(0));
                }

                for (int i = 1; i < lines.size(); i++) {
                    String line = lines.get(i);
                    String[] columns = line.split(",");
                    UUID currentMedicoId = UUID.fromString(columns[0]);

                    if (!currentMedicoId.equals(medicoId)) {
                        writer.println(line);
                    }
                }

                System.out.println("Médico excluído do arquivo CSV com sucesso!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editMedicoInCSV(UUID medicoId, Medico novosDados) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(CSV_FILE_PATH));

            try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH))) {
                if (!lines.isEmpty()) {
                    writer.println(lines.get(0));
                }

                for (int i = 1; i < lines.size(); i++) {
                    String line = lines.get(i);
                    String[] columns = line.split(",");
                    UUID currentMedicoId = UUID.fromString(columns[0]);

                    if (currentMedicoId.equals(medicoId)) {
                        writer.println(convertMedicoToCSVLine(novosDados));
                    } else {
                        writer.println(line);
                    }
                }

                System.out.println("Médico editado no arquivo CSV com sucesso!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String convertMedicoToCSVLine(Medico medico) {
        return medico.getId() + "," +
                medico.getNome() + "," +
                medico.getDataNascimento() + "," +
                medico.getCrm() + "," +
                medico.getUsuario() + "," +
                medico.getSenha() + "," +
                medico.getCreatedAt() + "," +
                LocalDateTime.now();
    }


}
