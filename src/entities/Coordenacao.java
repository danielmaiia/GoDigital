package entities;

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
    // Construtores, getters e setters
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

    // Outros métodos da classe, se necessário
    public static void main(String[] args) {
        List<Coordenacao> coordenacoes = new ArrayList<>();
// Mockar 10.000 objetos Coordenacao
        for (int i = 0; i < 10000; i++) {
            Coordenacao coordenacao = new Coordenacao(
                    "Nome" + i,
                    LocalDate.now().minusYears(i % 30), // Varia a data de nascimento
                    "CPF" + i,
                    "Usuario" + i,
                    "Senha" + i
            );
            coordenacoes.add(coordenacao);
        }
// Exemplo de uso: imprimir o nome e CPF dos 10 primeiros coordenadores
        for (int i = 0; i < 10; i++) {
            Coordenacao coordenacao = coordenacoes.get(i);
            System.out.println("Nome: " + coordenacao.getNome() + ", CPF: " +
                    coordenacao.getCpf());
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