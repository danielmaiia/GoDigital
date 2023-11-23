package writers;
import entities.Consulta;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

public class ConsultaCSVWriter {
    public static final String CONSULTAS_CSV_PATH = "consultas.csv";

    public static void deleteConsultaFromCSV(int consultaId) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(CONSULTAS_CSV_PATH));

            try (PrintWriter writer = new PrintWriter(new FileWriter(CONSULTAS_CSV_PATH))) {
                if (!lines.isEmpty()) {
                    writer.println(lines.get(0));
                }

                for (int i = 1; i < lines.size(); i++) {
                    String line = lines.get(i);
                    String[] columns = line.split(";");
                    int currentConsultaId = Integer.parseInt(columns[0]);

                    if (currentConsultaId != consultaId) {
                        writer.println(line);
                    }
                }

                System.out.println("Consulta excluída do arquivo CSV com sucesso!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static void writeConsultaToCSV (Consulta consulta){
            try (FileWriter csvWriter = new FileWriter(CONSULTAS_CSV_PATH, true)) {
                File file = new File(CONSULTAS_CSV_PATH);
                if (file.length() == 0) {
                    csvWriter.append("ID;NomePaciente;MedicoId;CartaoSus;CPF;dataNascimento;Escolaridade;Telefone;Email;" +
                            "DataRequisicao;Especialidade;Senha;Gravidade;Idade;TempoEsperaSemanas;Score;CreatedAt;UpdatedAt\n");
                }

                csvWriter.append(consulta.getId() + ";");
                csvWriter.append(consulta.getNomePaciente() + ";");
                csvWriter.append(consulta.getMedicoId() + ";");
                csvWriter.append(consulta.getCartaoSus() + ";");
                csvWriter.append(consulta.getCpfPaciente() + ";");
                csvWriter.append(consulta.getDataNascimento() + ";");
                csvWriter.append(consulta.getEscolaridade() + ";");
                csvWriter.append(consulta.getTelefone() + ";");
                csvWriter.append(consulta.getEmail() + ";");
                csvWriter.append(consulta.getDataRequisicao() + ";");
                csvWriter.append(consulta.getEspecialidade() + ";");
                csvWriter.append(consulta.getSenha() + ";");
                csvWriter.append(consulta.getGravidade() + ";");
                csvWriter.append(consulta.getIdade() + ";");
                csvWriter.append(consulta.getTempoEsperaSemanas() + ";");
                csvWriter.append(consulta.getScore() + ";");
                csvWriter.append(consulta.getCreatedAt() + ";");
                csvWriter.append(consulta.getUpdatedAt() + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    public static void editConsultaInCSV(int consultaId, Consulta novosDados) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(CONSULTAS_CSV_PATH));

            try (PrintWriter writer = new PrintWriter(new FileWriter(CONSULTAS_CSV_PATH))) {
                if (!lines.isEmpty()) {
                    writer.println(lines.get(0));
                }

                for (int i = 1; i < lines.size(); i++) {
                    String line = lines.get(i);
                    String[] columns = line.split(";");
                    int currentConsultaId = Integer.parseInt(columns[0]);

                    if (currentConsultaId == consultaId) {
                        writer.println(convertConsultaToCSVLine(novosDados));
                    } else {

                        writer.println(line);
                    }
                }

                System.out.println("Consulta editada no arquivo CSV com sucesso!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String convertConsultaToCSVLine(Consulta consulta) {
        return consulta.getId() + ";" +
                consulta.getNomePaciente() + ";" +
                consulta.getMedicoId() + ";" +
                consulta.getCartaoSus() + ";" +
                consulta.getCpfPaciente() + ";" +
                consulta.getDataNascimento() + ";" +
                consulta.getEscolaridade() + ";" +
                consulta.getTelefone() + ";" +
                consulta.getEmail() + ";" +
                consulta.getDataRequisicao() + ";" +
                consulta.getEspecialidade() + ";" +
                consulta.getSenha() + ";" +
                consulta.getGravidade() + ";" +
                consulta.getIdade() + ";" +
                consulta.getTempoEsperaSemanas() + ";" +
                consulta.getScore() + ";" +
                consulta.getCreatedAt() + ";" +
                LocalDateTime.now() + "\n";
    }

    }


