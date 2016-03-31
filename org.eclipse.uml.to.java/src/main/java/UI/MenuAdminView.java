package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuAdminView.
 * 
 * @author HelpingHand
 */
public class MenuAdminView extends JPanel implements ActionListener {
	
	/** The dashboard. */
	private JButton dashboard = new JButton("Dashboard");
	
	/** The activity category. */
	private JButton activityCategory = new JButton("Activity Category");
	
	/** The product category. */
	private JButton productCategory = new JButton("Product Category");
	
	/** The product. */
	private JButton product = new JButton("Product");
	
	/** The account. */
	private JButton account = new JButton("Account");
	
	/** The plan. */
	private JButton plan = new JButton("Plan");
	
	/** The task. */
	private JButton task = new JButton("Task");
	   
	/** The profile. */
	private JButton profile = new JButton("Profile");
	
	/** The notifications. */
	private JButton notifications = new JButton("Notifications");
	
	/** The ViewControler. */
	private ViewController vc;
	
	/**
	 * Instantiates a new menu admin view.
	 *
	 * @param vc the ViewController
	 */
	public MenuAdminView(ViewController vc) {
		this.vc = vc;
		
		/* Defined actions on the different buttons */
		this.dashboard.addActionListener(this);
		this.activityCategory.addActionListener(this);
		this.productCategory.addActionListener(this);
		this.productCategory.setEnabled(false);
		this.product.addActionListener(this);
		this.account.addActionListener(this);
		this.plan.addActionListener(this);
		this.task.addActionListener(this);
		this.profile.addActionListener(this);
		this.notifications.addActionListener(this);
		this.notifications.setEnabled(false);
		
		JPanel panelButton = new JPanel(new GridLayout(3, 1)); // 3 rows x 1 column
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
        
        this.add(panelButton,BorderLayout.NORTH);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if (source == "Dashboard") {
			this.vc.dashboardAdminView();
		}
		else if (source == "Activity Category" ){
			this.vc.ActivtyCategoryManageView();
		}
		else if (source == "Product Category"){
			System.out.println("Action pas faite");
		}
		else if (source == "Product"){
			this.vc.ProductManageView();
		}
		else if (source == "Account"){
			this.vc.AccountAdminView();
		}
		else if (source == "Plan"){
			this.vc.PlanManageView();
		}
		else if (source == "Task"){
			this.vc.TaskManageView();
		}
		else if (source == "Profile"){
			this.vc.ProfileAdminView();
		}
		else if (source == "Notifications"){
			System.out.println("Action pas faite");
		}
	}
}
