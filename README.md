Documentação do Código - Sistema de Consultas
Visão Geral
O código apresenta um sistema de gerenciamento de consultas médicas utilizando uma árvore AVL para garantir eficiência na busca e manipulação dos dados. A interface do usuário é implementada na classe Passos, proporcionando interações simples para o cadastro, edição, busca e listagem de consultas.

Como Iniciar
Para iniciar o sistema, chame o método start() na classe Passos. Isso inicializará consultas fictícias usando o método mockConsultas() da classe Consulta e, em seguida, executará o método firstStep().

java
Copy code
public static void main(String[] args) {
    Passos.start();
}
Funcionalidades Principais
1. Cadastro de Nova Consulta
Opção: 1
Descrição: Permite ao usuário cadastrar uma nova consulta, inserindo as informações necessárias como nome do paciente, cartão SUS e prioridade.
java
Copy code
System.out.println("Cadastrar uma nova consulta");
arvoreAVLConsulta.inserir(Consulta.cadrastroDeConsulta());
Passos.firstStep();
2. Edição de Prioridade do Paciente
Opção: 2
Descrição: Permite ao usuário editar a prioridade de um paciente específico, fornecendo o cartão SUS do paciente desejado.
java
Copy code
System.out.println("Editar a prioridade de um paciente");
System.out.println("Digite o cartao SUS do paciente que voce deseja editar");
arvoreAVLConsulta.buscar(sc.nextInt()).editarDadosDaConsulta();
Passos.firstStep();
3. Busca de Consulta
Opção: 3
Descrição: Permite ao usuário buscar uma consulta pelo cartão SUS do paciente, fornecendo informações detalhadas e opções adicionais após a busca.
java
Copy code
System.out.println("Buscar uma consulta");
System.out.println("Digite o cartao SUS do paciente que voce deseja buscar");
Consulta consultaEncontrada = arvoreAVLConsulta.buscar(sc.nextInt());
// ...
4. Listagem das Últimas 10 Consultas com Maior Prioridade
Opção: 4
Descrição: Lista as últimas 10 consultas com maior prioridade, ordenando-as de acordo.
java
Copy code
System.out.println("Listar as ultimas 10 consultas com maior prioridade?");
List<Consulta> todasConsultas = Consulta.getConsultasFromArvore();
Consulta.ordenarConsultas(todasConsultas);
for (int i = 0; i < 10; i++) {
    System.out.println(todasConsultas.get(i).toString());
}
Passos.firstStep();
5. Geração de Planilha com Todas as Consultas
Opção: 5
Descrição: Gera uma planilha em formato CSV contendo todas as consultas, exportando-as para o arquivo "consultas.csv".
java
Copy code
System.out.println("Gerar planilha com todas as consultas");
List<Consulta> todasConsultas = Consulta.getConsultasFromArvore();
Consulta.ordenarConsultas(todasConsultas);
// ...
Conclusão
O código fornece uma interface simples para gerenciar consultas médicas, utilizando estruturas de dados eficientes e permitindo a exportação de dados para uma planilha CSV. A integração de uma árvore AVL contribui para a eficiência na busca e manipulação de consultas, proporcionando uma solução mais robusta para o problema apresentado.
