import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        /*Graph graph = new Graph("elso", false);
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        //random node for testing
        int number_of_nodes = 4;
        Random random = new Random();

        //System.out.println(graph.getNode(random.nextInt(number_of_nodes-1)).getId());
        graph.getNode(3).addEdge(graph.getNode(2),0, false);
        graph.getNode(0).addEdge(graph.getNode(1),0, false);
        graph.getNode(1).addEdge(graph.getNode(2),0, false);

        *//*Graph graph = new Graph("elso", false);
        graph = loadFromFile("elso");*//*

        //BFS bfs = new BFS(graph, graph.getNode(random.nextInt(number_of_nodes-1)));
        BFS bfs = new BFS(graph.getNode(3));
        System.out.println(bfs.end_list_node.get(2).getId());//expected: 1
        DFS dfs = new DFS(graph.getNode(0));
        System.out.println(dfs.nodes_where_stopped.get(2).getId());//expected: 1
        graph.saveToFile();
*/
        /*Graph_editor graph_editor = new Graph_editor();
        Graph graph2 =graph_editor.graph;*/
        /*Graph g2 = loadFromFile("masodik");
        g2.getNode(0).getEdge(0);*/
        new Menu();
    }
    public static Graph loadFromFile(String name){
        Graph graph;
        try {
            FileInputStream fileInputStream = new FileInputStream(name+".ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            graph = (Graph) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
            return graph;
        }catch (Exception e){
            //TODO some error is expected if we try to load a graph which is not existing
            e.printStackTrace();
        }
        return null;
    }
}