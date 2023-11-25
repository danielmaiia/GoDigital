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

    public static void deleteConsultaFromCSV(int consultaSus) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(CONSULTAS_CSV_PATH));

            try (PrintWriter writer = new PrintWriter(new FileWriter(CONSULTAS_CSV_PATH))) {
                if (!lines.isEmpty()) {
                    writer.println(lines.get(0));
                }

                for (int i = 1; i < lines.size(); i++) {
                    String line = lines.get(i);
                    String[] columns = line.split(";");
                    int currenteCartaoSus = Integer.parseInt(columns[3]);

                    if (currenteCartaoSus == consultaSus) {
                        writer.println(line);
                        System.out.println("Consulta excluida do arquivo CSV com sucesso!");
                        break;
                    }
                    else if (i == lines.size() - 1){
                        System.out.println("Consulta não encontrada no arquivo CSV, verifique se o cartao sus está correto.");
                    }
                }

            }
        } catch (IOException e) {
            System.out.println("Erro ao excluir consulta do arquivo CSV. Verifique se existe algum registro com esse cartao sus está correto.");
            e.printStackTrace();
        }
    }

        public static void writeConsultaToCSV (Consulta consulta){
            try (FileWriter csvWriter = new FileWriter(CONSULTAS_CSV_PATH, true)) {
                File file = new File(CONSULTAS_CSV_PATH);
                if (file.length() == 0) {
                    csvWriter.append("ID;NomePaciente;MedicoId;CartaoSus;CPF;dataNascimento;Escolaridade;Telefone;Email;" +
                            "DataRequisicao;Especialidade;Senha;Gravidade;Idade;TempoEsperaSemanas;Score;CreatedAt;UpdatedAt;Prioridade\n");
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
                csvWriter.append(consulta.getUpdatedAt() + ";");
                csvWriter.append(consulta.getPrioridade() + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    public static void editConsultaInCSV(int consultaSus, Consulta novosDados) {
        novosDados.setCartaoSus(consultaSus);

        try {
            List<String> lines = Files.readAllLines(Paths.get(CONSULTAS_CSV_PATH));

            try (PrintWriter writer = new PrintWriter(new FileWriter(CONSULTAS_CSV_PATH))) {
                if (!lines.isEmpty()) {
                    writer.println(lines.get(0));
                }

                boolean consultaEncontrada = false;

                for (int i = 1; i < lines.size(); i++) {
                    String line = lines.get(i);
                    String[] columns = line.split(";");
                    int currentConsultaCartaoSus = Integer.parseInt(columns[3]);

                    if (currentConsultaCartaoSus == consultaSus) {
                        writer.println(convertConsultaToCSVLine(novosDados));
                        consultaEncontrada = true;
                        System.out.println("Consulta editada no arquivo CSV com sucesso!");
                    } else {
                        writer.println(line);
                    }
                }

                if (!consultaEncontrada) {
                    System.out.println("Consulta não encontrada no arquivo CSV, verifique se o cartão SUS está correto.");
                }
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
                LocalDateTime.now() + ";" +
                consulta.getPrioridade() + "\n";
    }

    }


