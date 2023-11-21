package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class Medico {
    public Medico() {
    }

    public Medico(String nome, LocalDate dataNascimento, String crm, String usuario, String
            senha) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.crm = crm;
        this.usuario = usuario;
        this.senha = senha;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }


    private UUID id;
    private String nome;
    private LocalDate dataNascimento;
    private String crm;
    private String usuario;
    private String senha;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Consulta createConsulta(String nomePaciente, String cartaoSus, String cpfPaciente,
                                   LocalDate dataNascimento,
                                   String escolaridade, String telefone, String email,
                                   String especialidade, String senha, int gravidade, int idade, int
                                           tempoEsperaSemanas, int score) {
        return new Consulta(
                nomePaciente,
                this.id,
                cartaoSus,
                cpfPaciente,
                dataNascimento,
                escolaridade,
                telefone,
                email,
                LocalDate.now(),
                especialidade,
                senha,
                gravidade,
                idade,
                tempoEsperaSemanas,
                score);
    }
    public static void main(String[] args) {
        List<Medico> medicos = new ArrayList<>();
// Mockar 10.000 objetos Medico
        for (int i = 0; i < 10000; i++) {
            Medico medico = new Medico(
                    "Nome" + i,
                    LocalDate.now().minusYears(i % 30), // Varia a data de nascimento
                    "CRM" + i,
                    "Usuario" + i,
                    "Senha" + i
            );
            medicos.add(medico);
        }
// Exemplo de uso: imprimir o nome e CRM dos 10 primeiros médicos
        for (int i = 0; i < 10; i++) {
            Medico medico = medicos.get(i);
            System.out.println("Nome: " + medico.getNome() + ", CRM: " + medico.getCrm());
        }
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
