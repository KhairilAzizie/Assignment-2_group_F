package gui;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kioskapp.itemproduct.ItemProduct;
import kioskapp.ordereditem.OrderedItem;
import controller.ItemProductManager;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import kioskapp.ordertransaction.OrderTransaction;
import javax.swing.JOptionPane;


public class Home extends JFrame {

	
	private JPanel contentPane;
	private boolean item[] = {false,false,false,false,false,false,false,false,false,false,false,false,false};
	private float price[] = {8.10f,11.90f,30.20f,11.90f,9.40f,9.45f,10.40f,8.45f,13.20f,13.20f,13.00f,4.15f,4.15f};
	//full harga satu item * quantity
	private float total[]= {0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f};
	private int quantity[]= {0,0,0,0,0,0,0,0,0,0,0,0,0};
	private JTextField creditcard = new JTextField();
	//total fullkprice
	private float fulltotal;
	private JTextArea textAreaL = new JTextArea();
	private JLabel newtotal = new JLabel();
	private boolean transactionStatus;
	public ItemProductManager prodManager= new ItemProductManager();
	private OrderTransaction orderTransaction;
	public OrderedItem orderItem = new OrderedItem();
	ArrayList<OrderedItem> orderItems = new ArrayList<OrderedItem>();
	//private String creditCard_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public OrderTransaction getOrderTransaction() {
		return this.orderTransaction;
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1026, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setEnabled(false);
		tabbedPane.setBackground(SystemColor.info);
		tabbedPane.setBounds(0, 0, 1019, 761);
		contentPane.add(tabbedPane);
		
		JPanel panel_home = new JPanel();
		panel_home.setLayout(null);
		tabbedPane.addTab(" Home ", null, panel_home, null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Home.class.getResource("/img/mcd.png")));
		logo.setBounds(283, 29, 286, 232);
		panel_home.add(logo);
		
		JLabel lblNewLabel = new JLabel("WHERE WILL YOU BE EATING TODAY?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel.setBounds(111, 263, 630, 111);
		panel_home.add(lblNewLabel);
		
		JButton eat_in = new JButton("EAT IN");
		eat_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			
			}
		});
		eat_in.setBorderPainted(false);
		eat_in.setBackground(new Color(255, 204, 102));
		eat_in.setBounds(111, 627, 286, 44);
		panel_home.add(eat_in);
		
		JButton take_away = new JButton("TAKE AWAY");
		take_away.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			
			}
		});
		take_away.setBorderPainted(false);
		take_away.setBackground(new Color(255, 204, 102));
		take_away.setAutoscrolls(true);
		take_away.setBounds(500, 627, 286, 44);
		panel_home.add(take_away);
		
		JLabel takeaway = new JLabel("");
		takeaway.setIcon(new ImageIcon(Home.class.getResource("/img/takeaway.png")));
		takeaway.setBackground(new Color(255, 204, 153));
		takeaway.setBounds(500, 395, 286, 232);
		panel_home.add(takeaway);
		
		JLabel eatin = new JLabel("");
		eatin.setIcon(new ImageIcon(Home.class.getResource("/img/eatin.png")));
		eatin.setBounds(111, 395, 286, 232);
		panel_home.add(eatin);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(Home.class.getResource("/img/menubackground.jpg")));
		background.setBounds(0, 0, 1016, 733);
		panel_home.add(background);
		
		JPanel panel_menu = new JPanel();
		panel_menu.setPreferredSize(new Dimension(1000,5000));
		panel_menu.setLayout(null);
		tabbedPane.addTab(" Menu ", null, panel_menu, null);
		
		JLabel lblNewLabel_1 = new JLabel("Menu");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(161, 81, 113, 41);
		panel_menu.add(lblNewLabel_1);
		
		JLabel logo_1 = new JLabel("");
		logo_1.setIcon(new ImageIcon(Home.class.getResource("/img/smallmcd.jpg")));
		logo_1.setBounds(49, 24, 113, 113);
		panel_menu.add(logo_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 157, 1004, 493);
		panel_menu.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[][][]", "[][][][][]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Strawberry Sundae", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_1, "cell 0 0,grow");
		panel_1.setLayout(new MigLayout("", "[]", "[][]"));
		
		JLabel lblStrawberrySundae = new JLabel("");
		panel_1.add(lblStrawberrySundae, "cell 0 0");
		lblStrawberrySundae.setIcon(new ImageIcon(Home.class.getResource("/img/strawsundae.jpg")));
		
		JLabel lblNewLabel_1_4_1_1_2_3_1 = new JLabel("RM4.15");
		panel_1.add(lblNewLabel_1_4_1_1_2_3_1, "flowx,cell 0 1,growx");
		lblNewLabel_1_4_1_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnstraw = new JButton("Add to cart");
		
		panel_1.add(btnstraw, "cell 0 1");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Chocolate Sundae", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2, "cell 1 0,grow");
		panel_2.setLayout(new MigLayout("", "[]", "[][]"));
		
		JLabel lblChocalateSundae = new JLabel("");
		panel_2.add(lblChocalateSundae, "cell 0 0");
		lblChocalateSundae.setIcon(new ImageIcon(Home.class.getResource("/img/chocsundae.jpg")));
		
		JLabel lblNewLabel_1_4_1_1_2_3_1_1 = new JLabel("RM4.15");
		panel_2.add(lblNewLabel_1_4_1_1_2_3_1_1, "flowx,cell 0 1,growx");
		lblNewLabel_1_4_1_1_2_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnchoc = new JButton("Add to cart");
		panel_2.add(btnchoc, "cell 0 1");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "McChicken", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_3, "cell 2 0,grow");
		panel_3.setLayout(new MigLayout("", "[]", "[][]"));
		
		JLabel lblMcChicken = new JLabel("");
		panel_3.add(lblMcChicken, "cell 0 0");
		lblMcChicken.setIcon(new ImageIcon(Home.class.getResource("/img/mcchicken.jpg")));
		
		JLabel lblNewLabel_1_4_1_1_2_3_1_2 = new JLabel("RM8.10");
		panel_3.add(lblNewLabel_1_4_1_1_2_3_1_2, "flowx,cell 0 1,growx");
		lblNewLabel_1_4_1_1_2_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnmcchicken = new JButton("Add to cart");
		panel_3.add(btnmcchicken, "cell 0 1");
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new TitledBorder(null, "Spicy Chicken McDeluxe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_10, "cell 0 1,grow");
		panel_10.setLayout(new MigLayout("", "[]", "[][]"));
		
		JLabel lblSpicyDeluxe = new JLabel("");
		panel_10.add(lblSpicyDeluxe, "cell 0 0");
		lblSpicyDeluxe.setIcon(new ImageIcon(Home.class.getResource("/img/mcdeluxe.jpg")));
		
		JButton btnspicydeluxe = new JButton("Add to cart");
		panel_10.add(btnspicydeluxe, "cell 0 1");
		
		JLabel lblNewLabel_1_4_1_1_2_3 = new JLabel("RM11.90");
		panel_10.add(lblNewLabel_1_4_1_1_2_3, "cell 0 1");
		lblNewLabel_1_4_1_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(null, "Ayam Goreng McD Spicy (2pcs)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_11, "cell 1 1,grow");
		panel_11.setLayout(new MigLayout("", "[]", "[][]"));
		
		JLabel lblayamgoreng2 = new JLabel("");
		panel_11.add(lblayamgoreng2, "cell 0 0");
		lblayamgoreng2.setIcon(new ImageIcon(Home.class.getResource("/img/ayam2.jpg")));
		
		JButton btnayam2 = new JButton("Add to cart");
		panel_11.add(btnayam2, "cell 0 1");
		
		JLabel lblNewLabel_1_4_1_1_2_4 = new JLabel("RM11.90");
		panel_11.add(lblNewLabel_1_4_1_1_2_4, "cell 0 1");
		lblNewLabel_1_4_1_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new TitledBorder(null, "Ayam Goreng McD Spicy (2pcs)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_12, "cell 2 1,grow");
		panel_12.setLayout(new MigLayout("", "[]", "[][]"));
		
		JLabel lblayamgoreng5 = new JLabel("");
		panel_12.add(lblayamgoreng5, "cell 0 0");
		lblayamgoreng5.setIcon(new ImageIcon(Home.class.getResource("/img/ayam5.jpg")));
		
		JButton btnayam5 = new JButton("Add to cart");
		panel_12.add(btnayam5, "cell 0 1");
		
		JLabel lblNewLabel_1_4_1_1_2_5 = new JLabel("RM30.20");
		panel_12.add(lblNewLabel_1_4_1_1_2_5, "cell 0 1");
		lblNewLabel_1_4_1_1_2_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Fillet-O-Fish Meal (Medium)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_7, "cell 0 2,grow");
		panel_7.setLayout(new MigLayout("", "[]", "[][]"));
		
		JLabel lblFilletMeal = new JLabel("");
		panel_7.add(lblFilletMeal, "cell 0 0");
		lblFilletMeal.setIcon(new ImageIcon(Home.class.getResource("/img/filletmeal.jpg")));
		
		JButton btnfilletmeal = new JButton("Add to cart");
		panel_7.add(btnfilletmeal, "cell 0 1");
		
		JLabel lblNewLabel_1_4_1_1_2 = new JLabel("RM13.00");
		panel_7.add(lblNewLabel_1_4_1_1_2, "cell 0 1");
		lblNewLabel_1_4_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "Double Cheeseburger", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_8, "cell 1 2,grow");
		panel_8.setLayout(new MigLayout("", "[]", "[][]"));
		
		JLabel lblDoubleCheeseBurger = new JLabel("");
		panel_8.add(lblDoubleCheeseBurger, "cell 0 0");
		lblDoubleCheeseBurger.setIcon(new ImageIcon(Home.class.getResource("/img/doublechees.jpg")));
		
		JButton btndoublecheese = new JButton("Add to cart");
		panel_8.add(btndoublecheese, "cell 0 1");
		
		JLabel lblNewLabel_1_4_1_1_2_1 = new JLabel("RM9.45");
		panel_8.add(lblNewLabel_1_4_1_1_2_1, "cell 0 1");
		lblNewLabel_1_4_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(null, "Chicken McNuggets (6pcs)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_9, "cell 2 2,grow");
		panel_9.setLayout(new MigLayout("", "[]", "[][]"));
		
		JLabel lblChickenMcNugget = new JLabel("");
		panel_9.add(lblChickenMcNugget, "cell 0 0");
		lblChickenMcNugget.setIcon(new ImageIcon(Home.class.getResource("/img/nugget.jpg")));
		
		JButton btnnugget = new JButton("Add to cart");
		panel_9.add(btnnugget, "cell 0 1");
		
		JLabel lblNewLabel_1_4_1_1_2_2 = new JLabel("RM9.40");
		panel_9.add(lblNewLabel_1_4_1_1_2_2, "cell 0 1");
		lblNewLabel_1_4_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "McChicken Meal (Medium)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_4, "cell 0 3,grow");
		panel_4.setLayout(new MigLayout("", "[]", "[][]"));
		
		JLabel lblbigmac = new JLabel("");
		panel_4.add(lblbigmac, "cell 0 0");
		lblbigmac.setIcon(new ImageIcon(Home.class.getResource("/img/bigmac.png")));
		lblbigmac.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("RM10.40");
		panel_4.add(lblNewLabel_1_4_1, "flowx,cell 0 1,growx");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnbigmac = new JButton("Add to cart");
		panel_4.add(btnbigmac, "cell 0 1");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Chicken McNugget Meal (Medium)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_5, "cell 1 3,grow");
		panel_5.setLayout(new MigLayout("", "[]", "[][]"));
		
		JLabel lblNuggetMeal = new JLabel("");
		panel_5.add(lblNuggetMeal, "cell 0 0");
		lblNuggetMeal.setIcon(new ImageIcon(Home.class.getResource("/img/nuggetmeal.jpg")));
		
		JLabel lblNewLabel_1_4_1_1_1 = new JLabel("RM13.20");
		panel_5.add(lblNewLabel_1_4_1_1_1, "flowx,cell 0 1,growx");
		lblNewLabel_1_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnnuggetmedium = new JButton("Add to cart");
		panel_5.add(btnnuggetmedium, "cell 0 1");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Big Mac", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_6, "cell 2 3,grow");
		panel_6.setLayout(new MigLayout("", "[]", "[][]"));
		
		JLabel lblMcChickenMeal = new JLabel("");
		panel_6.add(lblMcChickenMeal, "cell 0 0");
		lblMcChickenMeal.setIcon(new ImageIcon(Home.class.getResource("/img/mcchickenmeal.jpg")));
		lblMcChickenMeal.setForeground(Color.WHITE);
		lblMcChickenMeal.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("RM13.20");
		panel_6.add(lblNewLabel_1_4_1_1, "flowx,cell 0 1,growx");
		lblNewLabel_1_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnmcchickenmeal = new JButton("Add to cart");
		panel_6.add(btnmcchickenmeal, "cell 0 1");
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new TitledBorder(null, "Fillet-O-Fish", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_13, "cell 0 4,grow");
		panel_13.setLayout(new MigLayout("", "[]", "[][]"));
		
		JLabel lblfilletofish = new JLabel("");
		panel_13.add(lblfilletofish, "cell 0 0");
		lblfilletofish.setIcon(new ImageIcon(Home.class.getResource("/img/fillet.jpg")));
		
		JLabel lblNewLabel_1_4_2 = new JLabel("RM8.45");
		panel_13.add(lblNewLabel_1_4_2, "flowx,cell 0 1,growx");
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnfillet = new JButton("Add to cart");
		panel_13.add(btnfillet, "cell 0 1");
		
		JButton btncartlist = new JButton("Cart");
		btncartlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btncartlist.setBackground(SystemColor.activeCaption);
		btncartlist.setBounds(831, 669, 151, 41);
		panel_menu.add(btncartlist);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnBack.setBackground(SystemColor.activeCaption);
		btnBack.setBounds(37, 669, 151, 41);
		panel_menu.add(btnBack);
		
		JLabel background_1 = new JLabel("");
		background_1.setIcon(new ImageIcon(Home.class.getResource("/img/menubackground.jpg")));
		background_1.setBounds(0, 0, 1016, 763);
		panel_menu.add(background_1);
		
		JPanel panel_cart = new JPanel();
		tabbedPane.addTab(" Cart List ", null, panel_cart, null);
		panel_cart.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Cart List");
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_3.setBounds(173, 72, 146, 49);
		panel_cart.add(lblNewLabel_3);
		
		JLabel logo_2 = new JLabel("");
		logo_2.setIcon(new ImageIcon(Home.class.getResource("/img/smallmcd.jpg")));
		logo_2.setBounds(50, 26, 113, 113);
		panel_cart.add(logo_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(46, 189, 903, 412);
		panel_cart.add(scrollPane_1);
		
		JPanel panel_14 = new JPanel();
		panel_14.setPreferredSize(new Dimension(1000,3500));
		scrollPane_1.setViewportView(panel_14);
		panel_14.setLayout(new GridLayout(13, 0, 0, 0));
		
		JPanel p_0 = new JPanel();
		p_0.setBackground(SystemColor.control);
		p_0.setBorder(new TitledBorder(null, "McChicken", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		p_0.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(27, 23, 286, 232);
		p_0.add(lblNewLabel_5);
		lblNewLabel_5.setIcon(new ImageIcon(Home.class.getResource("/img/mcchicken.jpg")));

		JLabel lblNewLabel_4 = new JLabel("RM" + price[0] );
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(525, 119, 126, 36);
		p_0.add(lblNewLabel_4);
		
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				quantity[0] = (Integer)spinner.getValue();
				total[0] = quantity[0] * price[0];
				System.out.print(quantity[0]);
				lblNewLabel_4.setText(String.format("RM%.2f",total[0]));
			}
		});
		spinner.setBounds(352, 121, 163, 36);
		p_0.add(spinner);
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		
		JButton btnNewButton_1 = new JButton("Remove ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item[0] = false;
				panel_14.remove(p_0);
				panel_14.repaint();
				panel_14.invalidate();
				panel_14.revalidate();
			}
		});
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(661, 114, 146, 46);
		p_0.add(btnNewButton_1);
		
		JPanel p_1 = new JPanel();
		p_1.setBackground(SystemColor.controlHighlight);
		p_1.setLayout(null);
		p_1.setBorder(new TitledBorder(null, "Ayam Goreng McD Spicy (2pcs)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon(Home.class.getResource("/img/ayam2.jpg")));
		lblNewLabel_5_1.setBounds(27, 23, 286, 232);
		p_1.add(lblNewLabel_5_1);

		JLabel lblNewLabel_4_1 = new JLabel("RM"+ price[1]);
		lblNewLabel_4_1.setToolTipText("");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(525, 119, 126, 36);
		p_1.add(lblNewLabel_4_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				quantity[1] = (Integer)spinner_1.getValue();
				total[1] = quantity[1] * price[1];
				lblNewLabel_4_1.setText(String.format("RM%.2f",total[1]));
				
			}
		});
		spinner_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_1.setBounds(352, 121, 163, 36);
		p_1.add(spinner_1);
		
		
		JButton btnNewButton_1_1 = new JButton("Remove ");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item[1] = false;
				panel_14.remove(p_1);
				panel_14.repaint();
				panel_14.invalidate();
				panel_14.revalidate();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(661, 114, 146, 46);
		p_1.add(btnNewButton_1_1);
		
		JPanel p_2 = new JPanel();
		p_2.setBackground(SystemColor.control);
		p_2.setLayout(null);
		p_2.setBorder(new TitledBorder(null, "Ayam Goreng McD Spicy (5pcs)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_5_2 = new JLabel("");
		lblNewLabel_5_2.setIcon(new ImageIcon(Home.class.getResource("/img/ayam5.jpg")));
		lblNewLabel_5_2.setBounds(27, 23, 286, 232);
		p_2.add(lblNewLabel_5_2);

		JLabel lblNewLabel_4_2 = new JLabel("RM"+price[2]);
		lblNewLabel_4_2.setToolTipText("");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_4_2.setBounds(525, 119, 126, 36);
		p_2.add(lblNewLabel_4_2);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				quantity[2] = (Integer)spinner_2.getValue();
				total[2] = quantity[2] * price[2];
				lblNewLabel_4_2.setText(String.format("RM%.2f",total[2]));
				
			}
		});
		spinner_2.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_2.setBounds(352, 121, 163, 36);
		p_2.add(spinner_2);
		
		
		JButton btnNewButton_1_2 = new JButton("Remove ");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item[2] = false;
				panel_14.remove(p_2);
				panel_14.repaint();
				panel_14.invalidate();
				panel_14.revalidate();
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2.setBounds(661, 114, 146, 46);
		p_2.add(btnNewButton_1_2);
		
		JPanel p_3 = new JPanel();
		p_3.setBackground(SystemColor.controlHighlight);
		p_3.setLayout(null);
		p_3.setBorder(new TitledBorder(null, "Spicy Chicken McDeluxe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_5_3 = new JLabel("");
		lblNewLabel_5_3.setIcon(new ImageIcon(Home.class.getResource("/img/mcdeluxe.jpg")));
		lblNewLabel_5_3.setBounds(27, 23, 286, 232);
		p_3.add(lblNewLabel_5_3);

		JLabel lblNewLabel_4_3 = new JLabel("RM"+price[3]);
		lblNewLabel_4_3.setToolTipText("");
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_4_3.setBounds(525, 119, 126, 36);
		p_3.add(lblNewLabel_4_3);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				quantity[3] = (Integer)spinner_3.getValue();
				total[3] = quantity[3] * price[3];
				lblNewLabel_4_3.setText(String.format("RM%.2f",total[3]));
				
			}
		});
		spinner_3.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_3.setBounds(352, 121, 163, 36);
		p_3.add(spinner_3);
		
		
		JButton btnNewButton_1_3 = new JButton("Remove ");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item[3] = false;
				panel_14.remove(p_3);
				panel_14.repaint();
				panel_14.invalidate();
				panel_14.revalidate();
			}
		});
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_3.setBounds(661, 114, 146, 46);
		p_3.add(btnNewButton_1_3);
		
		JPanel p_4 = new JPanel();
		p_4.setBackground(SystemColor.control);
		p_4.setLayout(null);
		p_4.setBorder(new TitledBorder(null, "Chicken McNuggets (6pcs)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_5_4 = new JLabel("");
		lblNewLabel_5_4.setIcon(new ImageIcon(Home.class.getResource("/img/nugget.jpg")));
		lblNewLabel_5_4.setBounds(27, 23, 286, 232);
		p_4.add(lblNewLabel_5_4);

		JLabel lblNewLabel_4_4 = new JLabel("RM"+price[4]);
		lblNewLabel_4_4.setToolTipText("");
		lblNewLabel_4_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_4.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_4_4.setBounds(525, 119, 126, 36);
		p_4.add(lblNewLabel_4_4);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				quantity[4] = (Integer)spinner_4.getValue();
				total[4] = quantity[4] * price[4];
				lblNewLabel_4_4.setText(String.format("RM%.2f",total[4]));
				
			}
		});
		spinner_4.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_4.setBounds(352, 121, 163, 36);
		p_4.add(spinner_4);
		
		
		JButton btnNewButton_1_4 = new JButton("Remove ");
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item[4] = false;
				panel_14.remove(p_4);
				panel_14.repaint();
				panel_14.invalidate();
				panel_14.revalidate();
			}
		});
		btnNewButton_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_4.setBounds(661, 114, 146, 46);
		p_4.add(btnNewButton_1_4);
		
		JPanel p_5 = new JPanel();
		p_5.setBackground(SystemColor.controlHighlight);
		p_5.setLayout(null);
		p_5.setBorder(new TitledBorder(null, "Double Cheeseburger", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_5_5 = new JLabel("");
		lblNewLabel_5_5.setIcon(new ImageIcon(Home.class.getResource("/img/doublechees.jpg")));
		lblNewLabel_5_5.setBounds(27, 23, 286, 232);
		p_5.add(lblNewLabel_5_5);

		JLabel lblNewLabel_4_5 = new JLabel("RM"+price[5]);
		lblNewLabel_4_5.setToolTipText("");
		lblNewLabel_4_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_5.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_4_5.setBounds(525, 119, 126, 36);
		p_5.add(lblNewLabel_4_5);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				quantity[5] = (Integer)spinner_5.getValue();
				total[5] = quantity[5] * price[5];
				lblNewLabel_4_5.setText(String.format("RM%.2f",total[5]));
				
			}
		});
		spinner_5.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_5.setBounds(352, 121, 163, 36);
		p_5.add(spinner_5);
		
		
		JButton btnNewButton_1_5 = new JButton("Remove ");
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item[5] = false;
				panel_14.remove(p_5);
				panel_14.repaint();	
				panel_14.invalidate();
				panel_14.revalidate();
			}
		});
		btnNewButton_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_5.setBounds(661, 114, 146, 46);
		p_5.add(btnNewButton_1_5);
		
		JPanel p_6 = new JPanel();
		p_6.setBackground(SystemColor.control);
		p_6.setLayout(null);
		p_6.setBorder(new TitledBorder(null, "Big Mac", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_5_6 = new JLabel("");
		lblNewLabel_5_6.setIcon(new ImageIcon(Home.class.getResource("/img/bigmac.png")));
		lblNewLabel_5_6.setBounds(27, 23, 286, 232);
		p_6.add(lblNewLabel_5_6);

		JLabel lblNewLabel_4_6 = new JLabel("RM"+price[6]);
		lblNewLabel_4_6.setToolTipText("");
		lblNewLabel_4_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_6.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_4_6.setBounds(525, 119, 126, 36);
		p_6.add(lblNewLabel_4_6);
		
		JSpinner spinner_6 = new JSpinner();
		spinner_6.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				quantity[6] = (Integer)spinner_6.getValue();
				total[6] = quantity[6] * price[6];
				lblNewLabel_4_6.setText(String.format("RM%.2f",total[6]));
				
			}
		});
		spinner_6.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_6.setBounds(352, 121, 163, 36);
		p_6.add(spinner_6);
		
		JButton btnNewButton_1_6 = new JButton("Remove ");
		btnNewButton_1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item[6] = false;
				panel_14.remove(p_6);
				panel_14.repaint();
				panel_14.invalidate();
				panel_14.revalidate();
			}
		});
		btnNewButton_1_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_6.setBounds(661, 114, 146, 46);
		p_6.add(btnNewButton_1_6);
		
		JPanel p_7 = new JPanel();
		p_7.setBackground(SystemColor.controlHighlight);
		p_7.setLayout(null);
		p_7.setBorder(new TitledBorder(null, "Filet-O-Fish", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_5_7 = new JLabel("");
		lblNewLabel_5_7.setIcon(new ImageIcon(Home.class.getResource("/img/fillet.jpg")));
		lblNewLabel_5_7.setBounds(27, 23, 286, 232);
		p_7.add(lblNewLabel_5_7);

		JLabel lblNewLabel_4_7 = new JLabel("RM8.45");
		lblNewLabel_4_7.setToolTipText("");
		lblNewLabel_4_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_7.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_4_7.setBounds(525, 119, 126, 36);
		p_7.add(lblNewLabel_4_7);
		
		JSpinner spinner_7 = new JSpinner();
		spinner_7.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				quantity[7] = (Integer)spinner_7.getValue();
				total[7] = quantity[7] * price[7];
				lblNewLabel_4_7.setText(String.format("RM%.2f",total[7]));
				
			}
		});
		spinner_7.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_7.setBounds(352, 121, 163, 36);
		p_7.add(spinner_7);
		
		JButton btnNewButton_1_7 = new JButton("Remove ");
		btnNewButton_1_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item[7] = false;
				panel_14.remove(p_7);
				panel_14.repaint();
				panel_14.invalidate();
				panel_14.revalidate();
			}
		});
		btnNewButton_1_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_7.setBounds(661, 114, 146, 46);
		p_7.add(btnNewButton_1_7);
		
		JPanel p_8 = new JPanel();
		p_8.setBackground(SystemColor.control);
		p_8.setLayout(null);
		p_8.setBorder(new TitledBorder(null, "McChicken Meal (Medium)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_5_8 = new JLabel("");
		lblNewLabel_5_8.setIcon(new ImageIcon(Home.class.getResource("/img/mcchickenmeal.jpg")));
		lblNewLabel_5_8.setBounds(27, 23, 286, 232);
		p_8.add(lblNewLabel_5_8);

		JLabel lblNewLabel_4_8 = new JLabel("RM13.20");
		lblNewLabel_4_8.setToolTipText("");
		lblNewLabel_4_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_8.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_4_8.setBounds(525, 119, 126, 36);
		p_8.add(lblNewLabel_4_8);
		
		JSpinner spinner_8 = new JSpinner();
		spinner_8.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				quantity[8] = (Integer)spinner_8.getValue();
				total[8] = quantity[8] * price[8];
				lblNewLabel_4_8.setText(String.format("RM%.2f",total[8]));
				
			}
		});
		spinner_8.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_8.setBounds(352, 121, 163, 36);
		p_8.add(spinner_8);
		
		JButton btnNewButton_1_8 = new JButton("Remove ");
		btnNewButton_1_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item[8] = false;
				panel_14.remove(p_8);
				panel_14.repaint();
				panel_14.invalidate();
				panel_14.revalidate();
			}
		});
		btnNewButton_1_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_8.setBounds(661, 114, 146, 46);
		p_8.add(btnNewButton_1_8);
		
		JPanel p_9 = new JPanel();
		p_9.setBackground(SystemColor.controlHighlight);
		p_9.setLayout(null);
		p_9.setBorder(new TitledBorder(null, "Chicken McNuggets 6pcs Meal (Medium)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_5_9 = new JLabel("");
		lblNewLabel_5_9.setIcon(new ImageIcon(Home.class.getResource("/img/nuggetmeal.jpg")));
		lblNewLabel_5_9.setBounds(27, 23, 286, 232);
		p_9.add(lblNewLabel_5_9);
		
		JLabel lblNewLabel_4_9 = new JLabel("RM13.20");
		lblNewLabel_4_9.setToolTipText("");
		lblNewLabel_4_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_9.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_4_9.setBounds(525, 119, 126, 36);
		p_9.add(lblNewLabel_4_9);
		
		JSpinner spinner_9 = new JSpinner();
		spinner_9.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				quantity[9] = (Integer)spinner_9.getValue();
				total[9] = quantity[9] * price[9];
				lblNewLabel_4_9.setText(String.format("RM%.2f",total[9]));
				
			}
		});
		spinner_9.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_9.setBounds(352, 121, 163, 36);
		p_9.add(spinner_9);
		
		JButton btnNewButton_1_9 = new JButton("Remove ");
		btnNewButton_1_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item[9] = false;
				panel_14.remove(p_9);
				panel_14.repaint();
				panel_14.invalidate();
				panel_14.revalidate();
				
			}
		});
		btnNewButton_1_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_9.setBounds(661, 114, 146, 46);
		p_9.add(btnNewButton_1_9);
		
		JPanel p_10 = new JPanel();
		p_10.setBackground(SystemColor.control);
		p_10.setLayout(null);
		p_10.setBorder(new TitledBorder(null, "Filet-O-Fish Meal (Medium)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_5_10 = new JLabel("");
		lblNewLabel_5_10.setIcon(new ImageIcon(Home.class.getResource("/img/filletmeal.jpg")));
		lblNewLabel_5_10.setBounds(27, 23, 286, 232);
		p_10.add(lblNewLabel_5_10);

		JLabel lblNewLabel_4_10 = new JLabel("RM13.00");
		lblNewLabel_4_10.setToolTipText("");
		lblNewLabel_4_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_10.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_4_10.setBounds(525, 119, 126, 36);
		p_10.add(lblNewLabel_4_10);
		
		JSpinner spinner_10 = new JSpinner();
		spinner_10.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				quantity[10] = (Integer)spinner_10.getValue();
				total[10] = quantity[10] * price[10];
				lblNewLabel_4_10.setText(String.format("RM%.2f",total[10]));
				
			}
		});
		spinner_10.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_10.setBounds(352, 121, 163, 36);
		p_10.add(spinner_10);
		
		JButton btnNewButton_1_10 = new JButton("Remove ");
		btnNewButton_1_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item[10] = false;
				panel_14.remove(p_10);
				panel_14.repaint();
				panel_14.invalidate();
				panel_14.revalidate();
			
			}
		});
		btnNewButton_1_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_10.setBounds(661, 114, 146, 46);
		p_10.add(btnNewButton_1_10);
		
		JPanel p_11 = new JPanel();
		p_11.setBackground(SystemColor.controlHighlight);
		p_11.setLayout(null);
		p_11.setBorder(new TitledBorder(null, "Strawberry Sundae", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_5_11 = new JLabel("");
		lblNewLabel_5_11.setIcon(new ImageIcon(Home.class.getResource("/img/strawsundae.jpg")));
		lblNewLabel_5_11.setBounds(27, 23, 286, 232);
		p_11.add(lblNewLabel_5_11);

		JLabel lblNewLabel_4_11 = new JLabel("RM4.15");
		lblNewLabel_4_11.setToolTipText("");
		lblNewLabel_4_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_11.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_4_11.setBounds(525, 119, 126, 36);
		p_11.add(lblNewLabel_4_11);
		
		JSpinner spinner_11 = new JSpinner();
		spinner_11.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				quantity[11] = (Integer)spinner_11.getValue();
				total[11] = quantity[11] * price[11];
				lblNewLabel_4_11.setText(String.format("RM%.2f",total[11]));
				
			}
		});
		spinner_11.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_11.setBounds(352, 121, 163, 36);
		p_11.add(spinner_11);
		
		JButton btnNewButton_1_11 = new JButton("Remove ");
		btnNewButton_1_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item[11] = false;
				panel_14.remove(p_11);
				panel_14.repaint();
				panel_14.invalidate();
				panel_14.revalidate();
				
			}
		});
		btnNewButton_1_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_11.setBounds(661, 114, 146, 46);
		p_11.add(btnNewButton_1_11);
		
		JPanel p_12 = new JPanel();
		p_12.setBackground(SystemColor.control);
		p_12.setLayout(null);
		p_12.setBorder(new TitledBorder(null, "Chocolate Sundae", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_5_12 = new JLabel("");
		lblNewLabel_5_12.setIcon(new ImageIcon(Home.class.getResource("/img/chocsundae.jpg")));
		lblNewLabel_5_12.setBounds(27, 23, 286, 232);
		p_12.add(lblNewLabel_5_12);

		JLabel lblNewLabel_4_12 = new JLabel("RM4.15");
		lblNewLabel_4_12.setToolTipText("");
		lblNewLabel_4_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_12.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_4_12.setBounds(525, 119, 126, 36);
		p_12.add(lblNewLabel_4_12);
		
		JSpinner spinner_12 = new JSpinner();
		spinner_12.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				quantity[12] = (Integer)spinner_12.getValue();
				total[12] = quantity[12] * price[12];
				lblNewLabel_4_12.setText(String.format("RM%.2f",total[12]));
				
			}
		});
		spinner_12.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_12.setBounds(352, 121, 163, 36);
		p_12.add(spinner_12);
		
		JButton btnNewButton_1_12 = new JButton("Remove ");
		btnNewButton_1_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item[12] = false;
				panel_14.remove(p_12);
				panel_14.repaint();
				panel_14.invalidate();
				panel_14.revalidate();
				
			}
		});
		btnNewButton_1_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_12.setBounds(661, 114, 146, 46);
		p_12.add(btnNewButton_1_12);
		
		JButton btnpayment = new JButton("Proceed to Payment");
		btnpayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTotal();
				printOrderedItem();
				
				tabbedPane.setSelectedIndex(3);
				
				
			}
		});
		btnpayment.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnpayment.setBounds(741, 645, 208, 54);
		panel_cart.add(btnpayment);
		
		JButton btnback= new JButton("Back to Menu");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnback.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnback.setBounds(50, 645, 208, 54);
		panel_cart.add(btnback);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/img/menubackground.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1004, 733);
		panel_cart.add(lblNewLabel_2);
		
		JPanel panel_payment = new JPanel();
		tabbedPane.addTab(" Payment ", null, panel_payment, null);
		panel_payment.setLayout(null);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(SystemColor.menu);
		panel_15.setBounds(737, 160, 253, 562);
		panel_payment.add(panel_15);
		panel_15.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Review Order");
		lblNewLabel_7.setOpaque(true);
		lblNewLabel_7.setBackground(SystemColor.controlHighlight);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(10, 11, 233, 43);
		panel_15.add(lblNewLabel_7);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(SystemColor.controlHighlight);
		panel_16.setBounds(10, 65, 233, 446);
		panel_15.add(panel_16);
		panel_16.setLayout(null);
		
		JButton btnconfirm = new JButton("Confirm");
		btnconfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
			try {
				setOrderedItem();
			}
			catch(SQLException e2) {
				e2.printStackTrace();
			}
				
				
				
				try {
					release();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			}
			
		});
		
		
		
		
		btnconfirm.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnconfirm.setBackground(SystemColor.activeCaption);
		btnconfirm.setBounds(0, 180, 233, 56);
		panel_16.add(btnconfirm);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_14.removeAll();
				tabbedPane.setSelectedIndex(0);
				
			}
		});
		btnBack_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnBack_1.setBackground(SystemColor.activeCaption);
		btnBack_1.setBounds(0, 247, 233, 56);
		panel_16.add(btnBack_1);
		
		
		newtotal.setBounds(0, 11, 233, 56);
		panel_16.add(newtotal);
		newtotal.setOpaque(true);
		newtotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		newtotal.setBackground(SystemColor.controlHighlight);
		
		
		creditcard.setBounds(0, 94, 233, 38);
		panel_16.add(creditcard);
		creditcard.setColumns(10);
		

		textAreaL.setBounds(10, 160, 705, 562);
		panel_payment.add(textAreaL);
		
		JLabel lblNewLabel_6 = new JLabel("Payment");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_6.setBounds(312, 43, 373, 62);
		panel_payment.add(lblNewLabel_6); 
		
		JLabel background1 = new JLabel("");
		background1.setIcon(new ImageIcon(Home.class.getResource("/img/menubackground.jpg")));
		background1.setBounds(0, 0, 1004, 733);
		panel_payment.add(background1);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		tabbedPane.addTab("New tab", null, lblNewLabel_8, null);
		

		//Add Item to Cart List
				btnstraw.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						item[11] = true;
						total[11] = price[11];
						panel_14.add(p_11);
					}
				});
				btnchoc.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						item[12] = true;
						total[12] = price[12];
						panel_14.add(p_12);
					}
				});
				btnmcchicken.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						item[0] = true;
						total[0] = price[0];
						panel_14.add(p_0);
					}
				});
				btnfillet.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						item[7] = true;
						total[7] = price[7];
						panel_14.add(p_7);
					}
				});
				btnfilletmeal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						item[10] = true;
						total[10] = price[10];
						panel_14.add(p_10);
					}
				});
				btnspicydeluxe.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						item[3] = true;
						total[3] = price[3];
						panel_14.add(p_3);
					}
				});
				btnayam2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						item[1] = true;
						total[1] = price[1];
						panel_14.add(p_1);
					}
				});
				btnayam5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						item[2] = true;
						total[2] = price[2];
						panel_14.add(p_2);
					}
				});
				btndoublecheese.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						item[5] = true;
						total[5] = price[5];
						panel_14.add(p_5);
					}
				});
				btnnugget.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						item[4] = true;
						total[4] = price[4];
						panel_14.add(p_4);
					}
				});
				btnbigmac.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						item[6] = true;
						total[6] = price[6];
						panel_14.add(p_6);
					}
				});
				btnnuggetmedium.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						item[9] = true;
						total[9] = price[9];
						panel_14.add(p_9);
					}
				});
				btnmcchickenmeal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						item[8] = true;
						total[8] = price[8];
						panel_14.add(p_8);
					}
				});
		
		
}
	public String getcreditCard() throws InterruptedException
	{
		waitForInput();
		return creditcard.getText();
	}
	public void setcreditCard()
	{
		creditcard.getText();
		
	}
	
	//wait for input
	public void waitForInput() throws InterruptedException {
        synchronized(this) {
            wait();
        }
    }
	
	//release after button clicked
	public void release() throws InterruptedException {
        synchronized(this) {
            notifyAll();
        }
    }
	
	public void UpdateTotal() {
		fulltotal = 0;
		for(int i = 0; i<item.length ; i++) {
			if (item[i]) {
				fulltotal += total[i];
			}
		}
		newtotal.setText(String.format("%.2f",(float)fulltotal));
	}
	
	public void printOrderedItem() {
        String text = "";
        for(int i = 0;i<item.length ; i++) {
            ItemProduct itemProduct = new ItemProduct();
            itemProduct = prodManager.getProduct(i+1);

            if(item[i]) {
                text+=(i+1)+ ". " + quantity[i] +"x"+ itemProduct.getName() + " : RM" + price[i] + "\n";
                
            }
            textAreaL.setText(text);
            }

        }
        
        public void setOrderedItem() throws SQLException{
        	int j = 1;
            for(int i = 0;i<item.length ; i++) {
                ItemProduct itemProduct = new ItemProduct();
                itemProduct = prodManager.getProduct(i+1);

                if(item[i]) {
                	orderItem = new OrderedItem();
                	while(prodManager.getProduct(j) == null)
                	{
                		j++;
                	}
                	
                	orderItem.setQuantity(quantity[i]);
                    orderItem.setSubTotalAmount(total[i]);
                    orderItem.setItemProduct(prodManager.getProduct(i));
                    System.out.print(prodManager.getProduct(i).getName());
                    orderItem.setItemID(j);
                    
                    
                    
                    orderItems.add(orderItem);
                }
                
                
                
            }     
    }

        public ArrayList<OrderedItem> getOrderedItems() throws SQLException, InterruptedException {

        	return orderItems;
        } 
	}