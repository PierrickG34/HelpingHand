package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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
import Core.Plan;
import Core.PlanFacade;
import Core.Product;
import Core.ProductFacade;

import Core.TaskFacade;
import Core.User;
import Excpetion.AlreadyExistException;

public class TaskCreateView extends JPanel implements ActionListener {

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
	JLabel createTask = new JLabel("  Create a task :");

	
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
	 * Description for the choose plan
	 */
	JLabel choosePlan = new JLabel("Please select a plan for your task");
	
	/**
	 * Define the drop down menu with the product
	 */
	JComboBox<String> comboProduct = new JComboBox<String>();
	
	/**
	 * Define the drop down menu with the plan
	 */
	JComboBox<String> comboPlan = new JComboBox<String>();
	
	/**
	 * Contain all the product of the database
	 */
	List<Product> allProduct = new ArrayList<Product>();
	
	/**
	 * Contain all the plab of the database
	 */
	List<Plan> allPlan = new ArrayList<Plan>();
	
	/**
	 * Description of the property ActivityCategoryFacades.
	 */
	public ProductFacade productFacades = new ProductFacade(this);
	
	/**
	 * Description of the property ActivityCategoryFacades.
	 */
	public PlanFacade planFacades = new PlanFacade(this);
	
	
	/**
	 * Description for the button validate
	 */
	JButton create = new JButton("Create");
	
	/**
	 * Description of the property ActivityCategoryFacades.
	 */
	public TaskFacade taskFacades = new TaskFacade(this);
//	
	private User currentUser;
	private ViewController vc;
	
	    /**
     * Describe error message
     */
    JLabel errorMessage = new JLabel("");
	
	public TaskCreateView(User currentUser, ViewController vc) {
//		super("Task"); // Name of the frame
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
		
//        Container contentPane = getContentPane(); 
//        contentPane.setLayout(new BorderLayout());
//        setMinimumSize(new Dimension(1000,500));
//        setMaximumSize(new Dimension(1000,500));
        
        JPanel panelButton = new JPanel(new GridLayout(3, 1)); // 2 rows x 1 column
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
        Font font = new Font("bold", Font.BOLD,12);
        this.createTask.setFont(font);
        panelButton.add(this.createTask);
        
//        contentPane.add(panelButton,BorderLayout.NORTH);
        this.add(panelButton,BorderLayout.NORTH);
        
  
        /*-------------- Veritable view --------------------*/
        JPanel panelAll = new JPanel(new GridLayout(2, 0));
        JPanel panelSemiAll = new JPanel(new GridLayout(2, 0));
        JPanel panelCreateTask = new JPanel();
		JPanel panelLabels = new JPanel(new GridLayout(0,1));
		JPanel panelTextField = new JPanel(new GridLayout(0,1));
		JPanel panelComboBoxProduct = new JPanel(new GridLayout(2, 1));
		JPanel panelComboBoxPlan = new JPanel(new GridLayout(2, 1));
		JPanel panelComboBoxAll = new JPanel(new GridLayout(1, 2));
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
		
		//Combo list product
		//Recuperate the product and add to the combobox
		this.getAllProduct();
		for (int i = 0; i< this.allProduct.size(); i++) {
			this.comboProduct.addItem(this.allProduct.get(i).getName());
		}
		panelComboBoxProduct.add(this.chooseProduct);
		panelComboBoxProduct.add(this.comboProduct);
		panelComboBoxAll.add(panelComboBoxProduct);
		
		//Combo list plan
		//Recuperate the plan and add to the combobox
		this.getAllPlan();
		for (int i = 0; i< this.allPlan.size(); i++) {
			this.comboPlan.addItem(this.allPlan.get(i).getNamePlan());
		}
		panelComboBoxProduct.add(this.choosePlan);
		panelComboBoxProduct.add(this.comboPlan);
		panelComboBoxAll.add(panelComboBoxPlan);
		
		
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
//		contentPane.add(panelAll, BorderLayout.CENTER);
		this.add(panelAll, BorderLayout.CENTER);

        //Display
//        setSize(400,120);
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void getAllProduct() {
		this.allProduct = this.productFacades.getAllProduct();
		
	}

	public void getAllPlan() {
		this.allPlan = this.planFacades.getAllPlan();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Create") {
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
				this.taskFacades.createTask(this.nameEntre.getText(), this.descriptionEntre.getText(), this.allProduct.get(this.comboProduct.getSelectedIndex()).getId(), this.allPlan.get(this.comboPlan.getSelectedIndex()).getIdPlan());
			}
		}
	}
		
}
