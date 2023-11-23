import entities.Medico;
import readers.MedicoCSVReader;
import utils.OrdenacaoMedico;
import utils.Seed;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import static utils.OrdenacaoMedico.buscaBinariaMedico;
import static writers.MedicoCSVWriter.CSV_FILE_PATH;

public class Testes {
    public static void main(String[] args) {


//        Seed.seedConsultas();
//        Seed.seedMedicos();
//        Seed.seedCoordenacao();

        List<Medico> medicos = MedicoCSVReader.readMedicosFromCSV();

        medicos.sort(Comparator.comparing(m -> m.getId()));

        UUID idParaBuscar = UUID.fromString("193f7b4c-e9e7-42e6-8538-79d67e8335cb");
        Medico medicoEncontrado = OrdenacaoMedico.buscaBinariaMedico(medicos, idParaBuscar);

        if (medicoEncontrado != null) {
            System.out.println("Médico encontrado: " + medicoEncontrado.getNome());
        } else {
            System.out.println("Médico não encontrado.");
        }


    }
}
