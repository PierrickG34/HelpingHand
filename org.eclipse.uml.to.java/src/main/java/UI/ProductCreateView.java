package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Core.Product;
import Core.ProductFacade;
import Core.UserFacade;
import Excpetion.AlreadyExistException;

public class ProductCreateView extends JFrame implements ActionListener {
	
	
	/**
	 * Descriptions for the Name field
	 */
	JLabel name = new JLabel("Name :");
	JTextField nameEntre = new JTextField("", 15);

	/**
	 * Descriptions for the price field
	 */
	JLabel price = new JLabel("Price :");
	JTextField priceEntre = new JTextField("", 15);

	/**
	 * Description for the quantity field
	 */
	JLabel quantity = new JLabel("Quantity:");
	JTextField quantityEntre = new JTextField("", 15);
	
	/**
	 * Description for the category field
	 */
	
	JLabel category = new JLabel("Category:");
	JTextField categoryEntre = new JTextField("", 15);

	/**
	 * Description for the button validate
	 */
	JButton validateCreationProduct = new JButton("ValidateCreationProduct");

	/**
	 * Permit to cancel the creation
	 */
	JButton cancel = new JButton("Cancel");
	
	
	/**
	 * Describe error message
	 */
	
	JLabel errorMessage = new JLabel("");

	public ProductFacade productFacades = new ProductFacade(this);

	/*
	 *  Describe the menu
	 */
	
	   JButton dashboard = new JButton("Dashboard");
	   JButton journal = new JButton("Journal");
	   JButton myPlans = new JButton("My Plans");
	   JButton myFavorites = new JButton("My Favorites");
	   JButton myProducts = new JButton("My Products");
	   JButton shoppingCart = new JButton("Shopping Cart");
	   JButton profile = new JButton("Profile");
	   JButton notifications = new JButton("Notifications");
	   
public ProductCreateView()
{
	super("Product Creation");
	this.validateCreationProduct.addActionListener(this);
	this.cancel.addActionListener(this);
	Container contentPane = getContentPane(); 
    contentPane.setLayout(new BorderLayout()); 
    setMinimumSize(new Dimension(1000,500));
    setMaximumSize(new Dimension(1000,500));
    

	/*##### Display the menu bar #####*/
    
	JPanel panelButton = new JPanel(new GridLayout(2, 1)); // 2 rows x 1 column
	JPanel panelTopButton = new JPanel();
	JPanel panelBottomButton = new JPanel();
	JButton profile = new JButton("Profile");
	JButton notifications = new JButton("Notifications");
	panelTopButton.add(this.dashboard);
	panelTopButton.add(this.journal);
	panelTopButton.add(this.myPlans);
	panelTopButton.add(this.myFavorites);
	panelTopButton.add(this.shoppingCart);
	panelBottomButton.add(this.profile);
	panelBottomButton.add(this.notifications);
	panelButton.add(panelTopButton);
	panelButton.add(panelBottomButton);
	
	
	
	/*##### Display and edit the information #####*/
	JPanel panelEditInformation = new JPanel();
	JPanel panelLabels = new JPanel(new GridLayout(0,1));
	JPanel panelTextField = new JPanel(new GridLayout(0,1));
	
	//Name
	this.name.setPreferredSize(this.nameEntre.getPreferredSize());
	this.name.setHorizontalAlignment(SwingConstants.RIGHT);
	panelLabels.add(this.name);
	panelTextField.add(this.nameEntre);
	
	//Price
	this.price.setPreferredSize(this.priceEntre.getPreferredSize());
	this.price.setHorizontalAlignment(SwingConstants.RIGHT);
	panelLabels.add(this.price);
	panelTextField.add(this.priceEntre);
	
	
	//Quantity
	this.quantity.setPreferredSize(this.quantityEntre.getPreferredSize());
	this.quantity.setHorizontalAlignment(SwingConstants.RIGHT);
	panelLabels.add(this.quantity);
	panelTextField.add(this.quantityEntre);
	
	
	contentPane.add(panelButton,BorderLayout.NORTH);
	contentPane.add(panelEditInformation, BorderLayout.LINE_START);
	
	panelEditInformation.add(this.errorMessage);
	
	this.validateCreationProduct.addActionListener(this);
	
	panelEditInformation.add(panelLabels);
	panelEditInformation.add(panelTextField);
	panelEditInformation.add(this.validateCreationProduct);
	panelEditInformation.add(this.cancel);
	
	contentPane.add(panelButton,BorderLayout.NORTH);
	contentPane.add(panelEditInformation, BorderLayout.CENTER);



	
	//Display
	setSize(400,120);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	this.errorMessage.setHorizontalAlignment(JLabel.CENTER);
	this.errorMessage.setVisible(false);
}


@Override
public void actionPerformed(ActionEvent e) {
	String source = e.getActionCommand();
	if (source == "ValidateCreationProduct") {
			this.errorMessage.setVisible(false);
			this.name.setForeground(Color.black);
			this.price.setForeground(Color.black);
			this.quantity.setForeground(Color.black);
			
			if(this.nameEntre.getText().isEmpty()) {
				this.errorMessage.setText("Enter a Product name please");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
				this.name.setForeground(Color.red);
				System.out.println("Je passe ici");
			}
			if (this.priceEntre.getText().isEmpty()) {
				this.errorMessage.setText("Enter a prix please");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
				this.price.setForeground(Color.red);
			}
			if (this.quantityEntre.getText().isEmpty()) {
				this.errorMessage.setText("Enter a quantity please");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
				this.quantity.setForeground(Color.red);
			}
			
			if(!this.nameEntre.getText().isEmpty() && !this.priceEntre.getText().isEmpty() && !this.quantityEntre.getText().isEmpty())
			{
				System.out.println("La je passe deux fois ?");
				Product newProduct = this.productFacades.createProduct(this.nameEntre.getText(), Float.parseFloat(this.priceEntre.getText()), Integer.parseInt(this.quantityEntre.getText()), 
						this.categoryEntre.getText());
				if (newProduct != null) {				
					this.dispose();
				}
			}	
   }
 }
}