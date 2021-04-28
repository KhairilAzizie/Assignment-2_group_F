package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ItemProductController;
import controller.ItemProductManager;
import kioskapp.itemproduct.ItemProduct;
import kioskapp.ordereditem.OrderedItem;
import kioskapp.ordertransaction.OrderTransaction;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class kitchen extends JFrame {
	private JTextField textField_2 = new JTextField();
	public ItemProductManager prodManager= new ItemProductManager();
	public ItemProductController las = new ItemProductController();
	public kitchen() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Kitchen ( Customer Order )");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setBounds(220, 0, 307, 33);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(418, 150, 45, 13);
		getContentPane().add(lblNewLabel_6);
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_2.setBounds(23, 156, 595, 328);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("ORDER");
		lblNewLabel_7.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblNewLabel_7.setBounds(321, 93, 70, 22);
		getContentPane().add(lblNewLabel_7);
	}
	
	public void printOrderedItem(ArrayList<OrderedItem> orderItem ) {
        String text = "";
        for(int i = 0;i< orderItem.size(); i++) {
      
            ItemProduct itemProduct = new ItemProduct();
            itemProduct = prodManager.getProduct(i+1);
            
            for(OrderedItem os: orderItem) 
            {
            	text = "quantity" + os.getQuantity() + "\t" + las.getItemProductName(os.getItemID());
            	textField_2.setText(text);
            }
            
            }

        }
	

}
