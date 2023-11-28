import java.io.*;
import java.util.ArrayList;

public class Graph implements Serializable {
    private final ArrayList<Node> nodes;
    private final String name;

    /**
     * Constructs a new graph with the specified name and an empty list of nodes.
     *
     * @param name The name of the graph.
     */
    Graph(String name){
        this.name=name;
        nodes=new ArrayList<>();
    }

//  addNode
    /**
     * Adds a new node to the graph.
     */
    public void addNode(){
        nodes.add(new Node());
    }

//  getNode
    /**
     * Retrieves the node at the specified index from the list of nodes in the graph.
     *
     * @param index The index of the node to retrieve.
     * @return The node at the specified index.
     * @throws IndexOutOfBoundsException If the index is out of range (index < 0 || index >= size()).
     */
    public Node getNode(int index){
        return nodes.get(index);
    }

//  getAllNodes
    /**
     * Retrieves the list of nodes in the graph.
     *
     * @return The list of nodes in the graph.
     */
    public ArrayList<Node> getNodes() {
        return nodes;
    }

    /**
     * Retrieves the name of the graph.
     *
     * @return The name of the graph.
     */
    public String getName() {
        return name;
    }

    /**
     * Saves the current graph instance to a serialized file with the graph's name as the filename.
     * The file is saved with the ".ser" extension.
     * If an error occurs during the saving process, the exception is printed to the standard error stream.
     */
    public void saveToFile(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(name + ".ser");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(this);
            outputStream.close();
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
