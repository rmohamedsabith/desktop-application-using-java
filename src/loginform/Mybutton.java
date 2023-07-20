package loginform;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Mybutton extends JButton {
    
   

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public Color getColorover() {
        return colorover;
    }

    public void setColorover(Color colorover) {
        this.colorover = colorover;
    }

    public Color getColorclick() {
        return colorclick;
    }

    public void setColorclick(Color colorclick) {
        this.colorclick = colorclick;
    }

    public Color getBordercolor() {
        return bordercolor;
    }

    public void setBordercolor(Color bordercolor) {
        this.bordercolor = bordercolor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
     public Mybutton(){
        //initial color
        setColor(Color.WHITE);
        colorover = new Color(39, 54, 128); 
        colorin = new Color(70, 97, 235);
        colorclick = new Color(26, 35, 82);
        bordercolor = new Color(5, 7, 15);
        setContentAreaFilled(false);
        
        //add mouse event
        addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseEntered(MouseEvent me){
                setBackground(colorover);
                over = true;
            }
            
            @Override
            public void mouseExited(MouseEvent me){
                setBackground(colorin);
                over = false;
            }
            
            @Override
            public void mousePressed(MouseEvent me){
                setBackground(colorclick);
            }
            
            @Override
            public void mouseReleased(MouseEvent me){
                if(over){
                    setBackground(colorover);
                }else{
                    setBackground(colorin);
                }
            }
        });
        
    }
     
     
    
    private boolean over;
    private Color color;
    private Color colorin;
    private Color colorover;
    private Color colorclick;
    private Color bordercolor;
    private int radius = 0;
    
    /**
     *
     * @param grphcs
     */
    @Override
    protected void paintComponent(Graphics grphcs){
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //paint border
        g2.setColor(bordercolor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        //Background  and border set 2 pix
        g2.setColor(getBackground());
        g2.fillRoundRect(2, 2, getWidth(), getHeight() - 4, radius, radius);
        super.paintComponent(grphcs);
    }
}

