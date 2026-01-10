package Graph;

import java.util.ArrayList;

public class BellmanFord {


    public static void createGraph(ArrayList<EdgeWeight> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<EdgeWeight>();
        }

        graph[0].add(new EdgeWeight(0, 1, 2));
        graph[0].add(new EdgeWeight(0, 2, 4));

        graph[1].add(new EdgeWeight(1, 3, 7));
        graph[1].add(new EdgeWeight(1, 2, 1));

        graph[2].add(new EdgeWeight(2, 4, 3));

        graph[3].add(new EdgeWeight(3, 5, 1));

        graph[4].add(new EdgeWeight(4, 3, 2));
        graph[4].add(new EdgeWeight(4, 5, 5));

    }
    public static void bellmanFord(ArrayList<EdgeWeight> graph[], int src, int V) {

        int dist[] = new int[V];

        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }


        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                EdgeWeight e = graph[i].get(j);
                int u = e.src;
                int v = e.dist;
                if (dist[u] != Integer.MAX_VALUE &&
                        dist[u] + e.weight < dist[v]) {
                    dist[v] = dist[u] + e.weight;

                }
            }
        }
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + "  ");
        }    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<EdgeWeight> graph[] = new ArrayList[V];
        createGraph(graph);
        bellmanFord(graph, 0, V);
    }
}
