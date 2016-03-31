package UI;

import java.awt.Dimension;

import javax.swing.JFrame;

import Core.Plan;
import Core.User;


/**
 * The Class ViewController.
 * @author Helping Hand
 */
public class ViewController {

	/** The current user. */
	private User currentUser;
	
	/** The helpinghand windows. */
	private JFrame helpinghand = new JFrame();
	
	/**
	 * Instantiates a new view controller.
	 *
	 * @param current the current
	 */
	public ViewController(User current) {
		this.currentUser = current;
		helpinghand.setVisible(true);
		helpinghand.setTitle("Helping Hand");
		helpinghand.setMinimumSize((new Dimension(1000,500)));
		helpinghand.setMaximumSize((new Dimension(1000,500)));
		helpinghand.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*DASHBOARD*/
	
	/**
	 * Allows to launch the view Dashboard admin view.
	 */
	public void dashboardAdminView() {
		this.helpinghand.setContentPane(new DashboardAdminView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Dashboard user view.
	 */
	public void dashboardUserView() {
		this.helpinghand.setContentPane(new DashboardUserView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Dashboard seller view.
	 */
	public void dashboardSellerView() {
		this.helpinghand.setContentPane(new DashboardSellerView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	
	/*ACCOUNT*/
	/**
	 * Allows to launch the view Account admin view.
	 */
	public void AccountAdminView() {
		this.helpinghand.setContentPane(new AccountAdminView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Profile user view.
	 */
	public void ProfileUserView() {
		this.helpinghand.setContentPane(new ProfileUserView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Profile seller view.
	 */
	public void ProfileSellerView() {
		this.helpinghand.setContentPane(new ProfileSellerView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Profile admin view.
	 */
	public void ProfileAdminView() {
		this.helpinghand.setContentPane(new ProfileAdminView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Profile user modify view.
	 */
	public void ProfileUserModifyView() {
		this.helpinghand.setContentPane(new ProfileUserModifyView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Profile admin modify view.
	 */
	public void ProfileAdminModifyView() {
		this.helpinghand.setContentPane(new ProfileAdminModifyView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Profile seller modify view.
	 */
	public void ProfileSellerModifyView() {
		this.helpinghand.setContentPane(new ProfileSellerModifyView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Update account admin view.
	 */
	public void UpdateAccountAdminView() {
		this.helpinghand.setContentPane(new UpdateAccountAdminView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Delete account admin view.
	 */
	public void DeleteAccountAdminView() {
		this.helpinghand.setContentPane(new DeleteAccountAdminView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/*PLAN*/
	
	/**
	 * Allows to launch the view Plan delete view.
	 */
	public void PlanDeleteView() {
		this.helpinghand.setContentPane(new PlanDeleteView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Plan manage view.
	 */
	public void PlanManageView() {
		this.helpinghand.setContentPane(new PlanManageView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Plan view.
	 *
	 * @param plan the plan
	 */
	public void PlanView(Plan plan) {
		this.helpinghand.setContentPane(new PlanView(this.currentUser, plan,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Plan view user.
	 *
	 * @param plan the plan
	 */
	public void PlanViewUser(Plan plan) {
		this.helpinghand.setContentPane(new PlanViewUser(this.currentUser, plan,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Plan view seller.
	 *
	 * @param plan the plan
	 */
	public void PlanViewSeller(Plan plan) {
		this.helpinghand.setContentPane(new PlanViewSeller(this.currentUser, plan,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Creates plan view.
	 */
	public void CreatePlanView() {
		this.helpinghand.setContentPane(new CreatePlanView(this.currentUser, this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Creates plan user view.
	 */
	public void CreatePlanUserView() {
		this.helpinghand.setContentPane(new CreatePlanUserView(this.currentUser, this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Creates plan seller view.
	 */
	public void CreatePlanSellerView() {
		this.helpinghand.setContentPane(new CreatePlanSellerView(this.currentUser, this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/*PRODUT*/
	
	/**
	 * Allows to launch the view Product create view.
	 */
	public void ProductCreateView() {
		this.helpinghand.setContentPane(new ProductCreateView(this.currentUser, this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Product create view seller.
	 */
	public void ProductCreateViewSeller() {
		this.helpinghand.setContentPane(new ProductCreateViewSeller(this.currentUser, this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Product manage view.
	 */
	public void ProductManageView() {
		this.helpinghand.setContentPane(new ProductManageView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Delete product view.
	 */
	public void DeleteProductView() {
		this.helpinghand.setContentPane(new DeleteProductView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Update product view.
	 */
	public void UpdateProductView() {
		this.helpinghand.setContentPane(new UpdateProductView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Update product admin view.
	 */
	public void UpdateProductAdminView() {
		this.helpinghand.setContentPane(new UpdateProductAdminView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Product manage view seller.
	 */
	public void ProductManageViewSeller() {
		this.helpinghand.setContentPane(new ProductManageViewSeller(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Delete product view seller.
	 */
	public void DeleteProductViewSeller() {
		this.helpinghand.setContentPane(new DeleteProductViewSeller(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/*TASK*/
	
	/**
	 * Allows to launch the view Task create view.
	 */
	public void TaskCreateView() {
		this.helpinghand.setContentPane(new TaskCreateView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Task delete view.
	 */
	public void TaskDeleteView() {
		this.helpinghand.setContentPane(new TaskDeleteView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Task manage view.
	 */
	public void TaskManageView() {
		this.helpinghand.setContentPane(new TaskManageView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Task update view.
	 */
	public void TaskUpdateView() {
		this.helpinghand.setContentPane(new TaskUpdateView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/*ACTIVITY CATEGORY*/
	
	/**
	 * Allows to launch the view Creates the activity category view.
	 */
	public void CreateActivityCategoryView() {
		this.helpinghand.setContentPane(new CreateActivityCategoryView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Activty category manage view.
	 */
	public void ActivtyCategoryManageView() {
		this.helpinghand.setContentPane(new ActivtyCategoryManageView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}
	
	/**
	 * Allows to launch the view Update activity category view.
	 */
	public void UpdateActivityCategoryView() {
		this.helpinghand.setContentPane(new UpdateActivityCategoryView(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}

	/**
	 * Allows to launch the view My plan view user.
	 */
	public void MyPlanViewUser() {
		this.helpinghand.setContentPane(new MyPlanViewUser(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}

	/**
	 * Allows to launch the view My plan view seller.
	 */
	public void MyPlanViewSeller() {
		this.helpinghand.setContentPane(new MyPlanViewSeller(this.currentUser,this));
		this.helpinghand.repaint();
		this.helpinghand.revalidate();
	}

}
