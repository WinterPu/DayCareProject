package edu.dgp.java2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutFocusTraversalPolicy;

public class ChangeCase {

	public ChangeCase() {
		JFrame frame = new JFrame();
		
		// exit program, don't just hide window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);	// width,height
		
		// create text field for data entry
		JTextField textField = new JTextField("Enter Text");
		textField.setBounds(275,25, 200,40);	// x,y,width,height
		frame.add(textField);
		
		// create text area (in scroll pane) for data display
		JTextArea textArea = new JTextArea("", 5, 20);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(25, 100, 300, 200);	// x,y,width,height
		frame.add(scrollPane);
		
		// create buttons
		JButton b1 = new JButton("UpperCase");
		b1.setBounds(25, 25, 100, 40);	// x,y,width,height
		b1.addActionListener( (ActionEvent e) -> textArea.setText((textField.getText().toUpperCase())) );
		frame.add(b1);// adding button on frame
		
		JButton b2 = new JButton("LowerCase");
		b2.setBounds(150, 25, 100, 40);	// x,y,width,height
		b2.addActionListener( (ActionEvent e) -> textArea.setText((textField.getText().toLowerCase())) );
		frame.add(b2);// adding button on frame

//		b2.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				textArea.setText(textField.getText().toUpperCase());
//			}
//		});
		
		frame.setLayout(null);	// no layout manager
//		frame.setLayout(new FlowLayout());	// flow by order added to top level container
//		frame.setLayout(new BorderLayout(10, 20));	// hgap,vgap
//		frame.setLayout(new CardLayout(10,  20));	// hgap,vgap
//		frame.setLayout(new GridLayout(2, 3, 10, 20));	// rows,cols,hgap,vgap
//		frame.setLayout(new GridBagLayout());
		
		frame.setVisible(true);	// done last
	}

	public static void demo() {
		// instantiate object to display form
		new ChangeCase();
	}

}