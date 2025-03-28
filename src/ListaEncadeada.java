import javax.swing.JOptionPane;

public class ListaEncadeada {
    IntNoSimples primeiro, ultimo;
    int numero_nos=0;

    ListaEncadeada() {
        primeiro = ultimo = null;
    }

    void insereNo_fim (IntNoSimples novoNo){
        novoNo.prox = null;
        if (primeiro == null)
            primeiro = novoNo;
        if (ultimo != null)
            ultimo.prox = novoNo;
        ultimo = novoNo;
        numero_nos++;
    }
    void insereNo_inicio (IntNoSimples novoNo){
        novoNo.prox = primeiro;
        if(primeiro == null && ultimo==null) //Só tem um elemento na lista
        {
            ultimo = novoNo;
        }
        primeiro = novoNo;
        numero_nos++;
    }
    IntNoSimples buscaNo (String buscaValor){
        int i = 0;
        IntNoSimples temp_no = primeiro;
        while (temp_no != null)
        {
            if (temp_no.valor.equals(buscaValor))
            {
                return temp_no;
            }
            i++;
            temp_no = temp_no.prox;
        }
        return null;
    }
    void excluiNo (String valor){
        IntNoSimples temp_no = primeiro;
        IntNoSimples anterior_no=null;
        while (temp_no != null && !temp_no.valor.equals(valor)){
            anterior_no = temp_no;
            temp_no = temp_no.prox;
        }
        if (temp_no == primeiro){
            if (temp_no.prox !=null)
                primeiro = temp_no.prox;
            else
                primeiro = null;
        }
        else{
            anterior_no.prox = temp_no.prox;
        }

        if (ultimo == temp_no)
            ultimo = anterior_no;
    }

    public boolean listaVazia() {
        return primeiro == null;
    }

    public String listar() {
        if (listaVazia()) return "Nenhum chamado.";

        StringBuilder sb = new StringBuilder();
        IntNoSimples temp = primeiro;
        while (temp != null) {
            sb.append(temp.valor).append(", ");
            temp = temp.prox;
        }
        return sb.toString();
    }
}
