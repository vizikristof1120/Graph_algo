import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    JButton graph_chooser, graph_editor;
    JPanel panel1, panel2, panel3;
    JLabel title;
    Menu(){
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.gray.darker());
        this.setSize(400,647);
        this.setResizable(false);

        panel1 = new JPanel();
        panel1.setBackground(Color.gray.darker());
        panel1.setBounds(0,100,400,247);

        panel2 = new JPanel();
        panel2.setBackground(Color.gray.darker());
        panel2.setBounds(0,400,400,200);

        panel3 = new JPanel();
        panel3.setBackground(Color.gray.darker());
        panel3.setBounds(0,500,400,200);

        title = new JLabel("GráFOS");
        title.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        title.setForeground(Color.BLACK);
        title.setBounds(0,100, getWidth(),getHeight());

        graph_chooser = new JButton("Graph chooser");
        graph_chooser.addActionListener(e -> System.out.println("choose"));
        graph_chooser.setFocusable(false);
        graph_chooser.setBounds(0,0,getWidth(),getHeight());

        graph_editor = new JButton("Graph editor");
        graph_editor.addActionListener(e -> new Graph_editor());
        graph_editor.setFocusable(false);
        graph_editor.setBounds(0,0,getWidth(),getHeight());

        panel1.add(title);
        panel2.add(graph_chooser);
        panel3.add(graph_editor);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        revalidate();
    }
}
