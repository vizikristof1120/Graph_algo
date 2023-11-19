import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> nodes;
    private String name;
    Graph(String name){
        this.name=name;
        nodes=new ArrayList<>();
    }
//  add Node
    public void addNode(){
        nodes.add(new Node());
    }
//  getNode
    public Node getNode(int index){
        return nodes.get(index);
    }
}
