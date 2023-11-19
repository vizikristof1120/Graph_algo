public class Edge {
    private Node from;
    private Node to;
    private double weight;

//  Constructor
    public Edge(Node from, Node to, double weight){
        this.from=from;
        this.to=to;
        this.weight=weight;
    }

//  get/set weight
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

//  get From/To
    public Node getFrom() {
        return from;
    }
    public Node getTo() {
        return to;
    }

//  not necessary needed
    public void setFrom(Node from) {
        this.from = from;
    }
//  not necessary needed
    public void setTo(Node to) {
        this.to = to;
    }

}
