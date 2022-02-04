
package larguraprimeiro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class LarguraPrimeiro {
    
    public static double custo;

    public static void main(String[] args) {
        // TODO code application logic here
        
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeS = new Node("S");

        //Caminhos do ponto A
        nodeA.caminhos = new Caminho[]{
            new Caminho(nodeB, 3),
            new Caminho(nodeC, 1),
            new Caminho(nodeS, 1)
        };

        //Caminhos do ponto B
        nodeB.caminhos = new Caminho[]{
            new Caminho(nodeA, 3),
            new Caminho(nodeD, 3) 
        };

        //Caminhos do ponto C
        nodeC.caminhos = new Caminho[]{
            new Caminho(nodeA, 1),
            new Caminho(nodeD, 1),
            new Caminho(nodeG, 2)
        };

        //Caminhos do ponto D
        nodeD.caminhos = new Caminho[]{
            new Caminho(nodeB, 3),
            new Caminho(nodeC, 1),
            new Caminho(nodeG, 3)
        };

        //Caminhos do ponto G
        nodeG.caminhos = new Caminho[]{
            new Caminho(nodeD, 3),
            new Caminho(nodeC, 2),
            new Caminho(nodeG, 12)
        };

        //Caminhos do ponto S
        nodeS.caminhos = new Caminho[]{
            new Caminho(nodeA, 1),
            new Caminho(nodeG, 12)
        };  
        
        bfs(nodeS,nodeG);
    }
    
     public static void ImprimeResultado(Node target, double custo) {
        List<Node> resultado = new ArrayList<Node>();

        for (Node node = target; node != null; node = node.pai) {
            resultado.add(node);
        }

        Collections.reverse(resultado);

        for (Node i : resultado) {
            System.out.print(i.devolveValor() + " ");
        }
        System.out.println();
        System.out.println("Custo: " + custo);
    }
    
    public static void bfs(Node inicio,Node fim){
        
        Set<Node> visitados = new HashSet<Node>();
        
        LinkedList<Node> queue = new LinkedList<Node>(); 
        
        visitados.add(inicio);
        queue.add(inicio);
        
        while(!queue.isEmpty())
        {
            Node atual = queue.poll();
            
            if(atual.letra.equals(fim.letra))
            {
                ImprimeResultado(fim,atual.custo);
                break;
            }
            
            for(Caminho caminho: atual.caminhos)
            {
                Node vizinho = caminho.vizinho;
                double valor = caminho.distancia + atual.custo;
                
                if(!visitados.contains(vizinho))
                {
                    vizinho.pai = atual;
                    vizinho.custo = valor;
                    visitados.add(vizinho);
                    queue.add(vizinho);
                }
            }
            
        }
        
    }
    
}
