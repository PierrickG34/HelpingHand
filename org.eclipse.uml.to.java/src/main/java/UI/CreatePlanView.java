package UI;

import java.awt.BorderLayout;
import java.awt.Color;
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

/**
 * The Class CreatePlanView.
 * 
 * @author HelpingHand
 */
public class CreatePlanView extends JPanel implements ActionListener {
	
	/** Descriptions for the windows. */
	JLabel createPlan = new JLabel("  Create a Plan:");
	
	/** Descriptions for the name field. */
	JLabel name = new JLabel("Name :");
	
	/** Descriptions for the name field. */
	JTextField nameEntre = new JTextField("", 15);
	
	/** Descriptions for the observation field. */
	JLabel observation = new JLabel("Observation :");
	
	/** Descriptions for the short detail field. */
	JTextField observationEntre = new JTextField("", 15);
	
    /** Description for date of birth. */
    JLabel dateOfBirth = new JLabel("Enter a date of birth :*");
    
    /** The model. */
    UtilDateModel model = new UtilDateModel();
    
    /** The date panel. */
    JDatePanelImpl datePanel;
    
    /** The date picker. */
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
	
	/** Description for the button validate. */
	JButton validate = new JButton("Validate");
	
	/**
	 * Description of the property ActivityCategoryFacades.
	 */
	public ActivityCategoryFacade activityCategoryFacades = new ActivityCategoryFacade(this);
	
	/** Description of the property Plan. */
	public PlanFacade planFacades = new PlanFacade(this);
	
	/** The current user. */
	private User currentUser;
	
	 /** Describe error message. */
    JLabel errorMessage = new JLabel("");
    
    /** The ViewController. */
    private ViewController vc;
	
	/** The menu admin view. */
	private MenuAdminView menuAdminView;
	
    /**
     * Constructor.
     *
     * @param currentUser the current user
     * @param vc the vc
     */
	public CreatePlanView(User currentUser, ViewController vc) {
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuAdminView = new MenuAdminView(this.vc);
		this.add(menuAdminView);
	
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
        
        this.add(panelAll, BorderLayout.CENTER);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
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
				this.vc.PlanManageView();
			}
		}
		
	}
}
	
