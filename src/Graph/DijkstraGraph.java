package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraGraph {


    public static void createGraph(ArrayList<EdgeWeight> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
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

    //O(E+ElogV)
    public static void dijkstra(ArrayList<EdgeWeight>[] graph, int src, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue();
        int dist[] = new int[V];
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    EdgeWeight e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dist;
                    if (dist[u] + e.weight < dist[v]) {
                        dist[v] = dist[u] + e.weight;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + "  ");
        }

    }


    public static void main(String[] args) {
        int V = 6;
        ArrayList<EdgeWeight> graph[] = new ArrayList[V];
        createGraph(graph);
        dijkstra(graph, 0, V);


    }
}
