import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Graph graph = new Graph("elso");
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        //random node for testing
        int number_of_nodes = 4;
        Random random = new Random();

        //System.out.println(graph.getNode(random.nextInt(number_of_nodes-1)).getId());
        graph.getNode(3).addEdge(graph.getNode(2),0);
        //BFS bfs = new BFS(graph, graph.getNode(random.nextInt(number_of_nodes-1)));
        BFS bfs = new BFS(graph, graph.getNode(3));
        System.out.println(bfs.end_list_node.get(1).getId());//expected: 3

    }
}