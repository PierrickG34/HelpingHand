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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Core.ActivityCategoryFacade;
import Core.User;
import Excpetion.AlreadyExistException;

public class CreateActivityCategoryView extends JPanel implements ActionListener {

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
	JLabel createActivityCategory = new JLabel("  Create an activity category :");
	
	/**
	 * Descriptions for the name field
	 */
	JLabel name = new JLabel("Name :");
	/**
	 * Descriptions for the name field
	 */
	JTextField nameEntre = new JTextField("", 15);
	
	/**
	 * Descriptions for the short detail field
	 */
	JLabel shortDetail = new JLabel("Short Detail :");
	/**
	 * Descriptions for the short detail field
	 */
	JTextField shortDetailEntre = new JTextField("", 15);
	
	/**
	 * Descriptions for the long detail field
	 */
	JLabel longDetail = new JLabel("Long Detail :");
	/**
	 * Descriptions for the long detail field
	 */
	JTextField longDetailEntre = new JTextField("", 15);
	
	/**
	 * Description for the button validate
	 */
	JButton validate = new JButton("Validate");
	
	/**
	 * Description of the property ActivityCategoryFacades.
	 */
	public ActivityCategoryFacade activityCategoryFacades = new ActivityCategoryFacade(this);
	
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
	public CreateActivityCategoryView(User currentUser) {
//		super("Activity Category"); // Name of the frame
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
        this.createActivityCategory.setFont(font);
        panelButton.add(this.createActivityCategory);
        
//        contentPane.add(panelButton,BorderLayout.NORTH);
        this.add(panelButton,BorderLayout.NORTH);
        
  
        /*-------------- Veritable view --------------------*/
        JPanel panelAll = new JPanel(new GridLayout(2, 0));
        JPanel panelCreateActivityCategory = new JPanel();
		JPanel panelLabels = new JPanel(new GridLayout(0,1));
		JPanel panelTextField = new JPanel(new GridLayout(0,1));
		JPanel panelButtonValidate = new JPanel();
		
		//Name
		this.name.setPreferredSize(this.nameEntre.getPreferredSize());
		this.name.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.name);
		panelTextField.add(this.nameEntre);
		
		//Short Detail
		this.shortDetail.setPreferredSize(this.shortDetailEntre.getPreferredSize());
		this.shortDetail.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.shortDetail);
		panelTextField.add(this.shortDetailEntre);
		
		//Long Detail
		this.longDetail.setPreferredSize(this.longDetailEntre.getPreferredSize());
		this.longDetail.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.longDetail);
		panelTextField.add(this.longDetailEntre);
		
		panelCreateActivityCategory.add(panelLabels);
		panelCreateActivityCategory.add(panelTextField);
		panelButtonValidate.add(validate, BorderLayout.CENTER);
		panelButtonValidate.add(this.errorMessage, BorderLayout.CENTER);
		this.errorMessage.setVisible(false);
		this.validate.addActionListener(this);
		
		panelAll.add(panelCreateActivityCategory);
		panelAll.add(panelButtonValidate);
//		contentPane.add(panelAll, BorderLayout.WEST);
		this.add(panelAll, BorderLayout.WEST);

//        //Display
//        setSize(400,120);
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Validate") {
			/* Clean error message */
			this.errorMessage.setVisible(false);
			this.name.setForeground(Color.black);
			this.shortDetail.setForeground(Color.black);
			this.longDetail.setForeground(Color.black);
			
			/* Test if the admin fill alls field */
			int count = 0;
			if(this.nameEntre.getText().isEmpty()) {
				this.errorMessage.setText("Enter a name please");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
				this.name.setForeground(Color.red);
				count++;
			}
			if(this.shortDetailEntre.getText().isEmpty()) {
				this.errorMessage.setText("Enter a short detail please");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
				this.shortDetail.setForeground(Color.red);
				count++;
			}
			if(this.longDetailEntre.getText().isEmpty()) {
				this.errorMessage.setText("Enter a long detail please");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
				this.longDetail.setForeground(Color.red);
				count++;
			}
			if(count > 2) {
				this.errorMessage.setText("Please complete all fields");
				this.errorMessage.setVisible(true);
				this.errorMessage.setForeground(Color.red);
			}
			
			/*If all fields are filled, execute the request*/
			if(!this.nameEntre.getText().isEmpty() && !this.shortDetailEntre.getText().isEmpty() && !this.longDetailEntre.getText().isEmpty() && !this.currentUser.getIdUser().equals("")) {
				try {
					this.activityCategoryFacades.createActivityCategory(this.nameEntre.getText(), this.shortDetailEntre.getText(), this.longDetailEntre.getText(), this.currentUser.getIdUser());
				} catch (AlreadyExistException errorCreateActivityCategory) {
					this.errorMessage.setText(errorCreateActivityCategory.getNameError());
					this.errorMessage.setForeground(Color.red);
					this.errorMessage.setVisible(true);
					this.name.setForeground(Color.red);
				}
			}
		}
	}
}
