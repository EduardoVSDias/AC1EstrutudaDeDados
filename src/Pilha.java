import javax.swing.JOptionPane;

public class Pilha {
    IntNoSimples topo;
    int numero_nos = 0;

    Pilha(){
        topo = null;
    }

    void empilhar(String valor){
        IntNoSimples novoNo = new IntNoSimples(valor);
        novoNo.prox = topo;
        topo = novoNo;
        numero_nos++;
    }

    void visualizarPilha(){
        StringBuilder sb = new StringBuilder();
        IntNoSimples temp_no = topo;
        while (temp_no != null) {
            sb.append("Chamado Resolvido - ").append(temp_no.valor).append("\n");
            temp_no = temp_no.prox;
        }
        if (sb.length() == 0) {
            sb.append("Não há chamados resolvidos.");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Chamados Resolvidos", JOptionPane.INFORMATION_MESSAGE);
    }
}
