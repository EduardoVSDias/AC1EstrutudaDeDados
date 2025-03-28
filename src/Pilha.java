import javax.swing.JOptionPane;

public class Pilha {
    private String[] pilha;
    private int topo;

    Pilha() {
        pilha = new String[10];
        topo = -1;
    }

    public void empilhar(String item) {
        if (topo == pilha.length - 1) {
            JOptionPane.showMessageDialog(null, "Pilha cheia.");
            return;
        }
        pilha[++topo] = item;
    }

    public boolean pilhaVazia() {
        return topo == -1;
    }

    public String listar() {
        if (pilhaVazia()) return "Nenhum chamado.";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= topo; i++) {
            sb.append(pilha[i]).append(", ");
        }
        return sb.toString();
    }
}
