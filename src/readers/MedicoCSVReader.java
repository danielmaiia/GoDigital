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

import static writers.MedicoCSVWriter.MEDICOS_CSV_PATH;

public class MedicoCSVReader {


    public static List<Medico> readMedicosFromCSV() {
        List<Medico> medicos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(MEDICOS_CSV_PATH))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");

                if (!partes[0].equals("ID")) {

                    try {
                        Medico medico = criarMedicoFromCSV(partes);

                        if (medico != null) {
                            medicos.add(medico);
                            Medico.inserirNaArvore(medico);
                        }
                    } catch (DateTimeParseException | IllegalArgumentException e) {
                        System.err.println("Erro ao criar médico a partir da linha do CSV: " + linha);
                        e.printStackTrace();
                    }
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
        String senha = partes[5];
        String crm = partes[3];
        String usuario = partes[4];
        LocalDate dataNascimento = LocalDate.parse(partes[2]);



        return new Medico(id, nome, dataNascimento, crm, usuario, senha);
    }
}
