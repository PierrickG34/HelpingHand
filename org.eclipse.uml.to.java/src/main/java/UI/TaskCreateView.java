package UI;

import java.awt.BorderLayout;
import java.awt.Color;
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
import Excpetion.AlreadyExistException;

public class TaskCreateView extends JFrame implements ActionListener {

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
	 * Descriptions for the mobile field
	 */
	JLabel name = new JLabel("Name :");
	JTextField nameEntre = new JTextField("", 15);
	
	/**
	 * Descriptions for the description field
	 */
	JLabel description = new JLabel("Description :");
	JTextField descriptionEntre = new JTextField("", 15);
	
	/**
	 * Description for the choose product
	 */
	JLabel chooseProduct = new JLabel("Please select a product for your task");
	
	/**
	 * Define the drop down menu with the product
	 */
	JComboBox<String> combo = new JComboBox<String>();
	
	/**
	 * Contain all the product of the database
	 */
	List<Product> allProduct = new ArrayList<Product>();
	
	/**
	 * Description of the property ActivityCategoryFacades.
	 */
	public ProductFacade productFacades = new ProductFacade(this);
	
	
	/**
	 * Description for the button validate
	 */
	JButton create = new JButton("Create");
	
//	/**
//	 * Description of the property ActivityCategoryFacades.
//	 */
//	public ActivityCategoryFacade activityCategoryFacades = new ActivityCategoryFacade(this);
//	
	private User currentUser;
	
	    /**
     * Describe error message
     */
    JLabel errorMessage = new JLabel("");
	
	public TaskCreateView(User currentUser) {
		super("Task"); // Name of the frame
		this.currentUser = currentUser;
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
		
        Container contentPane = getContentPane(); 
        contentPane.setLayout(new BorderLayout());
        setMinimumSize(new Dimension(1000,500));
        setMaximumSize(new Dimension(1000,500));
        
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
        
        contentPane.add(panelButton,BorderLayout.NORTH);
        
  
        /*-------------- Veritable view --------------------*/
        JPanel panelAll = new JPanel(new GridLayout(2, 0));
        JPanel panelSemiAll = new JPanel(new GridLayout(2, 0));
        JPanel panelCreateTask = new JPanel();
		JPanel panelLabels = new JPanel(new GridLayout(0,1));
		JPanel panelTextField = new JPanel(new GridLayout(0,1));
		JPanel panelComboBox = new JPanel(new GridLayout(2, 1));
		JPanel panelComboBoxAll = new JPanel();
		JPanel panelButtonValidate = new JPanel();
		
		//Name
		this.name.setPreferredSize(this.nameEntre.getPreferredSize());
		this.name.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.name);
		panelTextField.add(this.nameEntre);
		
		//Description
		this.description.setPreferredSize(this.descriptionEntre.getPreferredSize());
		this.description.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.description);
		panelTextField.add(this.descriptionEntre);
		
		//Combo Product
//		this.combo.addItem("Test");
//		this.combo.addItem("REGFRERFRF");
		//Recuperate the activity Category and add to the combobox
		this.allProduct = this.productFacades.getAllProduct();
		for (int i = 0; i< this.allProduct.size(); i++) {
			this.combo.addItem(this.allProduct.get(i).getName());
		}
		panelComboBox.add(this.chooseProduct);
		panelComboBox.add(this.combo);
		panelComboBoxAll.add(panelComboBox);
		
		
		panelCreateTask.add(panelLabels);
		panelCreateTask.add(panelTextField);

		panelSemiAll.add(panelCreateTask);
		panelSemiAll.add(panelComboBoxAll);
		panelButtonValidate.add(this.create, BorderLayout.CENTER);
		panelButtonValidate.add(this.errorMessage, BorderLayout.CENTER);
		this.errorMessage.setVisible(false);
		this.create.addActionListener(this);
		
		panelAll.add(panelSemiAll);
		panelAll.add(panelButtonValidate);
		contentPane.add(panelAll, BorderLayout.WEST);

        //Display
        setSize(400,120);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Create") {
			System.out.println("BUTTON CREATE");
			/* Clean error message */
			this.errorMessage.setVisible(false);
			this.name.setForeground(Color.black);
			this.description.setForeground(Color.black);
			
			
			/* Test if the task fill alls field */
			int count = 0;
			if(this.nameEntre.getText().isEmpty()) {
				this.errorMessage.setText("Enter a name please");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
				this.name.setForeground(Color.red);
				count++;
			}
			if(this.descriptionEntre.getText().isEmpty()) {
				this.errorMessage.setText("Enter a description please");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
				this.description.setForeground(Color.red);
				count++;
			}
			if(count >= 2) {
				this.errorMessage.setText("Please complete all fields");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
			}
			
			/*If all fields are filled, execute the request*/
			if(!this.nameEntre.getText().isEmpty() && !this.descriptionEntre.getText().isEmpty()) {
				System.out.println("On peut le creer!");
			}
		}
	}
		
}
