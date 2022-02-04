
package larguraprimeiro;


public class Node {
    
    public final String letra;
    public double custo = 0;
    public Caminho[] caminhos;
    public Node pai;
    
    public Node(String letra)
    {
        this.letra = letra;
    }

    public String devolveValor() {
        return letra;
    }
    
}
