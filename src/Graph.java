import java.io.*;
import java.util.ArrayList;

public class Graph implements Serializable {
    private final ArrayList<Node> nodes;
    private final String name;
    private final boolean directed;
    Graph(String name, boolean directed){
        this.name=name;
        nodes=new ArrayList<>();
        this.directed=directed;
    }
//  addNode
    public void addNode(){
        nodes.add(new Node());
    }
//  getNode
    public Node getNode(int index){
        return nodes.get(index);
    }
//  getAllNodes
    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public String getName() {
        return name;
    }
    public void saveToFile(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(name + ".ser");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(this);
            outputStream.close();
            fileOutputStream.close();
        }catch (Exception e){
            //temporary system out
            //System.out.println("Write object failed");
            e.printStackTrace();
        }
    }
    /*public void loadFromFile(){
        try {
            FileInputStream fileInputStream = new FileInputStream(name+".ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            this = (Graph) objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
}
