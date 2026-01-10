package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Queue;

/**
 * Basic Graph.Graph
 * BFS/DFS and allPath
 */

public class GraphAdjacentList {

    public static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));


        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 4));


        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));


        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));

   /*     for (int i = 0; i < graph[1].size(); i++) {
            Graph.Graph.Edge e = graph[1].get(i);
            System.out.println(e.dist + "" + e.src);
        }*/
    }

    public static void bfs(ArrayList<Edge> graph[]) {
        Queue<Integer> queue = new LinkedList();
        boolean vis[] = new boolean[6];
        queue.add(0);
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            if (vis[curr] == false) {
                System.out.print(" " + curr);

                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    queue.add(e.dist);
                }
            }
        }
    }


    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.print(" " + curr);
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.dist] == false) {
                //System.out.print(" " + e.dist);
                dfs(graph, e.dist, vis);
            }
        }
    }


    public static void printAllPath(ArrayList<Edge> graph[],
                                    boolean vis[], int curr,
                                    String path, int tar) {
        if (curr == tar) {
            System.out.println(" " + path);
            return;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.dist] == false) {
                vis[e.dist] = true;
                printAllPath(graph, vis, e.dist, path + e.dist, tar);
                vis[curr] = false;

            }
        }

    }


    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[6];
        createGraph(graph);

        bfs(graph);


        boolean vis[] =  new boolean[6];
        dfs(graph, 0, vis);


        //printAllPath(graph, vis, 0, path, 5);


    }

}
