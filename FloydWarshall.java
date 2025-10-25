import java.util.Scanner;

public class FloydWarshall {
    static final int INF = 99999; // Represents infinity (no direct edge)

    // Function to implement Floyd–Warshall algorithm
    void floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        // Initialize distance matrix as the input graph
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        // Apply Floyd–Warshall Algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        // Print the result
        printSolution(dist);
    }

    // Function to print the shortest distance matrix
    void printSolution(int[][] dist) {
        int V = dist.length;
        System.out.println("\nShortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FloydWarshall fw = new FloydWarshall();

        // Take number of vertices as input
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int[][] graph = new int[V][V];

        System.out.println("\nEnter the adjacency matrix:");
        System.out.println("(Enter " + INF + " if there is no direct edge between vertices)");

        // Input adjacency matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        fw.floydWarshall(graph);
        sc.close();
    }
}
