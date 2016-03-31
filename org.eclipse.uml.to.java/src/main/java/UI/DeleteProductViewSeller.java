
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

import Core.Product;
import Core.ProductFacade;
import Core.User;
import Persist.ProductJDBC;

/**
 * The Class DeleteProductViewSeller.
 * 
 * @author HelpingHand
 */
public class DeleteProductViewSeller extends JPanel implements ActionListener {
	
	/** Description for the button validate. */
	JButton delete = new JButton("Delete");


	/** The combo. */
	JComboBox<String> combo = new JComboBox<String>();

	/** Text to choose the product to delete. */
	JLabel chooseProduct = new JLabel("Choose an product :");

	/** Button who permit to validate the product choosen. */
	JButton chooseProductButton = new JButton("Choose");

	/** This panel permit to display information. */
	JPanel panelEditAll = new JPanel(new GridLayout(2,0));
	
	/** Define the current product that the admin choose. */
	ProductJDBC currentProductJDBC;

	/**
	 * Description of the property ProductFacades.
	 */
	public ProductFacade productFacades = new ProductFacade(this);
	
	/** Contain all the activity category of the database. */
	List<Product> allProduct = new ArrayList<Product>();

	/** The current user. */
	private User currentUser;
	
	/** The menu seller view. */
	private MenuSellerView menuSellerView;
	
	/** The ViewController. */
	private ViewController vc;

/**
 * Instantiates a new delete product view seller.
 *
 * @param currentUser the current user
 * @param vc the ViewController
 */
public DeleteProductViewSeller(User currentUser, ViewController vc) {
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuSellerView = new MenuSellerView(this.vc);
		this.add(menuSellerView);

		/*-------------- Veritable view --------------------*/
		JPanel panelAll = new JPanel(new GridLayout(1, 2));
		JPanel panelEdit = new JPanel();
		JPanel panelButtonValidate = new JPanel();
		JPanel panelComboBox = new JPanel(new GridLayout(3, 1));

		this.delete.addActionListener(this);
		this.chooseProductButton.addActionListener(this);

		//Recuperate the product and add to the combobox
		this.allProduct = this.productFacades.getAllProduct(this.currentUser.getIdUser());
		for (int i = 0; i< this.allProduct.size(); i++) {
			this.combo.addItem(this.allProduct.get(i).getName());
		}
		panelComboBox.add(this.chooseProduct);
		panelComboBox.add(this.combo);
		panelComboBox.add(this.chooseProductButton);
	 
		panelButtonValidate.add(delete, BorderLayout.CENTER);
		panelAll.add(panelComboBox);

		this.panelEditAll.setVisible(false);
		this.panelEditAll.add(panelEdit);
		this.panelEditAll.add(panelButtonValidate);
		panelAll.add(this.panelEditAll);

		this.add(panelAll, BorderLayout.CENTER);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Choose") {
			this.panelEditAll.setVisible(true);
		}
		if(source == "Delete") {
			this.productFacades.DeleteProduct(this.allProduct.get(this.combo.getSelectedIndex()));
			this.vc.DeleteProductViewSeller();
		}
	}
}