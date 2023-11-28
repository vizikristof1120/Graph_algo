import java.util.ArrayList;
import java.io.Serializable;

public class Node implements Serializable{

    private static int id_counter=0;
    private final int id;
    private final ArrayList<Edge> edges;

    /**
     * Constructs a new Node with an automatically assigned ID and an empty list of edges.
     */
    Node(){
        edges=new ArrayList<>();
        this.id=id_counter++;
    }

//  add Node
    /**
     * Adds a new edge from this node to the specified node with the given weight.
     *
     * @param to The destination node of the edge.
     * @param weight The weight associated with the edge.
     * @param directed A flag indicating whether the edge is directed.
     */
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
    /**
     * Retrieves the unique identifier associated with this node.
     *
     * @return The ID of the node.
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the list of edges connected to this node.
     *
     * @return The list of edges associated with this node.
     */
    public ArrayList<Edge> getEdges() {
        return edges;
    }

    /**
     * Retrieves the edge at the specified index from the list of edges connected to this node.
     *
     * @param index The index of the edge to retrieve.
     * @return The edge at the specified index.
     * @throws IndexOutOfBoundsException If the index is out of range (index < 0 || index >= size()).
     */
    public Edge getEdge(int index){
        return edges.get(index);
    }

    /**
     * Retrieves the edge connecting this node to the specified destination node.
     *
     * @param dest The destination node for the edge.
     * @return The edge connecting this node to the specified destination, or null if no such edge exists.
     */
    public Edge getEdge(Node dest){
        for (Edge edge:edges) {
            if(edge.getTo().equals(dest)) return edge;
        }
        return null;
    }
}
