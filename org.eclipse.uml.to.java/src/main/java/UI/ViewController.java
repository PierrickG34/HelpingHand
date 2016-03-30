package UI;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void dashboardUserView() {
		this.helpinghand.setContentPane(new DashboardUserView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void dashboardSellerView() {
		this.helpinghand.setContentPane(new DashboardSellerView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	//ACCOUNT
	public void AccountAdminView() {
		this.helpinghand.setContentPane(new AccountAdminView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void ProfileUserView() {
		this.helpinghand.setContentPane(new ProfileUserView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void ProfileSellerView() {
		this.helpinghand.setContentPane(new ProfileSellerView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void ProfileAdminView() {
		this.helpinghand.setContentPane(new ProfileAdminView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void ProfileUserModifyView() {
		this.helpinghand.setContentPane(new ProfileUserModifyView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void ProfileAdminModifyView() {
		this.helpinghand.setContentPane(new ProfileAdminModifyView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void ProfileSellerModifyView() {
		this.helpinghand.setContentPane(new ProfileSellerModifyView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void UpdateAccountAdminView() {
		this.helpinghand.setContentPane(new UpdateAccountAdminView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void DeleteAccountAdminView() {
		this.helpinghand.setContentPane(new DeleteAccountAdminView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	//PLAN
	public void PlanDeleteView() {
		this.helpinghand.setContentPane(new PlanDeleteView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void PlanManageView() {
		this.helpinghand.setContentPane(new PlanManageView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void PlanView(Plan plan) {
		this.helpinghand.setContentPane(new PlanView(this.currentUser, plan,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void PlanViewUser(Plan plan) {
		this.helpinghand.setContentPane(new PlanViewUser(this.currentUser, plan,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void PlanViewSeller(Plan plan) {
		this.helpinghand.setContentPane(new PlanViewSeller(this.currentUser, plan,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void CreatePlanView() {
		this.helpinghand.setContentPane(new CreatePlanView(this.currentUser, this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void CreatePlanUserView() {
		this.helpinghand.setContentPane(new CreatePlanUserView(this.currentUser, this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void CreatePlanSellerView() {
		this.helpinghand.setContentPane(new CreatePlanSellerView(this.currentUser, this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	//PRODUCT
	public void ProductCreateView() {
		this.helpinghand.setContentPane(new ProductCreateView(this.currentUser, this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void ProductCreateViewSeller() {
		this.helpinghand.setContentPane(new ProductCreateViewSeller(this.currentUser, this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void ProductManageView() {
		this.helpinghand.setContentPane(new ProductManageView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void DeleteProductView() {
		this.helpinghand.setContentPane(new DeleteProductView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void UpdateProductView() {
		this.helpinghand.setContentPane(new UpdateProductView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void UpdateProductAdminView() {
		this.helpinghand.setContentPane(new UpdateProductAdminView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void ProductManageViewSeller() {
		this.helpinghand.setContentPane(new ProductManageViewSeller(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void DeleteProductViewSeller() {
		this.helpinghand.setContentPane(new DeleteProductViewSeller(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	
	//TASK
	public void TaskCreateView() {
		this.helpinghand.setContentPane(new TaskCreateView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void TaskDeleteView() {
		this.helpinghand.setContentPane(new TaskDeleteView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void TaskManageView() {
		this.helpinghand.setContentPane(new TaskManageView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void TaskUpdateView() {
		this.helpinghand.setContentPane(new TaskUpdateView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	//ACTIVITY CATEGORY
	public void CreateActivityCategoryView() {
		this.helpinghand.setContentPane(new CreateActivityCategoryView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void ActivtyCategoryManageView() {
		this.helpinghand.setContentPane(new ActivtyCategoryManageView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	public void UpdateActivityCategoryView() {
		this.helpinghand.setContentPane(new UpdateActivityCategoryView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}

	public void MyPlanViewUser() {
		this.helpinghand.setContentPane(new MyPlanViewUser(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}

	public void MyPlanViewSeller() {
		this.helpinghand.setContentPane(new MyPlanViewSeller(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}

}
