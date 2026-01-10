package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
    }

    public static void bsf(ArrayList<Edge> graph[], int V) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[V];
        queue.add(0);
        while (!queue.isEmpty()) {

            int curr = queue.remove();
            if (visit[curr] == false) {
                visit[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    queue.add(e.dist);
                }
            }

        }
        for (int i = 0; i < V; i++) {
            System.out.print(graph[i]+ "Snehal");
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bsf(graph,V);
        System.out.println("graph" + graph);

    }
}
