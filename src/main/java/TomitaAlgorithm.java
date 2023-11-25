import java.util.ArrayList;
import java.util.List;

public class TomitaAlgorithm {
    private Graph graph;

    public TomitaAlgorithm(Graph graph) {
        this.graph = graph;
    }

    public List<List<Integer>> findAllCliques() {
        List<Integer> clique = new ArrayList<>();
        List<List<Integer>> cliques = new ArrayList<>();
        boolean[] visited = new boolean[graph.getVertices()];
        tomek(graph, clique, cliques, visited);
        return cliques;
    }

    private void tomek(Graph graph, List<Integer> clique, List<List<Integer>> cliques, boolean[] visited) {
        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i] && isClique(graph, clique, i)) {
                clique.add(i);
                visited[i] = true;
                tomek(graph, clique, cliques, visited);
                clique.remove(clique.size() - 1);
                visited[i] = false;
            }
        }
        if (!clique.isEmpty()) {
            cliques.add(new ArrayList<>(clique));
        }
    }

    private boolean isClique(Graph graph, List<Integer> clique, int vertex) {
        for (Integer v : clique) {
            if (!graph.getNeighbors(vertex).contains(v)) {
                return false;
            }
        }
        return true;
    }
}
