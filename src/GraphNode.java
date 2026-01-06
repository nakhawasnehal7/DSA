import java.util.ArrayList;

public class GraphNode {

    public String name;
    public boolean isVisited;
    public int index;
    public ArrayList<GraphNode> neigbors = new ArrayList<>();


    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
