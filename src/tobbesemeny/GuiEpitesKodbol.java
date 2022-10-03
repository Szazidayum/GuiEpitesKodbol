package tobbesemeny;

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

//public class GuiEpitesKodbol implements ActionListener{
/*most már 2 ActionListener van*/
        public class GuiEpitesKodbol{

    private JFrame frame;
    private JButton btnKitoltes, btnKeret;
    private RajzPanel panel;
    private JLabel cimke;
    
    public GuiEpitesKodbol(){
        ini();
    }
    public void ini(){
        frame = new JFrame("GUI elrendezéssel");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnKitoltes = new JButton("Új kitöltés");
        btnKitoltes.addActionListener(this);
        
        /*ctrl + r => mindet átnevezi*/
        btnKeret = new JButton("keret");
        btnKeret.addActionListener(this);
        
//        JLabel cimke = new JLabel("<html><p color='red'>Van</p> keret</html>");
        cimke = new JLabel("<html><p style='color:red;'>Van</p> keret</html>");
        
        panel = new RajzPanel();
        
//        Border keret = new TitledBorder("Kör");
//        panel.setBorder(keret);
        panel.setBorder(new TitledBorder("Kör"));
        
        frame.getContentPane().add(btnKitoltes, BorderLayout.SOUTH);
        frame.getContentPane().add(btnKeret, BorderLayout.EAST);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.getContentPane().add(cimke, BorderLayout.WEST);
        
        frame.setVisible(true);
    }
    
    /*KOMOLY HIBÁK:
    1. metódus több dolgot csinál
    2. az else az mikor is fut le?
    3. nem végezhető csoportban a 2 gomb kódjának írása*/
    
//    @Override
//    public void actionPerformed(ActionEvent e) {
////        gomb.setText("rám kattintottál");
////        frame.repaint();
//        if(e.getSource() == btnKitoltes){
//            frame.repaint();
//        }else{
////            TitledBorder tb = new TitledBorder("Kör");
////            Border b = panel.getBorder() instanceof TitledBorder ? tb : null;
////            panel.setBorder(b);
//            
//            String s = "<html><p style='color:red;'>";
//            if(panel.getBorder() instanceof TitledBorder){
//                panel.setBorder(null);
//            }else{
//                panel.setBorder(new TitledBorder("Kör"));
//                s += "Van";
//            }
//            s += "</p> keret</html>";
//            cimke.setText(s);
//            
//        }
//    }
    
    /*belső osztály a kitöltés gomb kattintás figyelésére*/
    class KitoltesListener implements ActionListener{
        @Override
    public void actionPerformed(ActionEvent e) {
//        gomb.setText("rám kattintottál");
//        frame.repaint();
        
            frame.repaint();
    
        
    }
    }
    class KeretListener implements ActionListener{
        @Override
    public void actionPerformed(ActionEvent e) {
        String s = "<html><p style='color:red;'>";
            if(panel.getBorder() instanceof TitledBorder){
                panel.setBorder(null);
            }else{
                panel.setBorder(new TitledBorder("Kör"));
                s += "Van";
            }
            s += "</p> keret</html>";
            cimke.setText(s);
            
        }
    }
    
    public static void main(String[] args) {
        /*OOP szemlélet*/
        new GuiEpitesKodbol();
        
        
    }

    
    }
