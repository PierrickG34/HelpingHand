package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuAdminView extends JPanel implements ActionListener {
	
	private JButton dashboard = new JButton("Dashboard");
	private JButton activityCategory = new JButton("Activity Category");
	private JButton productCategory = new JButton("Product Category");
	private JButton product = new JButton("Product");
	private JButton account = new JButton("Account");
	private JButton plan = new JButton("Plan");
	private JButton task = new JButton("Task");
	   
	private JButton profile = new JButton("Profile");
	private JButton notifications = new JButton("Notifications");
	
	private ViewController vc;
	
	public MenuAdminView(ViewController vc) {
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
        
        this.add(panelButton,BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if (source == "Dashboard") {
			this.vc.dashboardAdminView();
		}
		else if (source == "Activity Category" ){
//			ActivtyCategoryManageView activityCategory = new ActivtyCategoryManageView(this.currentUser);
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
