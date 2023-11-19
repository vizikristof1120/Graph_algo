import java.util.ArrayList;

public class Node {

    //TODO name or id is needed

    ArrayList<Edge> edges;
    Node(){
        edges=new ArrayList<>();
    }
    public void AddEdge(Node to, double weight){
        edges.add(new Edge(this, to, weight));
    }
}
