package gui.modules;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
public class NumberPad extends JFrame implements NumpadButtons{
    private static final long serialVersionUID = 1L;
    private String enteredNumber = "";
    public NumberPad() {
        super();
        populateNumpad();
    }
    private void populateNumpad() {
        //Setup Buttons & Populate Layout       
    	for(int i = 0; i < numButtons.length; i++) {
            numButtons[i] = new JButton(buttonNames[i]);
        }
    }
    public void toggleNumpad(boolean toggle) {
        if(toggle) {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize((int) (Constants.LENGTH*0.6), Constants.WIDTH);
            setLocation(Constants.X_POS+Constants.LENGTH, Constants.Y_POS);
            setResizable(false);
            populateNumpad();
            JPanel numPanel = new JPanel();
            numPanel.setBorder(new TitledBorder("Numberpad"));
            numPanel.setLayout(new GridLayout(5,3,5,5));
            //Add Buttons            
            for(JButton button : numButtons) {
                numPanel.add(button);
            }
            //Colors for bottom row            
            numButtons[12].setBackground(Color.RED);
            numButtons[13].setBackground(Color.YELLOW);
            numButtons[14].setBackground(Color.GREEN);
            setListeners();
            getContentPane().add(numPanel);
            setVisible(true);
        }else{
            setVisible(false);
            dispose();
        }
    }
    private void setListeners() {
        //NumberPad Buttons        
    	for(int i = 0; i < numButtons.length; i++) {
            numButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String input = e.paramString().substring(e.paramString().indexOf('=')+1,e.paramString().indexOf(",when"));
                    System.out.println("NUM: " + input);
                    if(input.equals("Enter")) {
                        getNumber();
                        enteredNumber = "";
                    }else if (input.equals("X")) {
                        enteredNumber = "";
                        System.out.println(enteredNumber);
                    }else {
                        enteredNumber += input;
                        System.out.println(enteredNumber);
                    }
                }
            });
        }
    }
    public String getNumber() {
        String returnNumber = enteredNumber;
        System.out.println(enteredNumber);
        return returnNumber;
    }
}
