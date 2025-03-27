import javax.swing.JOptionPane;

public class GerenciadorChamados {

    ListaEncadeada listaAtendimento;
    Fila filaPendentes;
    Pilha pilhaResolvidos;

    // Construtor da classe GerenciadorChamados
    public GerenciadorChamados() {
        listaAtendimento = new ListaEncadeada();
        filaPendentes = new Fila();
        pilhaResolvidos = new Pilha();
    }

    // Método para exibir o menu de opções
    public void menu() {
        while (true) {
            String menu = "Escolha uma opção:\n" +
                    "1. Adicionar Chamado\n" +
                    "2. Mover para Atendimento\n" +
                    "3. Resolver Chamado\n" +
                    "4. Visualizar Chamados Pendentes\n" +
                    "5. Visualizar Chamados em Atendimento\n" +
                    "6. Visualizar Chamados Resolvidos\n" +
                    "7. Sair";
            // Exibe a opção para o usuário
            int escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (escolha) {
                case 1:
                    String valor = JOptionPane.showInputDialog("Digite o valor do chamado (como número):");
                    filaPendentes.adicionaChamado(valor); // Supondo que valor seja String
                    break;
                case 2:
                    String chamadoParaAtendimento = JOptionPane.showInputDialog("Digite o chamado para mover para atendimento:");
                    listaAtendimento.insereNo_fim(new IntNoSimples(chamadoParaAtendimento));
                    break;
                case 3:
                    String chamadoParaResolver = JOptionPane.showInputDialog("Digite o chamado para resolver:");
                    pilhaResolvidos.empilhar(chamadoParaResolver);
                    break;
                case 4:
                    filaPendentes.visualizarFila(); // Visualiza os chamados pendentes
                    break;
                case 5:
                    listaAtendimento.exibeLista(); // Visualiza os chamados em atendimento
                    break;
                case 6:
                    pilhaResolvidos.visualizarPilha(); // Visualiza os chamados resolvidos
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Saindo do sistema.", "Saída", JOptionPane.INFORMATION_MESSAGE);
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Método main que será executado quando a classe for chamada
    public static void main(String[] args) {
        // Criando uma instância de GerenciadorChamados
        GerenciadorChamados gerenciador = new GerenciadorChamados();
        // Chamando o menu de opções
        gerenciador.menu();
    }
}
