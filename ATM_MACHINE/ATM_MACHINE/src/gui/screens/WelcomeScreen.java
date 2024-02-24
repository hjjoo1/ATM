package gui.screens;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

//screen for welcome
public class WelcomeScreen extends Screen {
	int inc = 5;
	private static final long serialVersionUID = 1L;
	public WelcomeScreen() {
		super();
	}
	@Override
	public void keyFrame() {
		inc = inc + 2;
	}
	//paints welcome screen
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//welcome title
		drawHeader(g, "Welcome");
		//subtitle
		drawSubtitle(g, "Please Insert Card To Begin");
		//drawing animation for screen
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g2.setPaintMode();
		drawIdleAnimation(g2, inc);
	}
}
