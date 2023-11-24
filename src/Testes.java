import avl.ArvoreAVLConsulta;
import avl.ArvoreAVLCoordenacao;
import avl.ArvoreAVLMedico;
import entities.Consulta;
import writers.ConsultaCSVWriter;

import java.util.List;

public class Testes {
    public static void main(String[] args) {
        ArvoreAVLMedico arvoreAVLMedico = new ArvoreAVLMedico();
        ArvoreAVLConsulta arvoreAVLConsulta = new ArvoreAVLConsulta();
        ArvoreAVLCoordenacao arvoreAVLCoordenacao = new ArvoreAVLCoordenacao();

        Consulta.mockConsultas();

        List<Consulta> todasConsultas = Consulta.getConsultasFromArvore();
        Consulta.ordenarConsultas(todasConsultas);
        todasConsultas.forEach(ConsultaCSVWriter::writeConsultaToCSV);
        System.out.println("Exportadas pra planilha com sucesso!");
//
//        int cartaoSusDaConsultaParaBuscar = todasConsultas.get(0).getCartaoSus();
//        Consulta consultaEncontrada = arvoreAVLConsulta.buscar(cartaoSusDaConsultaParaBuscar);
//        if (consultaEncontrada != null) {
//            System.out.println("Consulta encontrada: " + consultaEncontrada.getNomePaciente());
//        } else {
//            System.out.println("Consulta não encontrada.");
//        }

//        ConsultaCSVWriter.deleteConsultaFromCSV(648);
        ConsultaCSVWriter.editConsultaInCSV(385,new Consulta(Consulta.mockEditado(1)));



    }
}
