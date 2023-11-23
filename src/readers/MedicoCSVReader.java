package readers;

import entities.Medico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MedicoCSVReader {
    private static final String CAMINHO_ARQUIVO_CSV = "medicos.csv";

    public static List<Medico> readMedicosFromCSV() {
        List<Medico> medicos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO_CSV))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");

                try {
                    Medico medico = criarMedicoFromCSV(partes);

                    if (medico != null) {
                        medicos.add(medico);
                    }
                } catch (DateTimeParseException | IllegalArgumentException e) {
                    System.err.println("Erro ao criar médico a partir da linha do CSV: " + linha);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return medicos;
    }

    private static Medico criarMedicoFromCSV(String[] partes) {
        if (partes.length < 6) {
            System.out.println("Dados insuficientes para criar um médico a partir da linha do CSV.");
            return null;
        }

        UUID id = UUID.fromString(partes[0]);;
        String nome = partes[1];
        String senha = partes[2];
        String crm = partes[3];
        String usuario = partes[4];
        LocalDate dataNascimento = LocalDate.parse(partes[5]);



        return new Medico(id, nome, dataNascimento, crm, usuario, senha);
    }
}
