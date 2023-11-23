package utils;

import entities.Medico;

import java.util.List;
import java.util.UUID;

public class BuscaBinariaMedico {
    public static Medico buscaBinariaMedico(List<Medico> medicos, UUID id) {
        int inicio = 0;
        int fim = medicos.size() - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;
            Medico medicoMeio = medicos.get(meio);

            int comparacao = id.compareTo(medicoMeio.getId());

            if (comparacao == 0) {
                return medicoMeio;
            } else if (comparacao < 0) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        return null;
    }


}
