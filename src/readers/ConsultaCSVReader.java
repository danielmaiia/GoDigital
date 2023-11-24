package readers;

import entities.Consulta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static writers.ConsultaCSVWriter.CONSULTAS_CSV_PATH;

public class ConsultaCSVReader {
    public static void readConsultasFromCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(CONSULTAS_CSV_PATH))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");

                if (!partes[0].equals("CartaoSus")) {

                    try {
                        Consulta consulta = criarConsultaFromCSV(partes);

                        if (consulta != null) {
                            Consulta.inserirNaArvore(consulta);
                        }
                    } catch (DateTimeParseException | IllegalArgumentException e) {
                        System.err.println("Erro ao criar consulta a partir da linha do CSV: " + linha);
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Consulta criarConsultaFromCSV(String[] partes) {
        if (partes.length < 16) {
            System.out.println("Dados insuficientes para criar uma consulta a partir da linha do CSV.");
            return null;
        }

        int id = Integer.parseInt(partes[0]);
        String nomePaciente = partes[1];
        UUID medicoId = UUID.fromString(partes[2]);
        int cartaoSus = Integer.parseInt(partes[3]);
        String cpfPaciente = partes[4];
        LocalDate dataNascimento = LocalDate.parse(partes[5]);
        String escolaridade = partes[6];
        String telefone = partes[7];
        String email = partes[8];
        LocalDate dataRequisicao = LocalDate.parse(partes[9]);
        String especialidade = partes[10];
        String senha = partes[11];
        int gravidade = Integer.parseInt(partes[12]);
        int idade = Integer.parseInt(partes[13]);
        int tempoEsperaSemanas = Integer.parseInt(partes[14]);
        int score = Integer.parseInt(partes[15]);
        LocalDateTime createdAt = LocalDateTime.parse(partes[16]);
        LocalDateTime updatedAt = LocalDateTime.parse(partes[17]);
        int prioridade = Integer.parseInt(partes[18]);

        return new Consulta(id, nomePaciente, medicoId, cartaoSus, cpfPaciente, dataNascimento,
                escolaridade, telefone, email, dataRequisicao, especialidade, senha, gravidade,
                idade, tempoEsperaSemanas, score, createdAt, updatedAt, prioridade);
    }
}

