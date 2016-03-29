package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Core.ActivityCategory;
import Core.ActivityCategoryFacade;
import Core.PlanFacade;
import Core.User;
import Persist.DateLabelFormatter;

public class CreatePlanView extends JPanel implements ActionListener {

	/**
	 * Menu button for dashboard
	 */
	JButton dashboard = new JButton("Dashboard");
	
	/**
	 * Menu button for activity category
	 */
	JButton activityCategory = new JButton("Activity Category");
	
	/**
	 * Menu button for product category
	 */
	JButton productCategory = new JButton("Product Category");
	
	/**
	 * Menu button for product
	 */
	JButton product = new JButton("Product");
	
	/**
	 * Menu button for account
	 */
	JButton account = new JButton("Account");
	
	/**
	 * Menu button for plan
	 */
	JButton plan = new JButton("Plan");
	
	/**
	 * Menu button for task
	 */
	JButton task = new JButton("Task");
	
	/**
	 * Menu button for profile
	 */   
	JButton profile = new JButton("Profile");
	
	/**
	 * Menu button for notification
	 */
	JButton notifications = new JButton("Notifications");
	
	
	
	/**
	 * Descriptions for the windows
	 */
	JLabel createPlan = new JLabel("  Create a Plan:");
	
	/**
	 * Descriptions for the name field
	 */
	JLabel name = new JLabel("Name :");
	/**
	 * Descriptions for the name field
	 */
	JTextField nameEntre = new JTextField("", 15);
	
	/**
	 * Descriptions for the observation field
	 */
	JLabel observation = new JLabel("Observation :");
	
	/**
	 * Descriptions for the short detail field
	 */
	JTextField observationEntre = new JTextField("", 15);
	
    /**
     * Description for date of birth
     */
    JLabel dateOfBirth = new JLabel("Enter a date of birth :*");
    UtilDateModel model = new UtilDateModel();
    JDatePanelImpl datePanel;
    JDatePickerImpl datePicker;
	
    /** Define the drop down menu with the activity category. */
	JComboBox<String> comboActivityCategory = new JComboBox<String>();
	
	/** Contain all the activity category of the database. */
	List<ActivityCategory> allActivityCategory = new ArrayList<ActivityCategory>();
	
	/** Text to choose the activity category to delete. */
	JLabel chooseActivityCategory = new JLabel("Choose an activity category : ");
	
	/** Define the drop down menu with the true or false for the public plan. */
	JComboBox<String> comboPublic = new JComboBox<String>();
	
	/** Text to choose the activity category to delete. */
	JLabel choosePublic = new JLabel("Choose public : ");
	
	
	

	
	/**
	 * Description for the button validate
	 */
	JButton validate = new JButton("Validate");
	
	/**
	 * Description of the property ActivityCategoryFacades.
	 */
	public ActivityCategoryFacade activityCategoryFacades = new ActivityCategoryFacade(this);
	
	/**
	 * Description of the property Plan
	 */
	public PlanFacade planFacades = new PlanFacade(this);
	
	/**
	 * The current user
	 */
	private User currentUser;
	
	 /**
     * Describe error message
     */
    JLabel errorMessage = new JLabel("");
	
    /**
     * Constructor
     * @param currentUser
     */
	public CreatePlanView(User currentUser) {
//		super("Task"); // Name of the frame
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
		
		/*Define the container*/
//        Container contentPane = getContentPane(); 
//        contentPane.setLayout(new BorderLayout());
//        setMinimumSize(new Dimension(1000,500));
//        setMaximumSize(new Dimension(1000,500));
        
        /*Define container for the display*/
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
        this.createPlan.setFont(font);
        panelButton.add(this.createPlan);
        
//        contentPane.add(panelButton,BorderLayout.NORTH);
        this.add(panelButton,BorderLayout.NORTH);
        
        
  
        /*-------------- Veritable view --------------------*/
        JPanel panelAll = new JPanel(new GridLayout(2,0));
        JPanel panelSemiAll = new JPanel(new GridLayout(2,0));
        JPanel panelCreate = new JPanel();
        JPanel panelLabels = new JPanel(new GridLayout(0,1));
		JPanel panelTextFiel = new JPanel(new GridLayout(0,1));
		JPanel panelCombo = new JPanel(new GridLayout(1, 2));
		JPanel panelcomboAC = new JPanel(new GridLayout(2, 0));
		JPanel panelcomboPublic = new JPanel(new GridLayout(2, 0));
		JPanel panelButtonValidate = new JPanel();
		JPanel panelComboAll = new JPanel();
        
		// Name 
        this.name.setPreferredSize(this.nameEntre.getPreferredSize());
        this.name.setHorizontalAlignment(SwingConstants.RIGHT);
        panelLabels.add(this.name);
        panelTextFiel.add(this.nameEntre);
        
        // Name 
        this.observation.setPreferredSize(this.observationEntre.getPreferredSize());
        this.observation.setHorizontalAlignment(SwingConstants.RIGHT);
        panelLabels.add(this.observation);
        panelTextFiel.add(this.observationEntre);
        
        // Dead line
        this.dateOfBirth.setHorizontalAlignment(SwingConstants.RIGHT);
        panelLabels.add(this.dateOfBirth);
        Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		this.datePanel = new JDatePanelImpl(model, p);
		this.datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		panelTextFiel.add(datePicker);
		
		//Recuperate the activity Category and add to the combobox
		this.allActivityCategory = this.activityCategoryFacades.getAllCategories();
		for (int i = 0; i< this.allActivityCategory.size(); i++) {
			this.comboActivityCategory.addItem(this.allActivityCategory.get(i).getName());
		}
		panelcomboAC.add(this.chooseActivityCategory);
		panelcomboAC.add(this.comboActivityCategory);
		
		// Combo box public or not
		this.comboPublic.addItem("Yes");
		this.comboPublic.addItem("No");
		panelcomboPublic.add(this.choosePublic);
		panelcomboPublic.add(this.comboPublic);
		
		panelButtonValidate.add(this.validate, BorderLayout.CENTER);
		panelButtonValidate.add(this.errorMessage, BorderLayout.CENTER);
		this.validate.addActionListener(this);
        
        
		panelCreate.add(panelLabels);
        panelCreate.add(panelTextFiel);
        panelCombo.add(panelcomboAC);
        panelCombo.add(panelcomboPublic);
        panelComboAll.add(panelCombo);
        panelSemiAll.add(panelCreate);
        panelSemiAll.add(panelComboAll);
        panelAll.add(panelSemiAll);
        panelAll.add(panelButtonValidate);
        
//        contentPane.add(panelAll, BorderLayout.CENTER);
        this.add(panelAll, BorderLayout.CENTER);
        
       
        
        
        //Display
//        setSize(400,120);
//		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Validate") {
			/* Clean error message */
			this.errorMessage.setVisible(false);
			this.name.setForeground(Color.black);
			this.observation.setForeground(Color.black);
			this.dateOfBirth.setForeground(Color.black);
			
			/* Test if the plan fill alls field */
			int count = 0;
			if(this.nameEntre.getText().isEmpty()) {
				this.errorMessage.setText("Enter a name please");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
				this.name.setForeground(Color.red);
				count++;
			}
			if(this.observationEntre.getText().isEmpty()) {
				this.errorMessage.setText("Enter an observation");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
				this.observation.setForeground(Color.red);
				count++;
			}
			if(count > 0) {
				this.errorMessage.setText("Please complete all fields");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
			}
			
			System.out.println("id of category" + this.allActivityCategory.get(this.comboActivityCategory.getSelectedIndex()).getIdActivityCategory());
			System.out.println("public ? " + this.comboPublic.getSelectedItem());
			
			/* If all the fiels are fills, we save*/
			if(!this.nameEntre.getText().isEmpty() && !this.observationEntre.getText().isEmpty()) {
				/* Cast date to a valid format for postgresql database*/
				java.util.Date dateOfUser = (Date) datePicker.getModel().getValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				final String stringDate= dateFormat.format(dateOfUser);
				final java.sql.Date valideDateUser =  java.sql.Date.valueOf(stringDate);
				
				boolean isPublic;
				if(this.comboPublic.getSelectedItem() == "Yes") {
					isPublic = true;
				}
				else {
					isPublic = false;
				}
				
				this.planFacades.createPlan(this.nameEntre.getText(), this.observationEntre.getText(), valideDateUser, false, isPublic, this.allActivityCategory.get(this.comboActivityCategory.getSelectedIndex()).getName(), this.currentUser.getIdUser());
			}
		}
		
	}
}
	
