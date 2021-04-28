package orderServer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import java.io.*;
import java.net.*;

public class server1 extends JFrame {
		
	private JPanel contentPane;
	private JLabel lblNewLabel = new JLabel("");
	private JTextArea textArea = new JTextArea();
	
	public server1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textArea.setBounds(76, 136, 526, 245);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Order Server");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(155, 39, 323, 50);
		contentPane.add(lblNewLabel);
		
		
	}
	
//	public void setText(String word)
//	{
//		textArea.setText(textArea.getText()+ "->"+word+"\n");
//	}
	
	public void updateRequestStatus (String status) {
		
		// Get current status displayed on the window
		String currentText = this.textArea.getText();
		textArea.setEditable(true);
		
		// Display the latest status on top
		status += "\n > " + currentText;
		this.textArea.setText(status);
		textArea.setEditable(false);
	}
	
}
