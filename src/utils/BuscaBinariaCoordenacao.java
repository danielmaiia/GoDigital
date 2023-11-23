package utils;
import entities.Coordenacao;

import java.util.List;
import java.util.UUID;
public class BuscaBinariaCoordenacao {
    public static Coordenacao buscaBinariaCoordenacao(List<Coordenacao> coordenacoes, UUID id) {
        int inicio = 0;
        int fim = coordenacoes.size() - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;
            Coordenacao coordenacaoMeio = coordenacoes.get(meio);

            int comparacao = id.compareTo(coordenacaoMeio.getId());

            if (comparacao == 0) {
                return coordenacaoMeio;
            } else if (comparacao < 0) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        return null;
    }
}

