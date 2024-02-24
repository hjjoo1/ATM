
package gui.screens;
import java.awt.Graphics;
public class MainMenu extends Screen{
    private static final long serialVersionUID = 1L;
    public MainMenu() {
        super();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawHeader(g, "Main Menu");
        drawB1(g, "Withdraw");
        drawB2(g, "Check Balance");
        drawB4(g, "Deposit");
        drawB6(g, "Log Out");
    }
}