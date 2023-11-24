package readers;

import entities.Coordenacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static writers.CoordenacaoCSVWriter.COORDENACOES_CSV_PATH;

public class CoordenacaoCSVReader {
    public static List<Coordenacao> readCoordenacoesFromCSV() {
        List<Coordenacao> coordenacoes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(COORDENACOES_CSV_PATH))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");

                if (!partes[0].equals("ID")) {
                    try {
                        Coordenacao coordenacao = criarCoordenacaoFromCSV(partes);

                        if (coordenacao != null) {
                            coordenacoes.add(coordenacao);
                            Coordenacao.inserirNaArvore(coordenacao);
                        }
                    } catch (DateTimeParseException | IllegalArgumentException e) {
                        System.err.println("Erro ao criar coordenacao a partir da linha do CSV: " + linha);
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return coordenacoes;
    }

    private static Coordenacao criarCoordenacaoFromCSV(String[] partes) {
        if (partes.length < 6) {
            System.out.println("Dados insuficientes para criar uma coordenacao a partir da linha do CSV.");
            return null;
        }

        UUID id = UUID.fromString(partes[0]);
        String nome = partes[1];
        String senha = partes[5];
        String cpf = partes[3];
        String usuario = partes[4];
        LocalDate dataNascimento = LocalDate.parse(partes[2]);

        return new Coordenacao(id, nome, dataNascimento, cpf, usuario, senha);
    }
}


