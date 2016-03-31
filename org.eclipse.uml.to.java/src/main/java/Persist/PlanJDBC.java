package Persist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Core.Plan;

/**
 * The Class PlanJDBC.
 * @author Helping Hand
 */
public class PlanJDBC extends Plan {
	
	/**
	 * Description of the property jDBConnexions.
	 */
	public JDBConnexion jDBConnexions = JDBConnexion.createConnect();
	
	/**
	 * Instantiates a new plan jdbc.
	 */
	public PlanJDBC() {
		super();
	}
	
	/**
	 * Instantiates a new planJDBC.
	 *
	 * @param name the name
	 * @param observation the observation
	 * @param deadline the deadline
	 * @param tutorial the tutorial
	 * @param isPublic the is public
	 * @param ac the activitycategory
	 * @param idUser the id user
	 */
	public PlanJDBC(String name, String observation, Date deadline, boolean tutorial, boolean isPublic,
			String ac, int idUser) {
		super(name, observation, deadline, tutorial, isPublic, ac, idUser);
		try {
			this.jDBConnexions.executeUpdate("INSERT INTO Plan VALUES (DEFAULT, '"+ name + "','"+ observation +"','" + deadline + "','" + isPublic + "','false','RIEN',"+ idUser +",'"+ac+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see Core.Plan#getAllPlan()
	 */
	@Override
	public List<Plan> getAllPlan() {
		List<Plan> list = new ArrayList<Plan>();
		list = this.jDBConnexions.getAllPlan("SELECT * FROM Plan");
		return list;
	}

	/* (non-Javadoc)
	 * @see Core.Plan#delete()
	 */
	@Override
	public void delete() {
		this.jDBConnexions.delete("DELETE FROM Plan where idplan = " + this.getIdPlan());
	}

	/* (non-Javadoc)
	 * @see Core.Plan#getRandomPlan()
	 */
	@Override
	public List<Plan> getRandomPlan() {
		List<Plan> list = new ArrayList<Plan>();
		list = this.jDBConnexions.getRandomPlan("SELECT * FROM Plan ORDER BY RANDOM() LIMIT 2");
		return list;
	}

	/* (non-Javadoc)
	 * @see Core.Plan#getMyPlan(int)
	 */
	public List<Plan> getMyPlan(int idUser) {
		List<Plan> list = new ArrayList<Plan>();
		list = this.jDBConnexions.getMyPlan("SELECT * FROM plan WHERE iduser = '" +idUser+ "' ORDER BY RANDOM() LIMIT 2;");
		return list;
	}
}