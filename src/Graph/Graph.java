package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {

    ArrayList<GraphNode> nodeList = new ArrayList<>();

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUnDirected(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neigbors.add(second);
        second.neigbors.add(first);
    }

    //BFS
    void bsf() {
        for (GraphNode node : nodeList) {
            bsfVisit(node);
        }
    }

    public void bsfVisit(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            for (GraphNode neighbor : currentNode.neigbors) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

}
