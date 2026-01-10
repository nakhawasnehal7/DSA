package Graph;

import java.util.ArrayList;

public class DFS {


    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visit[]) {
        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (visit[e.dist] == false) {
                dfs(graph, e.dist, visit);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        boolean [] visites = new boolean[V];
        dfs(graph, 0, visites);
    }
}
