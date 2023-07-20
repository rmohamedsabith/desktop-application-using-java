/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author User
 */
public class buttonGradient extends JButton{

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    
    private Color color1=Color.decode("#0099F7");
    private Color color2=Color.decode("#F11712");
    private final Timer timer;
    private final Timer timePressed;
    private float alpha =0.3f;
    private boolean mouseOver;
    private boolean pressed;
    private Point pressedLocation;
    private float pressedSize;
    private float sizeSpeed=20f;
    private float alphapressed =0.5f;
    
    public buttonGradient(){
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBorder(new EmptyBorder(10,20,10,20));
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me)
                {
                   mouseOver=true;
                   timer.start();
                }
            @Override
            public void mouseExited(MouseEvent me)
                {
                   mouseOver=false;
                   timer.start();
                }
            @Override
            public void mousePressed(MouseEvent me)
                {
                   pressedSize=0;
                   alphapressed=0.5f;
                   pressed=true;
                   pressedLocation=me.getPoint();
                   timePressed.setDelay(0);
                   timePressed.start();
                }

            
        });
        
        timer =new Timer(40,new ActionListener()
                {
                
                @Override
                public void actionPerformed(ActionEvent ae){
                        if(mouseOver)
                {
                    if(alpha<0.6f){
                        alpha+=0.05f;
                        repaint();
                    }
                    else{
                        alpha=0.6f;
                        timer.stop();
                        repaint();
                    }
                }else{
                            if(alpha >0.3f)
                                {
                                    alpha-=0.05f;
                                    repaint();
                                }else{
                                    alpha=0.03f;
                                    timer.stop();
                                    repaint();
                            }
                        }
                    }
                });
        
        timePressed=new Timer(0,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pressedSize +=sizeSpeed;
                if(alphapressed <= 0)
                 {
                     pressed=false;
                     timePressed.stop();
                 }else{
                    repaint();
                }
            }
        });
         
            
    }

    @Override
    protected void paintComponent(Graphics grphc) { 
        int width=getWidth();
        int height=getHeight();
        BufferedImage img= new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2=img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
        
        //create gradients Color
        GradientPaint gra =new GradientPaint(0,0,color1,width,0,color2);
        g2.setPaint(gra);
        g2.fillRoundRect(0, 0, width, height, height, height);
        
        //Add Style
         createStyle(g2);
         if(pressed)
         {
             paintPressed(g2);
         }
         g2.dispose();
        grphc.drawImage(img,0,0, null);           
        
        super.paintComponent(grphc); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void createStyle(Graphics2D g2)
    {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,alpha ));
        int width =getWidth();
        int height =getHeight();
        GradientPaint gra=new GradientPaint(0,0,Color.WHITE,0,height,new Color(255,255,255,60));
        g2.setPaint(gra);
        Path2D.Float f=new Path2D.Float();
        f.moveTo(0, 0);
        int control1=height + height/2;
        f.curveTo(0,0,width/2,control1,width,0);
        g2.fill(f);
    }
    
    private void paintPressed(Graphics2D g2)
    {
        if((pressedLocation.x-(pressedSize/2)) < 0 && pressedLocation.x +(pressedSize/2) >getWidth())
        {
            timePressed.setDelay(20);
            alphapressed-=0.05f;
            if(alphapressed<0){
                alphapressed=0;
            }
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,alphapressed  ));
        g2.setColor(Color.WHITE);
        float x=pressedLocation.x-(pressedSize/2);
        float y=pressedLocation.y-(pressedSize/2);
        g2.fillOval((int)x,(int)y,(int)pressedSize,(int)pressedSize);
    }
}
