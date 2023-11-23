package utils;

import entities.Consulta;

import java.util.List;

public class BuscaBinariaConsulta {
    public static Consulta buscaBinariaConsulta(List<Consulta> consultas, int id) {
        int inicio = 0;
        int fim = consultas.size() - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;
            Consulta consultaMeio = consultas.get(meio);

            int comparacao = Integer.compare(id, consultaMeio.getId());

            if (comparacao == 0) {
                return consultaMeio;
            } else if (comparacao < 0) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        return null;
    }
}