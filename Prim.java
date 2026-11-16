import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/** Algoritmo de Prim con cola de prioridad. Complejidad: O(E log V). */
public class Prim {

    public static List<Arista> arbolMinimo(GrafoLista g, int inicio) {
        int n = g.numVertices();
        boolean[] enArbol = new boolean[n];
        List<Arista> resultado = new ArrayList<>();
        PriorityQueue<Arista> cola = new PriorityQueue<>();

        enArbol[inicio] = true;
        cola.addAll(g.adyacentes(inicio));

        while (!cola.isEmpty() && resultado.size() < n - 1) {
            Arista a = cola.poll();               // arista de menor peso
            if (enArbol[a.destino]) continue;     // evitaria un ciclo
            enArbol[a.destino] = true;
            resultado.add(a);
            for (Arista b : g.adyacentes(a.destino)) {
                if (!enArbol[b.destino]) cola.add(b);
            }
        }
        return resultado;
    }
}
