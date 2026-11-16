import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] nombres = {"A", "B", "C", "D", "E", "F"};
        // Indices: A=0, B=1, C=2, D=3, E=4, F=5
        int[][] datos = {
            {0, 1, 4}, {0, 2, 2}, {1, 2, 1}, {1, 3, 5}, {2, 4, 10},
            {2, 3, 8}, {3, 4, 2}, {3, 5, 6}, {4, 5, 3}
        };

        GrafoMatriz gm = new GrafoMatriz(nombres);
        GrafoLista gl = new GrafoLista(nombres);
        for (int[] e : datos) {
            gm.agregarArista(e[0], e[1], e[2]);
            gl.agregarArista(e[0], e[1], e[2]);
        }

        System.out.println("=== Matriz de adyacencia ===");
        gm.imprimir();
        System.out.println("\n=== Listas de adyacencia ===");
        gl.imprimir();

        System.out.println("\n=== Recorridos desde A ===");
        System.out.println("BFS: " + nombresDe(gl, Recorridos.bfs(gl, 0)));
        System.out.println("DFS: " + nombresDe(gl, Recorridos.dfs(gl, 0)));

        System.out.println("\n=== Arbol de expansion minima ===");
        imprimirArbol("Prim", gl, Prim.arbolMinimo(gl, 0));
        imprimirArbol("Kruskal", gl, Kruskal.arbolMinimo(gl));
    }

    private static String nombresDe(GrafoLista g, List<Integer> orden) {
        StringBuilder sb = new StringBuilder();
        for (int v : orden) sb.append(g.nombre(v)).append(" ");
        return sb.toString().trim();
    }

    private static void imprimirArbol(String titulo, GrafoLista g, List<Arista> arbol) {
        int total = 0;
        System.out.println(titulo + ":");
        for (Arista a : arbol) {
            System.out.println("  " + g.nombre(a.origen) + " - " + g.nombre(a.destino) + " (" + a.peso + ")");
            total += a.peso;
        }
        System.out.println("  Peso total = " + total);
    }
}
