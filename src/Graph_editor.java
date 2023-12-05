import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph_editor extends JFrame implements MouseListener {
    JPanel left, middle, right;
    JLabel jlabel;
    JButton save_graph;
    public Graph graph;
    Node from, to;
    Map<JButton, Node> node_map = new HashMap<>();
    int horizontal = 1280;
    int vertical = 720;
    static int counter = 0;
    int b1x, b1y, b2x, b2y;
    boolean paint= false;
    ArrayList<Line2D> lines = new ArrayList<>();


    /**
     * Constructs a new Graph Editor application window.
     * Prompts the user for a graph name using a dialog box.
     * Initializes the application window with left, middle, and right panels.
     * Provides functionality for saving the graph to a file.
     */
    public Graph_editor() {
        String graph_name = JOptionPane.showInputDialog("Graph name:");

        this.setLayout(null);

        this.setSize(horizontal, vertical);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.gray);

        graph = new Graph(graph_name);

        //left panel

        left = new JPanel();
        left.setBounds(0, 0, horizontal / 4, vertical);
        left.setBackground(Color.gray.darker());
        this.add(left);

        jlabel = new JLabel("Graph editor");
        jlabel.setFont(new Font("Arial", Font.PLAIN, 24));
        left.add(jlabel);

        save_graph = new JButton("Save Graph");
        save_graph.addActionListener(e -> graph.saveToFile());
        save_graph.setFocusable(false);
        left.add(save_graph);

        //middle panel

        middle = new JPanel();
        middle.setLayout(null);
        middle.setBounds(horizontal / 4, 0, horizontal / 2, vertical);
        middle.setBackground(Color.gray);
        middle.updateUI();
        middle.addMouseListener(this);
        this.add(middle);

        //right panel

        right = new JPanel();
        right.setBounds(horizontal / 4 * 3, 0, horizontal / 4, vertical);
        right.setBackground(Color.gray.darker());
        this.add(right);
    }

    /**
     * Invoked when the mouse button has been clicked (pressed and released) on the middle panel.
     * Adds a new node to the graph at the mouse click coordinates and displays it as a button.
     * Handles the creation of edges between nodes based on user interactions.
     *
     * @param e The MouseEvent containing information about the mouse click.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        //
        graph.addNode();

        JButton button_node = new JButton();
        button_node.setText(String.valueOf(graph.getNode(counter++).getId()));
        button_node.setFocusable(false);
        button_node.setLayout(null);
        button_node.setBounds(x-25, y-25, 50, 50);
        button_node.setBorder(new RoundedBorder(50));
        button_node.setBackground(Color.gray);

        node_map.put(button_node, graph.getNode(counter-1));

        button_node.addActionListener(e1 -> {
            if(from==null){
                from=node_map.get(button_node);
                b1x=button_node.getX();
                b1y=button_node.getY();
            } else if (from.equals(node_map.get(button_node))) {
                JOptionPane.showMessageDialog(null, "Self pointed edge is nor allowed");
                from=null;
                to=null;
            } else {
                to = node_map.get(button_node);
                double weight = Double.parseDouble(JOptionPane.showInputDialog("Weight:"));
                boolean directed = Boolean.parseBoolean(String.valueOf(JOptionPane.showConfirmDialog(null, "Directed?")));
                from.addEdge(to, weight, directed);
                b2x= button_node.getX();
                b2y= button_node.getY();
                from=null;
                to=null;
                paint=true;

                revalidate();

                //needed
                repaint();
                button_node.updateUI();
            }
        });
        middle.add(button_node);
        System.out.println("button added");
        middle.revalidate();
        middle.updateUI();
    }

    /**
     * Overrides the paint method to draw edges between nodes on the middle panel.
     * Draws lines connecting buttons representing nodes based on user interactions.
     *
     * @param g The Graphics context in which to paint.
     */
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(horizontal/4+b1x+25, b1y+50,horizontal/4+b2x+25, b2y+50);
        lines.add(lin);
        for (Line2D l :
                lines) {
            g2.draw(l);
        }
        b1x=b2x=b1y=b2y=0;
    }

    /**
     * Invoked when a mouse button is pressed on the middle panel.
     * (This method is intentionally left empty and has no specific functionality.)
     *
     * @param e The MouseEvent containing information about the mouse press.
     */
    @Override
    public void mousePressed(MouseEvent e) {}

    /**
     * Invoked when a mouse button is released on the middle panel.
     * (This method is intentionally left empty and has no specific functionality.)
     *
     * @param e The MouseEvent containing information about the mouse release.
     */
    @Override
    public void mouseReleased(MouseEvent e) {}

    /**
     * Invoked when the mouse enters the middle panel.
     * (This method is intentionally left empty and has no specific functionality.)
     *
     * @param e The MouseEvent containing information about the mouse entering.
     */
    @Override
    public void mouseEntered(MouseEvent e) {}

    /**
     * Invoked when the mouse exits the middle panel.
     * (This method is intentionally left empty and has no specific functionality.)
     *
     * @param e The MouseEvent containing information about the mouse exit.
     */
    @Override
    public void mouseExited(MouseEvent e) {}
}
