import entities.Consulta;
import entities.Coordenacao;
import entities.Medico;
import readers.ConsultaCSVReader;
import readers.CoordenacaoCSVReader;
import readers.MedicoCSVReader;
import utils.BuscaBinariaConsulta;
import utils.BuscaBinariaCoordenacao;
import utils.BuscaBinariaMedico;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class Testes {
    public static void main(String[] args) {

        //TESTE DE SEEDS
//        Seed.seedConsultas();
//        Seed.seedMedicos();
//        Seed.seedCoordenacao();

        //TESTE BUSCA BINARIA PRA MEDICO
        List<Medico> medicos = MedicoCSVReader.readMedicosFromCSV();

        medicos.sort(Comparator.comparing(m -> m.getId()));

        UUID idDoMedicoParaBuscar = UUID.fromString("321cab38-ff1e-4c2c-bd60-f1043ccfc50e");
        Medico medicoEncontrado = BuscaBinariaMedico.buscaBinariaMedico(medicos, idDoMedicoParaBuscar);

        if (medicoEncontrado != null) {
            System.out.println("Médico encontrado: " + medicoEncontrado.getNome());
        } else {
            System.out.println("Médico não encontrado.");
        }

        //TESTE BUSCA BINARIA PRA CONSULTA
        List<Consulta> consultas = ConsultaCSVReader.readConsultasFromCSV();

        consultas.sort(Comparator.comparing(c -> c.getId()));

        int idDaConsultaParaBuscar = Integer.parseInt("6825");
        Consulta consultaEncontrada = BuscaBinariaConsulta.buscaBinariaConsulta(consultas, idDaConsultaParaBuscar);

        if (medicoEncontrado != null) {
            System.out.println("Consulta encontrada: " + consultaEncontrada.getNomePaciente());
        } else {
            System.out.println("Consulta não encontrada.");
        }

        //TESTE BUSCA BINARIA PRA COORDERNACAO

        List<Coordenacao> coordenacaos = CoordenacaoCSVReader.readCoordenacoesFromCSV();

        coordenacaos.sort(Comparator.comparing(c -> c.getId()));

        UUID idDaCoordenacaoParaBuscar = UUID.fromString("d9498f71-dad9-44e2-9bae-943d0486342a");
        Coordenacao coordernacaoEncontrada = BuscaBinariaCoordenacao.buscaBinariaCoordenacao(coordenacaos, idDaCoordenacaoParaBuscar);

        if (coordernacaoEncontrada != null) {
            System.out.println("Coordernacao encontrada: " + coordernacaoEncontrada.getNome());
        } else {
            System.out.println("Coordenacao não encontrada.");
        }


    }
}
