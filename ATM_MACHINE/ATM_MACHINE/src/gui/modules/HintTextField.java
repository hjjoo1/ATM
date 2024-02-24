package gui.modules;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class HintTextField extends JTextField implements FocusListener {

	  private static final long serialVersionUID = 1L;
	private final String hint;
	  private boolean showHint;

	  public HintTextField(final String hint) {
	    super(hint);
	    this.hint = hint;
	    this.showHint = true;
	    super.addFocusListener(this);
	  }

	  @Override
	  public void focusGained(FocusEvent e) {
	    if(this.getText().isEmpty()) {
	      super.setText("");
	      showHint = false;
	    }
	  }
	  @Override
	  public void focusLost(FocusEvent e) {
	    if(this.getText().isEmpty()) {
	      super.setText(hint);
	      showHint = true;
	    }
	  }

	  @Override
	  public String getText() {
		  if(showHint) {
			  return "";
		  }
		  return super.getText();
	  }
	}

