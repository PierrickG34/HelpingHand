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

public class DashboardAdminView extends JFrame implements ActionListener {
	
	JButton dashboard = new JButton("Dashboard");
	JButton activityCategory = new JButton("Activity Category");
	JButton productCategory = new JButton("Product Category");
	JButton product = new JButton("Product");
	JButton account = new JButton("Account");
	JButton plan = new JButton("Plan");
	JButton task = new JButton("Task");
	   
	JButton profile = new JButton("Profile");
	JButton notifications = new JButton("Notifications");
	
	
	private User currentUser;
	
	
	
	public DashboardAdminView(User currentUser) {
		super("DashBoard"); // Name of the frame
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

        //Display
        setSize(400,120);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if (source == "Dashboard") {
			System.out.println("Je suis Dashboard");
			System.out.println("Action a définir ici...");
		}
		else if (source == "Activity Category" ){
//			System.out.println("Je suis Activity Category");
//			System.out.println("Action a définir ici...");
			ActivtyCategoryManageView activityCategory = new ActivtyCategoryManageView(this.currentUser);
		}
		else if (source == "Product Category"){
			System.out.println("Je suis Product Category");
			System.out.println("Action a définir ici...");
		}
		else if (source == "Product"){
			System.out.println("Je suis Product");
			System.out.println("Action a définir ici...");
		}
		else if (source == "Account"){
			AccountAdminView accountAdminView = new AccountAdminView(this.currentUser);
		}
		else if (source == "Plan"){
			System.out.println("Je suis Plan");
			System.out.println("Action a définir ici...");
		}
		else if (source == "Task"){
			TaskManageView taskManageView = new TaskManageView(this.currentUser);
		}
		else if (source == "Profile"){
			System.out.println("Je suis Profile");
			System.out.println("Action a définir ici...");
		}
		else if (source == "Notifications"){
			System.out.println("Je suis Notifications");
			System.out.println("Action a définir ici...");
		}
	}

}
