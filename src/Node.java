import java.util.ArrayList;

public class Node {

    static int idcounter=0;
    int id;
    ArrayList<Edge> edges;

    Node(){
        edges=new ArrayList<>();
        this.id=idcounter++;
    }
    public void AddEdge(Node to, double weight){
        edges.add(new Edge(this, to, weight));
    }
//  setId is not necessary
//  getId
    public int getId() {
        return id;
    }
}
