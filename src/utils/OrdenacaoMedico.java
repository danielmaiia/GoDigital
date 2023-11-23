package utils;

import entities.Medico;

import java.util.List;
import java.util.UUID;

public class OrdenacaoMedico {
    public static Medico buscaBinariaMedico(List<Medico> medicos, UUID id) {
        int inicio = 0;
        int fim = medicos.size() - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;
            Medico medicoMeio = medicos.get(meio);

            int comparacao = id.compareTo(medicoMeio.getId());

            if (comparacao == 0) {
                return medicoMeio; // Médico encontrado
            } else if (comparacao < 0) {
                fim = meio - 1; // Buscar na metade inferior
            } else {
                inicio = meio + 1; // Buscar na metade superior
            }
        }

        return null; // Médico não encontrado
    }
}
