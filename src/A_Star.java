import java.util.ArrayList;

public class A_Star {
    ArrayList<Node> closed_list;
    ArrayList<Node> open_list;//list of nodes which we encountered but haven't analysed (found)
    private double cost = 0;
    private double move = 0;
    private double heuristic = 0;
    A_Star(Node start_node, Node end_node){
        closed_list = new ArrayList<>();
        open_list = new ArrayList<>();
        open_list.add(start_node);
        while(!open_list.isEmpty()){

        }
    }
    // cost function: (f)

    // move function: (g)

    // heuristic function: (h)

    //f = g + h
}
