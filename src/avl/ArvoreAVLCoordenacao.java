package avl;

import entities.Coordenacao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ArvoreAVLCoordenacao {
    private static NoCoordenacao raiz;

    private static class NoCoordenacao {
        private final UUID id;
        private final Coordenacao coordenacao;
        private NoCoordenacao esquerda;
        private NoCoordenacao direita;
        private int altura;

        NoCoordenacao(UUID id, Coordenacao coordenacao) {
            this.id = id;
            this.coordenacao = coordenacao;
            this.altura = 1;
        }
    }

    public void inserir(Coordenacao coordenacao) {
        raiz = inserirRec(raiz, coordenacao);
    }

    private NoCoordenacao inserirRec(NoCoordenacao no, Coordenacao coordenacao) {
        if (no == null) {
            return new NoCoordenacao(UUID.randomUUID(), coordenacao);
        }

        int comparacao = coordenacao.getId().compareTo(no.coordenacao.getId());

        if (comparacao < 0) {
            no.esquerda = inserirRec(no.esquerda, coordenacao);
        } else if (comparacao > 0) {
            no.direita = inserirRec(no.direita, coordenacao);
        } else {
            return no;
        }

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        int fatorBalanceamento = getFatorBalanceamento(no);

        if (fatorBalanceamento > 1) {
            if (coordenacao.getId().compareTo(no.esquerda.coordenacao.getId()) < 0) {
                return rotacaoDireita(no);
            } else {
                no.esquerda = rotacaoEsquerda(no.esquerda);
                return rotacaoDireita(no);
            }
        }
        if (fatorBalanceamento < -1) {
            if (coordenacao.getId().compareTo(no.direita.coordenacao.getId()) > 0) {
                return rotacaoEsquerda(no);
            } else {
                no.direita = rotacaoDireita(no.direita);
                return rotacaoEsquerda(no);
            }
        }

        return no;
    }

    public List<Coordenacao> getTodasCoordenacoes() {
        List<Coordenacao> todasCoordenacoes = new ArrayList<>();
        inOrderTraversal(raiz, todasCoordenacoes);
        return todasCoordenacoes;
    }

    private void inOrderTraversal(NoCoordenacao no, List<Coordenacao> resultado) {
        if (no != null) {
            inOrderTraversal(no.esquerda, resultado);
            resultado.add(no.coordenacao);
            inOrderTraversal(no.direita, resultado);
        }
    }

    private int altura(NoCoordenacao no) {
        return (no == null) ? 0 : no.altura;
    }

    private int getFatorBalanceamento(NoCoordenacao no) {
        return (no == null) ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private NoCoordenacao rotacaoDireita(NoCoordenacao y) {
        NoCoordenacao x = y.esquerda;
        NoCoordenacao T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private NoCoordenacao rotacaoEsquerda(NoCoordenacao x) {
        NoCoordenacao y = x.direita;
        NoCoordenacao T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    public Coordenacao buscar(UUID id) {
        return buscarRec(raiz, id);
    }

    private Coordenacao buscarRec(NoCoordenacao no, UUID id) {
        if (no == null) {
            return null;
        }

        int comparacao = id.compareTo(no.coordenacao.getId());

        if (comparacao == 0) {
            return no.coordenacao;
        } else if (comparacao < 0) {
            return buscarRec(no.esquerda, id);
        } else {
            return buscarRec(no.direita, id);
        }
    }
}
