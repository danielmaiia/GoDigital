package entities;

import avl.ArvoreAVLConsulta;
import avl.ArvoreAVLMedico;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;


public class Consulta {
    private int id;
    private String nomePaciente;
    private UUID medicoId;
    private int cartaoSus;
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
    private int prioridade;

    private static final ArvoreAVLMedico arvoreAVL = new ArvoreAVLMedico();


    public Consulta(String nomePaciente, UUID medicoId, int cartaoSus, String cpfPaciente,
                    LocalDate dataNascimento,
                    String escolaridade, String telefone, String email, LocalDate dataRequisicao,
                    String especialidade, String senha, int gravidade, int idade, int
                            tempoEsperaSemanas, int score, int prioridade) {
        this.prioridade = prioridade;
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

    public Consulta(int id, String nomePaciente, UUID medicoId, int cartaoSus, String cpfPaciente,
                    LocalDate dataNascimento, String escolaridade, String telefone, String email,
                    LocalDate dataRequisicao, String especialidade, String senha, int gravidade,
                    int idade, int tempoEsperaSemanas, int score, LocalDateTime createdAt,
                    LocalDateTime updatedAt, int prioridade) {
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
        this.prioridade = prioridade;
    }

    private static final ArvoreAVLConsulta ARVORE_AVL_CONSULTA = new ArvoreAVLConsulta();

    public Consulta(Consulta consulta) {
        this.id = consulta.id;
        this.nomePaciente = consulta.nomePaciente;
        this.medicoId = consulta.medicoId;
        this.cartaoSus = consulta.cartaoSus;
        this.cpfPaciente = consulta.cpfPaciente;
        this.dataNascimento = consulta.dataNascimento;
        this.escolaridade = consulta.escolaridade;
        this.telefone = consulta.telefone;
        this.email = consulta.email;
        this.dataRequisicao = consulta.dataRequisicao;
        this.especialidade = consulta.especialidade;
        this.senha = consulta.senha;
    }

    public Consulta() {

    }

    public static void inserirNaArvore(Consulta consulta) {
        ARVORE_AVL_CONSULTA.inserir(consulta);
    }

    public static List<Consulta> getConsultasFromArvore() {
        return ARVORE_AVL_CONSULTA.getTodasConsultas();
    }

    public static Consulta buscarNaArvore(int id) {
        return ARVORE_AVL_CONSULTA.buscar(id);
    }

    public static void inserirNaArvore(Medico medico) {
        arvoreAVL.inserir(medico);
    }

    public static Consulta mockConsulta(int i) {
        return new Consulta(
                "Paciente" + i,
                UUID.randomUUID(),
                10 + i,
                "CPFPaciente" + i,
                LocalDate.now().minusYears(i % 30),
                "Escolaridade" + i,
                "Telefone" + i,
                "Email" + i + "@example.com",
                LocalDate.now().minusDays(i),
                "Especialidade" + i,
                "$2a$1"+ i + "$beV"+ i + "g3" + i + "xTr5hcHE" + i + "AmydX.3mX" + i + "WmG4hb/GxTM8" + i + "/YktkxJZ.UwpaS"+ i,
                ThreadLocalRandom.current().nextInt(1, 4),
                ThreadLocalRandom.current().nextInt(2, 100),
                ThreadLocalRandom.current().nextInt(2, 10),
                ThreadLocalRandom.current().nextInt(2, 100),
                ThreadLocalRandom.current().nextInt(1, 100));
    }

    public static Consulta cadrastroDeConsulta(){

        Scanner sc = new Scanner(System.in);
        Consulta consulta = new Consulta();
        consulta.id = generateId();
        System.out.println("Digite o nome do paciente: ");
        consulta.nomePaciente = sc.nextLine();
        System.out.println("Digite o cartão do SUS do paciente: ");
        consulta.cartaoSus = sc.nextInt();
        System.out.println("Digite o CPF do paciente: ");
        consulta.cpfPaciente = sc.nextLine()+ sc.next();
        consulta.dataNascimento = LocalDate.now().minusYears( ThreadLocalRandom.current().nextInt(1950, 2023));
        System.out.println("Digite a escolaridade do paciente: ");
        consulta.escolaridade = sc.nextLine() + sc.next();
        System.out.println("Digite o telefone do paciente: ");
        consulta.telefone = sc.nextLine()+ sc.next();;
        System.out.println("Digite o email do paciente: ");
        consulta.email = sc.nextLine()+ sc.next();
        consulta.dataRequisicao = LocalDate.now();
        System.out.println("Digite a especialidade");
        consulta.especialidade = sc.nextLine()+ sc.next();;
        System.out.println("Digite a senha");
        consulta.senha = sc.nextLine()+ sc.next();
        // Gerar um hash
        consulta.senha = BCrypt.hashpw(consulta.senha, BCrypt.gensalt());
        consulta.gravidade = ThreadLocalRandom.current().nextInt(1, 4);
        consulta.idade = ThreadLocalRandom.current().nextInt(1, 100);
        consulta.tempoEsperaSemanas = ThreadLocalRandom.current().nextInt(1, 10);
        consulta.score = ThreadLocalRandom.current().nextInt(1, 100);
        consulta.createdAt = LocalDateTime.now();
        consulta.updatedAt = LocalDateTime.now();
        System.out.println("Qual a prioridade do paciente?(numero inteiro de 1 a 100)");
        consulta.prioridade = sc.nextInt();

        System.out.println("Consulta cadastrada com sucesso!");

        return consulta;
    }

    public static Consulta mockEditado(int i) {
        return new Consulta(
                "Editado" + i,
                UUID.randomUUID(),
                10 + i,
                "editado" + i,
                LocalDate.now().minusYears(i % 30),
                "ediato" + i,
                "edtiad" + i,
                "Email" + i + "@example.com",
                LocalDate.now().minusDays(i),
                "Especialidade" + i,
                "Senha" + i,
                ThreadLocalRandom.current().nextInt(1, 4),
                ThreadLocalRandom.current().nextInt(1, 100),
                ThreadLocalRandom.current().nextInt(1, 10),
                ThreadLocalRandom.current().nextInt(1, 100),
                ThreadLocalRandom.current().nextInt(1, 100));
    }

    public static void mockConsultas() {
        for (int i = 0; i < 10000; i++) {
            Consulta.inserirNaArvore(mockConsulta(i));
        }
    System.out.println("Consultas inseridas com sucesso na arvore AVL!");
    }

    public static int compararConsultas(Consulta consulta1, Consulta consulta2) {
        if (consulta1.getPrioridade() != consulta2.getPrioridade()) {
            return Integer.compare(consulta2.getPrioridade(), consulta1.getPrioridade());
        } else {
            return Integer.compare(consulta2.getIdade(), consulta1.getIdade());
        }
    }

    // Método para realizar o QuickSort em uma lista de consultas
    public static void quickSort(List<Consulta> consultas, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(consultas, inicio, fim);
            quickSort(consultas, inicio, indicePivo - 1);
            quickSort(consultas, indicePivo + 1, fim);
        }
    }

    // Método auxiliar para particionar a lista no QuickSort
    private static int particionar(List<Consulta> consultas, int inicio, int fim) {
        Consulta pivo = consultas.get(fim);
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (compararConsultas(consultas.get(j), pivo) < 0) {
                i++;
                Collections.swap(consultas, i, j);
            }
        }

        Collections.swap(consultas, i + 1, fim);
        return i + 1;
    }

    // Método para ordenar as consultas antes da exportação
    public static void ordenarConsultas(List<Consulta> consultas) {
        quickSort(consultas, 0, consultas.size() - 1);
        System.out.println("Consultas devidamente ordenadas atraves do quicksort!");
    }


    private static int generateId() {
        return ThreadLocalRandom.current().nextInt(1, 100000);
    }

    // Outros métodos da classe, se necessário

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public UUID getMedicoId() {
        return medicoId;
    }

    public int getCartaoSus() {
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

    public void setCartaoSus(int cartaoSus) {
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

    @Override
    public String toString() {
        return "Consulta{" +
                ", nomePaciente='" + nomePaciente + '\'' +
                ", medicoId=" + medicoId +
                ", cartaoSus=" + cartaoSus +
                ", cpfPaciente='" + cpfPaciente + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", escolaridade='" + escolaridade + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", dataRequisicao=" + dataRequisicao +
                ", senha='" + senha + '\'' +
                ", gravidade=" + gravidade +
                ", idade=" + idade +
                ", tempoEsperaSemanas=" + tempoEsperaSemanas +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", prioridade=" + prioridade +
                '}';
    }

    public void editarDadosDaConsulta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("A prioridade atual do cliente é: " + this.prioridade);
        System.out.println("Digite um numero de 0 a 99 para a prioridade do paciente sendo a 99 a mais alta e 0 a mais baixa");
        this.prioridade = sc.nextInt();
        System.out.println("Editado com sucesso!");
    }
}
