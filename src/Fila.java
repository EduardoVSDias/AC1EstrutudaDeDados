import javax.swing.JOptionPane;

public class Fila {
    IntNoSimples primeiro, ultimo;
    int numero_nos = 0;

    Fila(){
        primeiro = ultimo = null;
    }

    void adicionaChamado(String valor){
        IntNoSimples novoNo = new IntNoSimples(valor);
        if (primeiro == null) {
            primeiro = ultimo = novoNo;
        } else {
            ultimo.prox = novoNo;
            ultimo = novoNo;
        }
        numero_nos++;
    }

    void visualizarFila(){
        StringBuilder sb = new StringBuilder();
        IntNoSimples temp_no = primeiro;
        while (temp_no != null) {
            sb.append("Chamado Pendente - ").append(temp_no.valor).append("\n");
            temp_no = temp_no.prox;
        }
        if (sb.length() == 0) {
            sb.append("Não há chamados pendentes.");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Chamados Pendentes", JOptionPane.INFORMATION_MESSAGE);
    }
}
