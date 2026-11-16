import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Algoritmo de Kruskal con Union-Find. Complejidad: O(E log E). */
public class Kruskal {

    /** Estructura Union-Find con compresion de caminos y union por rango. */
    private static class UnionFind {
        private final int[] padre, rango;

        UnionFind(int n) {
            padre = new int[n];
            rango = new int[n];
            for (int i = 0; i < n; i++) padre[i] = i;
        }

        int buscar(int x) {
            if (padre[x] != x) padre[x] = buscar(padre[x]);
            return padre[x];
        }

        boolean unir(int a, int b) {
            int ra = buscar(a), rb = buscar(b);
            if (ra == rb) return false; // ya estan en el mismo conjunto: habria ciclo
            if (rango[ra] < rango[rb]) { int t = ra; ra = rb; rb = t; }
            padre[rb] = ra;
            if (rango[ra] == rango[rb]) rango[ra]++;
            return true;
        }
    }

    public static List<Arista> arbolMinimo(GrafoLista g) {
        int n = g.numVertices();
        List<Arista> ordenadas = new ArrayList<>(g.todasLasAristas());
        Collections.sort(ordenadas);              // O(E log E)

        UnionFind uf = new UnionFind(n);
        List<Arista> resultado = new ArrayList<>();
        for (Arista a : ordenadas) {
            if (uf.unir(a.origen, a.destino)) {
                resultado.add(a);
                if (resultado.size() == n - 1) break;
            }
        }
        return resultado;
    }
}
