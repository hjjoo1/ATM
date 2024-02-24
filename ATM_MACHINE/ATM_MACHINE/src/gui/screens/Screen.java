package gui.screens;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Screen extends JPanel implements Runnable{
    private static final long serialVersionUID = 1L;
    final int DELAY = 10;
    Thread animation;
    private int color;
    private float R;
    private float G;
    private float B;
    private int xpos;
    private int ypos;
    public Screen() {
        setBackground(new Color(255,255,255));
        color = 0;
        xpos = 0;
        ypos = 0;
    }
    public void drawHeader(Graphics g, String text) {
        drawCenteredString(g, text, new Rectangle(getWidth(), getHeight()/3), new Font("TimesRoman", Font.PLAIN, 18));
    }
    public void drawSubtitle(Graphics g, String text) {
        drawCenteredString(g, text, new Rectangle(getWidth(), getHeight()/2), new Font("TimesRoman", Font.PLAIN, 10));
    }
    public void drawB1(Graphics g, String text) {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        g.drawString(text, 20, 60);
    }
    public void drawB2(Graphics g, String text) {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        g.drawString(text, 20, 185);
    }
    public void drawB4(Graphics g, String text) {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        g.drawString(text, 375, 60);
    }
    public void drawB6(Graphics g, String text) {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        g.drawString(text, 375, 305);
    }
    public void drawLoadingAnimation(Graphics g, int inc) {
        int width = 25;
        int height = 25;
        double speed = 0.01;
        for(int i = 0; i < 6; i ++) {
            R = (float) 0;
            G = (float) 0;
            B = (float) (127 * Math.sin(0.03*color) + 127)/255;
            g.setColor(new Color(R, G, B));
            width += 7;
            height += 7;
            xpos = (int) (alignHorizontal(width)+i*2*Math.cos(speed*color));
            ypos = (int) (i*2*Math.sin(speed*color)+getHeight()/2-height/2)+50;
            g.drawArc(xpos, ypos, width, height, 0+inc, 45+inc);
            color += 1;
            sync();
        }
    }
    public void drawIdleAnimation(Graphics g, int inc) {
    }
    public void keyFrame() {
    }
    private int alignHorizontal(int width) {
        int startPoint = (getWidth()-width)/2;
        return startPoint;
    }
    private void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setFont(font);
        g.drawString(text, x, y);
    }
    private void sync() {
        Toolkit.getDefaultToolkit().sync();
    }
    @Override    public void addNotify() {
        super.addNotify();
        animation = new Thread(this);
        animation.start();
    }
    @Override    public void run() {
        long timeBefore, timeDiff, sleep;
        timeBefore = System.currentTimeMillis();
        while(true) {
            keyFrame();
            repaint();
            timeDiff = System.currentTimeMillis() - timeBefore;
            sleep = DELAY- timeDiff;
            if(sleep < 0) {
                sleep =2;
            }
            try {
                Thread.sleep(sleep);
            }catch (Exception e){
                String errorMsg = String.format("Thead interrupted: %s", e.getMessage());
                JOptionPane.showMessageDialog(this, errorMsg, "Error", JOptionPane.ERROR_MESSAGE);
            }
            timeBefore = System.currentTimeMillis();
        }
    }
}