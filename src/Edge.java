import java.io.Serializable;
public class Edge implements Serializable {
    private final Node from;
    private final Node to;
    private double weight;

//  Constructor

    /**
     * Constructs a new Edge between two nodes with the specified weight.
     *
     * @param from   The starting node of the edge.
     * @param to     The ending node of the edge.
     * @param weight The weight associated with the edge.
     */
    public Edge(Node from, Node to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

//  get/set weight

    /**
     * Retrieves the weight associated with this edge.
     *
     * @return The weight of the edge.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight associated with this edge to the specified value.
     *
     * @param weight The new weight to be set for the edge.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

//  get From/To

    /**
     * Retrieves the starting node of this edge.
     *
     * @return The starting node.
     */
    public Node getFrom() {
        return from;
    }

    /**
     * Retrieves the ending node of this edge.
     *
     * @return The ending node.
     */
    public Node getTo() {
        return to;
    }
}
