
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

public class DeleteProductView extends JPanel implements ActionListener {
	
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
	JButton delete = new JButton("Delete");


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

public DeleteProductView(User currentUser, ViewController vc) {
//		super("DashBoard"); // Name of the frame
		this.currentUser = currentUser;
		this.vc = vc;
		/* Defined actions on the different buttons */
		this.dashboard.addActionListener(this);
		this.activityCategory.addActionListener(this);
		this.productCategory.addActionListener(this);
		this.product.addActionListener(this);
		this.account.addActionListener(this);
		this.plan.addActionListener(this);
		this.task.addActionListener(this);
		this.profile.addActionListener(this);
		this.notifications.addActionListener(this);

//		Container contentPane = getContentPane(); 
//		contentPane.setLayout(new BorderLayout());
//		setMinimumSize(new Dimension(1000,500));
//		setMaximumSize(new Dimension(1000,500));

		JPanel panelButton = new JPanel(new GridLayout(2, 1)); // 2 rows x 1 column
		JPanel panelTopButton = new JPanel();
		JPanel panelBottomButton = new JPanel();

		panelTopButton.add(this.dashboard);
		panelTopButton.add(this.activityCategory);
		panelTopButton.add(this.productCategory);
		panelTopButton.add(this.product);
		panelTopButton.add(this.account);
		panelTopButton.add(this.plan);
		panelTopButton.add(this.task);

		panelBottomButton.add(this.profile);
		panelBottomButton.add(this.notifications);

		panelButton.add(panelTopButton);
		panelButton.add(panelBottomButton);

//		contentPane.add(panelButton,BorderLayout.NORTH);
		this.add(panelButton,BorderLayout.NORTH);

		/*-------------- Veritable view --------------------*/
		JPanel panelAll = new JPanel();
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

//		contentPane.add(panelAll, BorderLayout.WEST);
		this.add(panelAll, BorderLayout.WEST);

		//Display
//		setSize(400,120);
//		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Choose") {
			this.panelEditAll.setVisible(true);
		}
		if(source == "Delete") {
			this.productFacades.DeleteProduct(this.allProduct.get(this.combo.getSelectedIndex()));
		}
	}
}