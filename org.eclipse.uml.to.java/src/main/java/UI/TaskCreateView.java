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

// TODO: Auto-generated Javadoc
/**
 * The Class TaskCreateView.
 */
public class TaskCreateView extends JPanel implements ActionListener {
	
	/** Descriptions for the mobile field. */
	JLabel createTask = new JLabel("  Create a task :");

	
	/** Descriptions for the mobile field. */
	JLabel name = new JLabel("Name :");
	
	/** The name entre. */
	JTextField nameEntre = new JTextField("", 15);
	
	/** Descriptions for the description field. */
	JLabel description = new JLabel("Description :");
	
	/** The description entre. */
	JTextField descriptionEntre = new JTextField("", 15);
	
	/** Description for the choose product. */
	JLabel chooseProduct = new JLabel("Please select a product for your task   ");
	
	/** Description for the choose plan. */
	JLabel choosePlan = new JLabel("Please select a plan for your task");
	
	/** Define the drop down menu with the product. */
	JComboBox<String> comboProduct = new JComboBox<String>();
	
	/** Define the drop down menu with the plan. */
	JComboBox<String> comboPlan = new JComboBox<String>();
	
	/** Contain all the product of the database. */
	List<Product> allProduct = new ArrayList<Product>();
	
	/** Contain all the plab of the database. */
	List<Plan> allPlan = new ArrayList<Plan>();
	
	/**
	 * Description of the property ActivityCategoryFacades.
	 */
	public ProductFacade productFacades = new ProductFacade(this);
	
	/**
	 * Description of the property ActivityCategoryFacades.
	 */
	public PlanFacade planFacades = new PlanFacade(this);
	
	
	/** Description for the button validate. */
	JButton create = new JButton("Create");
	
	/**
	 * Description of the property ActivityCategoryFacades.
	 */
	public TaskFacade taskFacades = new TaskFacade(this);

/** The current user. */
//	
	private User currentUser;
	
	/** The vc. */
	private ViewController vc;
	
	/** The menu admin view. */
	private MenuAdminView menuAdminView;
	
	    /** Describe error message. */
    JLabel errorMessage = new JLabel("");
	
	/**
	 * Instantiates a new task create view.
	 *
	 * @param currentUser the current user
	 * @param vc the vc
	 */
	public TaskCreateView(User currentUser, ViewController vc) {
//		super("Task"); // Name of the frame
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuAdminView = new MenuAdminView(vc);
		this.add(menuAdminView);
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
		//this.name.setHorizontalAlignment(SwingConstants.CENTER);
		panelLabels.add(this.name);
		panelTextField.add(this.nameEntre);
		
		//Description
		this.description.setPreferredSize(this.descriptionEntre.getPreferredSize());
		//this.description.setHorizontalAlignment(SwingConstants.CENTER);
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
		panelComboBoxAll.add(panelComboBoxProduct, BorderLayout.CENTER);
		
		//Combo list plan
		//Recuperate the plan and add to the combobox
		this.getAllPlan();
		for (int i = 0; i< this.allPlan.size(); i++) {
			this.comboPlan.addItem(this.allPlan.get(i).getNamePlan());
		}
		panelComboBoxPlan.add(this.choosePlan, BorderLayout.CENTER);
		panelComboBoxPlan.add(this.comboPlan, BorderLayout.CENTER);
		panelComboBoxAll.add(panelComboBoxPlan, BorderLayout.CENTER);
		
		
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
		this.add(panelAll, BorderLayout.CENTER);

	}
	
	/**
	 * Gets the all product.
	 *
	 * @return the all product
	 */
	private void getAllProduct() {
		this.allProduct = this.productFacades.getAllProduct();
		
	}

	/**
	 * Gets the all plan.
	 *
	 * @return the all plan
	 */
	public void getAllPlan() {
		this.allPlan = this.planFacades.getAllPlan();
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
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
				this.vc.TaskManageView();
			}
		}
	}
		
}
