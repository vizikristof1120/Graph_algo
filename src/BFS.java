import java.util.ArrayList;

public class BFS {
    ArrayList<Node> end_list_node;
    ArrayList<Edge> end_list_edge;
    public BFS(Graph graph, Node start_node){
        ArrayList<Node> found = new ArrayList<>();
        ArrayList<Node> visited = new ArrayList<>();
        ArrayList<Edge> used_edges = new ArrayList<>();
        visited.add(start_node);
        found.add(start_node);
        while(found.containsAll(visited)){
            for (int i = 0; i < found.get(0).getEdges().size(); i++) {
                Node to = found.get(0).getEdge(i).getTo();
                if(!visited.contains(to) && !found.contains(to)){
                    found.add(to);
                    used_edges.add(found.get(0).getEdge(i));
                }
            }
            visited.add(found.remove(0));
        }

        end_list_node = visited;
        end_list_edge = used_edges;
    }
}
