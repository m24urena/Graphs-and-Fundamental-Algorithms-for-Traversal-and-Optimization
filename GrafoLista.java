import java.util.ArrayList;
import java.util.List;

/** Grafo no dirigido ponderado con listas de adyacencia. */
public class GrafoLista {
    private final int n;
    private final List<List<Arista>> ady;
    private final List<Arista> aristas = new ArrayList<>(); // cada arista una sola vez
    private final String[] nombres;

    public GrafoLista(String[] nombres) {
        this.n = nombres.length;
        this.nombres = nombres;
        this.ady = new ArrayList<>();
        for (int i = 0; i < n; i++) ady.add(new ArrayList<>());
    }

    /** O(1) */
    public void agregarArista(int u, int v, int peso) {
        ady.get(u).add(new Arista(u, v, peso));
        ady.get(v).add(new Arista(v, u, peso));
        aristas.add(new Arista(u, v, peso));
    }

    public List<Arista> adyacentes(int u) { return ady.get(u); }
    public List<Arista> todasLasAristas() { return aristas; }
    public int numVertices() { return n; }
    public String nombre(int i) { return nombres[i]; }

    public void imprimir() {
        for (int u = 0; u < n; u++) {
            StringBuilder sb = new StringBuilder(nombres[u] + " -> ");
            for (Arista a : ady.get(u))
                sb.append("[").append(nombres[a.destino]).append(",").append(a.peso).append("] ");
            System.out.println(sb);
        }
    }
}
