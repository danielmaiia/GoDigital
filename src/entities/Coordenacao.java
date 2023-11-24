package entities;

import avl.ArvoreAVLConsulta;
import avl.ArvoreAVLCoordenacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class Coordenacao {
    private UUID id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String usuario;
    private String senha;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private static final ArvoreAVLCoordenacao ARVORE_AVL_COORDENACAO = new ArvoreAVLCoordenacao();

    public Coordenacao(String nome, LocalDate dataNascimento, String cpf, String usuario,
                       String senha) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.usuario = usuario;
        this.senha = senha;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Coordenacao(UUID id, String nome, LocalDate dataNascimento, String cpf, String usuario, String senha) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.usuario = usuario;
        this.senha = senha;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public static void inserirNaArvore(Coordenacao coordenacao) {
        ARVORE_AVL_COORDENACAO.inserir(coordenacao);
    }

    public static List<Coordenacao> getCoordenacoesFromArvore() {
        return ARVORE_AVL_COORDENACAO.getTodasCoordenacoes();
    }

    public static Coordenacao buscarNaArvore(UUID id) {
        return ARVORE_AVL_COORDENACAO.buscar(id);
    }

    private static Coordenacao mockCoordenacao(int i) {
        return new Coordenacao(
                "Nome" + i,
                LocalDate.now().minusYears(i % 30),
                "CPF" + i,
                "Usuario" + i,
                "Senha" + i
        );
    }

    public static void mockCoordenacoes() {
        for (int i = 0; i < 10000; i++) {
            Coordenacao coordenacao = mockCoordenacao(i);
            inserirNaArvore(coordenacao);
        }
    }



    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}