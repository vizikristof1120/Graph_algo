import java.util.ArrayList;

public class Node {

    private static int idcounter=0;
    private final int id;
    private final ArrayList<Edge> edges;

    Node(){
        edges=new ArrayList<>();
        this.id=idcounter++;
    }
//  add Node
    public void addEdge(Node to, double weight, boolean directed){
        //checking for duplicate edges
        for (Edge edge :edges) {
            if (edge.getTo().equals(to)) return;
        }
        //if edge is undirected then adds another edge which has the 'from' and 'to' is swapped
        edges.add(new Edge(this, to, weight));
        if(!directed){
            to.addEdge(this, weight, true);
        }
    }

//  getId
    public int getId() {
        return id;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }
    public Edge getEdge(int index){
        return edges.get(index);
    }
    public Edge getEdge(Node dest){
        for (Edge edge:edges) {
            if(edge.getTo().equals(dest)) return edge;
        }
        return null;
    }
}
