package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Core.User;

public class PlanManageView extends JPanel implements ActionListener {

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
	 * Button for create an activity category
	 */
	JButton create = new JButton("Create a Plan");
	
	/**
	 * Button for update an activity category
	 */
	JButton update = new JButton("Update a Plan");
	
	JButton delete = new JButton("Delete a Plan");
	
	/**
	 * The current user
	 */
	private User currentUser;
	private ViewController vc;

	
	/**
	 * Constructor for the class
	 * @param currentUser
	 */
	public PlanManageView(User currentUser, ViewController vc) {
//		super("Plan"); // Name of the frame
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
		
		/*Define the container*/
//        Container contentPane = getContentPane(); 
//        contentPane.setLayout(new BorderLayout());
//        setMinimumSize(new Dimension(1000,500));
//        setMaximumSize(new Dimension(1000,500));
        
        /*Define container for the display*/
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
        
//        contentPane.add(panelButton,BorderLayout.NORTH);
        this.add(panelButton,BorderLayout.NORTH);
        
  
        /*-------------- Veritable view --------------------*/
        JPanel manageButton = new JPanel(new GridLayout(3, 1));
        JPanel createButton = new JPanel();
        JPanel updateButton = new JPanel();
        JPanel deleteButton = new JPanel();
        
        this.create.addActionListener(this);
        this.update.addActionListener(this);
        this.delete.addActionListener(this);
        
        createButton.add(this.create);
        updateButton.add(this.update);
        deleteButton.add(this.delete);
        
        manageButton.add(createButton);
        manageButton.add(updateButton);
        manageButton.add(deleteButton);
        
//        contentPane.add(manageButton, BorderLayout.WEST);
        this.add(manageButton, BorderLayout.WEST);

        //Display
//        setSize(400,120);
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Action when the user click on a button
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Create a Plan") {
			System.out.println("PlanManageView --> DEJA FAIT");
		}
		else if(source == "Update a Plan") {
			System.out.println("PlanManageView --> Button udpdate");
		}
		else if(source == "Delete a Plan") {
			this.vc.PlanDeleteView();
		}
	}
}
