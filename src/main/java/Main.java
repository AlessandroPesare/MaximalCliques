import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Esempio di utilizzo
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        TomitaAlgorithm tomitaAlgorithm = new TomitaAlgorithm(graph);
        List<List<Integer>> tomitaCliques = tomitaAlgorithm.findAllCliques();

        BronKerboschAlgorithm bronKerboschAlgorithm = new BronKerboschAlgorithm(graph);
        //trova tutte le cliques con bronKerbosch
        List<List<Integer>> bronKerboschCliques = bronKerboschAlgorithm.findAllCliques();

        // Stampa i risultati
        System.out.println("Cliques found by Tomita Algorithm: " + tomitaCliques);
        System.out.println("Cliques found by Bron–Kerbosch Algorithm: " + bronKerboschCliques);
    }
}
