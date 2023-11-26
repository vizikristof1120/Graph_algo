import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;



public class Menu extends JFrame implements MouseListener {
    //TODO if new graph then save this and create new
    //implemented
    JPanel left, middle, right;
    JLabel jlabel;
    JButton button1, b, save_graph;
    public Graph graph;
    Node from, to;
    Map<JButton, Node> nodemap = new HashMap<>();

    public Menu() {
        //TODO not menu but the graph designer
        String graph_name = JOptionPane.showInputDialog("Graph name:");

        int horizontal = 1280;
        int vertical = 720;

        this.setLayout(null);

        this.setSize(horizontal, vertical);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.gray);


        graph = new Graph(graph_name, false);

        //left panel

        left = new JPanel();
        left.setBounds(0, 0, horizontal / 4, vertical);
        left.setBackground(Color.gray.darker());
        this.add(left);

        jlabel = new JLabel("Graph editor");
        jlabel.setFont(new Font("Arial", Font.PLAIN, 24));
        left.add(jlabel);

        //tmp button
        button1 = new JButton("node");
        button1.addActionListener(e -> System.out.println("au ez faj"));//set enabled after action
        button1.setFocusable(false);//weird box around the text
        left.add(button1);
        save_graph = new JButton("Save Graph");
        save_graph.addActionListener(e -> graph.saveToFile());
        save_graph.setFocusable(false);
        left.add(save_graph);
        //this.dispose deletes this window


        //middle panel


        middle = new JPanel();
        middle.setLayout(null);
        middle.setBounds(horizontal / 4, 0, horizontal / 2, vertical);
        middle.setBackground(Color.gray);

        b = new JButton("in_middle");
        b.setLayout(null);
        b.setLocation(500, 530);
        b.setBounds(500, 530, 50, 50);
        b.setBorder(new RoundedBorder(50));
        b.setBackground(Color.gray);
        b.setFocusable(false);


        middle.add(b);
        middle.addMouseListener(this);
        this.add(middle);



        //right panel

        right = new JPanel();
        right.setBounds(horizontal / 4 * 3, 0, horizontal / 4, vertical);
        right.setBackground(Color.gray.darker());
        this.add(right);


        //this.pack();//resize to fit everything
    }
    static int counter = 0;

    //we just need this
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        //
        graph.addNode();

        JButton node = new JButton();
        node.setText(String.valueOf(graph.getNode(counter++).getId()));
        node.setFocusable(false);
        node.setLayout(null);
        node.setBounds(x-25, y-25, 50, 50);
        node.setBorder(new RoundedBorder(50));
        node.setBackground(Color.gray);
        //like the buttons are one object!!!
        //always just the last one exists
        //maybe a list solves that

        nodemap.put(node, graph.getNode(counter-1));

        node.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(counter-1);
                if(from==null){
                    from=graph.getNode(counter-1);
                } else if (from.equals(graph.getNode(counter-1))) {
                    JOptionPane.showMessageDialog(null, "Self pointed edge is nor allowed");
                    from=null;
                    to=null;
                } else {
                    to = graph.getNode(counter-1);
                    double weight = Double.parseDouble(JOptionPane.showInputDialog("Weight:"));
                    boolean directed = Boolean.parseBoolean(String.valueOf(JOptionPane.showConfirmDialog(null, "Directed?")));
                    from.addEdge(to, weight, directed);
                    from=null;
                    to=null;
                }
            }

        });
        middle.add(node);
        System.out.println("button added");
        middle.revalidate();


    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {
        //this.validate();
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
