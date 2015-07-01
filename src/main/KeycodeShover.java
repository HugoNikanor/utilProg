package main;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.KeyListener; 
import java.awt.event.KeyEvent; 

class KeycodeShower {
	JFrame frame;
	JPanel panel;
	JLabel label;
	int keycode;
	String dispString;
	BtnListener listener;


	KeycodeShower() {
		keycode = 0;
		dispString = "Keycode: \n #" + keycode;
		
		frame = new JFrame("keycode");
		panel = new JPanel();
		label = new JLabel(dispString);
		
		listener = new BtnListener();

		panel.add(label);
		frame.add(panel);
		frame.addKeyListener(listener);

		frame.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		frame.repaint();

	}

	/*
	 * This should possibly have some form of error handling.
	 */
	void setDispString() {
		try {
			dispString = dispString.substring(0, dispString.indexOf('#') + 1) + keycode;
			label.setText(dispString);
			frame.repaint();
		} catch (Exception e) {
			System.out.println("there was an error: main.KeycodeShover.setDispString();");
		}
	}

	class BtnListener implements KeyListener{
		@Override	
		public void keyPressed(KeyEvent keyEvent) {
			keycode = keyEvent.getKeyCode();
			setDispString();
		}
		@Override
		public void keyReleased(KeyEvent keyEvent) {	}
		@Override
		public void keyTyped(KeyEvent keyEvent) {	}

	}

}
