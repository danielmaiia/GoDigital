package avl;

import entities.Consulta;

import java.util.ArrayList;
import java.util.List;

public class ArvoreAVLConsulta {
    private static NoConsulta raiz;

    private static class NoConsulta {
        private final int cartaoSUS;
        private final Consulta consulta;
        private NoConsulta esquerda;
        private NoConsulta direita;
        private int altura;

        NoConsulta(int cartaoSUS, Consulta consulta) {
            this.cartaoSUS = cartaoSUS;
            this.consulta = consulta;
            this.altura = 1;
        }
    }

    public void inserir(Consulta consulta) {
        if (raiz == null) {
            raiz = new NoConsulta(consulta.getCartaoSus(), consulta);
        } else {
            raiz = inserirRec(raiz, consulta);
        }
    }

    private NoConsulta inserirRec(NoConsulta no, Consulta consulta) {
        if (no == null) {
            return new NoConsulta(consulta.getCartaoSus(), consulta);
        }

        int comparacao = Integer.compare(consulta.getCartaoSus(), no.consulta.getCartaoSus());

        if (comparacao < 0) {
            no.esquerda = inserirRec(no.esquerda, consulta);
        } else if (comparacao > 0) {
            no.direita = inserirRec(no.direita, consulta);
        } else {
            return no;
        }

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        int fatorBalanceamento = getFatorBalanceamento(no);

        if (fatorBalanceamento > 1) {
            if (consulta.getCartaoSus() < no.esquerda.consulta.getCartaoSus()) {
                return rotacaoDireita(no);
            } else {
                no.esquerda = rotacaoEsquerda(no.esquerda);
                return rotacaoDireita(no);
            }
        }
        if (fatorBalanceamento < -1) {
            if (consulta.getCartaoSus() > no.direita.consulta.getCartaoSus()) {
                return rotacaoEsquerda(no);
            } else {
                no.direita = rotacaoDireita(no.direita);
                return rotacaoEsquerda(no);
            }
        }

        return no;
    }

    public List<Consulta> getTodasConsultas() {
        List<Consulta> todasConsultas = new ArrayList<>();
        inOrderTraversal(raiz, todasConsultas);
        return todasConsultas;
    }

    private void inOrderTraversal(NoConsulta no, List<Consulta> resultado) {
        if (no != null) {
            inOrderTraversal(no.esquerda, resultado);
            resultado.add(no.consulta);
            inOrderTraversal(no.direita, resultado);
        }
    }

    private int altura(NoConsulta no) {
        return (no == null) ? 0 : no.altura;
    }

    private int getFatorBalanceamento(NoConsulta no) {
        return (no == null) ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private NoConsulta rotacaoDireita(NoConsulta y) {
        NoConsulta x = y.esquerda;
        NoConsulta T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private NoConsulta rotacaoEsquerda(NoConsulta x) {
        NoConsulta y = x.direita;
        NoConsulta T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    public Consulta buscar(int cartaoSUS) {
        return buscarRec(raiz, cartaoSUS);
    }

    private Consulta buscarRec(NoConsulta no, int cartaoSUS) {
        if (no == null) {
            return null;
        }

        int comparacao = Integer.compare(cartaoSUS, no.consulta.getCartaoSus());

        if (comparacao == 0) {
            return no.consulta;
        } else if (comparacao < 0) {
            return buscarRec(no.esquerda, cartaoSUS);
        } else {
            return buscarRec(no.direita, cartaoSUS);
        }
    }
}
