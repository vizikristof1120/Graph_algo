import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Graph_chooser extends JFrame {
    JPanel left, middle, right;
    JFileChooser fileChooser;
    JButton bfs, dfs, select_file;
    int horizontal = 1280;
    int vertical = 720;
    Graph graph;
    BFS bfs_algorithm;
    DFS dfs_algorithm;
    ArrayList<Edge> extended_bfs = new ArrayList<>();
    ArrayList<Edge> extended_dfs = new ArrayList<>();

    /**
     * Constructs a new Graph Chooser application window.
     * Provides functionality for selecting a file, loading a graph from the selected file,
     * and initiating BFS or DFS algorithms on the loaded graph.
     */
    Graph_chooser() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.gray);
        this.setSize(horizontal, vertical);
        this.setLayout(null);

        left = new JPanel();
        left.setBounds(0, 0, horizontal / 4, vertical);
        left.setBackground(Color.gray.darker());
        this.add(left);

        select_file = new JButton("Select file");
        select_file.addActionListener(e -> {
            fileChooser = new JFileChooser("C:/Users/vizik/IdeaProjects/Graph_algo");
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                graph = Main.loadFromFile(fileChooser.getSelectedFile().getAbsolutePath());
            }
            repaint();
            revalidate();
        });
        left.add(select_file);

        middle = new JPanel();
        middle.setLayout(null);
        middle.setBounds(horizontal / 4, 0, horizontal / 2, vertical);
        middle.setBackground(Color.gray);
        this.add(middle);

        right = new JPanel();
        right.setBounds((horizontal / 4) * 3, 0, horizontal / 4, vertical);
        right.setBackground(Color.gray.darker());
        this.add(right);

        bfs = new JButton("BFS");
        bfs.addActionListener(e -> {
            if (graph == null) {
                JOptionPane.showMessageDialog(null, "Select Graph first!");
            } else {
                int start_node_id = Integer.parseInt(JOptionPane.showInputDialog("Starting node's id"));
                bfs_algorithm = new BFS(graph.getNode(start_node_id));
                repaint();
            }
        });
        right.add(bfs);

        dfs = new JButton("DFS");
        dfs.addActionListener(e -> {
            if (graph == null) {
                JOptionPane.showMessageDialog(null, "Select Graph first!");
            } else {
                int start_node_id = Integer.parseInt(JOptionPane.showInputDialog("Starting node's id"));
                dfs_algorithm = new DFS(graph.getNode(start_node_id));
                repaint();
            }
        });
        right.add(dfs);
    }

    /**
     * Overrides the paint method to draw nodes and edges on the middle panel.
     * Draws circles for nodes and lines for edges based on the provided graph.
     * Optionally highlights edges based on BFS or DFS algorithms.
     *
     * @param g The Graphics context in which to paint.
     */
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        if (graph != null) {
            int n = graph.getNodes().size();

            for (int i = 0; i < n; i++) {
                Ellipse2D.Float v = new Ellipse2D.Float((int) (600 + 230 * Math.cos(2 * i * Math.PI / n)) - 15,
                        (int) (400 + 230 * Math.sin(2 * i * Math.PI / n)) - 15, 20, 20);
                g2.draw(v);
                g2.fill(v);
            }
            if(bfs_algorithm!=null) {
                extended_bfs.addAll(bfs_algorithm.end_list_edge);
                for (Edge edge :
                        bfs_algorithm.end_list_edge) {
                    extended_bfs.add(edge.getTo().getEdge(edge.getFrom()));
                }
            }
            if(dfs_algorithm!=null) {
                extended_dfs.addAll(dfs_algorithm.end_list_edge);
                for (Edge edge :
                        dfs_algorithm.end_list_edge) {
                    extended_dfs.add(edge.getTo().getEdge(edge.getFrom()));
                }
            }
            for (Node node : graph.getNodes()) {
                int from = node.getId();
                for (Edge edge : node.getEdges()) {
                    int to = edge.getTo().getId();
                    drawThisLine(g2, n, from, to, Color.black);

                    if (bfs_algorithm != null) {
                        if (extended_bfs.contains(edge)) {
                            drawThisLine(g2, n, from, to, Color.blue);
                            drawThisLine(g2, n, to, from, Color.blue);
                        }
                    }
                    if (dfs_algorithm != null) {
                        if (extended_dfs.contains(edge)) {
                            drawThisLine(g2, n, from, to, Color.red);
                            drawThisLine(g2, n, to, from, Color.red);
                        }
                    }
                }
            }
        }
        bfs_algorithm = null;
        dfs_algorithm = null;
    }

    /**
     * Draws a line connecting two nodes on the middle panel based on their respective indices.
     *
     * @param g2   The Graphics2D context in which to draw the line.
     * @param n    The total number of nodes in the graph.
     * @param from The index of the starting node.
     * @param to   The index of the ending node.
     */
    private void drawThisLine(Graphics2D g2, int n, int from, int to, Color color) {

        g2.setColor(color);
        //System.out.println(from + " / " + to + " ////" + color);

        g2.drawLine((int) (600 + 230 * Math.cos(2 * from * Math.PI / n)), (int) (400 + 230 * Math.sin(2 * from * Math.PI / n)),
                (int) (600 + 230 * Math.cos(2 * to * Math.PI / n)), (int) (400 + 230 * Math.sin(2 * to * Math.PI / n)));
        g2.setColor(Color.BLACK);
    }
}
