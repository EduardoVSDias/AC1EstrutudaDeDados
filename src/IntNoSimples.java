public class IntNoSimples {
    String valor;  // O valor que o nó vai armazenar (neste caso, será um chamado)
    IntNoSimples prox;  // Ponteiro para o próximo nó

    // Construtor que inicializa o nó com um valor
    public IntNoSimples(String valor) {
        this.valor = valor;
        this.prox = null;
    }
}
