package lab123;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main extends JFrame {
    public Main(int utc) {
    	setTitle("Simple Clock");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JButton btton = new JButton("Update Time");
        JTextField jtf = new JTextField();
        jtf.setPreferredSize(new Dimension(60, 30));
        JPanel pnclk = new JPanel();
        JPanel jpnd = new JPanel();
        jpnd.add(jtf, BorderLayout.EAST);
        jpnd.add(btton);
        clock clock = new clock();
        pnclk.add(clock);
        jpnd.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 30));
        this.add(pnclk);
        this.add(jpnd);
        this.setLayout(new GridLayout(2, 1));
        clock.Start(utc);
        
        btton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String st = jtf.getText();
                int newUtc = Integer.parseInt(st);
                new Main(newUtc);
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new Main(7);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }
}
   
  
