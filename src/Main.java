public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Graph graph = new Graph("elso");
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        System.out.println(graph.getNode(3).getId());
        graph.getNode(3).addEdge(graph.getNode(2),0);
        BFS bfs = new BFS(graph);
        bfs.end_list.get(0);
    }
}