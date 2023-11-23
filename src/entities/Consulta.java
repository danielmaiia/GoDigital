package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
public class Consulta {
    private int id;
    private String nomePaciente;
    private UUID medicoId;
    private String cartaoSus;
    private String cpfPaciente;
    private LocalDate dataNascimento;
    private String escolaridade;
    private String telefone;
    private String email;
    private LocalDate dataRequisicao;
    private String especialidade;
    private String senha;
    private int gravidade;
    private int idade;
    private int tempoEsperaSemanas;
    private int score;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    // Construtores, getters e setters
    public Consulta(String nomePaciente, UUID medicoId, String cartaoSus, String cpfPaciente,
                    LocalDate dataNascimento,
                    String escolaridade, String telefone, String email, LocalDate dataRequisicao,
                    String especialidade, String senha, int gravidade, int idade, int
                            tempoEsperaSemanas, int score) {
        this.id = generateId();
        this.nomePaciente = nomePaciente;
        this.medicoId = medicoId;
        this.cartaoSus = cartaoSus;
        this.cpfPaciente = cpfPaciente;
        this.dataNascimento = dataNascimento;
        this.escolaridade = escolaridade;
        this.telefone = telefone;
        this.email = email;
        this.dataRequisicao = dataRequisicao;
        this.especialidade = especialidade;
        this.senha = senha;
        this.gravidade = gravidade;
        this.idade = idade;
        this.tempoEsperaSemanas = tempoEsperaSemanas;
        this.score = score;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Consulta(int id, String nomePaciente, UUID medicoId, String cartaoSus, String cpfPaciente, LocalDate dataNascimento, String escolaridade, String telefone, String email, LocalDate dataRequisicao, String especialidade, String senha, int gravidade, int idade, int tempoEsperaSemanas, int score, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nomePaciente = nomePaciente;
        this.medicoId = medicoId;
        this.cartaoSus = cartaoSus;
        this.cpfPaciente = cpfPaciente;
        this.dataNascimento = dataNascimento;
        this.escolaridade = escolaridade;
        this.telefone = telefone;
        this.email = email;
        this.dataRequisicao = dataRequisicao;
        this.especialidade = especialidade;
        this.senha = senha;
        this.gravidade = gravidade;
        this.idade = idade;
        this.tempoEsperaSemanas = tempoEsperaSemanas;
        this.score = score;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private static int generateId() {
// Simples gerador de IDs, você pode usar uma lógica mais avançada conform necessário
        return ThreadLocalRandom.current().nextInt(1, 100000);
    }


    // Outros métodos da classe, se necessário


    public int getId() {
        return id;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public UUID getMedicoId() {
        return medicoId;
    }

    public String getCartaoSus() {
        return cartaoSus;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataRequisicao() {
        return dataRequisicao;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getSenha() {
        return senha;
    }

    public int getGravidade() {
        return gravidade;
    }

    public int getIdade() {
        return idade;
    }

    public int getTempoEsperaSemanas() {
        return tempoEsperaSemanas;
    }

    public int getScore() {
        return score;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public void setMedicoId(UUID medicoId) {
        this.medicoId = medicoId;
    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataRequisicao(LocalDate dataRequisicao) {
        this.dataRequisicao = dataRequisicao;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setGravidade(int gravidade) {
        this.gravidade = gravidade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setTempoEsperaSemanas(int tempoEsperaSemanas) {
        this.tempoEsperaSemanas = tempoEsperaSemanas;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}