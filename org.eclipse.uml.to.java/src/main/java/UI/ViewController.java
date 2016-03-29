package UI;

import java.awt.Dimension;

import javax.swing.JFrame;

import Core.User;

public class ViewController {

	private User currentUser;
	private JFrame helpinghand = new JFrame();
	
	public ViewController(User current) {
		this.currentUser = current;
		helpinghand.setVisible(true);
		helpinghand.setTitle("Helping Hand");
		helpinghand.setMinimumSize((new Dimension(1000,500)));
		helpinghand.setMaximumSize((new Dimension(1000,500)));
		helpinghand.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void AccountAdminView() {
		this.helpinghand.setContentPane(new AccountAdminView(this.currentUser));
	}
	
	public void ActivityCategoryManageView() {
		ActivtyCategoryManageView activityCategoryManageView = new ActivtyCategoryManageView(this.currentUser);
	}
	
	public void dashboardAdminView() {
		this.helpinghand.setContentPane(new DashboardAdminView(this.currentUser));
	}
}
