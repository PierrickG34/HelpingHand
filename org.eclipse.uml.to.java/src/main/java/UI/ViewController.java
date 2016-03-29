package UI;

import java.awt.Dimension;

import javax.swing.JFrame;

import Core.Plan;
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
	
	
	
	public void ActivityCategoryManageView() {
		ActivtyCategoryManageView activityCategoryManageView = new ActivtyCategoryManageView(this.currentUser);
	}
	
	//DASHBOARD
	public void dashboardAdminView() {
		this.helpinghand.setContentPane(new DashboardAdminView(this.currentUser));
	}
	
	public void dashboardUserView() {
		this.helpinghand.setContentPane(new DashboardUserView(this.currentUser));
	}
	
	public void dashboardSellerView() {
		this.helpinghand.setContentPane(new DashboardSellerView(this.currentUser));
	}
	
	//ACCOUNT
	public void AccountAdminView() {
		this.helpinghand.setContentPane(new AccountAdminView(this.currentUser));
	}
	
	public void ProfileUserView() {
		this.helpinghand.setContentPane(new ProfileUserView(this.currentUser));
	}
	
	public void ProfileUserModifyView() {
		this.helpinghand.setContentPane(new ProfileUserModifyView(this.currentUser));
	}
	
	public void UpdateAccountAdminView() {
		this.helpinghand.setContentPane(new UpdateAccountAdminView(this.currentUser));
	}
	
	public void DeleteAccountAdminView() {
		this.helpinghand.setContentPane(new DeleteAccountAdminView(this.currentUser));
	}
	
	//PLAN
	public void PlanDeleteView() {
		this.helpinghand.setContentPane(new PlanDeleteView(this.currentUser));
	}
	
	public void PlanManageView() {
		this.helpinghand.setContentPane(new PlanManageView(this.currentUser));
	}
	
	public void PlanView(Plan plan) {
		this.helpinghand.setContentPane(new PlanView(this.currentUser, plan));
	}
	
	public void CreatePlanView() {
		this.helpinghand.setContentPane(new CreatePlanView(this.currentUser));
	}
	
	//PRODUCT
	public void ProductCreateView() {
		this.helpinghand.setContentPane(new ProductCreateView(this.currentUser));
	}
	
	public void ProductManageView() {
		this.helpinghand.setContentPane(new ProductManageView(this.currentUser));
	}
	
	public void DeleteProductView() {
		this.helpinghand.setContentPane(new DeleteProductView(this.currentUser));
	}
	
	public void UpdateProductView() {
		this.helpinghand.setContentPane(new UpdateProductView(this.currentUser));
	}
	
	//TASK
	public void TaskCreateView() {
		this.helpinghand.setContentPane(new TaskCreateView(this.currentUser));
	}
	
	public void TaskDeleteView() {
		this.helpinghand.setContentPane(new TaskDeleteView(this.currentUser));
	}
	
	public void TaskManageView() {
		this.helpinghand.setContentPane(new TaskManageView(this.currentUser));
	}
	
	public void TaskUpdateView() {
		this.helpinghand.setContentPane(new TaskUpdateView(this.currentUser));
	}
	
	//ACTIVITY CATEGORY
	public void CreateActivityCategoryView() {
		this.helpinghand.setContentPane(new CreateActivityCategoryView(this.currentUser));
	}
	
	public void ActivtyCategoryManageView() {
		this.helpinghand.setContentPane(new ActivtyCategoryManageView(this.currentUser));
	}
	
	public void UpdateActivityCategoryView() {
		this.helpinghand.setContentPane(new UpdateActivityCategoryView(this.currentUser));
	}
	
}
