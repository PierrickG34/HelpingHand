
package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Core.ActivityCategory;
import Core.ActivityCategoryFacade;
import Core.Product;
import Core.ProductFacade;
import Core.User;
import Persist.ActivityCategoryJDBC;
import Persist.ProductJDBC;

public class UpdateProductView extends JPanel implements ActionListener {
	
	JButton dashboard = new JButton("Dashboard");
	JButton activityCategory = new JButton("Activity Category");
	JButton productCategory = new JButton("Product Category");
	JButton product = new JButton("Product");
	JButton account = new JButton("Account");
	JButton plan = new JButton("Plan");
	JButton task = new JButton("Task");

	JButton profile = new JButton("Profile");
	JButton notifications = new JButton("Notifications");

	/**
	 * Description for the button validate
	 */
	JButton submit = new JButton("Submit");


	JComboBox<String> combo = new JComboBox<String>();

	/**
	 * Text to choose the activity category to delete
	 */
	JLabel chooseProduct = new JLabel("Choose an product :");

	/**
	 * Button who permit to validate the activity category choosen
	 */
	JButton chooseProductButton = new JButton("Choose");

	/**
	 * Descriptions for the name of an activity category
	 */
	JLabel nameProduct = new JLabel("Name :");
	JTextField nameProductEntre = new JTextField("", 15);

	/**
	 * Descriptions for the short detail of an activity category
	 */
	JLabel priceProduct = new JLabel("price :");
	JTextField priceProductEntre = new JTextField("", 15);

	/**
	 * Descriptions for the short detail of an activity category
	 */
	JLabel quantityProduct = new JLabel("quantity :");
	JTextField quantityProductEntre = new JTextField("", 15);
	
	/**
	 * Descriptions for the short detail of an activity category
	 */
	JLabel categoryProduct = new JLabel("category :");
	JTextField categoryProductEntre = new JTextField("", 15);
	
	/**
	 * This panel permit to display information 
	 */
	JPanel panelEditAll = new JPanel(new GridLayout(2,0));
	
	/**
	 * Define the current activit category that the admin choose
	 */
	ProductJDBC currentProductJDBC;

	/**
	 * Description of the property ActivityCategoryFacades.
	 */
	public ProductFacade productFacades = new ProductFacade(this);
	
	/**
	 * Contain all the activity category of the database
	 */
	List<Product> allProduct = new ArrayList<Product>();

	private User currentUser;
	private ViewController vc;
	private MenuSellerView menuSellerView;
	
public UpdateProductView(User currentUser,ViewController vc) {
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuSellerView = new MenuSellerView(this.vc);
		this.add(menuSellerView);

		/*-------------- Veritable view --------------------*/
		JPanel panelAll = new JPanel();
		JPanel panelEdit = new JPanel();
		JPanel panelButtonValidate = new JPanel();
		JPanel panelComboBox = new JPanel(new GridLayout(3, 1));
		JPanel panelLabels = new JPanel(new GridLayout(0,1));
		JPanel panelTextFiel = new JPanel(new GridLayout(0,1));

		this.submit.addActionListener(this);
		this.chooseProductButton.addActionListener(this);

		//Recuperate the product and add to the combobox
		this.allProduct = this.productFacades.getAllProduct(this.currentUser.getIdUser());
		for (int i = 0; i< this.allProduct.size(); i++) {
			this.combo.addItem(this.allProduct.get(i).getName());
		}
		panelComboBox.add(this.chooseProduct);
		panelComboBox.add(this.combo);
		panelComboBox.add(this.chooseProductButton);
	 
		// Name 
        this.nameProduct.setPreferredSize(this.nameProductEntre.getPreferredSize());
        this.nameProduct.setHorizontalAlignment(SwingConstants.RIGHT);
        panelLabels.add(this.nameProduct);
        panelTextFiel.add(this.nameProductEntre);
        
        // Price
        this.priceProduct.setPreferredSize(this.priceProductEntre.getPreferredSize());
        this.priceProduct.setHorizontalAlignment(SwingConstants.RIGHT);
        panelLabels.add(this.priceProduct);
        panelTextFiel.add(this.priceProductEntre);

        // quantity
        this.quantityProduct.setPreferredSize(this.quantityProductEntre.getPreferredSize());
        this.quantityProduct.setHorizontalAlignment(SwingConstants.RIGHT);
        panelLabels.add(this.quantityProduct);
        panelTextFiel.add(this.quantityProductEntre);
        
        //Category
        this.categoryProduct.setPreferredSize(this.categoryProductEntre.getPreferredSize());
        this.categoryProduct.setHorizontalAlignment(SwingConstants.RIGHT);
        panelLabels.add(this.categoryProduct);
        panelTextFiel.add(this.categoryProductEntre);
        
		panelButtonValidate.add(submit, BorderLayout.CENTER);
		panelAll.add(panelComboBox);
		panelEdit.add(panelLabels);
		panelEdit.add(panelTextFiel);
		this.panelEditAll.setVisible(false);
		this.panelEditAll.add(panelEdit);
		this.panelEditAll.add(panelButtonValidate);
		panelAll.add(this.panelEditAll);

		this.add(panelAll);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Choose") {
			this.panelEditAll.setVisible(true);
		
		/* Aller dans la base de données avec l'id de l'utilisateur*/
			this.nameProductEntre.setToolTipText(this.allProduct.get(this.combo.getSelectedIndex()).getName());
			this.priceProductEntre.setToolTipText(String.valueOf(this.allProduct.get(this.combo.getSelectedIndex()).getPrice()));
			this.quantityProductEntre.setToolTipText(String.valueOf(this.allProduct.get(this.combo.getSelectedIndex()).getQuantity()));
			this.categoryProductEntre.setToolTipText(this.allProduct.get(this.combo.getSelectedIndex()).getCategory());
		}
		if(source == "Submit") {
			this.productFacades.modifyProduct(this.allProduct.get(this.combo.getSelectedIndex()), this.nameProductEntre.getText(), this.priceProductEntre.getText(),this.quantityProductEntre.getText(), this.categoryProductEntre.getText());
		}
	}
}