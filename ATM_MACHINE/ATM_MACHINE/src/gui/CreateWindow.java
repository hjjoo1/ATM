package gui;
import java.awt.BorderLayout;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import gui.modules.Constants;
import gui.modules.HintTextField;
import gui.screens.CardInserted;
import gui.screens.CardVerified;
import gui.screens.InvalidCard;
import gui.screens.MainMenu;
import gui.screens.WelcomeScreen;
import controller.MainMenuController;
import controller.VerifyCard;

//createWindow function for GUI
public class CreateWindow extends GUIController{
    private static final long serialVersionUID = 1L;
    private boolean toggle = false;
    private boolean start = false;
    GUIController menuControl;
    public CreateWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		//setBounds(0, 0, LENGTH, WIDTH);        
		setSize(Constants.LENGTH, Constants.WIDTH);
        setLocation(Constants.X_POS, Constants.Y_POS);
        setResizable(false);
        //Main Window        
		JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new TitledBorder("ATM MACHINE"));
        mainPanel.setLayout(new BorderLayout());
        //Left Controls        
		JPanel buttonsLeft = new JPanel();
        buttonsLeft.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonsLeft.setLayout(new GridLayout(3,0));
        buttonsLeft.add(btn1);
        buttonsLeft.add(btn2);
        buttonsLeft.add(btn3);
        mainPanel.add(buttonsLeft, BorderLayout.LINE_START);
        //Center Display        
		centerDisplay = new JPanel();
        centerDisplay.setLayout(new CardLayout(5,5));
        //----  Display Screen at Center ----//        
		WelcomeScreen welcomeScreen = new WelcomeScreen();
        centerDisplay.add(welcomeScreen);
        //----                          ----//        
		mainPanel.add(centerDisplay, BorderLayout.CENTER);
        //Right Controls        
		JPanel buttonsRight = new JPanel();
        buttonsRight.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonsRight.setLayout(new GridLayout(3,0));
        buttonsRight.add(btn4);
        buttonsRight.add(btn5);
        buttonsRight.add(btn6);
        mainPanel.add(buttonsRight, BorderLayout.LINE_END);
        //Card Input        
		JPanel cardInsert = new JPanel();
        cardInsert.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Card Insert", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 51, 51)));
        cardInsert.setLayout(new GridLayout(2,3));
        JTextField cardNumber = new HintTextField("Card Number");
        JTextField expDate = new HintTextField("Exp Date");
        JTextField csv = new HintTextField("CSV");
        JButton toggleNumpad = new JButton("Toggle Numpad");
        JButton insertButton = new JButton("Insert Card");
        cardInsert.add(cardNumber);
        cardInsert.add(expDate);
        cardInsert.add(csv);
        cardInsert.add(new JSeparator());
        cardInsert.add(insertButton);
        cardInsert.add(toggleNumpad);
        mainPanel.add(cardInsert, BorderLayout.PAGE_END);
        getContentPane().add(mainPanel);
        setVisible(true);
        //Toggle Number Pad        
		toggleNumpad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toggle = !toggle;
                numberPad.toggleNumpad(toggle);
             }
        });
        //Insert Card Button        
		insertButton.addActionListener(new ActionListener() {
			
	            public void actionPerformed(ActionEvent e) {
	            	if(start == false) {
	                String cNumber = cardNumber.getText();
	                String cDate = expDate.getText();
	                String cSv = csv.getText();
	                System.out.println(cNumber + " : " + cDate + " : " + cSv);
	                //Change the screen                
	                CardInserted insertedScreen = new CardInserted();
	                centerDisplay.add(insertedScreen);
	                CardLayout cardLayout = (CardLayout) centerDisplay.getLayout();
	                cardLayout.next(centerDisplay);
	                //Implement Timer to make it look like the program is taking time to load                 
					 verifyTimer = new Timer(2500, new ActionListener() {
	                      @Override                      
						  public void actionPerformed(ActionEvent evt) {
	                        //Send card info to another class here                            
							VerifyCard isVerified = new VerifyCard(cNumber, cDate, cSv);
	                            if(isVerified.verified()) {
	                                CardVerified vardVerified = new CardVerified();
	                                centerDisplay.add(vardVerified);
	                                CardLayout cardLayout = (CardLayout) centerDisplay.getLayout();
	                                cardLayout.next(centerDisplay);
	                                loadMainTimer = new Timer(1000, new ActionListener() {
	                                    @Override                                    
	                                    public void actionPerformed(ActionEvent e) {
	                                        MainMenu menuScreen = new MainMenu();
	                                        centerDisplay.add(menuScreen);
	                                        CardLayout cardLayout = (CardLayout) centerDisplay.getLayout();
	                                        cardLayout.next(centerDisplay);
	                                        menuControl = new MainMenuController(cNumber, cDate, cSv,isVerified.getdb());
	                                        loadMainTimer.stop();
	                                        return;
	                                    }
	                                });
	                                loadMainTimer.start();
	                                verifyTimer.stop();
	                                return;
	                            }else {
	                                InvalidCard invalidCard = new InvalidCard();
	                                centerDisplay.add(invalidCard);
	                                CardLayout cardLayout = (CardLayout) centerDisplay.getLayout();
	                                cardLayout.next(centerDisplay);
	                                verifyTimer.stop();
	                                return;
	                            }
	                      }
	                  });
	                  verifyTimer.start();
	            }
	            }
	        });
		
	   }
    public void backToStart(){
    	WelcomeScreen welcomeScreen = new WelcomeScreen();
        centerDisplay.add(welcomeScreen);
        CardLayout cardLayout = (CardLayout) GUIController.centerDisplay.getLayout();
		cardLayout.next(GUIController.centerDisplay);
		menuControl = null;
    	start = false;
    	return;
    }
}