/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package larguraprimeiro;

/**
 *
 * @author Diogo Pinheiro
 */
public class Caminho {
    
    public final double distancia;
    public final Node vizinho;

    public Caminho(Node vizinho, double distancia) {
        this.distancia = distancia;
        this.vizinho = vizinho;
    }
    
}
