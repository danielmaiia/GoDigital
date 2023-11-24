package avl;

import entities.Medico;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ArvoreAVLMedico {
    private static NoMedico raiz;

    private static class NoMedico {
        private final UUID id;
        private final Medico medico;
        private NoMedico esquerda;
        private NoMedico direita;
        private int altura;

        NoMedico(UUID id, Medico medico) {
            this.id = id;
            this.medico = medico;
            this.altura = 1;
        }


    }

    public void inserir(Medico medico) {
        if (raiz == null) {
            raiz = new NoMedico(medico.getId(), medico);
        } else {
            raiz = inserirRec(raiz, medico);
        }
    }

    private NoMedico inserirRec(NoMedico no, Medico medico) {
        if (no == null) {
            return new NoMedico(medico.getId(), medico);
        }

        int comparacao = medico.getId().compareTo(no.medico.getId());

        if (comparacao < 0) {
            no.esquerda = inserirRec(no.esquerda, medico);
        } else if (comparacao > 0) {
            no.direita = inserirRec(no.direita, medico);
        } else {
            return no;
        }

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        int fatorBalanceamento = getFatorBalanceamento(no);

        if (fatorBalanceamento > 1) {
            if (medico.getId().compareTo(no.esquerda.medico.getId()) < 0) {
                return rotacaoDireita(no);
            } else {
                no.esquerda = rotacaoEsquerda(no.esquerda);
                return rotacaoDireita(no);
            }
        }
        if (fatorBalanceamento < -1) {
            if (medico.getId().compareTo(no.direita.medico.getId()) > 0) {
                return rotacaoEsquerda(no);
            } else {
                no.direita = rotacaoDireita(no.direita);
                return rotacaoEsquerda(no);
            }
        }

        return no;
    }

    public List<Medico> getTodosMedicos() {
        List<Medico> todosMedicos = new ArrayList<>();
        inOrderTraversal(raiz, todosMedicos);
        return todosMedicos;
    }

    private void inOrderTraversal(NoMedico no, List<Medico> resultado) {
        if (no != null) {
            inOrderTraversal(no.esquerda, resultado);
            resultado.add(no.medico);
            inOrderTraversal(no.direita, resultado);
        }
    }

    private int altura(NoMedico no) {
        return (no == null) ? 0 : no.altura;
    }

    private int getFatorBalanceamento(NoMedico no) {
        return (no == null) ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private NoMedico rotacaoDireita(NoMedico y) {
        NoMedico x = y.esquerda;
        NoMedico T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private NoMedico rotacaoEsquerda(NoMedico x) {
        NoMedico y = x.direita;
        NoMedico T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    public Medico buscar(UUID id) {
        return buscarRec(raiz, id);
    }

    private Medico buscarRec(NoMedico no, UUID id) {
        if (no == null) {
            return null;
        }

        int comparacao = id.compareTo(no.medico.getId());

        if (comparacao == 0) {
            return no.medico;
        } else if (comparacao < 0) {
            return buscarRec(no.esquerda, id);
        } else {
            return buscarRec(no.direita, id);
        }
    }
}
