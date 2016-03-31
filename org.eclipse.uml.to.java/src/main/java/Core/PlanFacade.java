package Core;

import java.util.Date;
import java.util.List;

import UI.CreatePlanSellerView;
import UI.CreatePlanUserView;
import UI.CreatePlanView;
import UI.DashboardAdminView;
import UI.DashboardSellerView;
import UI.DashboardUserView;
import UI.MyPlanViewSeller;
import UI.MyPlanViewUser;
import UI.PlanDeleteView;
import UI.PlanView;
import UI.PlanViewSeller;
import UI.PlanViewUser;
import UI.TaskCreateView;

/**
 * The Class PlanFacade.
 * 
 * @author HelpingHand
 */
public class PlanFacade {

	/** The plan manager. */
	public PlanManager planManager = new PlanManager();
	
	/**
	 * Instantiates a new plan facade.
	 *
	 * @param planCreateView the plan create view
	 */
	public PlanFacade(CreatePlanView planCreateView) {
		super();
	}

	/**
	 * Instantiates a new plan facade.
	 *
	 * @param planDeleteView the plan delete view
	 */
	public PlanFacade(PlanDeleteView planDeleteView) {
		super();
	}

	/**
	 * Instantiates a new plan facade.
	 *
	 * @param dashboardAdminView the dashboard admin view
	 */
	public PlanFacade(DashboardAdminView dashboardAdminView) {
		super();
	}

	/**
	 * Instantiates a new plan facade.
	 *
	 * @param planView the plan view
	 */
	public PlanFacade(PlanView planView) {
		super();
	}

	/**
	 * Instantiates a new plan facade.
	 *
	 * @param taskCreateView the task create view
	 */
	public PlanFacade(TaskCreateView taskCreateView) {
		super();
	}

	/**
	 * Instantiates a new plan facade.
	 *
	 * @param dashboardUserView the dashboard user view
	 */
	public PlanFacade(DashboardUserView dashboardUserView) {
		super();
	}

	/**
	 * Instantiates a new plan facade.
	 *
	 * @param planViewUser the plan view user
	 */
	public PlanFacade(PlanViewUser planViewUser) {
		super();
	}

	/**
	 * Instantiates a new plan facade.
	 *
	 * @param myPlanViewUser the my plan view user
	 */
	public PlanFacade(MyPlanViewUser myPlanViewUser) {
		super();
	}

	/**
	 * Instantiates a new plan facade.
	 *
	 * @param createPlanUserView the create plan user view
	 */
	public PlanFacade(CreatePlanUserView createPlanUserView) {
		super();
	}

	/**
	 * Instantiates a new plan facade.
	 *
	 * @param dashboardSellerView the dashboard seller view
	 */
	public PlanFacade(DashboardSellerView dashboardSellerView) {
		super();
	}

	/**
	 * Instantiates a new plan facade.
	 *
	 * @param planViewSeller the plan view seller
	 */
	public PlanFacade(PlanViewSeller planViewSeller) {
		super();
	}

	/**
	 * Instantiates a new plan facade.
	 *
	 * @param myPlanViewSeller the my plan view seller
	 */
	public PlanFacade(MyPlanViewSeller myPlanViewSeller) {
		super();
	}

	/**
	 * Instantiates a new plan facade.
	 *
	 * @param createPlanSellerView the create plan seller view
	 */
	public PlanFacade(CreatePlanSellerView createPlanSellerView) {
		super();
	}

	/**
	 * Creates the plan.
	 *
	 * @param name the name
	 * @param observation the observation
	 * @param deadline the deadline
	 * @param tutorial the tutorial
	 * @param isPublic the is public
	 * @param ac the ac
	 * @param idUser the id user
	 * @return the plan
	 */
	public Plan createPlan(String name, String observation, Date deadline, boolean tutorial, boolean isPublic, String ac, int idUser) {
		return this.planManager.createPlan(name, observation, deadline, tutorial, isPublic, ac, idUser);
		
	}

	/**
	 * Gets the all plan.
	 *
	 * @return the all plan
	 */
	public List<Plan> getAllPlan() {
		return this.planManager.getAllPlan();
	}
	
	/**
	 * Gets the random plan.
	 *
	 * @return the random plan
	 */
	public List<Plan> getRandomPlan() {
		return this.planManager.getRandomPlan();
	}

	/**
	 * Gets the my plan.
	 *
	 * @param idUser the id user
	 * @return the my plan
	 */
	public List<Plan> getMyPlan(int idUser) {
		return this.planManager.getMyPlan(idUser);
	}
	
	/**
	 * Delete task.
	 *
	 * @param plan the plan
	 */
	public void deleteTask(Plan plan) {
		this.planManager.deletePlan(plan);
	}

	/**
	 * Gets the task for plan.
	 *
	 * @param idPlan the id plan
	 * @return the task for plan
	 */
	public List<Task> getTaskForPlan(Integer idPlan) {
		return this.planManager.getTaskForPlan(idPlan);
	}

}
