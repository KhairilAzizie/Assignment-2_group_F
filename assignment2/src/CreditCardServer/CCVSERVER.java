package CreditCardServer;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import orderServer.server1;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class CCVSERVER extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea = new JTextArea();
	
	/**
	 * Create the frame.
	 */
	public CCVSERVER() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Credit Card Validation Server");
		lblNewLabel.setBounds(153, 31, 200, 14);
		contentPane.add(lblNewLabel);
		
		textArea.setBounds(10, 56, 414, 194);
		contentPane.add(textArea);
	}
	
	public void setText(String word)
	{
		textArea.setText(textArea.getText()+ "->"+word+"\n");
	}

	public void updateRequest(String status) {
		
		// Get current status displayed on the window
				String currentText = this.textArea.getText();
				textArea.setEditable(true);
				
				// Display the latest status on top
				status += "\n > " + currentText;
				this.textArea.setText(status);
				textArea.setEditable(false);
		
	}

}