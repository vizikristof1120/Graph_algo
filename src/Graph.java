import java.util.ArrayList;

public class Graph {
    private final ArrayList<Node> nodes;
    private final String name;
    private final boolean directed;
    Graph(String name, boolean directed){
        this.name=name;
        nodes=new ArrayList<>();
        this.directed=directed;
    }
    //TODO a boolean for directed or undirected graphs
//  addNode
    public void addNode(){
        nodes.add(new Node());
    }
//  getNode
    public Node getNode(int index){
        return nodes.get(index);
    }
//  getAllNodes
    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public String getName() {
        return name;
    }
}
