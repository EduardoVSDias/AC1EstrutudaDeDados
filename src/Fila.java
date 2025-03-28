import javax.swing.JOptionPane;

public class Fila {
    private String[] fila;
    private int front = -1, rear = -1;

    Fila() {
        fila = new String[10];
    }

    public void adicionar(String item) {
        if (rear == fila.length - 1) {
            JOptionPane.showMessageDialog(null, "Fila cheia.");
            return;
        }
        if (front == -1) front = 0;
        fila[++rear] = item;
    }

    public String remover() {
        if (front == -1 || front > rear) {
            JOptionPane.showMessageDialog(null, "Fila vazia.");
            return null;
        }
        return fila[front++];
    }

    public boolean filaVazia() {
        return front == -1 || front > rear;
    }

    public String listar() {
        if (filaVazia()) return "Nenhum chamado.";

        StringBuilder sb = new StringBuilder();
        for (int i = front; i <= rear; i++) {
            sb.append(fila[i]).append(", ");
        }
        return sb.toString();
    }
}
