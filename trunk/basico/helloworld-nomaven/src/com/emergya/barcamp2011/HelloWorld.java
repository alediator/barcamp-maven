/**
 * 
 */
package com.emergya.barcamp2011;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author adiaz
 *
 */
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name = showHello();
		System.out.println(name);
	}

	/**
	 * @param args
	 */
	public static String showHello() {
		JTextField jtf = new JTextField(10);
		JPanel panel = new JPanel();
		panel.add(new JLabel("Hello..."));
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.add(new JLabel(" "));
		panel.add(jtf);
		int res= JOptionPane.showConfirmDialog(
				null,
				panel,
				"name",
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null);
		if (res==JOptionPane.OK_OPTION) return new String(jtf.getText());
		return null;
	}

}
