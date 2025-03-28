import javax.swing.*;

public class GerenciadorChamados {

    // Fila de pendentes
    Fila filaPendentes = new Fila();

    // Lista encadeada de chamados em atendimento
    ListaEncadeada listaAtendimento = new ListaEncadeada();

    // Pilha de chamados resolvidos
    Pilha pilhaResolvidos = new Pilha();

    public static void main(String[] args) {
        GerenciadorChamados gerenciador = new GerenciadorChamados();
        gerenciador.menuInterativo();
    }

    // Função do menu interativo
    public void menuInterativo() {
        while (true) {
            String[] options = {"Adicionar Chamado", "Mover para Atendimento", "Resolver Chamado", "Visualizar Chamados", "Sair"};
            int escolha = JOptionPane.showOptionDialog(null, "Selecione uma opção", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (escolha) {
                case 0:
                    adicionarChamado();
                    break;
                case 1:
                    moverParaAtendimento();
                    break;
                case 2:
                    resolverChamado();
                    break;
                case 3:
                    visualizarChamados();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }
    }

    // Adiciona um chamado à fila de pendentes
    public void adicionarChamado() {
        String chamado = JOptionPane.showInputDialog("Insira o chamado:");
        if (chamado != null) {
            filaPendentes.adicionar(chamado);
            JOptionPane.showMessageDialog(null, "Chamado adicionado à fila de pendentes.");
        }
    }

    // Move um chamado da fila para a lista de atendimento
    public void moverParaAtendimento() {
        if (filaPendentes.filaVazia()) {
            JOptionPane.showMessageDialog(null, "Não há chamados pendentes.");
        } else {
            String chamado = filaPendentes.remover();
            listaAtendimento.insereNo_fim(new IntNoSimples(chamado));
            JOptionPane.showMessageDialog(null, "Chamado movido para atendimento.");
        }
    }

    // Resolve um chamado da lista de atendimento e move para a pilha de resolvidos
    public void resolverChamado() {
        String resolver = JOptionPane.showInputDialog("Insira o chamado:");
        if (listaAtendimento.listaVazia()) {
            JOptionPane.showMessageDialog(null, "Não há chamados em atendimento.");
        } else {
            if(listaAtendimento.buscaNo(resolver) == null){
                JOptionPane.showMessageDialog(null, "Não há chamado com este nome.");
            }
            else {
                IntNoSimples c = listaAtendimento.buscaNo(resolver);
                listaAtendimento.excluiNo(c.toString());;
                pilhaResolvidos.empilhar(resolver);

                JOptionPane.showMessageDialog(null, "Chamado resolvido.");
            }
        }
    }

    // Visualiza todos os chamados
    public void visualizarChamados() {
        StringBuilder sb = new StringBuilder();

        // Pendentes
        sb.append("Pendentes: ");
        if (filaPendentes.filaVazia()) {
            sb.append("Nenhum chamado pendente.\n");
        } else {
            sb.append(filaPendentes.listar()).append("\n");
        }

        // Em Atendimento
        sb.append("Em Atendimento: ");
        if (listaAtendimento.listaVazia()) {
            sb.append("Nenhum chamado em atendimento.\n");
        } else {
            sb.append(listaAtendimento.listar()).append("\n");
        }

        // Resolvidos
        sb.append("Resolvidos: ");
        if (pilhaResolvidos.pilhaVazia()) {
            sb.append("Nenhum chamado resolvido.\n");
        } else {
            sb.append(pilhaResolvidos.listar()).append("\n");
        }

        // Exibe as listas
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
