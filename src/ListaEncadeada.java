import javax.swing.JOptionPane;

public class ListaEncadeada {
    IntNoSimples primeiro, ultimo;
    int numero_nos = 0;

    ListaEncadeada(){
        primeiro = ultimo = null;
    }

    void insereNo_fim(IntNoSimples novoNo){
        novoNo.prox = null;
        if (primeiro == null)
            primeiro = novoNo;
        if (ultimo != null)
            ultimo.prox = novoNo;
        ultimo = novoNo;
        numero_nos++;
    }

    void insereNo_inicio(IntNoSimples novoNo){
        novoNo.prox = primeiro;
        if(primeiro == null && ultimo == null)
            ultimo = novoNo;
        primeiro = novoNo;
        numero_nos++;
    }

    void exibeLista(){
        StringBuilder sb = new StringBuilder();
        IntNoSimples temp_no = primeiro;
        while (temp_no != null) {
            sb.append("Chamado em Atendimento - ").append(temp_no.valor).append("\n");
            temp_no = temp_no.prox;
        }
        if (sb.length() == 0) {
            sb.append("Não há chamados em atendimento.");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Chamados em Atendimento", JOptionPane.INFORMATION_MESSAGE);
    }

    IntNoSimples buscaNo(String buscaValor){
        IntNoSimples temp_no = primeiro;
        while (temp_no != null) {
            if (temp_no.valor == buscaValor) {
                JOptionPane.showMessageDialog(null, "Chamado em Atendimento encontrado: " + temp_no.valor, "Chamado Encontrado", JOptionPane.INFORMATION_MESSAGE);
                return temp_no;
            }
            temp_no = temp_no.prox;
        }
        JOptionPane.showMessageDialog(null, "Chamado não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        return null;
    }
}
