import java.util.ArrayList;

public class BFS {
    ArrayList<Node> end_list_node;
    ArrayList<Edge> end_list_edge;

    /**
     * Constructs a Breadth-First Search (BFS) object to traverse a graph starting from the specified node.
     *
     * @param start_node The starting node for the BFS traversal.
     */
    public BFS(Node start_node){
        ArrayList<Node> found = new ArrayList<>();
        ArrayList<Node> visited = new ArrayList<>();
        ArrayList<Edge> used_edges = new ArrayList<>();
        found.add(start_node);
        while(!found.isEmpty()){
            for (Edge e : found.get(0).getEdges()) {
                if(!visited.contains(e.getTo()) && !found.contains(e.getTo())){
                    found.add(e.getTo());
                    used_edges.add(e);
                }
            }
            visited.add(found.remove(0));
        }
        end_list_node = visited;
        end_list_edge = used_edges;
    }
}
