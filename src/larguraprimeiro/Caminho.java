
package larguraprimeiro;


public class Caminho {

    public final double distancia;
    public final Node vizinho;

    public Caminho(Node vizinho, double distancia) {
        this.distancia = distancia;
        this.vizinho = vizinho;
    }
}