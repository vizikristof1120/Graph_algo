import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tests {
    Graph graph;
    BFS bfs1, bfs2;
    DFS dfs1, dfs2;
    @Before
        public void init(){
        graph = new Graph("test_graph");
        graph.addNode();//0
        graph.addNode();//1
        graph.addNode();//2
        graph.addNode();//3
        graph.addNode();//4
        graph.addNode();//5
        graph.getNode(0).addEdge(graph.getNode(1),0,false);
        graph.getNode(1).addEdge(graph.getNode(2),0,false);
        graph.getNode(1).addEdge(graph.getNode(3),0,false);
        graph.getNode(4).addEdge(graph.getNode(1),0,false);
        bfs1 = new BFS(graph.getNode(0));
        bfs2 = new BFS(graph.getNode(5));
        dfs1 = new DFS(graph.getNode(0));
        dfs2 = new DFS(graph.getNode(5));
    }
    @Test
    public void test_get_node_id(){
        Assert.assertEquals(1,graph.getNode(1).getId());
    }
    @Test
    public void test_add_node(){
        int size = graph.getNodes().size();
        graph.addNode();//6
        Assert.assertEquals(size+1,graph.getNodes().size());
    }
    @Test
    public void test_add_edge(){
        int size = graph.getNode(5).getEdges().size();
        graph.getNode(5).addEdge(graph.getNode(0), 0,true);
        Assert.assertEquals(size+1,graph.getNode(5).getEdges().size());
    }
    @Test
    public void test_get_name(){
        String name = "test_graph";
        Assert.assertEquals(name,graph.getName());
    }
    @Test
    public void test_bfs1(){
        Assert.assertEquals(graph.getNode(1), bfs1.end_list_node.get(1));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void test_bfs2(){
        Assert.assertEquals(graph.getNode(1), bfs2.end_list_node.get(1));
    }
    @Test
    public void test_dfs1(){
        Assert.assertEquals(graph.getNode(2), dfs1.nodes_where_stopped.get(0));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void test_dfs2(){
        Assert.assertEquals(graph.getNode(1), dfs2.nodes_where_stopped.get(1));
    }
    @Test
    public void test_bfs1_get_edge(){
        Assert.assertEquals(graph.getNode(1).getEdge(0).getFrom(),bfs1.end_list_edge.get(1).getFrom());
    }
    @Test
    public void test_dfs1_get_edge(){
        Assert.assertEquals(graph.getNode(1).getEdge(0).getFrom(),dfs1.end_list_edge.get(1).getFrom());
    }
}
