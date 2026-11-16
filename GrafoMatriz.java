/** Grafo no dirigido ponderado con una matriz de adyacencia. 0 = sin arista. */
public class GrafoMatriz {
    private final int n;
    private final int[][] matriz;
    private final String[] nombres;

    public GrafoMatriz(String[] nombres) {
        this.n = nombres.length;
        this.nombres = nombres;
        this.matriz = new int[n][n];
    }

    /** O(1) */
    public void agregarArista(int u, int v, int peso) {
        matriz[u][v] = peso;
        matriz[v][u] = peso;
    }

    /** O(1) */
    public boolean existeArista(int u, int v) {
        return matriz[u][v] != 0;
    }

    /** O(V): recorre toda la fila para hallar sus vecinos. */
    public java.util.List<Integer> vecinos(int u) {
        java.util.List<Integer> res = new java.util.ArrayList<>();
        for (int v = 0; v < n; v++) {
            if (matriz[u][v] != 0) res.add(v);
        }
        return res;
    }

    public void imprimir() {
        System.out.print("   ");
        for (String s : nombres) System.out.printf("%4s", s);
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf("%3s", nombres[i]);
            for (int j = 0; j < n; j++) System.out.printf("%4d", matriz[i][j]);
            System.out.println();
        }
    }
}
