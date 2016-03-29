package Persist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Core.ActivityCategory;
import Core.Plan;
import Core.Product;
import Core.Task;
import Excpetion.AlreadyExistException;

public class PlanJDBC extends Plan {
	
	/**
	 * Description of the property jDBConnexions.
	 */
	//public JDBConnexion jDBConnexions = new JDBConnexion();
	public JDBConnexion jDBConnexions = JDBConnexion.createConnect();
	
	/**
	 * 
	 */
	public PlanJDBC() {
		super();
	}
	
	public PlanJDBC(String name, String observation, Date deadline, boolean tutorial, boolean isPublic,
			String ac, int idUser) {
		super(name, observation, deadline, tutorial, isPublic, ac, idUser);
		try {
			this.jDBConnexions.executeUpdate("INSERT INTO Plan VALUES (DEFAULT, '"+ name + "','"+ observation +"','" + deadline + "','" + isPublic + "','false','RIEN',"+ idUser +",'"+ac+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Plan> getAllPlan() {
		List<Plan> list = new ArrayList<Plan>();
		list = this.jDBConnexions.getAllPlan("SELECT * FROM Plan");
		return list;
	}

	@Override
	public void delete() {
		this.jDBConnexions.delete("DELETE FROM Plan where idplan = " + this.getIdPlan());
	}

	@Override
	public List<Plan> getRandomPlan() {
		List<Plan> list = new ArrayList<Plan>();
		list = this.jDBConnexions.getRandomPlan("SELECT * FROM Plan ORDER BY RANDOM() LIMIT 2");
		return list;
	}

	public List<Plan> getMyPlan(int idUser) {
		List<Plan> list = new ArrayList<Plan>();
		list = this.jDBConnexions.getMyPlan("SELECT * FROM plan WHERE iduser = '" +idUser+ "' ORDER BY RANDOM() LIMIT 2;");
		return list;
	}
}