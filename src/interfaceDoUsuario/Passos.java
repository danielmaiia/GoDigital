package interfaceDoUsuario;

import avl.ArvoreAVLConsulta;
import entities.Consulta;
import writers.ConsultaCSVWriter;

import java.util.List;
import java.util.Scanner;

public class Passos {
    public static void start() {
       Consulta.mockConsultas();
       firstStep();
    }
    public static void firstStep(){
        Scanner sc = new Scanner(System.in);
        ArvoreAVLConsulta arvoreAVLConsulta = new ArvoreAVLConsulta();

        int options;

        System.out.println("Bem vindo ao sistema de consultas!");
        System.out.println("Oque gostaria de fazer?");
        System.out.println("1 - Cadastrar uma nova consulta");
        System.out.println("2 - Editar a prioridade de um paciente");
        System.out.println("3 - Buscar uma consulta");
        System.out.println("4 - Listar as ultimas 10 consultas com maior prioridade?");
        System.out.println("5 - Gerar planilha com todas as consultas ");
        options = sc.nextInt();

        if (options == 1) {
            System.out.println("Cadastrar uma nova consulta");
            arvoreAVLConsulta.inserir(Consulta.cadrastroDeConsulta());
            Passos.firstStep();
        }
        if (options == 2){
            System.out.println(" Editar a prioridade de um paciente");
            System.out.println("Digite o cartao SUS do paciente que voce deseja editar");
            arvoreAVLConsulta.buscar(sc.nextInt()).editarDadosDaConsulta();
            Passos.firstStep();
        }

        if (options == 3){
            System.out.println("Buscar uma consulta");
            System.out.println("Digite o cartao SUS do paciente que voce deseja buscar");
            Consulta consultaEncontrada = arvoreAVLConsulta.buscar(sc.nextInt());
            if (consultaEncontrada != null) {
                System.out.println("Consulta encontrada: " + "Nome: " + consultaEncontrada.getNomePaciente() + "\n" + "Prioridade:" + consultaEncontrada.getPrioridade() + "\n" + "CartaoSUS:" + consultaEncontrada.getCartaoSus());
                System.out.println("Oque gostaria de fazer?");
                System.out.println("1 - Editar a prioridade de um paciente");
                System.out.println("2 - Voltar ao menu principal");
                options = sc.nextInt();
                if (options == 1){
                    consultaEncontrada.editarDadosDaConsulta();
                    firstStep();
                }
                if (options == 2){
                    Passos.firstStep();
                }

            } else {
                System.out.println("Consulta não encontrada.");
                Passos.firstStep();
            }
        }
        if (options == 4){
            System.out.println("Listar as ultimas 10 consultas com maior prioridade?");
            List<Consulta> todasConsultas = Consulta.getConsultasFromArvore();
            Consulta.ordenarConsultas(todasConsultas);
            for (int i = 0; i < 10; i++) {
                System.out.println(todasConsultas.get(i).toString());
            }
            Passos.firstStep();
        }
        if (options == 5){
            System.out.println("Gerar planilha com todas as consultas(As consultas serão exportadas para o arquivo consultas.csv)");
            List<Consulta> todasConsultas = Consulta.getConsultasFromArvore();
            Consulta.ordenarConsultas(todasConsultas);
            System.out.println();
            todasConsultas.forEach(ConsultaCSVWriter::writeConsultaToCSV);
            System.out.println("Exportadas pra planilha com sucesso!");
            Passos.firstStep();
        }


    }
}
