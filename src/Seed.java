import entities.Consulta;
import entities.Coordenacao;
import entities.Medico;
import utils.ConsultaCSVWriter;
import utils.CoordenacaoCSVWriter;
import utils.MedicoCSVWriter;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Seed {
    public static void main (String[]args){

        for (int i = 0; i < 10000; i++) {
            Medico medico = new Medico(
                    "Nome" + i,
                    LocalDate.now().minusYears(i % 30),
                    "CRM" + i,
                    "Usuario" + i,
                    "Senha" + i
            );
            MedicoCSVWriter.writeMedicoToCSV(medico);
        }


        for (int i = 0; i < 10000; i++) {
            Consulta consulta = new Consulta(
                    "Paciente" + i,
                    UUID.randomUUID(), // Você pode substituir isso pelo ID real de um médico
                    "CartaoSus" + i,
                    "CPFPaciente" + i,
                    LocalDate.now().minusYears(i % 30), // Varia a data de nascimento
                    "Escolaridade" + i,
                    "Telefone" + i,
                    "Email" + i + "@example.com",
                    LocalDate.now().minusDays(i),
                    "Especialidade" + i,
                    "Senha" + i,
                    ThreadLocalRandom.current().nextInt(1, 4), // Gravidade entre 1 e 3
                    ThreadLocalRandom.current().nextInt(1, 100),
                    ThreadLocalRandom.current().nextInt(1, 10),
                    ThreadLocalRandom.current().nextInt(1, 100)
            );
            ConsultaCSVWriter.writeConsultaToCSV(consulta);
        }

        for (int i = 0; i < 10000; i++) {
                    Coordenacao coordenacao = new Coordenacao(
                    "Nome" + i,
                    LocalDate.now().minusYears(i % 30), // Varia a data de nascimento
                    "CPF" + i,
                    "Usuario" + i,
                    "Senha" + i
            );
            CoordenacaoCSVWriter.writeCoordenacaoToCSV(coordenacao);
        }


    }
}
