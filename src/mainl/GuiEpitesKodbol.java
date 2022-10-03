package mainl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GuiEpitesKodbol implements ActionListener{

    private JFrame frame;
    private JButton gomb;
    
    public GuiEpitesKodbol(){
        ini();
    }
    public void ini(){
        frame = new JFrame("Egyszerű GUI 1 gombbal");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gomb = new JButton("Klikk ide");
        gomb.addActionListener(this);
        
        frame.getContentPane().add(gomb);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        gomb.setText("rám kattintottál");
    }
    
    public static void main(String[] args) {
        /*OOP szemlélet*/
        new GuiEpitesKodbol();
        /* Spagetti kód
        JFrame frame = new JFrame("Egyszerű GUI 1 gombbal");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton gomb = new JButton("Klikk ide");
        gomb.addActionListener(this);
        
        frame.getContentPane().add(gomb);
        frame.setVisible(true);
        */
        
    }

    
}
