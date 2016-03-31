
package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Core.Product;
import Core.ProductFacade;
import Core.User;
import Persist.ProductJDBC;

/**
 * The Class UpdateProductView.
 * @author Helping Hand 
 */
public class UpdateProductView extends JPanel implements ActionListener {

	/** Description for the button submit. */
	JButton submit = new JButton("Submit");

	/** The combo. */
	JComboBox<String> combo = new JComboBox<String>();

	/** Text to choose the product to delete. */
	JLabel chooseProduct = new JLabel("Choose an product :");

	/** Button who permit to validate the product choosen. */
	JButton chooseProductButton = new JButton("Choose");

	/** Descriptions for the name of a product. */
	JLabel nameProduct = new JLabel("Name :");

	/** The name product type. */
	JTextField nameProductEntre = new JTextField("", 15);

	/** Descriptions for the price of a product. */
	JLabel priceProduct = new JLabel("price :");

	/** The price product type. */
	JTextField priceProductEntre = new JTextField("", 15);

	/** Descriptions for the quantity of a product. */
	JLabel quantityProduct = new JLabel("quantity :");

	/** The quantity product type. */
	JTextField quantityProductEntre = new JTextField("", 15);

	/** Descriptions for the category product. */
	JLabel categoryProduct = new JLabel("category :");

	/** The category product type. */
	JTextField categoryProductEntre = new JTextField("", 15);

	/** This panel permit to display information. */
	JPanel panelEditAll = new JPanel(new GridLayout(2,0));

	/** Define the current produt that the admin choose. */
	ProductJDBC currentProductJDBC;

	/**
	 * Description of the property ProductFacade.
	 */
	public ProductFacade productFacades = new ProductFacade(this);

	/** Contain all the product of the database. */
	List<Product> allProduct = new ArrayList<Product>();

	/** The current user. */
	private User currentUser;

	/** The ViewController. */
	private ViewController vc;

	/** The menu seller view. */
	private MenuSellerView menuSellerView;

	/**
	 * Instantiates a new update product view.
	 *
	 * @param currentUser the current user
	 * @param vc the ViewController
	 */
	public UpdateProductView(User currentUser,ViewController vc) {
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuSellerView = new MenuSellerView(this.vc);
		this.add(menuSellerView);

		/*-------------- Veritable view --------------------*/
		JPanel panelAll = new JPanel(new GridLayout(1, 2));
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

		// Quantity
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

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Choose") {
			this.panelEditAll.setVisible(true);

			/* Display the information about the product in the database*/
			this.nameProductEntre.setToolTipText(this.allProduct.get(this.combo.getSelectedIndex()).getName());
			this.priceProductEntre.setToolTipText(String.valueOf(this.allProduct.get(this.combo.getSelectedIndex()).getPrice()));
			this.quantityProductEntre.setToolTipText(String.valueOf(this.allProduct.get(this.combo.getSelectedIndex()).getQuantity()));
			this.categoryProductEntre.setToolTipText(this.allProduct.get(this.combo.getSelectedIndex()).getCategory());
		}
		if(source == "Submit") {
			this.productFacades.modifyProduct(this.allProduct.get(this.combo.getSelectedIndex()), this.nameProductEntre.getText(), this.priceProductEntre.getText(), this.categoryProductEntre.getText(),this.quantityProductEntre.getText());
			this.vc.ProductManageViewSeller();
		}
	}
}