import java.util.ArrayList;

public class Node {

    private static int idcounter=0;
    private int id;
    private ArrayList<Edge> edges;

    Node(){
        edges=new ArrayList<>();
        this.id=idcounter++;
    }
//  add Node
    public void addEdge(Node to, double weight){
        edges.add(new Edge(this, to, weight));
    }

//  setId is not necessary
//  getId
    public int getId() {
        return id;
    }
    //TODO addEdge testing (not already added)

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
