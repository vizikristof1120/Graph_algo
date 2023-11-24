import java.util.ArrayList;

public class DFS {
    ArrayList<Edge> end_list_edge;
    ArrayList<Node> nodes_where_stopped;
    ArrayList<Node> found;
    public DFS(Node start_node){
        end_list_edge= new ArrayList<>();
        nodes_where_stopped = new ArrayList<>();
        found = new ArrayList<>();
        found.add(start_node);
        oneLevelDeeper(start_node);
    }
    private void oneLevelDeeper(Node node){
        for (Edge edge :node.getEdges()) {
            if(!found.contains(edge.getTo())) {
                end_list_edge.add(edge);
                found.add(edge.getTo());
                oneLevelDeeper(edge.getTo());
            }
        }
        nodes_where_stopped.add(node);
    }
}
