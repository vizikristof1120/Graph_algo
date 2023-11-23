import java.util.ArrayList;

public class BFS {
    ArrayList<Node> end_list_node;
    ArrayList<Edge> end_list_edge;
    public BFS(Node start_node){// graph is not needed because the node defines the graph
        ArrayList<Node> found = new ArrayList<>();
        ArrayList<Node> visited = new ArrayList<>();
        ArrayList<Edge> used_edges = new ArrayList<>();
        visited.add(start_node);
        found.add(start_node);
        while(found.containsAll(visited)){
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
