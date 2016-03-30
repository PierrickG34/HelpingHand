package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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
import Core.User;
import Core.UserFacade;
import Excpetion.AlreadyExistException;

public class ProductCreateViewSeller extends JPanel implements ActionListener {


	/**
	 * Descriptions for the windows
	 */
	JLabel createProduct = new JLabel("  Create a product :");

	private User currentUser;
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
	JButton validateCreationProduct = new JButton("Validate Creation Product");

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

	private ViewController vc;
	private MenuSellerView menuSellerView;

	public ProductCreateViewSeller(User user, ViewController vc)
	{
//		super("Product Creation");
		this.currentUser = user;
		this.vc = vc;
		this.menuSellerView = new MenuSellerView(this.vc);
		this.add(menuSellerView);
		this.cancel.addActionListener(this);


		/*##### Display and edit the information #####*/
		JPanel panelAll = new JPanel(new GridLayout(2, 0));
		JPanel panelEditInformation = new JPanel();
		JPanel panelLabels = new JPanel(new GridLayout(0,1));
		JPanel panelTextField = new JPanel(new GridLayout(0,1));
		JPanel panelButtonValidate = new JPanel();

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



		this.validateCreationProduct.addActionListener(this);

		panelEditInformation.add(panelLabels);
		panelEditInformation.add(panelTextField);
		panelButtonValidate.add(this.validateCreationProduct);
		panelButtonValidate.add(this.cancel);
		this.cancel.addActionListener(this);
		panelButtonValidate.add(this.errorMessage);
		panelAll.add(panelEditInformation);
		panelAll.add(panelButtonValidate);

		this.add(panelAll, BorderLayout.CENTER);

		this.errorMessage.setHorizontalAlignment(JLabel.CENTER);
		this.errorMessage.setVisible(false);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if (source == "Validate Creation Product") {
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
				Product newProduct = this.productFacades.createProduct(this.nameEntre.getText(), Double.parseDouble(this.priceEntre.getText()), Integer.parseInt(this.quantityEntre.getText()), 
						this.categoryEntre.getText(), this.currentUser.getIdUser());
			}
		}
		else if (source == "Cancel") {
			this.vc.ProductManageViewSeller();
		}
	}
}