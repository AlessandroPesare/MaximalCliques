import java.util.ArrayList;
import java.util.List;

public class BronKerboschAlgorithm {
    private Graph graph;

    public BronKerboschAlgorithm(Graph graph) {
        this.graph = graph;
    }

    public List<List<Integer>> findAllCliques() {
        List<Integer> R = new ArrayList<>();
        List<Integer> P = new ArrayList<>();
        for (int i = 0; i < graph.getVertices(); i++) {
            P.add(i);
        }
        List<Integer> X = new ArrayList<>();
        List<List<Integer>> cliques = new ArrayList<>();
        bronKerbosch(R, P, X, cliques);
        return cliques;
    }

    private void bronKerbosch(List<Integer> R, List<Integer> P, List<Integer> X, List<List<Integer>> cliques) {
        if (P.isEmpty() && X.isEmpty()) {
            cliques.add(new ArrayList<>(R));
            return;
        }

        List<Integer> pivotList = new ArrayList<>(P);
        pivotList.addAll(X);
        int u = choosePivot(pivotList);

        List<Integer> P_minus_Nu = new ArrayList<>(P);
        P_minus_Nu.removeAll(graph.getNeighbors(u));

        for (Integer v : P_minus_Nu) {
            List<Integer> neighborsV = graph.getNeighbors(v);
            List<Integer> R_new = new ArrayList<>(R);
            R_new.add(v);
            List<Integer> P_new = new ArrayList<>(P);
            P_new.retainAll(neighborsV);
            List<Integer> X_new = new ArrayList<>(X);
            X_new.retainAll(neighborsV);
            bronKerbosch(R_new, P_new, X_new, cliques);
            P.remove(v);
            X.add(v);
        }
    }

    private int choosePivot(List<Integer> vertices) {
        // Choose a pivot vertex from the list (can be optimized based on specific criteria)
        return vertices.get(0);
    }
}
