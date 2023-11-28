import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {
        new Menu();
    }

    /**
     * Loads a graph instance from a serialized file with the specified name.
     *
     * @param name The name of the serialized file (including the ".ser" extension).
     * @return The loaded graph instance, or null if an error occurs during the loading process.
     */
    public static Graph loadFromFile(String name){
        Graph graph;
        try {
            FileInputStream fileInputStream = new FileInputStream(name);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            graph = (Graph) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
            return graph;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}