package utils;

import entities.Consulta;
import entities.Coordenacao;
import entities.Medico;
import writers.ConsultaCSVWriter;
import writers.CoordenacaoCSVWriter;
import writers.MedicoCSVWriter;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Seed {


    public static void seeding() {
        for (int i = 0; i < 10000; i++) {

//            ConsultaCSVWriter.writeConsultaToCSV(consulta);

//            Medico medico = new Medico(
//                    "Nome" + i,
//                    LocalDate.now().minusYears(i % 30),
//                    "CRM" + i,
//                    "Usuario" + i,
//                    "Senha" + i
//            );
//            MedicoCSVWriter.writeMedicoToCSV(medico);

            Coordenacao coordenacao = new Coordenacao(
                    "Nome" + i,
                    LocalDate.now().minusYears(i % 30),
                    "CPF" + i,
                    "Usuario" + i,
                    "Senha" + i
            );
            CoordenacaoCSVWriter.writeCoordenacaoToCSV(coordenacao);
        }
        }
        public static void seedingMedico() {

        }
    }


