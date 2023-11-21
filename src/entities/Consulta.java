package entities;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
    private static int generateId() {
// Simples gerador de IDs, você pode usar uma lógica mais avançada conform necessário
        return ThreadLocalRandom.current().nextInt(1, 100000);
    }


    // Outros métodos da classe, se necessário
    public static void main(String[] args) {
        List<Consulta> consultas = new ArrayList<>();
// Mockar 10.000 objetos Consulta
        for (int i = 0; i < 10000; i++) {
            Consulta consulta = new Consulta(
                    "Paciente" + i,
                    UUID.randomUUID(), // Você pode substituir isso pelo ID real de um médico
                    "CartaoSus" + i,
                    "CPFPaciente" + i,
                    LocalDate.now().minusYears(i % 30), // Varia a data de nascimento
                    "Escolaridade" + i,
                    "Telefone" + i,
                    "Email" + i + "@example.com",
                    LocalDate.now().minusDays(i),
                    "Especialidade" + i,
                    "Senha" + i,
                    ThreadLocalRandom.current().nextInt(1, 4), // Gravidade entre 1 e 3
                    ThreadLocalRandom.current().nextInt(1, 100),
                    ThreadLocalRandom.current().nextInt(1, 10),
                    ThreadLocalRandom.current().nextInt(1, 100)
            );
            consultas.add(consulta);
        }
// Exemplo de uso: imprimir o nome do paciente e especialidade das 10 primeiras consultas
        for (int i = 0; i < 10; i++) {
            Consulta consulta = consultas.get(i);
            System.out.println("Paciente: " + consulta.getNomePaciente() + ", Especialidade: " +
                    consulta.getEspecialidade());
        }
    }

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