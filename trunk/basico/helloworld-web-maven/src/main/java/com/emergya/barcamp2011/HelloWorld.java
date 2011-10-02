/* 
 * HelloWorld.java
 * 
 * Copyright (C) 2011
 * 
 * This file is part of barcamp2011-charlamaven
 * 
 * This software is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *
 * As a special exception, if you link this library with other files to
 * produce an executable, this library does not by itself cause the
 * resulting executable to be covered by the GNU General Public License.
 * This exception does not however invalidate any other reasons why the
 * executable file might be covered by the GNU General Public License.
 * 
 * Authors:: Alejandro Díaz Torres (mailto:adiaz@emergya.com)
 */
package com.emergya.barcamp2011;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Only shows a JPanel with text field and sho it console
 * 
 * @author <a href="mailto:adiaz@emergya.com">Alejandro Diat Torres</a>
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
	 * Shows JPanel 
	 * 
	 * @return the text field value
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
