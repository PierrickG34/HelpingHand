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
	
	//DASHBOARD
	public void dashboardAdminView() {
		this.helpinghand.setContentPane(new DashboardAdminView(this.currentUser,this));
	}
	
	public void dashboardUserView() {
		this.helpinghand.setContentPane(new DashboardUserView(this.currentUser,this));
	}
	
	public void dashboardSellerView() {
		this.helpinghand.setContentPane(new DashboardSellerView(this.currentUser,this));
	}
	
	//ACCOUNT
	public void AccountAdminView() {
		this.helpinghand.setContentPane(new AccountAdminView(this.currentUser,this));
	}
	
	public void ProfileUserView() {
		this.helpinghand.setContentPane(new ProfileUserView(this.currentUser,this));
	}
	
	public void ProfileSellerView() {
		this.helpinghand.setContentPane(new ProfileSellerView(this.currentUser,this));
	}
	
	public void ProfileAdminView() {
		this.helpinghand.setContentPane(new ProfileAdminView(this.currentUser,this));
	}
	
	public void ProfileUserModifyView() {
		this.helpinghand.setContentPane(new ProfileUserModifyView(this.currentUser,this));
	}
	
	public void ProfileSellerModifyView() {
		this.helpinghand.setContentPane(new ProfileSellerModifyView(this.currentUser,this));
	}
	
	public void UpdateAccountAdminView() {
		this.helpinghand.setContentPane(new UpdateAccountAdminView(this.currentUser,this));
	}
	
	public void DeleteAccountAdminView() {
		this.helpinghand.setContentPane(new DeleteAccountAdminView(this.currentUser,this));
	}
	
	//PLAN
	public void PlanDeleteView() {
		this.helpinghand.setContentPane(new PlanDeleteView(this.currentUser,this));
	}
	
	public void PlanManageView() {
		this.helpinghand.setContentPane(new PlanManageView(this.currentUser,this));
	}
	
	public void PlanView(Plan plan) {
		this.helpinghand.setContentPane(new PlanView(this.currentUser, plan,this));
	}
	
	public void CreatePlanView() {
		this.helpinghand.setContentPane(new CreatePlanView(this.currentUser, this));
	}
	
	//PRODUCT
	public void ProductCreateView() {
		this.helpinghand.setContentPane(new ProductCreateView(this.currentUser, this));
	}
	
	public void ProductManageView() {
		this.helpinghand.setContentPane(new ProductManageView(this.currentUser,this));
	}
	
	public void DeleteProductView() {
		this.helpinghand.setContentPane(new DeleteProductView(this.currentUser,this));
	}
	
	public void UpdateProductView() {
		this.helpinghand.setContentPane(new UpdateProductView(this.currentUser,this));
	}
	
	//TASK
	public void TaskCreateView() {
		this.helpinghand.setContentPane(new TaskCreateView(this.currentUser,this));
	}
	
	public void TaskDeleteView() {
		this.helpinghand.setContentPane(new TaskDeleteView(this.currentUser,this));
	}
	
	public void TaskManageView() {
		this.helpinghand.setContentPane(new TaskManageView(this.currentUser,this));
	}
	
	public void TaskUpdateView() {
		this.helpinghand.setContentPane(new TaskUpdateView(this.currentUser,this));
	}
	
	//ACTIVITY CATEGORY
	public void CreateActivityCategoryView() {
		this.helpinghand.setContentPane(new CreateActivityCategoryView(this.currentUser,this));
	}
	
	public void ActivtyCategoryManageView() {
		this.helpinghand.setContentPane(new ActivtyCategoryManageView(this.currentUser,this));
	}
	
	public void UpdateActivityCategoryView() {
		this.helpinghand.setContentPane(new UpdateActivityCategoryView(this.currentUser,this));
	}
	
}
