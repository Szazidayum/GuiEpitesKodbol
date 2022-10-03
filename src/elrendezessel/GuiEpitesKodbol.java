package elrendezessel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

class RajzPanel extends JPanel{
    /*ALT + INSERT*/
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        /*körvonal*/
//        g.setColor(Color.red);
//        g.drawOval(50, 50, 100, 100);
        
        /*kitöltés 1 színnel*/
//        g.setColor(Color.CYAN);
        int piros = (int)(Math.random() * 255);
        int zold = (int)(Math.random() * 255);
        int kek = (int)(Math.random() * 255);
        Color kezdoSzin = new Color(piros, zold, kek);
//        g.setColor(szin);
//        g.fillOval(55, 55, 80, 80);
        
        /*színátmenet: gradiens*/
//        GradientPaint szinatmenet = new GradientPaint(50, 50, szin, 150, 150, szin);
        piros = (int)(Math.random() * 255);
        zold = (int)(Math.random() * 255);
        kek = (int)(Math.random() * 255);
        Color vegzoSzin = new Color(piros, zold, kek);
        GradientPaint szinatmenet = new GradientPaint(50, 50, kezdoSzin, 150, 150, vegzoSzin);
        
        /*Típus kényszerítés a "valódi" típusra*/
        Graphics2D g2d = (Graphics2D) g;
        
        /*gradiens használata*/
        g2d.setPaint(szinatmenet);
        g2d.fillOval(55, 55, 80, 80);
    }
   
    
}

public class GuiEpitesKodbol implements ActionListener{

    private JFrame frame;
    
    private JButton gomb;
    private JButton gomb2;
    
    public GuiEpitesKodbol(){
        ini();
    }
    public void ini(){
        frame = new JFrame("GUI elrendezéssel");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gomb = new JButton("Új kitöltés");
        gomb.addActionListener(this);
        
        gomb2 = new JButton("keret");
//        JLabel cimke = new JLabel("<html><p color='red'>Van</p> keret</html>");
        JLabel cimke = new JLabel("<html><p style='color:red;'>Van</p> keret</html>");
        
        RajzPanel panel = new RajzPanel();
        
//        Border keret = new TitledBorder("Kör");
//        panel.setBorder(keret);
        panel.setBorder(new TitledBorder("Kör"));
        
        frame.getContentPane().add(gomb, BorderLayout.SOUTH);
        frame.getContentPane().add(gomb2, BorderLayout.EAST);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.getContentPane().add(cimke, BorderLayout.WEST);
        
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        gomb.setText("rám kattintottál");
        
    }
    
    public static void main(String[] args) {
        /*OOP szemlélet*/
        new GuiEpitesKodbol();
        
        
    }

    
}
