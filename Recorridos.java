import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/** BFS y DFS sobre GrafoLista. Complejidad: O(V + E). */
public class Recorridos {

    /** Recorrido por anchura usando una cola. */
    public static List<Integer> bfs(GrafoLista g, int inicio) {
        List<Integer> orden = new ArrayList<>();
        boolean[] visitado = new boolean[g.numVertices()];
        Queue<Integer> cola = new ArrayDeque<>();

        visitado[inicio] = true;
        cola.add(inicio);
        while (!cola.isEmpty()) {
            int u = cola.poll();
            orden.add(u);
            for (Arista a : g.adyacentes(u)) {
                if (!visitado[a.destino]) {
                    visitado[a.destino] = true; // se marca al encolar
                    cola.add(a.destino);
                }
            }
        }
        return orden;
    }

    /** Recorrido por profundidad (recursivo, usa la pila de llamadas). */
    public static List<Integer> dfs(GrafoLista g, int inicio) {
        List<Integer> orden = new ArrayList<>();
        dfsRec(g, inicio, new boolean[g.numVertices()], orden);
        return orden;
    }

    private static void dfsRec(GrafoLista g, int u, boolean[] visitado, List<Integer> orden) {
        visitado[u] = true;
        orden.add(u);
        for (Arista a : g.adyacentes(u)) {
            if (!visitado[a.destino]) dfsRec(g, a.destino, visitado, orden);
        }
    }
}
